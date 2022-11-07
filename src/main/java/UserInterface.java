import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
    private final ControllerSuperhero controller = new ControllerSuperhero();
    Scanner scanner = new Scanner(System.in);

    public void startProgram() {
        int userChoice = -1;
        controller.loadSuperhero();

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
                    2. View Superhero List
                    3. Search Superhero
                    4. Edit Superhero List
                    5. Delete Superhero
                    9. End Program
                    """);

            userChoice = readInteger();
            scanner.nextLine();
            handlingUserChoice(userChoice);
        }
    }

    public void handlingUserChoice(int userChoice) {
        switch (userChoice) {
            case 1 -> addSuperhero();
            case 2 -> superheroList();
            case 3 -> searchByAlias();
            case 4 -> editTool();
            case 5 -> deleteHero();
            case 9 -> {
                controller.saveSuperhero();
                System.out.println("\nGoodbye, Thank you!");
            }

            default -> System.out.println("""   
                    Could not handle input. Please try again
                    Choose menu item from 1-4
                    """);
        }
    }

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
        double strength = readDouble();

        controller.addSuperhero(name, alias, power, year, strength);

        System.out.println("Superhero Registered!");
    }

    public void superheroList() {
        if (controller.getHeros().size() == 0) {
            System.out.println("\nThere's no Superhero registered...\n");
        } else {
            System.out.println("List of Superhero's registered\n");
            //Name Comparator
            for (Superhero superhero : controller.getHeros()) {
                System.out.println(superhero);
            }
        }

        int sortChoice = -1;

        while (sortChoice != 9) {
            System.out.println("""      
                    Choose to sorted list by:            
                    1. Name
                    2. Alias
                    3. Power
                    4. Year
                    5. Strength                   
                    9. Back to menu
                    """);
            sortChoice = readInteger();
            scanner.nextLine();
            handlingSortedList(sortChoice);

        }
    }

    public void handlingSortedList(int sortChoice) {
        switch (sortChoice) {
            case 1 -> {
                controller.sortByName();
                for (Superhero superhero : controller.getHeros()) {
                    System.out.println(superhero);
                }
            }
            case 2 -> {
                controller.sortByAlias();
                for (Superhero superhero : controller.getHeros()) {
                    System.out.println(superhero);
                }
            }
            case 3 -> {
                controller.sortByPower();
                for (Superhero superhero : controller.getHeros()) {
                    System.out.println(superhero);
                }
            }
            case 4 -> {
                controller.sortByYear();
                for (Superhero superhero : controller.getHeros()) {
                    System.out.println(superhero);
                }
            }
            case 5 -> {
                controller.sortByStrength();
                for (Superhero superhero : controller.getHeros()) {
                    System.out.println(superhero);
                }
            }
            case 9 -> handlingUserChoice(sortChoice);

            default -> System.out.println("""   
                    Could not handle input. Please try again
                    Choose menu item from 1-5
                    """);
        }
    }

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

    public void editTool() {
        if (controller.getHeros().size() == 0) {
            System.out.println("\nThere's no Superhero registered...\n");
        } else {
            System.out.println("List of Superhero's registered\n");

            for (int i = 0; i < controller.getHeros().size(); i++) {
                System.out.println(i + 1 + " Superhero: \n" + controller.getHeros().get(i));
            }

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

                System.out.println("Strength: " + editHero.getStrength());
                System.out.println("Please enter the new STRENGTH below *OBS! You need to make a DOT (.) instead of COMMA");
                String newStrength = scanner.nextLine();
                if (!newStrength.isEmpty()) {
                    newStrength = newStrength.replace(",", ".");
                    editHero.setStrength(Double.parseDouble(newStrength));
                }
            }
            System.out.println("done");
        }
    }

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
            MessageEnum deleteHero = controller.removeHero(nr);

            switch(deleteHero) {
                case SUCCESS -> System.out.println("Superhero deleted");
                case ERROR -> System.out.println("Error! - Please try again\n");
            }
        }
    }

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