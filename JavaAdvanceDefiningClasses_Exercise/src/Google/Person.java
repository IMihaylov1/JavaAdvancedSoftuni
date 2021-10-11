package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public Person() {
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }
    public Person(Company company) {
        this.company = company;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }
    public Person(Car car) {
        this.car = car;
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    private String name;
    private Company company;
    private Car car;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private List<Pokemon> pokemonList;

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParents(Parents parents) {
        this.parentsList.add(parents);
    }

    public void addChildren(Children children) {
        this.childrenList.add(children);
    }
}
