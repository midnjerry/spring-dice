package games.crusader.springdice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RollService {

    @Autowired
    Die die;

    public int roll() {
        return die.roll();
    }

    public List<Integer> rolls(int count) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++){
            result.add(die.roll());
        }
        return result;
    }

}
