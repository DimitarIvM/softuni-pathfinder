package softuni.pathfinder.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "comments")
@Entity
public class CommentEntity extends BaseEntity {

    @Column
    private Boolean approved;

    @Column
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public void setRoute(RouteEntity route) {
        this.route = route;
    }
}
