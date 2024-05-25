package py.edu.simplepokedex;

import java.io.Serializable;
import java.util.List;

public class pokemon implements Serializable {
    private int id;
    private String name;
    private String species;
    private List<String> type;
    private String height;
    private String weight;
    private List<String> abilities;
    private Stats stats;
    private List<String> evolution;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<String> getEvolution() {
        return evolution;
    }

    public void setEvolution(List<String> evolution) {
        this.evolution = evolution;
    }
}
