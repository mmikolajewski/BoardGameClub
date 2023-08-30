package pl.portofilm.project.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.portofilm.project.genre.GenreDto;
import pl.portofilm.project.genre.GenreService;

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
        return "admin/genre-form";
    }

    @PostMapping("/admin/dodaj-gatunek")
    String addGenre(GenreDto genreDto, RedirectAttributes redirectAttributes) {
        genreService.addGenre(genreDto);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Gatunek %s został zapisany".formatted(genreDto.getName()));
        return "redirect:admin";
    }

}
