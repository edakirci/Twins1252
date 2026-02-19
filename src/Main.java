import enigma.core.Enigma;
import enigma.console.TextWindow;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Maze maze = new Maze();
        maze.readFile("maze.txt");
        TextWindow window = Enigma.createTextWindow("Twins", 53, 23);
        Renderer renderer = new Renderer(maze, window);
        renderer.drawGrid();
    }
}