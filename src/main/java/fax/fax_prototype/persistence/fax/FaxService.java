package fax.fax_prototype.persistence.fax;

import org.springframework.stereotype.Service;

@Service
public class FaxService {

    private final FaxRepo faxRepo;

    public FaxService(FaxRepo faxRepo) {
        this.faxRepo = faxRepo;
    }

    public Fax createFax(Fax fax) {
        return faxRepo.save(fax);
    }

    public Fax getFax(long faxId) {
        return faxRepo.findById(faxId).orElse(null);
    }

    public void updateFax(Fax fax) {
        faxRepo.save(fax);
    }

    public void deleteFax(long faxId) {
        faxRepo.deleteById(faxId);
    }

    public Iterable<Fax> getAllFaxes() {
        return faxRepo.findAll();
    }

    public Iterable<Fax> getFaxesByStatus(String status) {
        return faxRepo.findByStatus(status);
    }
}
