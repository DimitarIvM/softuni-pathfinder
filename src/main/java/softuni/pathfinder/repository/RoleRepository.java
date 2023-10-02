package softuni.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.pathfinder.model.entity.RoleEntity;
import softuni.pathfinder.model.entity.enums.Role;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {


    RoleEntity findByName(Role role);
}

