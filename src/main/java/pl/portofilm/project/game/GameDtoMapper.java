package pl.portofilm.project.game;

import pl.portofilm.project.game.dto.GameDto;
import pl.portofilm.project.rating.Rating;

public class GameDtoMapper {
    static GameDto map(Game game) {
        double avgRating = game.getRatings().stream()
                .map(Rating::getRating)
                .mapToDouble(value -> value)
                .average().orElse(0);
        int ratingCount = game.getRatings().size();
        return new GameDto(
                game.getId(),
                game.getTitle(),
                game.getReleaseYear(),
                game.getShortDescription(),
                game.getDescription(),
                game.getYoutubeId(),
                game.getMinPlayers(),
                game.getMaxPlayers(),
                game.getGenreList(),
                game.isPromoted(),
                game.getPoster(),
                avgRating,
                ratingCount);
    }
}
