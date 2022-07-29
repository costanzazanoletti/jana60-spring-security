package jana60.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jana60.model.User;
import jana60.repository.UserRepository;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // recupera lo User da database a partire dallo username
    Optional<User> user = repository.findByUsername(username);

    if (user.isPresent()) {
      // se lo trova genera un DatabaseUserDetail copiando i dati di User
      return new DatabaseUserDetails(user.get());
    } else {
      throw new UsernameNotFoundException(username + " not found");
    }
  }

}
