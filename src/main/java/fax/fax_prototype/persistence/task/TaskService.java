package fax.fax_prototype.persistence.task;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

import fax.fax_prototype.persistence.fax.Fax;
import fax.fax_prototype.persistence.fax.FaxService;

@Service
public class TaskService {

    private final TaskRepo taskRepo;

    private final FaxService faxService;

    public TaskService(TaskRepo taskRepo, FaxService faxService) {
        this.taskRepo = taskRepo;
        this.faxService = faxService;
    }

    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public Task getTask(long taskId) {
        return taskRepo.findById(taskId).orElse(null);
    }

    public Task updateTask(Task task) {
        return taskRepo.save(task);
    }

    public void deleteTask(long taskId) {
        taskRepo.deleteById(taskId);
    }

    public Iterable<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Iterable<Task> getTasksByStatus(String status) {
        return taskRepo.findByStatus(status);
    }

    public void putInProgress(long taskId) {
        Task task = taskRepo.findById(taskId).orElse(null);
        if (task != null) {
            Timestamp currenTimestamp = new Timestamp(System.currentTimeMillis());
            task.setStatus(Task.Status.IN_PROGRESS.toString());
            task.setUpdatedAt(currenTimestamp);
            taskRepo.save(task);

            Fax updatedFax = faxService.getFax(task.getFaxId());
            updatedFax.setUpdatedAt(currenTimestamp);
            faxService.updateFax(updatedFax);
        }
    }

    public void putCompleted(long taskId) {
        Task task = taskRepo.findById(taskId).orElse(null);
        if (task != null) {
            Timestamp currenTimestamp = new Timestamp(System.currentTimeMillis());

            // Update task
            task.setStatus(Task.Status.COMPLETED.toString());
            task.setUpdatedAt(currenTimestamp);
            task.setCompletedAt(currenTimestamp);
            taskRepo.save(task);

            // Update fax
            Fax updatedFax = faxService.getFax(task.getFaxId());
            updatedFax.setUpdatedAt(currenTimestamp);
            updatedFax.setCompletedAt(currenTimestamp);
            faxService.updateFax(updatedFax);
        }
    }

    public void putFailed(long taskId) {
        Task task = taskRepo.findById(taskId).orElse(null);
        if (task != null) {
            task.setStatus(Task.Status.FAILED.toString());
            task.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            taskRepo.save(task);
        }
    }
}
