package pl.portofilm.project;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.portofilm.project.game.dto.GameDto;
import pl.portofilm.project.game.GameService;
import pl.portofilm.project.rating.RatingService;

import java.util.List;

@Controller
public class GameController {

    private final GameService gameService;
    private final RatingService ratingService;

    public GameController(GameService gameService, RatingService ratingService) {
        this.gameService = gameService;
        this.ratingService = ratingService;
    }

    @GetMapping("/gra/{id}")
    String game(Model model, @PathVariable Long id, Authentication authentication){
        GameDto game = gameService.findGameById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("game", game);
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            Integer rating = ratingService.getUserRatingForMovie(currentUserEmail, id).orElse(0);
            model.addAttribute("userRating", rating);
        }
        return "game";
    }

    @GetMapping("/top10")
    public String getTop10(Model model) {
        List<GameDto> topGames = gameService.findTopGames(10);
        model.addAttribute("heading", "TOP 10 GIER");
        model.addAttribute("description", "Gry z najwyższą oceną");
        model.addAttribute("games", topGames);
        return "game-listing";
    }
}
