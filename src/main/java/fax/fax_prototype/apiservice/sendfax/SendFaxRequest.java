package fax.fax_prototype.apiservice.sendfax;

public class SendFaxRequest {
    private String faxNumber;
    private String faxTemplateId;
    private String faxData;

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getFaxTemplateId() {
        return faxTemplateId;
    }

    public void setFaxTemplateId(String faxTemplateId) {
        this.faxTemplateId = faxTemplateId;
    }

    public String getFaxData() {
        return faxData;
    }

    public void setFaxData(String faxData) {
        this.faxData = faxData;
    }

}
