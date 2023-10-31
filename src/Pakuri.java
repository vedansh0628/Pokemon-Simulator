public class Pakuri {
    //Initialized all variables.
    private String name;
    private int attack;
    private int defence;
    private int speed;
    //Default constructor takes in name and sets all the stats.
    public Pakuri(String species) {
        name = species;
        attack = (species.length() * 7) + 9;
        defence = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }
    //Returns name.
    public String getSpecies() {
        return name;
    }
    //Returns attack;
    public int getAttack() {
        return attack;
    }
    //Returns defense;
    public int getDefense() {
        return defence;
    }
    //Returns speed;
    public int getSpeed() {
        return speed;
    }
    //Sets attack;
    public void setAttack(int newAttack) {
        attack = newAttack;
    }
    //Evolves the stats by multiplying them by different values.
    public void evolve() {
        attack = attack * 2;
        defence = defence * 4;
        speed = speed * 3;
    }
}
