package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hv.socialmedia.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
