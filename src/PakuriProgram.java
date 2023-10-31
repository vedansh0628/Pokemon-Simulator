import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        //Initializes scanner, sets booleans to false for menu and pakudexCount try catch.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        int pakudexCount = 0;
        boolean isCapacity = false;
        boolean isMenu = false;
        //Try catch determines if an integer is not inputted or input is less than 0.
        while(!isCapacity) {
            try {
                System.out.println("Enter max capacity of the Pakudex: ");
                pakudexCount = scanner.nextInt();
                if(pakudexCount < 0) {
                    System.out.println("Please enter a valid size.");
                    isCapacity = false;
                }
                else {
                    isCapacity = true;
                    System.out.println("The Pakudex can hold " + pakudexCount + " species of Pakuri.");
                }
            }
            catch(Exception e) {
                System.out.println("Please enter a valid size.");
                scanner.next();
                isCapacity = false;
            }
        }
        //Pakudex object is created.
        Pakudex pakudex = new Pakudex(pakudexCount);
        //While loop for entire program
        while(true) {
            int userInput = 0;
            //Try catch determines if an integer 1-6 is not inputted or input isn't and integer.
            while(!isMenu) {
                try {
                    System.out.println("\n" + "Pakudex Main Menu");
                    System.out.println("-----------------");
                    System.out.println("1. List Pakuri");
                    System.out.println("2. Show Pakuri");
                    System.out.println("3. Add Pakuri");
                    System.out.println("4. Evolve Pakuri");
                    System.out.println("5. Sort Pakuri");
                    System.out.println("6. Exit" + "\n");
                    System.out.println("What would you like to do?");
                    userInput = scanner.nextInt();
                    if(userInput <= 0 || userInput > 6) {
                        System.out.println("Unrecognized menu selection!");
                        isMenu = false;
                    }
                    else {
                        isMenu = true;
                    }
                }
                catch(Exception e) {
                    System.out.println("Unrecognized menu selection!");
                    scanner.next();
                    isMenu = false;
                }
            }
            //If input is a number 1-6 program determines what to do.
            if(userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4 || userInput == 5 || userInput == 6) {
                if(userInput != 6) {
                    //If input is 1 then the Pakuri are listed.
                    if(userInput == 1) {
                        String[] arr = pakudex.getSpeciesArray();
                        if(arr != null) {
                            System.out.println("Pakuri In Pakudex: ");
                            for(int i = 0; i < arr.length; i++) {
                                if(arr[i] != null) {
                                    System.out.println((i + 1) + ". " + arr[i]);
                                }
                            }
                        }
                        //If there are no Pakuri to be listed this statement is printed.
                        else {
                            System.out.println("No Pakuri in Pakudex yet!");
                        }
                    }
                    //If input is 2 stats for selected Pakuri are listed.
                    else if(userInput == 2) {
                        System.out.println("Enter the name of the species to display: ");
                        String pakuri = scanner.next();
                        int[] arr = pakudex.getStats(pakuri);
                        if(arr != null) {
                            if(arr[0] != 0 && arr[1] != 0 &&arr[2] != 0) {
                                System.out.println("Species: " + pakuri);
                                System.out.println("Attack: " + arr[0]);
                                System.out.println("Defense: " + arr[1]);
                                System.out.println("Speed: " + arr[2]);
                            }
                            //If Pakuri is not in Pakudex.
                            else {
                                System.out.println("Error: No such Pakuri!");
                            }
                        }
                        //If array returns null.
                        else {
                            System.out.println("Error: No such Pakuri!");
                        }
                    }
                    //If input is 3 Pakuri is added to Pakudex.
                    else if(userInput == 3) {
                        if(pakudex.getSize() != pakudex.getCapacity()) {
                            System.out.println("Enter the name of the species to add: ");
                            String name = scanner.next();
                            boolean added = pakudex.addPakuri(name);
                            if(added) {
                                System.out.println("Pakuri species " + name + " successfully added!");
                            }
                        }
                        //If Pakudex is full.
                        else {
                            System.out.println("Error: Pakudex is full!");
                        }
                    }
                    //Evolves the selected Pakuri.
                    else if(userInput == 4) {
                        System.out.println("Enter the name of the species to evolve: ");
                        String name = scanner.next();
                        Boolean evolved = pakudex.evolveSpecies(name);
                        //If Pakuri is not in Pakudex.
                        if(!evolved) {
                            System.out.println("Error: No such Pakuri!");
                        }
                    }
                    //Sorts the Pakudex.
                    else if(userInput == 5) {
                        pakudex.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                    }
                }
                //Ends the program when 6 is selected
                else {
                    System.out.println("Thanks for using Pakudex! Bye!");
                    break;
                }
            }
            //If input is not 1-6 menu is printed again and input is asked.
            else {
                isMenu = false;
            }
        }
    }
}
