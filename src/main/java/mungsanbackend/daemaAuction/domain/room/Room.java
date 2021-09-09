package mungsanbackend.daemaAuction.domain.room;

import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.room.joinRoom.JoinRoom;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int msgCnt;

    @OneToMany(mappedBy = "room")
    private List<JoinRoom> joinRooms= new ArrayList<>();
}
