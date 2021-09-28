package mungsanbackend.daemaAuction.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mungsanbackend.daemaAuction.domain.BaseTimeEntity;
import mungsanbackend.daemaAuction.domain.Product;
import mungsanbackend.daemaAuction.domain.JoinRoom;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Builder
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 4)
    private int gcn;    // 학번

    private String email;

    @OneToMany(mappedBy = "user")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<JoinRoom> joinRooms= new ArrayList<>();
}
