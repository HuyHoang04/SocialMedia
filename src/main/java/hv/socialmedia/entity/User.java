package hv.socialmedia.entity;

import java.time.LocalDate;
import java.util.List;

import hv.socialmedia.enums.EnumConstants.PrivacySetting;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    String name;
    String gender;
    LocalDate dob;
    String email;
    String bio;
    String avatar;

    @Column(name = "cover_picture")
    String coverPicture;
    
    String role;

    @Enumerated(EnumType.STRING)
    PrivacySetting privacySetting;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Post> posts;

    @ManyToMany
    @JoinTable(name = "user_chat", 
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "chat_id"))
    List<Chat> chats;

    @ManyToMany
    @JoinTable(name = "friendlist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id"))
    List<User> friends;

    @ManyToMany
    @JoinTable(name = "blacklist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "blocked_id"))
    List<User> blacklists;
}

