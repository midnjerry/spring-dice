package games.crusader.springdice.controller;

import games.crusader.springdice.controller.request.RollResponse;
import games.crusader.springdice.controller.request.RollsResponse;
import games.crusader.springdice.service.RollService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RollControllerTest {

    @Mock
    RollService rollService;

    @InjectMocks
    RollController rollController;

    @Test
    public void getRoll_callsService(){
        when(rollService.roll()).thenReturn(5);
        assertEquals(new RollResponse(5),rollController.getRoll());
        verify(rollService).roll();
    }

    @Test
    public void getRolls_callsService(){
        List<Integer> expected = Arrays.asList(2,3,5);
        when(rollService.rolls(3)).thenReturn(expected);
        assertEquals(new RollsResponse(expected),rollController.getRolls(3));
        verify(rollService).rolls(3);
    }
}