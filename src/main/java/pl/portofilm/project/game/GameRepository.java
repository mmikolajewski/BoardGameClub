package pl.portofilm.project.game;

import org.springframework.data.repository.CrudRepository;
import pl.portofilm.project.game.Game;
import pl.portofilm.project.genre.Genre;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAllByPromotedIsTrue();
    List<Game> findAllByGenreList_NameIgnoreCase(String name);
}
