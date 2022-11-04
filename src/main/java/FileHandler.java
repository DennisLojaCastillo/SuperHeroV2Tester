import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class FileHandler {

    private ControllerSuperhero controller;

        private void saveListOfNames() throws FileNotFoundException {
            PrintStream saveToFile = new PrintStream("names.txt");
            for (Superhero superhero : controller.getHeros()) {
                saveToFile.println(superhero.getName());
                saveToFile.println(superhero.getAlias());
            }
        }

    private void loadListOfNames() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("names.txt"));
        String name = "-nothing yet-";
        while (!name.isBlank() && sc.hasNextLine()) {
            name = sc.nextLine();
            if (!name.isBlank()) {
            String[] att = name.split(",");

                controller.addSuperhero( att[0],
                        att[1],
                        att[2],
                        Integer.parseInt(att[3]),
                        Double.parseDouble(att[4]));
            }
        }
    }

    }


