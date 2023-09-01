package pl.portofilm.project.rating;

import org.springframework.stereotype.Service;
import pl.portofilm.project.game.Game;
import pl.portofilm.project.game.GameRepository;
import pl.portofilm.project.user.User;
import pl.portofilm.project.user.UserRepository;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, GameRepository gameRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    public void addOrUpdateRating(String userEmail, long gameId, int rating) {
        Rating ratingToSaveOrUpdate = ratingRepository.findByUser_EmailAndGame_Id(userEmail,gameId)
                .orElseGet(Rating::new);
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Game game = gameRepository.findById(gameId).orElseThrow();
        ratingToSaveOrUpdate.setUser(user);
        ratingToSaveOrUpdate.setGame(game);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }

    public Optional<Integer> getUserRatingForMovie(String userEmail, long gameId) {
        return ratingRepository.findByUser_EmailAndGame_Id(userEmail, gameId)
                .map(Rating::getRating);
    }
}
