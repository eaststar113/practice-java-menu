package menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class ApplicationTest extends NsTest {

    private static final Duration RANDOM_TEST_TIMEOUT = Duration.ofSeconds(10L);

    @DisplayName("전체 기능 테스트")
    @Nested
    class AllFeatureTest {

        @Test
        void 기능_테스트() {
            assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT, () -> {
                final Executable executable = () -> {
                    runException("구구,제임스", "김밥", "떡볶이");

                    assertThat(output()).contains(
                        "점심 메뉴 추천을 시작합니다.",
                        "코치의 이름을 입력해 주세요. (, 로 구분)",
                        "구구(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "제임스(이)가 못 먹는 메뉴를 입력해 주세요.",
                        "메뉴 추천 결과입니다.",
                        "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]",
                        "[ 카테고리 | 한식 | 양식 | 일식 | 중식 | 아시안 ]",
                        "[ 구구 | 김치찌개 | 스파게티 | 규동 | 짜장면 | 카오 팟 ]",
                        "[ 제임스 | 제육볶음 | 라자냐 | 가츠동 | 짬뽕 | 파인애플 볶음밥 ]",
                        "추천을 완료했습니다."
                    );
                };

            });
        }
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
