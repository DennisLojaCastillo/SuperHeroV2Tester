import java.util.ArrayList;

public class Database {

   /* public Database() {
        heroes.add(new Superhero("Peter Parker", "Spider Man", "Spider-Power", 1992, 11.21));
        heroes.add(new Superhero("Clark Kent", "Super Man", "Strong", 1943, 34.31));
        heroes.add(new Superhero("Bruce Wayne", "Bat Man", "Agile", 1923, 65.21));
    }*/

    private final ArrayList<Superhero> heroes = new ArrayList<>();


    public void addSuperhero(String name, String alias, String power, int year, double strength) {
        heroes.add(new Superhero(name, alias, power, year, strength));
    }

    public ArrayList<Superhero> getHeros() {
        return heroes;
    }

    //TODO Lav en hvor metoden godtager både store og små bogstaver
    public ArrayList<Superhero> searchByAlias(String alias) {
        ArrayList<Superhero> heroList = new ArrayList<>();

        for (Superhero superhero : heroes) {
            if (superhero.getAlias().contains(alias)) {
                heroList.add(superhero);
            }
        }
        return heroList;
    }
}
