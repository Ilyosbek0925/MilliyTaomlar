package org.spring.milliytaomlar.controller;

import lombok.RequiredArgsConstructor;
import org.spring.milliytaomlar.DTO.request.LikeRequest;
import org.spring.milliytaomlar.DTO.response.LikeResponse;
import org.spring.milliytaomlar.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService service;

    @PostMapping
    public ResponseEntity<LikeResponse> addLike(@RequestBody LikeRequest request) {
        LikeResponse response = service.addLike(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/userId")
    public ResponseEntity<LikeResponse> getLike(@RequestParam Integer userId) {
        LikeResponse response = service.getUserLikes(userId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{userId}/{menuId}")
    public ResponseEntity<LikeResponse> deleteLike(@PathVariable Integer userId, @PathVariable Integer menuId) {
        LikeResponse likeResponse = service.delete(userId, menuId);
        return ResponseEntity.ok(likeResponse);
    }

}
