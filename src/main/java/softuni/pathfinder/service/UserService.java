package softuni.pathfinder.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.pathfinder.model.dto.UserLoginDTO;
import softuni.pathfinder.model.dto.UserRegisterDTO;
import softuni.pathfinder.model.entity.RoleEntity;
import softuni.pathfinder.model.entity.UserEntity;
import softuni.pathfinder.model.entity.enums.Level;
import softuni.pathfinder.model.entity.enums.Role;
import softuni.pathfinder.repository.UserRepository;
import softuni.pathfinder.utils.CurrentUser;

import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        this.roleService = roleService;
        this.currentUser = currentUser;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {


        if (this.userRepository.findByEmail(userRegisterDTO.email()).isEmpty() &&
                this.userRepository.findByUsername(userRegisterDTO.username()).isEmpty()) {

            this.userRepository.saveAndFlush(map(userRegisterDTO));


        }
    }


    private UserEntity map(UserRegisterDTO userRegisterDTO) {


        UserEntity userEntity = new UserEntity();


        userEntity.setAge(userRegisterDTO.age());
        userEntity.setEmail(userRegisterDTO.email());
        userEntity.setUsername(userRegisterDTO.username());
        userEntity.setPassword(passwordEncoder.encode(userRegisterDTO.password()));
        userEntity.setFullName(userRegisterDTO.fullName());
        userEntity.setLevel(Level.BEGINNER);
        userEntity.setRole(Set.of(roleService.getUserRole()));

        return userEntity;

    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {

        UserEntity userEntity = userRepository.findByUsername(userLoginDTO.username()).
                orElse(null);

        boolean isLoginSuccessful = false;

        if (userEntity != null) {

            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();

            Set<RoleEntity> roles = userEntity.getRole();

            isLoginSuccessful = encodedPassword != null && passwordEncoder.matches(rawPassword,encodedPassword);

            if (isLoginSuccessful ){

                currentUser.setLogged(true);
                currentUser.setAge(userEntity.getAge());
                currentUser.setFullName(userEntity.getFullName());
                currentUser.setUsername(userEntity.getUsername());

                if (roles.contains(Role.ADMIN)){
                    currentUser.setAdmin(true);
                } else {
                    currentUser.setAdmin(false);
                }

            }else {
                currentUser.logout();
            }

        }
        return isLoginSuccessful;

    }

    public void logoutUser(){
        currentUser.logout();
    }

    public UserEntity getUser(Long id) {
      return   userRepository.findById(id).get();
    }
}