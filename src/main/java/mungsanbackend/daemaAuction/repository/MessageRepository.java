package mungsanbackend.daemaAuction.repository;

import mungsanbackend.daemaAuction.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
