package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hv.socialmedia.entity.PostReaction;

public interface PostReactionRepository extends JpaRepository<PostReaction, Long> {

}
