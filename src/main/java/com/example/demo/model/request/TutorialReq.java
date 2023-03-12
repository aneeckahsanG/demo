package com.example.demo.model.request;

import com.example.demo.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialReq {
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private boolean published;
    private Set<Comment> comments = new HashSet<>();

    public TutorialReq(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public TutorialReq(String title, String description, boolean published, Set<Comment> comments) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.comments = comments;
    }
    // getters and setters


}
