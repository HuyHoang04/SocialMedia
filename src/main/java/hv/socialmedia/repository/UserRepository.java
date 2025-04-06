package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hv.socialmedia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
