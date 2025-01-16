package fax.fax_prototype.apiservice.sendfaxfromfile;

import java.util.HexFormat;

import org.springframework.stereotype.Controller;

import fax.fax_prototype.persistence.fax.Fax;
import fax.fax_prototype.persistence.fax.FaxService;
import fax.fax_prototype.persistence.task.Task;
import fax.fax_prototype.persistence.task.TaskService;

@Controller
public class SendFaxFromFileController {
    final private FaxService faxService;
    final private TaskService taskService;

    public SendFaxFromFileController(FaxService faxService, TaskService taskService) {
        this.faxService = faxService;
        this.taskService = taskService;
    }

    public SendFaxFromFileResponse sendFaxFromFile(SendFaxFromFileRequest request) {
        byte[] faxData = HexFormat.of().parseHex(request.getFaxData());
        Fax fax = new Fax(request.getFaxNumber(), request.getFaxTemplateId(), faxData);
        faxService.createFax(fax);

        Task task = new Task(fax.getId(), Task.Type.SEND_FAX.toString(), Task.Status.QUEUED.toString());
        taskService.createTask(task);

        return new SendFaxFromFileResponse(fax, Task.Status.QUEUED.toString(), "Fax queued for sending");
    }

}
