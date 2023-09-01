package pl.portofilm.project.genre;

public class GenreDto {
    private Long id;
    private String name;
    private String namePl;
    private String description;

    public GenreDto() {
    }

    public GenreDto(Long id, String name, String namePl, String description) {
        this.id = id;
        this.name = name;
        this.namePl = namePl;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePl() {
        return namePl;
    }

    public void setNamePl(String namePl) {
        this.namePl = namePl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
