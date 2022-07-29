package jana60.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import jana60.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

  public Optional<User> findByUsername(String username);

}
