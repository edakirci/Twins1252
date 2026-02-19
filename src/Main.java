import enigma.core.Enigma;
import enigma.console.TextWindow;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int choice = menu();
        if (choice == 0) {
            System.out.println("Bye!");
            return;
        }

        Maze maze = new Maze();

        if (choice == 1) {
            maze.readFile("maze.txt");
        } else {
            maze.generateRandomMaze();
        }

        TextWindow window = Enigma.createTextWindow("Twins", 53, 23);
        Renderer renderer = new Renderer(maze, window);
        renderer.drawGrid();
    }

    private static int menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("           TWINS - MAIN MENU         ");
        System.out.println("====================================");
        System.out.println(" 1) Load Maze from file (maze.txt)  ");
        System.out.println(" 2) Generate Random Maze            ");
        System.out.println(" 0) Exit                            ");
        System.out.println("====================================");

        int choice;
        while (true) {
            System.out.print("Select: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice == 0 || choice == 1 || choice == 2) return choice;
            } else {
                sc.next();
            }
            System.out.println("Invalid choice. Please enter 0, 1 or 2.");
        }
    }
}


