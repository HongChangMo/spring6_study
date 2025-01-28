package tobyspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {

    Sort sort;

    // 각 테스트 전에 실행된다.
    @BeforeEach
    void beforeEach() {
        sort = new Sort();
        System.out.println(this);
    }
    @Test
    void sort() {
        // 테스트는 3단계로 구성되어있다.
        // 첫번째 : 준비 ( given )
        //Sort sort = new Sort();

        // 두번째 : 실행 ( when )
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));

        // 세번째 : 검증 ( then )
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa"));
    }

    @Test
    void sort3Items() {
        // 테스트는 3단계로 구성되어있다.
        // 첫번째 : 준비 ( given )
        //Sort sort = new Sort();

        // 두번째 : 실행 ( when )
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));

        // 세번째 : 검증 ( then )
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
        // 테스트는 3단계로 구성되어있다.
        // 첫번째 : 준비 ( given )
        //Sort sort = new Sort();

        // 두번째 : 실행 ( when )
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "ccc"));

        // 세번째 : 검증 ( then )
        Assertions.assertThat(list).isEqualTo(List.of("b", "aa", "ccc"));
    }
}
