package fax.fax_prototype.apiservice.getfaxes;

import fax.fax_prototype.persistence.fax.Fax;

public class GetFaxesResponse {
    private Iterable<Fax> faxes;

    public GetFaxesResponse(Iterable<Fax> faxes) {
        this.faxes = faxes;
    }

    public Iterable<Fax> getFaxes() {
        return faxes;
    }
}
