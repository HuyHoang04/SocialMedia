package hv.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hv.socialmedia.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
