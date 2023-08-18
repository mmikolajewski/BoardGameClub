package pl.portofilm.project.game.dto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameDto> findAllPromotedGames() {
        return gameRepository.findAllByPromotedIsTrue().stream()
                .map(GameDtoMapper::map)
                .toList();
    }
}
