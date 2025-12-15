package cinema;

import java.util.HashSet;
import java.util.Set;

public class Actor {

    private String name;
    private Set<Film> films = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}