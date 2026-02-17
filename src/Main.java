import enigma.core.Enigma;
import enigma.console.TextWindow;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Maze maze = new Maze();
        maze.dosyaOku("maze.txt");
        TextWindow pencere = Enigma.createTextWindow("Twins", 53, 23);
        Renderer renderer = new Renderer(maze, pencere);
        renderer.gridCiz();
    }
}