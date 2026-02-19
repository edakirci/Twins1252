import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

    private char [][]grid= new char[23][53];
    public void readFile(String file) throws IOException{
        BufferedReader rd = new BufferedReader(new FileReader(file));
        for(int i =0; i<23;i++){

            String  line= rd.readLine();
            for(int j=0;j<53;j++){
                grid[i][j]=line.charAt(j) ;
            }
        }
    }
    public char  getCell(int row,int column){  // public çünkü renderer çağıracak
        return grid[row][column];
    }
    public void setCell(int row,int column,char puts){
        grid[row][column]= puts;
    }

}