package games.crusader.springdice.controller;

import games.crusader.springdice.controller.request.RollResponse;
import games.crusader.springdice.controller.request.RollsResponse;
import games.crusader.springdice.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dice")
public class RollController {

    @Autowired
    RollService rollService;

    @GetMapping("/roll")
    public RollResponse getRoll() {
        return new RollResponse(rollService.roll());
    }

    @GetMapping("/rolls")
    public RollsResponse getRolls(@RequestParam("count")int count){
        return new RollsResponse(rollService.rolls(count));
    }
}
