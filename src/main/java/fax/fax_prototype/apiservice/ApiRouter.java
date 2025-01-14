package fax.fax_prototype.apiservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fax.fax_prototype.apiservice.dailysummary.GetDailySummaryController;
import fax.fax_prototype.apiservice.dailysummary.GetDailySummaryRequest;
import fax.fax_prototype.apiservice.dailysummary.GetDailySummaryResponse;
import fax.fax_prototype.apiservice.getfaxes.GetFaxesController;
import fax.fax_prototype.apiservice.getfaxes.GetFaxesRequest;
import fax.fax_prototype.apiservice.getfaxes.GetFaxesResponse;
import fax.fax_prototype.apiservice.health.GetHealthController;
import fax.fax_prototype.apiservice.health.GetHealthResponse;
import fax.fax_prototype.apiservice.sendfax.SendFaxController;
import fax.fax_prototype.apiservice.sendfax.SendFaxRequest;
import fax.fax_prototype.apiservice.sendfax.SendFaxResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class ApiRouter {

    @Autowired
    private GetHealthController getHealthController;
    @Autowired
    private SendFaxController sendFaxController;
    @Autowired
    private GetFaxesController getFaxesController;
    @Autowired
    private GetDailySummaryController getDailySummaryController;

    @GetMapping("/health")
    public @ResponseBody GetHealthResponse getHealth() {
        return getHealthController.getHealth();
    }

    @GetMapping("/getfaxes")
    public @ResponseBody GetFaxesResponse getFaxes(@RequestParam(required = false) GetFaxesRequest request) {
        return getFaxesController.getFaxes();
    }

    @GetMapping("/dailysummary")
    public @ResponseBody GetDailySummaryResponse getDailySummary(
            @RequestParam(required = false) GetDailySummaryRequest request) {
        return getDailySummaryController.getDailySummary();
    }

    @PostMapping("/sendfax")
    public @ResponseBody SendFaxResponse postSendFax(@RequestBody SendFaxRequest request) {
        return sendFaxController.sendFax(request);
    }

    @PostMapping("/sendfaxfromfile")
    public String postSendFaxFromFile(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    @PostMapping("/txtsendfax")
    public String postTxtSendFax(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
