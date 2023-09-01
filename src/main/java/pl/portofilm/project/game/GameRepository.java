package pl.portofilm.project.game;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    List<Game> findAllByPromotedIsTrue();
    List<Game> findAllByGenreList_NameIgnoreCase(String name);

    @Query("select g from Game g join g.ratings r group by g order by avg(r.rating) desc")
    List<Game> findTopByRating(Pageable page);
}
