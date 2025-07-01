package org.spring.milliytaomlar.repository;

import org.spring.milliytaomlar.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages,Long> {
}
