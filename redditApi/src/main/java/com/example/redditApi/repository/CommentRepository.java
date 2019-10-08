package com.example.redditApi.repository;
import com.example.redditApi.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
public interface CommentRepository extends CrudRepository<Comment, Long> {
}