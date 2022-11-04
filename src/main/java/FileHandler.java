import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileHandler {

    private ControllerSuperhero controller;

    public FileHandler() {
        controller = new ControllerSuperhero();
    }

        public void saveListOfNames() throws FileNotFoundException {
            PrintStream saveToFile = new PrintStream("src/names.txt");
            for (Superhero superhero : controller.getHeros()) {
                saveToFile.println(superhero.getName());
                saveToFile.println(superhero.getAlias());
            }
        }

    public void loadListOfNames() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/names.txt"));
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            String[] att = name.split(",");

                controller.addSuperhero(
                        att[0],
                        att[1],
                        att[2],
                        Integer.parseInt(att[3]),
                        Double.parseDouble(att[4]));

        }
    }

    }


