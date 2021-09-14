package mungsanbackend.daemaAuction.domain.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.room.joinRoom.JoinRoom;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int msgCnt;

    @OneToMany(mappedBy = "room")
    private List<JoinRoom> joinRooms= new ArrayList<>();
}
