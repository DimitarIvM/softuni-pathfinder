package softuni.pathfinder.model.entity;


import jakarta.persistence.*;
import softuni.pathfinder.model.entity.enums.Level;
import softuni.pathfinder.model.entity.enums.Role;

import java.util.HashSet;
import java.util.Set;

@Table(name="users")
@Entity
public class UserEntity extends BaseEntity {
    @Column
    private Integer age;

    @Column(name = "full_name")
    private String fullName;
    @Column
    private String email;
    @Column
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column
    private String password;
    @Column
    private String username;

    @ManyToMany
    private Set<RoleEntity> roles;

    public UserEntity(Set<RoleEntity> roles) {
        this.roles = new HashSet<>();
    }

    public Set<RoleEntity> getRole() {
        return roles;
    }

    public void setRole(Set<RoleEntity> roles) {
        this.roles = roles;

    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
