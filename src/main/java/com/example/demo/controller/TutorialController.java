package com.example.demo.controller;

import com.example.demo.model.dto.TutorialDto;
import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.Tutorial;
import com.example.demo.service.TutorialService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/tutorial")
@Api(description = "Tutorial management API")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Tutorial findById(@PathVariable Long id) {
        return tutorialService.findById(id);
    }
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.GET)
    public Set<Comment> findCommentsByTutorialId(@PathVariable @NotNull Long id){

        return tutorialService.findCommentsByTutorialId(id);

    }
    @RequestMapping(method = RequestMethod.POST)
    public Tutorial save(@RequestBody Tutorial tutorial) { //@Validated
        return tutorialService.save(tutorial);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Tutorial> findAll() {
        return tutorialService.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, params = "title")
    public List<Tutorial> findByTitleContaining(@RequestParam @NotEmpty String title) {
        return tutorialService.findByTitleContaining(title);
    }
    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
    public List<Comment> findAllByTutorial_Id(@PathVariable @NotEmpty Long id) {
        return tutorialService.findAllByTutorial_Id(id);
    }
    @RequestMapping(value = "{id}/comments", method = RequestMethod.POST)
    public List<Comment> saveComments(@PathVariable @NotEmpty Long id, @RequestBody List<Comment> comments) {
        return tutorialService.saveComments(id, comments);
    }
    @RequestMapping(value = "/join/{id}", method = RequestMethod.GET)
    List<TutorialDto> findByIdAndFetchComments(@PathVariable Long id){
        return tutorialService.findByIdAndFetchComments(id);
    }
}
