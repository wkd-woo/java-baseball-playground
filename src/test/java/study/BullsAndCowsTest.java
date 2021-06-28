package study;

/*
> 1) 1-9 사이의 서로 다른 3자리 난수 생성 (컴퓨터)
> 2) 서로 다른 3자리 수를 입력 (사용자)
> 3) 입력 값 적합 여부를 확인하는 예외처리
> 4) 각 자리 수 일치(스트라이크) or 다른 포지션에 존재(볼) 여부 확인
> 5) 숫자 3개를 모두 맞췄을 때 게임 종료
> 6) 게임 종료 후 다시 시작 or 완전히 종료
 */

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BullsAndCowsTest {
    private static LinkedHashSet<Integer> set = new LinkedHashSet<Integer>(); // 3 자리 수

    @Test
    public void makeDigits(){  // 3 자리 난수 생성
        while(set.size() < 3){
            double dValue = Math.random();
            int random = (int)(dValue * 10);
            set.add(random);
        }
        System.out.println(set);

        assertEquals(3, set.size());
    }



}
