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

    @Test
    @DisplayName("5단계: 목록")
    public void t5() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                등록
                실패는 성공의 어머니다.
                작자미상
                목록
                """);

        assertThat(output).contains("1 / 작자미상 / 현재를 사랑하라.")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("3 / 작자미상 / 실패는 성공의 어머니다.");
    }

    @Test
    @DisplayName("6단계: 1번 명언삭제")
    public void t6() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                """);

        assertThat(output).contains("1번 명언이 삭제되었습니다.");
    }

    @Test
    @DisplayName("7단계: 존재하지 않는 명언삭제에 대한 예외처리")
    public void t7() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                """);

        assertThat(output).contains("1번 명언은 존재하지 않습니다.");
    }
}
