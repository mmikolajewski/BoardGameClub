package pl.portofilm.project.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.portofilm.project.game.GameService;
import pl.portofilm.project.game.dto.GameSaveDto;
import pl.portofilm.project.genre.GenreDto;
import pl.portofilm.project.genre.GenreService;

import java.util.List;

@Controller
public class GameManagementController {

    private final GameService gameService;

    private final GenreService genreService;

    public GameManagementController(GameService gameService, GenreService genreService) {
        this.gameService = gameService;
        this.genreService = genreService;
    }

    @GetMapping("/admin/dodaj-gre")
    public String addGameForm(Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("allGenres", allGenres);

        GameSaveDto game = new GameSaveDto();
        model.addAttribute("newGame", game);
        return "admin/game-form";
    }

    @PostMapping("/admin/dodaj-gre")
    public String addGame(GameSaveDto game, RedirectAttributes redirectAttributes) {
        gameService.addGame(game);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE, "Gra %s została zapisana".formatted(game.getTitle())
        );
        return "redirect:/admin";
    }

}
