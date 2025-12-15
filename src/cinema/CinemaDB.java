package cinema;

import java.util.*;

public class CinemaDB {

    private Set<Film> films = new HashSet<>();
    private Set<Actor> actors = new HashSet<>();

    // Map: фільм → кількість акторів
    private Map<Film, Integer> filmActorCount = new HashMap<>();

    public void addFilm(Film f) {
        films.add(f);
        filmActorCount.put(f, f.getActors().size());
    }

    public void addActor(Actor a) {
        actors.add(a);
    }

    // 1. Чи є актор, який не зіграв у жодному фільмі
    public boolean hasActorWithoutFilms() {
        for (Actor a : actors) {
            if (a.getFilms().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    // 2. Список ко-акторів заданого актора
    public Set<Actor> coActors(Actor target) {
        Set<Actor> result = new HashSet<>();

        for (Film f : films) {
            if (f.getActors().contains(target)) {
                for (Actor a : f.getActors()) {
                    if (!a.equals(target)) {
                        result.add(a);
                    }
                }
            }
        }
        return result;
    }

    // 3. Фільм з найбільшою кількістю акторів (через Map)
    public Film maxActorsFilm() {
        Film best = null;
        int max = -1;

        for (Map.Entry<Film, Integer> entry : filmActorCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                best = entry.getKey();
            }
        }
        return best;
    }
}