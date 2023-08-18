package pl.portofilm.project.game.dto;

import pl.portofilm.project.game.Game;

public class GameDtoMapper {
    static GameDto map(Game game) {
        return new GameDto(
                game.getId(),
                game.getTitle(),
                game.getReleaseYear(),
                game.getMinPlayers(),
                game.getMaxPlayers(),
                game.getGenreList(),
                game.isPromoted()
        );
    }
}
