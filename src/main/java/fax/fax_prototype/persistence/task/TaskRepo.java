package fax.fax_prototype.persistence.task;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

    List<Task> findByStatus(String status);

}
