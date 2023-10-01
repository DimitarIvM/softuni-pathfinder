package softuni.pathfinder.model.entity;

import jakarta.persistence.*;
import softuni.pathfinder.model.entity.enums.Level;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class RouteEntity  extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "gpx_coordinates",columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Column
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String name;

    @ManyToOne
    private UserEntity author;
@Column(name = "video_url")
    private String videoUrl;

@ManyToMany
private Set<CategoryEntity> categories;

    public RouteEntity(Set<CategoryEntity> categories) {
        this.categories = new HashSet<>();
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}