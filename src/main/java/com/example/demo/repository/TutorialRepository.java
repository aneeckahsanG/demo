package com.example.demo.repository;

import com.example.demo.model.dto.TutorialDto;
import com.example.demo.model.entity.Comment;
import com.example.demo.model.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findTutorialsByTitleContaining(String title);
    @Query("SELECT new com.example.demo.model.dto.TutorialDto(t.id, t.title,t.description,t.published,c.content) FROM Tutorial t JOIN com.example.demo.model.entity.Comment c on t = c.tutorial and t.id = :id")
    List<TutorialDto> findByIdAndFetchComments(Long id);
    Tutorial findTutorialsByCommentsId(long id);

}
