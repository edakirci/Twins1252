import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

    private char [][]grid= new char[23][53];
    public void dosyaOku(String dosya) throws IOException{   // theows try catct yapısıdır
        BufferedReader oku = new BufferedReader(new FileReader(dosya));
        for(int i =0; i<23;i++){

            String  line= oku.readLine();
            for(int j=0;j<53;j++){
                grid[i][j]=line.charAt(j) ;
            }
        }
    }
    public char  getHucre(int satir,int sutun){  // public çünkü renderer çağıracak
        return grid[satir][sutun];
    }
    public void setHucre(int satir,int sutun,char koyulacak){
        grid[satir][sutun]= koyulacak;
    }

}