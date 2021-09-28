package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
