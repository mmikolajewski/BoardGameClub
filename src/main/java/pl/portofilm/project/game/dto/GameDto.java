package pl.portofilm.project.game.dto;

import pl.portofilm.project.genre.Genre;

import java.util.ArrayList;
import java.util.List;

public class GameDto {
    private Long id;
    private String title;
    private Integer releaseYear;
    private String shortDescription;
    private String description;
    private String youtubeId;
    private Integer minPlayers;
    private Integer maxPlayers;
    private List<Genre> genreList = new ArrayList<>();
    private boolean promoted;
    private String poster;
    private double ratingAvg;
    private int ratingCount;

    public GameDto(Long id, String title, Integer releaseYear, String shortDescription, String description,
                   String youtubeId, Integer minPlayers, Integer maxPlayers, List<Genre> genreList,
                   boolean promoted, String poster, double ratingAvg, int ratingCount) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.shortDescription = shortDescription;
        this.description = description;
        this.youtubeId = youtubeId;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.genreList = genreList;
        this.promoted = promoted;
        this.poster = poster;
        this.ratingAvg = ratingAvg;
        this.ratingCount = ratingCount;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
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

    public String getGenreListAsString() {
        return genreList.toString()
                .replace("[", "")
                .replace("]", "");
    }

    public double getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(double ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
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

