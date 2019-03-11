package games.crusader.springdice.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RollServiceTest {
    @InjectMocks
    RollService service;

    @Mock
    Die dice;

    @Test
    public void roll_ReturnsDieRollFive() {
        when(dice.roll()).thenReturn(5);
        assertEquals(5, service.roll());
    }

    @Test
    public void roll_ReturnsDieRollThree() {
        when(dice.roll()).thenReturn(3);
        assertEquals(3, service.roll());
    }

    @Test
    public void rolls_ReturnsListTwoAndFour(){
        when(dice.roll()).thenReturn(2, 4);
        assertEquals(Arrays.asList(2, 4), service.rolls(2));
    }
}