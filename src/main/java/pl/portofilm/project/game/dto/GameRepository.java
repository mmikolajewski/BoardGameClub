package pl.portofilm.project.game.dto;

import org.springframework.data.repository.CrudRepository;
import pl.portofilm.project.game.Game;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAllByPromotedIsTrue();
}
