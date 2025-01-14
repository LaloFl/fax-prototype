package fax.fax_prototype.apiservice.sendfax;

import fax.fax_prototype.persistence.fax.Fax;

public class SendFaxResponse {
    Fax fax;
    String status;
    String message;

    public SendFaxResponse(Fax fax, String status, String message) {
        this.fax = fax;
        this.status = status;
        this.message = message;
    }

    public Fax getFax() {
        return fax;
    }

    public void setFax(Fax fax) {
        this.fax = fax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
