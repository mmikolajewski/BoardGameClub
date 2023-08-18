package pl.portofilm.project.game.dto;

import pl.portofilm.project.genre.Genre;

import java.util.ArrayList;
import java.util.List;

public class GameDto {
    private Long id;
    private String title;
    private Integer releaseYear;
    private Integer minPlayers;
    private Integer maxPlayers;
    private List<Genre> genreList = new ArrayList<>();
    private boolean promoted;

    public GameDto(Long id, String title, Integer releaseYear, Integer minPlayers, Integer maxPlayers, List<Genre> genreList, boolean promoted) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.genreList = genreList;
        this.promoted = promoted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }
}

