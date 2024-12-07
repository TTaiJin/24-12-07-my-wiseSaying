package com.ll.domain.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WiseSaying {
    private int id;
    private String content;
    private String author;

    public boolean isNew() {
        return this.id == 0;
    }
}
