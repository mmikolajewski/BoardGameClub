package pl.portofilm.project;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.portofilm.project.game.dto.GameDto;
import pl.portofilm.project.game.GameService;
import pl.portofilm.project.genre.GenreDto;
import pl.portofilm.project.genre.GenreService;
import java.util.List;

@Controller
public class GenreController {
    private final GameService gameService;
    private final GenreService genreService;

    public GenreController(GameService gameService, GenreService genreService) {
        this.gameService = gameService;
        this.genreService = genreService;
    }
    @GetMapping("/gatunek/{name}")
    String getGenre(Model model, @PathVariable String name) {
        GenreDto genre = genreService.findGenreByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<GameDto> games = gameService.findGamesByGenreName(name);
        model.addAttribute("heading", genre.getNamePl());
        model.addAttribute("description", genre.getDescription());
        model.addAttribute("games", games);
        return "game-listing";
    }

    @GetMapping("/gatunki-gier")
    String getGenreList(Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("gentres", allGenres);
        return "gentre-listing";
    }
}
