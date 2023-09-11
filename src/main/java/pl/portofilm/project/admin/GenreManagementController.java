package pl.portofilm.project.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.portofilm.project.genre.GenreDto;
import pl.portofilm.project.genre.GenreService;

import java.util.List;

@Controller
public class GenreManagementController {
    private final GenreService genreService;

    public GenreManagementController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("admin/dodaj-gatunek")
    String addGenre(Model model) {
        GenreDto genre = new GenreDto();
        model.addAttribute("newGenre", genre);
        model.addAttribute("heading", "Dodaj nowy gatunek");
        return "admin/genre-form";
    }

    @GetMapping("admin/gatunki")
    String genres(Model model) {
        List<GenreDto> allGenres = genreService.findAllGenres();
        model.addAttribute("genres", allGenres);
        return "admin/gentre-listing";
    }
    @GetMapping("admin/edytuj-gatunek")
    String editGenre(Model model, @RequestParam(required = false) Long id) {

        GenreDto genre = genreService.findGenreById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("newGenre", genre);
        model.addAttribute("heading", "Edytuj gatunek");
        return "admin/genre-form";
    }

    @PostMapping("/admin/dodaj-gatunek")
    String addGenre(GenreDto genreDto, RedirectAttributes redirectAttributes) {
        genreService.addOrEditGenre(genreDto);
        if (genreDto.getId() == null) {
            messageAttribute(genreDto, redirectAttributes,"Gatunek %s został zapisany" );
            return "redirect:/admin";
        } {
            messageAttribute(genreDto, redirectAttributes,"Gatunek %s został edytowany" );
            return "redirect:/admin";
        }
    }

    private static void messageAttribute(GenreDto genreDto, RedirectAttributes redirectAttributes, String message) {
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                message.formatted(genreDto.getName()));
    }

}
