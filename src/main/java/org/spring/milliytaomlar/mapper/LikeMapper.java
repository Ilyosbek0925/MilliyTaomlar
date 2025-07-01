package org.spring.milliytaomlar.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.LikeRequest;
import org.spring.milliytaomlar.DTO.response.LikeResponse;
import org.spring.milliytaomlar.entity.UserLike;
import org.spring.milliytaomlar.repository.MenuRepository;
import org.spring.milliytaomlar.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class LikeMapper {
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;
    private final MenuMapper menuMapper;
    private final RegisterMapper registerMapper;

    public UserLike toLike(LikeRequest request) {
        UserLike like = userRepository.findById(request.getUserId()).orElseThrow(EntityNotFoundException::new).getUserLike();
        if(like == null) {
            like=new UserLike();
            like.setMenus(new ArrayList<>());
            like.setUser(userRepository.findById(request.getUserId()).orElseThrow(EntityNotFoundException::new));
        }
        like.getMenus().add(menuRepository.findById(request.getMenuId()).orElseThrow(EntityNotFoundException::new));
        return like;
    }


    public LikeResponse toLikeResponse(UserLike like) {
        return LikeResponse.builder()
                .menu(like.getMenus().stream().map(menuMapper::toMenuResponse).toList())
                .user(registerMapper.toRegisterResponse(like.getUser()))
                .id(like.getId())
                .build();
    }


}
