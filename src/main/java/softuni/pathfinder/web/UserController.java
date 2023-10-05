package softuni.pathfinder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.pathfinder.model.dto.UserLoginDTO;
import softuni.pathfinder.model.dto.UserProfileDTO;
import softuni.pathfinder.model.dto.UserRegisterDTO;
import softuni.pathfinder.model.entity.UserEntity;
import softuni.pathfinder.repository.UserRepository;
import softuni.pathfinder.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }




    @GetMapping("/profile")
    public ModelAndView getProfile(@PathVariable("id") Long id, ModelAndView modelAndView){

        UserEntity user = userService.getUser(id);

        UserProfileDTO userProfileDTO = new UserProfileDTO();

        userProfileDTO.setId(user.getId());
        userProfileDTO.setAge(user.getAge());
        userProfileDTO.setFullName(user.getFullName());
        userProfileDTO.setUsername(user.getUsername());

        modelAndView.addObject("userProfileDTO",userProfileDTO);


        modelAndView.setViewName("redirect:profile/{id}");

        return modelAndView;

    }

    @GetMapping("/logout")
    public ModelAndView logoutUser(ModelAndView modelAndView) {

        userService.logoutUser();
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/login")
    private ModelAndView getLogin(ModelAndView modelAndView) {

        modelAndView.setViewName("login");

        return modelAndView;

    }

    @PostMapping("/login")
    private ModelAndView userLogin(ModelAndView modelAndView, UserLoginDTO userLoginDTO){

        boolean loginSuccessful = userService.loginUser(userLoginDTO);

        if (loginSuccessful) {

            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("redirect:login");
        }


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
