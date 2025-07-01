package org.spring.milliytaomlar.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.LikeRequest;
import org.spring.milliytaomlar.DTO.response.LikeResponse;
import org.spring.milliytaomlar.entity.UserLike;
import org.spring.milliytaomlar.mapper.LikeMapper;
import org.spring.milliytaomlar.repository.LikeRepository;
import org.spring.milliytaomlar.repository.MenuRepository;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository repository;
    private final LikeMapper mapper;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final LikeRepository likeRepository;

    public LikeResponse addLike(LikeRequest request) {
        UserLike like = mapper.toLike(request);
        return mapper.toLikeResponse(likeRepository.save(like));
    }


    public LikeResponse getUserLikes(Integer userId) {
        UserLike userLike = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId)).getUserLike();
        return mapper.toLikeResponse(userLike);
    }


    public LikeResponse delete(Integer userId, Integer menuId) {
        UserLike like = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId)).getUserLike();
        like.getMenus().remove(menuRepository.findById(menuId).orElseThrow(() -> new EntityNotFoundException("Menu not found with id: " + menuId)));
        UserLike save = likeRepository.save(like);
        return mapper.toLikeResponse(save);
    }
}
