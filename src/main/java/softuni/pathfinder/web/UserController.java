package softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    private ModelAndView getLogin(ModelAndView modelAndView) {

        modelAndView.setViewName("login");

        return modelAndView;

    }

    @GetMapping("/register")

    private ModelAndView getRegister(ModelAndView modelAndView) {

        modelAndView.setViewName("register");

        return modelAndView;
    }

}
