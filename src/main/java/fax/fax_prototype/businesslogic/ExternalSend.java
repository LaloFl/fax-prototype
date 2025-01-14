package fax.fax_prototype.businesslogic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fax.fax_prototype.persistence.task.Task;
import fax.fax_prototype.persistence.task.TaskService;

@Component
public class ExternalSend {

    private TaskService taskService;

    private Logger logger = LoggerFactory.getLogger(ExternalSend.class);

    public ExternalSend(TaskService taskService) {
        this.taskService = taskService;
    }

    public void sendFax(Task task) {
        // Send fax (wait 3 seconds)
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        taskService.putCompleted(task.getId());

        logger.info("Fax sent: " + task.getFaxId());
    }

}
