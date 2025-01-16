package fax.fax_prototype.apiservice.txtsendfax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HexFormat;

import org.springframework.stereotype.Controller;

import fax.fax_prototype.persistence.fax.Fax;
import fax.fax_prototype.persistence.fax.FaxService;
import fax.fax_prototype.persistence.task.Task;
import fax.fax_prototype.persistence.task.TaskService;

@Controller
public class TxtSendFileController {
    final private FaxService faxService;
    final private TaskService taskService;

    public TxtSendFileController(FaxService faxService, TaskService taskService) {
        this.faxService = faxService;
        this.taskService = taskService;
    }

    public TxtSendFileResponse sendFax(InputStream inputStream) {
        String line = null;
        int faxNumberLine = -1;
        int faxTemplateIdLine = -1;
        int faxDataLine = -1;
        int lineCounter = 0;

        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if (inputStream != null) {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                    if (line.toLowerCase().contains("faxnumber")) {
                        faxNumberLine = lineCounter + 1;
                    } else if (line.toLowerCase().contains("faxtemplateid")) {
                        faxTemplateIdLine = lineCounter + 1;
                    } else if (line.toLowerCase().contains("faxdata")) {
                        faxDataLine = lineCounter + 1;
                    }
                    lineCounter++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String[] lines = sb.toString().split("\n");
        String faxNumber = lines[faxNumberLine];
        String faxTemplateId = lines[faxTemplateIdLine];
        String faxDataText = lines[faxDataLine];

        byte[] faxData = HexFormat.of().parseHex(faxDataText);
        Fax fax = new Fax(faxNumber, faxTemplateId, faxData);
        faxService.createFax(fax);

        Task task = new Task(fax.getId(), Task.Type.SEND_FAX.toString(), Task.Status.QUEUED.toString());
        taskService.createTask(task);

        return new TxtSendFileResponse(fax, Task.Status.QUEUED.toString(), "Fax queued for sending");
    }

}
