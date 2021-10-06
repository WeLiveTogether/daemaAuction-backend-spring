package mungsanbackend.daemaAuction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.JoinRoom;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Entity
@Getter
public class Room {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int msgCnt;

    @OneToMany(mappedBy = "room")
    private List<JoinRoom> joinRooms= new ArrayList<>();
}
