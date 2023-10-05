package softuni.pathfinder.model.dto;

import softuni.pathfinder.model.entity.CategoryEntity;
import softuni.pathfinder.model.entity.UserEntity;
import softuni.pathfinder.model.entity.enums.Category;
import softuni.pathfinder.model.entity.enums.Level;

import java.util.Set;

public class AddRouteDTO {
    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private Set<Category> categories;

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    private UserEntity author;

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }



    public boolean isValid() {

       return  true;
    }
}
