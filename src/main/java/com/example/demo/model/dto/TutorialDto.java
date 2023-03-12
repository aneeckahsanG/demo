package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorialDto {
    private long id;
    private String title;
    private String description;
    private boolean published;
    private String comment;

}
