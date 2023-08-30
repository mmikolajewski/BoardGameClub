package pl.portofilm.project.game;

import pl.portofilm.project.game.Game;
import pl.portofilm.project.game.dto.GameDto;

public class GameDtoMapper {
    static GameDto map(Game game) {
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
                game.getPoster()
        );
    }
}
