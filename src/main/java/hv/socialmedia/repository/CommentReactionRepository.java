package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hv.socialmedia.entity.CommentReaction;

public interface CommentReactionRepository extends JpaRepository<CommentReaction, Long> {

}
