package mungsanbackend.daemaAuction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import mungsanbackend.daemaAuction.api.entity.user.User;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Entity
@Getter
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;

    private String context;

    @Temporal(TemporalType.TIMESTAMP)
    private Date sendAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
}
