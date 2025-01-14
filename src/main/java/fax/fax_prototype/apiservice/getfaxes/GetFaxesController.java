package fax.fax_prototype.apiservice.getfaxes;

import org.springframework.stereotype.Controller;

import fax.fax_prototype.persistence.fax.FaxService;

@Controller
public class GetFaxesController {

    FaxService faxService;

    public GetFaxesController(FaxService faxService) {
        this.faxService = faxService;
    }

    public GetFaxesResponse getFaxes() {
        return new GetFaxesResponse(faxService.getAllFaxes());
    }

}
