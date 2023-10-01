package softuni.pathfinder.model.entity;


import jakarta.persistence.*;
import softuni.pathfinder.model.entity.enums.Category;

@Table(name = "categories")
@Entity
public class CategoryEntity extends BaseEntity{

    @Column
    @Enumerated(value = EnumType.STRING)
private Category name;

@Column(columnDefinition = "TEXT")
private String description;

    public Category getName() {
        return name;
    }

    public void setName(Category name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
