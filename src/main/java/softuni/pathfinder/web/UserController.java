package softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.pathfinder.model.dto.UserRegisterDTO;
import softuni.pathfinder.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/register")
    private ModelAndView registerUser(ModelAndView modelAndView,UserRegisterDTO userRegisterDTO) {

        if (userRegisterDTO.isValid()) {

            userService.registerUser(userRegisterDTO);

            modelAndView.setViewName("/login");

        } else {
            modelAndView.setViewName("register");
        }
        return modelAndView;

    }

}
