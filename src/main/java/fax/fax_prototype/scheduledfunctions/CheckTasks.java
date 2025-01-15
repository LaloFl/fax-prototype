package fax.fax_prototype.scheduledfunctions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fax.fax_prototype.businesslogic.ExternalSend;
import fax.fax_prototype.persistence.task.Task;
import fax.fax_prototype.persistence.task.TaskService;

@Component
public class CheckTasks {

    TaskService taskService;

    ExternalSend externalSend;

    int TASKS_LIMIT = 100;

    public CheckTasks(TaskService taskService, ExternalSend externalSend) {
        this.taskService = taskService;
        this.externalSend = externalSend;
    }

    private Logger logger = LoggerFactory.getLogger(CheckTasks.class);

    // Check tasks every 10 seconds
    @Scheduled(fixedRate = 10 * 1000)
    public void checkTasks() {
        List<Task> currentTasksInProgress = (List<Task>) taskService
                .getTasksByStatus(Task.Status.IN_PROGRESS.toString());
        // Don't start more than TASKS_LIMIT tasks at once
        if (currentTasksInProgress.size() >= TASKS_LIMIT)
            return;
        taskService.getTasksByStatus(Task.Status.QUEUED.toString()).forEach(task -> {
            if (task.getType().equals(Task.Type.SEND_FAX.toString())) {
                // Send fax
                logger.info("Sending fax to external service: " + task.getId());
                taskService.putInProgress(task.getId());
                // Send fax
                externalSend.sendFax(task);
            }

        });
    }

}
