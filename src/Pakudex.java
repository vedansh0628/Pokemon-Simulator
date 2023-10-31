public class Pakudex {
    //Initializes variables.
    private static Pakuri arr[];
    private int length;
    //Default constructor sets Pakudex length to 20.
    public Pakudex() {
        length = 20;
        arr = new Pakuri[length];
    }
    //Constructor sets length based on user input;
    public Pakudex(int length) {
        this.length = length;
        arr = new Pakuri[length];
    }
    //Returns how many Pakuri and in the Pakudex.
    public int getSize() {
        int size = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                size++;
            }
        }
        return size;
    }
    //Returns how many Pakuri the Pakudex can hold.
    public int getCapacity() {
        return length;
    }
    //Returns an array with the string name of the Pakuri.
    public String[] getSpeciesArray() {
        String[] pakudexArr = new String[getSize()];
        if(getSize() == 0) {
            return null;
        }
        for(int i = 0; i < getSize(); i++) {
            if(arr[i] != null) {
                pakudexArr[i] = arr[i].getSpecies();
            }
        }
        return pakudexArr;
    }
    //Returns an array with the stats of user inputted Pakuri
    public int[] getStats(String species) {

        int[] stats = new int[3];
        int count = 0;
        if(getSize() == 0) {
            return null;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                if(arr[i].getSpecies().equals(species)) {
                    stats[0] = arr[i].getAttack();
                    stats[1] = arr[i].getDefense();
                    stats[2] = arr[i].getSpeed();
                }
            }
        }
        return stats;
    }
    //Sorts the Pakuri.
    public void sortPakuri() {
        Pakuri[] tempArr = new Pakuri[1];
       if(getSize() != 0) {
           for(int i = 0; i < getSize(); i++) {
               for(int j = 0; j < getSize(); j++) {
                   if(arr[i].getSpecies().compareToIgnoreCase(arr[j].getSpecies()) < 0) {
                       tempArr[0] = arr[i];
                       arr[i] = arr[j];
                       arr[j] = tempArr[0];
                   }
               }
           }
       }
    }
    //Returns true or false depending on if the user inputted Pakuri has been added to the Pakudex.
    public boolean addPakuri(String species) {
        //If pakudex is full.
        if(getSize() == getCapacity()) {
            System.out.println("Error: Pakudex is full!");
            return false;
        }
        //If pakudex already has the user inputted Pakuri.
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                if(arr[i].getSpecies().equals(species)) {
                    System.out.println("Error: Pakudex already contains this species!");
                    return false;
                }
            }
        }
        //Adds Pakuri.7
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                Pakuri temp = new Pakuri(species);
                arr[i] = temp;
                break;
            }
        }
        return true;
    }
    //Returns true or false depending on if the user inputted Pakuri has been evolved or not.
    public boolean evolveSpecies(String species) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != null) {
                if(arr[i].getSpecies().equals(species)) {
                    arr[i].evolve();
                    System.out.println(species + " has evolved!");
                    return true;
                }
            }
        }
        return false;
    }
}