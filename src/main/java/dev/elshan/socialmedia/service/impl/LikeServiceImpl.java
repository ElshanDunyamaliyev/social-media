package dev.elshan.socialmedia.service.impl;

import dev.elshan.socialmedia.repository.LikeRepository;
import dev.elshan.socialmedia.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository repository;

    @Override
    public void addLike() {

    }

    @Override
    public void deleteLike() {

    }
}
