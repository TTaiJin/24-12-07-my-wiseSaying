package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying requireAdd(String content, String author) {
        return wiseSayingRepository.save(new WiseSaying(0, content, author));
    }

    public List<WiseSaying> requireList() {
        return wiseSayingRepository.findAll();
    }

    public boolean requireDelete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public Optional<WiseSaying> requireFindById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void requireModify(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);
        wiseSayingRepository.save(wiseSaying);
    }
}
