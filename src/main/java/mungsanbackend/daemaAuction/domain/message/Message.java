package mungsanbackend.daemaAuction.domain.message;

import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.room.Room;
import mungsanbackend.daemaAuction.domain.user.User;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;

    private String context;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
