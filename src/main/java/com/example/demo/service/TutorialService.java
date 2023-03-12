package com.example.demo.service;

import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.dto.TutorialDto;
import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.Tutorial;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service()
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    @Autowired
    CommentRepository commentRepository;

    public Tutorial findById(Long id){
        return tutorialRepository.findById(id).orElseThrow(() -> new NoDataFoundException());

    }
    public Set<Comment> findCommentsByTutorialId(Long id){

        return tutorialRepository.findById(id)
                .map(tutorial -> tutorial.getComments())
                .orElseThrow(() -> new NoDataFoundException());

    }
    public Tutorial save(Tutorial tutorial) {
        if(tutorial.getComments() != null){

            Tutorial _tutorial = new Tutorial();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            for(Comment comment : tutorial.getComments()){
                _tutorial.addComment(new Comment(comment.getContent()));
            }
            return tutorialRepository.save(_tutorial);
        }
        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> findAll() {
        List tutorials = tutorialRepository.findAll();

        if (tutorials.isEmpty()) {

            throw new NoDataFoundException();
        }

        return tutorials;
    }
    public List<Tutorial> findByPublished(boolean published){
        List tutorials = tutorialRepository.findByPublished(published);

        if (tutorials.isEmpty()) {

            throw new NoDataFoundException();
        }

        return tutorials;
    }
    public List<Tutorial> findByTitleContaining(String title){
        List tutorials = tutorialRepository.findByTitleContaining(title);

        if (tutorials.isEmpty()) {

            throw new NoDataFoundException();
        }

        return tutorials;
    }
    public List<Comment> findAllByTutorial_Id(Long id){
        List comments = commentRepository.findAllByTutorial_Id(id);

        if (comments.isEmpty()) {

            throw new NoDataFoundException();
        }

        return comments;
    }
    public Long countByTutorialId(Long id){
        return commentRepository.countByTutorialId(id);

    }
    public List<Comment> saveComments(Long id, List<Comment> comments) {
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(()->new NoDataFoundException());
        for(Comment comment : comments){
            comment.setTutorial(tutorial);
        }
        return commentRepository.saveAll(comments);
    }
    public List<TutorialDto> findByIdAndFetchComments(Long id){
        return tutorialRepository.findByIdAndFetchComments(id);
    }

}
