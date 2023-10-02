package softuni.pathfinder.model.dto;

import softuni.pathfinder.model.entity.RoleEntity;
import softuni.pathfinder.model.entity.enums.Role;

public record UserRegisterDTO(String username,
                              String fullName,
                              String email,
                              Integer age,
                              String password,
                              String confirmPassword
                              ) {



    public boolean isValid() {

        if (username.length() >= 2 &&
                password.length() >= 2 &&
                fullName.length() >= 2 &&
                email.contains("@") &&
                password.equals(confirmPassword)) {
            return true;

        }
        return false;

    }
}
