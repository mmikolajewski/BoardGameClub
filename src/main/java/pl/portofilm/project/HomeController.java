package pl.portofilm.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.portofilm.project.game.dto.GameDto;
import pl.portofilm.project.game.GameService;

import java.util.List;

@Controller
public class HomeController {

    private final GameService gameService;

    public HomeController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    String home(Model model){
        List<GameDto> promotedGames = gameService.findAllPromotedGames();
        model.addAttribute("heading", "Promowane gry");
        model.addAttribute("description", "Polecane gry");
        model.addAttribute("games", promotedGames);
        return "game-listing";
    }

}
