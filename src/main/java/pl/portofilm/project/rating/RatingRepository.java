package pl.portofilm.project.rating;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Long> {

    Optional<Rating> findByUser_EmailAndGame_Id(String email, Long movieId);
}
