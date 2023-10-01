package softuni.pathfinder.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import java.time.LocalDateTime;

@Table(name = "messages")
@Entity
public class MessageEntity extends BaseEntity{
    @Column(name = "date_time")
    private LocalDateTime dateTime;

@Column(name = "text_content",columnDefinition = "TEXT")
    private String textContent;

@ManyToOne
    private UserEntity author;
@ManyToOne

    private UserEntity 	recipient ;
}
