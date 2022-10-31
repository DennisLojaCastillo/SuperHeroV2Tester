import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    //private final Database db = new Database();
    private ControllerSuperhero controller = new ControllerSuperhero();
    Scanner scanner = new Scanner(System.in);

    //------------------------------------------------------------------------------------------------
    // Hovedmenu
    // Brugeren udvælger en funktion

    public void startProgram() {
        int userChoice = -1;

        System.out.println("""
                ███████╗██╗   ██╗██████╗ ███████╗██████╗ ██╗  ██╗███████╗██████╗  ██████╗    \s
                ██╔════╝██║   ██║██╔══██╗██╔════╝██╔══██╗██║  ██║██╔════╝██╔══██╗██╔═══██╗   \s
                ███████╗██║   ██║██████╔╝█████╗  ██████╔╝███████║█████╗  ██████╔╝██║   ██║   \s
                ╚════██║██║   ██║██╔═══╝ ██╔══╝  ██╔══██╗██╔══██║██╔══╝  ██╔══██╗██║   ██║   \s
                ███████║╚██████╔╝██║     ███████╗██║  ██║██║  ██║███████╗██║  ██║╚██████╔╝   \s
                ╚══════╝ ╚═════╝ ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝    \s
                    ██████╗  █████╗ ████████╗ █████╗ ██████╗  █████╗ ███████╗███████╗        \s
                    ██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝        \s
                    ██║  ██║███████║   ██║   ███████║██████╔╝███████║███████╗█████╗          \s
                    ██║  ██║██╔══██║   ██║   ██╔══██║██╔══██╗██╔══██║╚════██║██╔══╝          \s
                    ██████╔╝██║  ██║   ██║   ██║  ██║██████╔╝██║  ██║███████║███████╗        \s
                    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝        \s
                                                                                             \s
                """);

        while (userChoice != 9) {
            System.out.println("""                  
                    1. Add new Superhero
                    2. Superhero List
                    3. Search Superhero
                    4. Edit Superhero List
                    5. Delete Superhero
                    9. End Program
                    """);

            userChoice = readInteger();
            scanner.nextLine(); // Håndtering af Scanner bug
            handlingUserChoice(userChoice);
        }
    }

    // Brugeren vælger mellem 1 og 4 til en specifik metode.
    public void handlingUserChoice(int userChoice) {
        switch (userChoice) {
            case 1 -> addToolHandlingUserChoice();
            case 2 -> superheroList();
            case 3 -> startSearchTool();
            case 4 -> editToolHandlingUserChoice();
            case 5 -> deleteToolHandlingUserChoice();
            case 9 -> System.out.println("Goodbye, Thank you!");

            default -> System.out.println("""
                                        
                    Could not handle input. Please try again
                    Choose menu item from 1-4
                    """);
        }
    }

    //------------------------------------------------------------------------------------------------
    // Menu til oprettelse af Superhelt og giver brugeren et valg om gennemføre oprettelsen
    // eller gå tilbage til hovedmenu.
    public void addToolHandlingUserChoice() {

        int addUserChoice = -1;

        System.out.println("""

                ███████╗██╗   ██╗██████╗ ███████╗██████╗ ██╗  ██╗███████╗██████╗  ██████╗    \s
                ██╔════╝██║   ██║██╔══██╗██╔════╝██╔══██╗██║  ██║██╔════╝██╔══██╗██╔═══██╗   \s
                ███████╗██║   ██║██████╔╝█████╗  ██████╔╝███████║█████╗  ██████╔╝██║   ██║   \s
                ╚════██║██║   ██║██╔═══╝ ██╔══╝  ██╔══██╗██╔══██║██╔══╝  ██╔══██╗██║   ██║   \s
                ███████║╚██████╔╝██║     ███████╗██║  ██║██║  ██║███████╗██║  ██║╚██████╔╝   \s
                ╚══════╝ ╚═════╝ ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝    \s
                                    ████████╗ ██████╗  ██████╗ ██╗                           \s
                                    ╚══██╔══╝██╔═══██╗██╔═══██╗██║                           \s
                                       ██║   ██║   ██║██║   ██║██║                           \s
                                       ██║   ██║   ██║██║   ██║██║                           \s
                                       ██║   ╚██████╔╝╚██████╔╝███████╗                      \s
                                       ╚═╝    ╚═════╝  ╚═════╝ ╚══════╝                      \s
                                                                                             \s
                """);

        while (addUserChoice != 9) {
            System.out.println("""               
                    1. Add New Superhero
                    9. Back to menu
                    """);

            addUserChoice = readInteger();
            scanner.nextLine(); // Håndtering af Scanner bug
            addToolUserChoice(addUserChoice);
        }
    }

    //-----------------------------------

    private void addToolUserChoice(int addUserChoice) {
        switch (addUserChoice) {
            case 1 -> addSuperhero();
            case 9 -> handlingUserChoice(addUserChoice);
            default -> System.out.println("""
                                      
                    Could not handle input. Please try again
                    Choose menu item 1 or tab 9 back to menu
                    """);
        }
    }

    //Oprettelsen af Superhelt

    public void addSuperhero() {
        System.out.println("Enter the superhero's real name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the superhero's alias: ");
        String alias = scanner.nextLine();

        System.out.println("Enter the superhero's power: ");
        String power = scanner.nextLine();

        System.out.println("Enter the superhero's year of publication: ");
        int year = readInteger();

        System.out.println("Enter the superhero's strength power: ");
        double strength = readDouble(); //læser om inputtet indeholder double

        controller.addSuperhero(name, alias, power, year, strength);

        System.out.println("""
                               
                Superhero Registered!
                """);
    }

    //------------------------------------------------------------------------------------------------
    // Printer Superhelte liste ud.
    public void superheroList() {
        if (controller.getHeros().size() == 0) {
            System.out.println("\nThere's no Superhero registered...\n");
        } else {
            System.out.println("List of Superhero's registered\n");
            for (Superhero superhero : controller.getHeros()) {
                System.out.println(superhero);
            }
        }
    }

    //------------------------------------------------------------------------------------------------
    // Søgefunktion til Superhelte databasen.

    public void startSearchTool() {

        int searchUserChoice = -1;

        System.out.println("""

                ███████╗██╗   ██╗██████╗ ███████╗██████╗ ██╗  ██╗███████╗██████╗  ██████╗    \s
                ██╔════╝██║   ██║██╔══██╗██╔════╝██╔══██╗██║  ██║██╔════╝██╔══██╗██╔═══██╗   \s
                ███████╗██║   ██║██████╔╝█████╗  ██████╔╝███████║█████╗  ██████╔╝██║   ██║   \s
                ╚════██║██║   ██║██╔═══╝ ██╔══╝  ██╔══██╗██╔══██║██╔══╝  ██╔══██╗██║   ██║   \s
                ███████║╚██████╔╝██║     ███████╗██║  ██║██║  ██║███████╗██║  ██║╚██████╔╝   \s
                ╚══════╝ ╚═════╝ ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝    \s
                            ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗                 \s
                            ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║                 \s
                            ███████╗█████╗  ███████║██████╔╝██║     ███████║                 \s
                            ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║                 \s
                            ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║                 \s
                            ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝                 \s
                            ███████╗███╗   ██╗ ██████╗ ██╗███╗   ██╗███████╗                 \s
                            ██╔════╝████╗  ██║██╔════╝ ██║████╗  ██║██╔════╝                 \s
                            █████╗  ██╔██╗ ██║██║  ███╗██║██╔██╗ ██║█████╗                   \s
                            ██╔══╝  ██║╚██╗██║██║   ██║██║██║╚██╗██║██╔══╝                   \s
                            ███████╗██║ ╚████║╚██████╔╝██║██║ ╚████║███████╗                 \s
                            ╚══════╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝╚══════╝                 \s
                                                                                             \s
                """);

        while (searchUserChoice != 9) {
            System.out.println("""
                      Search by:
                      1. Alias name
                      2. Real name
                      3. Power
                      
                      9. Back to menu
                    """);

            searchUserChoice = readInteger();
            scanner.nextLine(); // Håndtering af Scanner bug
            toolHandlingUserChoice(searchUserChoice);
        }
    }

    //-----------------------------------

    private void toolHandlingUserChoice(int searchUserChoice) {
        switch (searchUserChoice) {
            case 1 -> searchByAlias();
            case 9 -> handlingUserChoice(searchUserChoice);
            default -> System.out.println("""
                                        
                    Could not handle input. Please try again
                    Choose menu item from 1-3 or tab 9 back to menu
                    """);
        }
    }

    //-----------------------------------

    //TODO Lav dem på alle søgefunktioner!
    //Søgefunktion ved Superhelte navn
    public void searchByAlias() {

        System.out.println("Search Superhero by alias name: ");
        String findHero = scanner.nextLine();
        ArrayList<Superhero> superhero = controller.searchByAlias(findHero);
        if (superhero.size() == 0) {
            System.out.println("\nFound nothing with this name.\n");
        } else {
            System.out.println("\nInformation\n");
            for (Superhero sh : superhero) {
                System.out.println(sh);
                System.out.println();
            }
        }
    }


    //------------------------------------------------------------------------------------------------
    // Rediger superhelt menu
    public void editToolHandlingUserChoice() {

        int editUserChoice = -1;

        System.out.println("""

                Superhero Edit Tool
                ________________________________
                """);

        while (editUserChoice != 9) {
            System.out.println("""               
                    1. Edit Superhero
                    9. Back to menu
                    """);

            editUserChoice = readInteger();
            scanner.nextLine(); // Håndtering af Scanner bug
            editToolHandlingUserChoice(editUserChoice);
        }
    }

    //-----------------------------------

    private void editToolHandlingUserChoice(int editUserChoice) {
        switch (editUserChoice) {
            case 1 -> editTool();
            case 9 -> handlingUserChoice(editUserChoice);
            default -> System.out.println("""
                                        
                    Could not handle input. Please try again
                    Choose menu item 1 or tab 9 back to menu
                    """);
        }
    }

    //Redigere Superhelt
    public void editTool() {
        if (controller.getHeros().size() == 0) {
            System.out.println("\nThere's no Superhero registered...\n");
        } else {
            System.out.println("List of Superhero's registered\n");

            for (int i = 0; i < controller.getHeros().size(); i++) {
                System.out.println(i + 1 + " Superhero: \n" + controller.getHeros().get(i));
            }

            //Brugerdialog for redigere i oplysninger.
            //-----------------------------------

            System.out.println("Enter Superhero number to edit informations:");
            int numb = scanner.nextInt();
            Superhero editHero;
            scanner.nextLine();
            if (numb - 1 >= controller.getHeros().size()) {
                System.out.println("\nThis number don't exits in the database. Please try again");
            } else {
                editHero = controller.getHeros().get(numb - 1);
                System.out.println("Edit Person: " + editHero);

                System.out.println("Edit data and press ENTER If data is not to be edited press ENTER\n");


                System.out.println("Current Real name: " + editHero.getName());
                System.out.println("Please enter the new NAME below");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    editHero.setName(newName);
                }
                System.out.println("Current Alias name: " + editHero.getAlias());
                System.out.println("Please enter the new ALIAS name below");
                String newAlias = scanner.nextLine();
                if (!newAlias.isEmpty()) {
                    editHero.setAlias(newAlias);
                }

                System.out.println("Current Super Power: " + editHero.getPower());
                System.out.println("Please enter the new SUPER POWER below");
                String newPower = scanner.nextLine();
                if (!newPower.isEmpty()) {
                    editHero.setPower(newPower);
                }

                System.out.println("Current Year of publication: " + editHero.getYear());
                System.out.println("Please enter the new YEAR below");
                String newYear = scanner.nextLine();
                if (!newYear.isEmpty()) {
                    editHero.setYear(Integer.parseInt(newYear));
                }

                //TODO Fejl her - man skal både kunne skrive en (.) og (,)
                System.out.println("Strength: " + editHero.getStrength());
                System.out.println("Please enter the new STRENGTH below *OBS! You need to make a DOT (.) instead of COMMA");
                String newStrength = scanner.nextLine();
                if (!newStrength.isEmpty()) {
                    editHero.setStrength(Double.parseDouble(newStrength));
                }
            }
        }
    }

    //------------------------------------------------------------------------------------------------
    //Slet superhelt Menu
    public void deleteToolHandlingUserChoice() {

        int deleteUserChoice = -1;

        System.out.println("""

                Superhero Delete Tool
                ________________________________
                """);

        while (deleteUserChoice != 9) {
            System.out.println("""               
                    1. Delete Superhero
                    9. Back to menu
                    """);

            deleteUserChoice = readInteger();
            scanner.nextLine(); // Håndtering af Scanner bug
            deleteToolHandlingUserChoice(deleteUserChoice);
        }
    }

    //-----------------------------------
    //Sletter en Superhelt

    private void deleteToolHandlingUserChoice(int deleteUserChoice) {
        switch (deleteUserChoice) {
            case 1 -> deleteHero();
            case 9 -> handlingUserChoice(deleteUserChoice);
            default -> System.out.println("""
                                        
                    Could not handle input. Please try again
                    Choose menu item 1 or tab 9 back to menu
                    """);
        }
    }

    // Metode til at slette en superhelt
    public void deleteHero() {

        if (controller.getHeros().size() == 0) {
            System.out.println("\nThere's no Superhero registered...\n");
        } else {
            System.out.println("List of Superhero's registered\n");
            for (int i = 0; i < controller.getHeros().size(); i++) {
                System.out.println(i + 1 + " Superhero: \n" + controller.getHeros().get(i));
            }
            System.out.println("Enter Superhero number to delete Superhero: ");

            int nr = readInteger();

            if (nr <= controller.getHeros().size()) {
                controller.getHeros().remove(nr - 1);
                System.out.println("\nSuperhero deleted!\n");
            } else {
                System.out.println("Error! - Please try again\n");
            }
        }
    }

    //------------------------------------------------------------------------------------------------
    // Læser om det er et tal (int eller double) og inputtet ikke er et bogstav.
    public int readInteger() {
        while (!scanner.hasNextInt()) {
            String errorMsg = scanner.next();
            System.out.println("Invalid value \"" + errorMsg + "\" Please try again");
        }
        return scanner.nextInt();
    }

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            String errorMsg = scanner.next();
            System.out.println("Invalid value \"" + errorMsg + "\" Please try again");
        }
        return scanner.nextDouble();
    }
}


