package tasos.springframework.simple_web_application.repositories;

import org.springframework.data.repository.CrudRepository;
import tasos.springframework.simple_web_application.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
