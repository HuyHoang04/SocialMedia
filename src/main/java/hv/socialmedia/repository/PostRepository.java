package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hv.socialmedia.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
