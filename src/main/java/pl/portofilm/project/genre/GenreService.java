package pl.portofilm.project.genre;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Optional<GenreDto> findGenreByName(String name) {
        return genreRepository.findByNameIgnoreCase(name).map(GenreDtoMapper::map);
    }

    public List<GenreDto> findAllGenres() {
        return StreamSupport.stream(genreRepository.findAll().spliterator(), false)
                .map(GenreDtoMapper::map)
                .toList();
    }

    @Transactional
    public void addGenre(GenreDto genre) {
        Genre genreToSave = new Genre();
        genreToSave.setName(genre.getName());
        genreToSave.setDescription(genre.getDescription());
        genreRepository.save(genreToSave);
    }

}
