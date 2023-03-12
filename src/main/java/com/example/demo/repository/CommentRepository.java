package com.example.demo.repository;

import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByTutorial_Id(Long id);
    List<Comment> findAllByTutorial_Published(boolean value);
    Long countByTutorialId(Long id);

}
