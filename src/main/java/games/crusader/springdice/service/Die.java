package games.crusader.springdice.service;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Random;

@Data
@Component
public class Die {
    private int sides;
    private Random generator;

    Die(){
        this(6);
    }

    Die(int sides) {
        this.sides = sides;
        generator = new Random();
    }

    public int roll() {
        return generator.nextInt(sides) + 1;
    }
}
