package com.example.demo.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "comments")
@Table(name = "tutorials")
//@ToString(exclude = "comments")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
    private long id;
    @NotEmpty(message = "Title is mandatory")
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "published")
    private boolean published;
    @OneToMany(mappedBy = "tutorial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Tutorial(String title, String description, boolean published, Set<Comment> comments) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.comments = comments;
    }

    public void addComment(Comment comment){
        comment.setTutorial(this);
        this.comments.add(comment);
    }

}
