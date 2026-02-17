import enigma.console.TextWindow;
import enigma.console.TextAttributes;
import java.awt.Color;

public class Renderer{
    TextAttributes renk = new TextAttributes(Color.WHITE, Color.BLACK); // output için renk nesnesi enigma

    private  Maze  maze;
    private TextWindow pencere;

    public Renderer(Maze maze,TextWindow pencere)
    {
        this.maze=maze;
        this.pencere=pencere;
    }

    public void gridCiz()
    {
        for(int s =0; s<23;s++){
            for(int p=0;p<53;p++){
                char karakter = this.maze.getHucre(s,p);// maze deki her bir karakteri aldım
                pencere.output(p, s, karakter, renk);
            }
        }
    }


}

