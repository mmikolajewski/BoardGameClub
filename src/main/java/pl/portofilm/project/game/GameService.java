package pl.portofilm.project.game;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.portofilm.project.game.dto.GameDto;
import pl.portofilm.project.game.dto.GameSaveDto;
import pl.portofilm.project.genre.Genre;
import pl.portofilm.project.genre.GenreRepository;
import pl.portofilm.project.storage.FileStorageService;


import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;

    private final FileStorageService fileStorageService;

    public GameService(GameRepository gameRepository, GenreRepository genreRepository, FileStorageService fileStorageService) {
        this.gameRepository = gameRepository;
        this.genreRepository = genreRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<GameDto> findAllPromotedGames() {
        return gameRepository.findAllByPromotedIsTrue().stream()
                .map(GameDtoMapper::map)
                .toList();
    }

    public Optional<GameDto> findGameById(Long id) {
        return gameRepository.findById(id).map(GameDtoMapper::map);
    }

    public List<GameDto> findGamesByGenreName(String genre) {
        return gameRepository.findAllByGenreList_NameIgnoreCase(genre).stream()
                .map(GameDtoMapper::map)
                .toList();
    }

    public void addGame(GameSaveDto gameToSaveDto) {
        Game game = new Game();
        game.setTitle(gameToSaveDto.getTitle());
        game.setPromoted(gameToSaveDto.isPromoted());
        game.setReleaseYear(gameToSaveDto.getReleaseYear());
        game.setMinPlayers(gameToSaveDto.getMinPlayers());
        game.setMaxPlayers(gameToSaveDto.getMaxPlayers());
        game.setDescription(gameToSaveDto.getDescription());
        game.setShortDescription(game.getShortDescription());
        game.setYoutubeId(gameToSaveDto.getYoutubeId());
        Genre genre = genreRepository.findByNameIgnoreCase(gameToSaveDto.getGenre()).orElseThrow();
        game.getGenreList().add(genre);

        if (gameToSaveDto.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(gameToSaveDto.getPoster());
            game.setPoster(savedFileName);
        }
        gameRepository.save(game);
    }

    public List<GameDto> findTopGames(int size) {
        Pageable page= Pageable.ofSize(size);
        return gameRepository.findTopByRating(page).stream()
                .map(GameDtoMapper::map)
                .toList();
    }
}
