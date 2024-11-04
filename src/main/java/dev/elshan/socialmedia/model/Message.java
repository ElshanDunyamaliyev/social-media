//package dev.elshan.socialmedia.model;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "messages")
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "sender_id", nullable = false)
//    private User sender;
//
//    @ManyToOne
//    @JoinColumn(name = "receiver_id", nullable = false)
//    private User receiver;
//
//    private String content;
//    private LocalDateTime sentAt;
//    private String status;
//}
