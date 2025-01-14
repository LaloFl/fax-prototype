package fax.fax_prototype.apiservice.sendfax;

import java.util.HexFormat;

import org.springframework.stereotype.Controller;

import fax.fax_prototype.persistence.fax.Fax;
import fax.fax_prototype.persistence.fax.FaxService;
import fax.fax_prototype.persistence.task.Task;
import fax.fax_prototype.persistence.task.TaskService;

@Controller
public class SendFaxController {

    final private FaxService faxService;
    final private TaskService taskService;

    public SendFaxController(FaxService faxService, TaskService taskService) {
        this.faxService = faxService;
        this.taskService = taskService;
    }

    public SendFaxResponse sendFax(SendFaxRequest sendFaxRequest) {
        byte[] faxData = HexFormat.of().parseHex(sendFaxRequest.getFaxData());
        Fax fax = new Fax(sendFaxRequest.getFaxNumber(), sendFaxRequest.getFaxTemplateId(), faxData);
        faxService.createFax(fax);

        Task task = new Task(fax.getId(), Task.Type.SEND_FAX.toString(), Task.Status.QUEUED.toString());
        taskService.createTask(task);

        return new SendFaxResponse(fax, Task.Status.QUEUED.toString(), "Fax queued for sending");
    }
}
