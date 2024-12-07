package com.ll.domain.wiseSaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("2단계: 명언, 작가 입력받기")
    public void t2() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(output).contains("명언 : ")
                .contains("작가 : ");
    }

    @Test
    @DisplayName("3단계: 등록시 생성된 명언번호 노출")
    public void t3() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(output).contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("4단계: 등록할때 마다 생성되는 명언번호 증가")
    public void t4() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(output).contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }
}
