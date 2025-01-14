package fax.fax_prototype.persistence.fax;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaxRepo extends CrudRepository<Fax, Long> {

    @Query("SELECT f.id, f.faxNumber, f.faxTemplateId, f.faxData, f.createdAt, f.updatedAt, f.completedAt, t.status FROM Fax f INNER JOIN Task t ON f.id=t.faxid WHERE t.status = ?1")
    List<Fax> findByStatus(String status);

}
