package jana60.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jana60.model.Role;
import jana60.model.User;

public class DatabaseUserDetails implements UserDetails {

  private String username;
  private String password;
  private Set<GrantedAuthority> authorities;

  // costruttore che genera un DatabaseUserDetails a partire da un oggetto User
  public DatabaseUserDetails(User user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.authorities = new HashSet<GrantedAuthority>();
    for (Role r : user.getRoles()) {
      this.authorities.add(new SimpleGrantedAuthority(r.getName()));
    }
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
