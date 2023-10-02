package softuni.pathfinder.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.pathfinder.model.dto.UserRegisterDTO;
import softuni.pathfinder.model.entity.UserEntity;
import softuni.pathfinder.model.entity.enums.Level;
import softuni.pathfinder.model.entity.enums.Role;
import softuni.pathfinder.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

        this.roleService = roleService;
    }

    public void registerUser(UserRegisterDTO userRegisterDTO) {


        if (this.userRepository.findByEmail(userRegisterDTO.email()).isEmpty() &&
        this.userRepository.findByUsername(userRegisterDTO.username()).isEmpty()) {

            this.userRepository.saveAndFlush(map(userRegisterDTO));


        }
    }


        private  UserEntity map(UserRegisterDTO userRegisterDTO){


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

}