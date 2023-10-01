package softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import softuni.pathfinder.model.entity.enums.Role;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity{


    @Column
    @Enumerated(EnumType.STRING)
    private Role name;


    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
