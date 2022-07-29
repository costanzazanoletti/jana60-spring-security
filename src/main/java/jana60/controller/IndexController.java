package jana60.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

  @GetMapping
  public String index() {
    return "index";
  }

  @GetMapping("/user")
  public String user(Authentication authentication, Model model) {

    model.addAttribute("loggedUser", authentication.getName());
    return "user";
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }
}
