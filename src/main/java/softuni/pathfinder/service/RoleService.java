package softuni.pathfinder.service;

import org.springframework.stereotype.Service;
import softuni.pathfinder.model.entity.RoleEntity;
import softuni.pathfinder.model.entity.enums.Role;
import softuni.pathfinder.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleEntity getUserRole(){

        return this.roleRepository.findByName(Role.USER);
    }
}
