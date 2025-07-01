package org.spring.milliytaomlar.repository;

import org.spring.milliytaomlar.DTO.response.LikeResponse;
import org.spring.milliytaomlar.entity.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<UserLike,Integer> {
}
