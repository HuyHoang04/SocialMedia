package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hv.socialmedia.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
