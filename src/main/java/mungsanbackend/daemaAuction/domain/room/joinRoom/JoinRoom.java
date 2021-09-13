package mungsanbackend.daemaAuction.domain.room.joinRoom;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.room.Room;
import mungsanbackend.daemaAuction.domain.user.User;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
@Builder
public class JoinRoom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
