package pl.portofilm.project.rating;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.portofilm.project.admin.AdminController;

@Controller
public class RatingController {

    private final static String LOG_IN_REQUIRED_NOTIFICATION = "zaloguj się aby oddać głos";
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/ocen-gre")
    public String addMovieRating(@RequestParam Long gameId,
                                 @RequestParam int rating,
                                 @RequestHeader String referer,
                                 Authentication authentication,
                                 RedirectAttributes redirectAttributes) {
        if (authentication != null) {
            String currentUserEmail = authentication.getName();
            ratingService.addOrUpdateRating(currentUserEmail, gameId, rating);
            return "redirect:" + referer;
        } else {
            redirectAttributes.addFlashAttribute(AdminController.NOTIFICATION_ATTRIBUTE, "zaloguj się, aby oddać głos");
            return "redirect:/gra/" + gameId;
        }

    }
}
