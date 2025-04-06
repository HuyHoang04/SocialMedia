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

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private LocalDate dob;
    private String email;
    private String bio;
    private String avatar;

    @Column(name = "cover_picture")
    private String coverPicture;
    
    private String role;

    @Enumerated(EnumType.STRING)
    private PrivacySetting privacySetting;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToMany
    @JoinTable(name = "user_chat", 
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "chat_id"))
    private List<Chat> chats;

    @ManyToMany
    @JoinTable(name = "friendlist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<User> friends;

    @ManyToMany
    @JoinTable(name = "blacklist",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "blocked_id"))
    private List<User> blacklists;
}

