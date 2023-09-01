package pl.portofilm.project.genre;

public class GenreDtoMapper {

    static GenreDto map(Genre genre) {
        return new GenreDto(
                genre.getId(),
                genre.getName(),
                genre.getNamePl(),
                genre.getDescription()
        );
    }
}
