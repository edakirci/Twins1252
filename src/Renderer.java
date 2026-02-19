import enigma.console.TextWindow;
import enigma.console.TextAttributes;
import java.awt.Color;

public class Renderer{
    TextAttributes color = new TextAttributes(Color.WHITE, Color.BLACK); // color object for enigma

    private  Maze  maze;
    private TextWindow window;

    public Renderer(Maze maze,TextWindow window)
    {
        this.maze=maze;
        this.window=window;
    }

    public void drawGrid()
    {
        for(int s =0; s<23;s++){
            for(int p=0;p<53;p++){
                char character = this.maze.getCell(s,p);// getting each character from maze
                window.output(p, s, character, color);
            }
        }
    }


}

