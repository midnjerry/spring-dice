package games.crusader.springdice.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DieTest {

    @Test
    public void roll_ReturnsRandomNumberWithinRange() {
        Die die = new Die(3);
        int totalCount = 1000;
        Map<Integer, Integer> resultCounter = new HashMap<>();
        for (int i = 0; i < totalCount; i++) {
            int result = die.roll();
            int count = resultCounter.getOrDefault(result, 0);
            resultCounter.put(result, count + 1);
        }
        assertEquals(Arrays.asList(1, 2, 3), new ArrayList<>(resultCounter.keySet()));
        assertEquals(0.33, resultCounter.get(1) / (double) totalCount, 0.03);
        assertEquals(0.33, resultCounter.get(2) / (double) totalCount, 0.03);
        assertEquals(0.33, resultCounter.get(3) / (double) totalCount, 0.03);
    }

    @Test
    public void noArgsConstructor_initiatesDieWith6Sides(){
        Die die = new Die();
        assertEquals(6, die.getSides());
    }
}