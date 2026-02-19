import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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


    //RANDOM MAZE GENERATION:

    private static final int ROWS = 23; // final=fixed size for maze. no changes !!!!
    private static final int COLS = 53; // static=same for every maze object

    private final Random random = new Random();

    public void generateRandomMaze() {
        // we are trying multiple times just in case. bcs the program might not generate in the first attempt
        for (int attempt = 0; attempt < 30; attempt++) {
            initEmptyWithBorders(); //just borders

            boolean ok =
                    addWalls(4, 8) &&
                            addWalls(6, 6) &&
                            addWalls(20, 4) &&
                            addWalls(5, 3);

            if (ok && checkConnected()) {
                return; //succesfull
            }
        }

        // if we cannot generate in 30 times then fail
        throw new RuntimeException("Random maze generation failed after many attempts.");
    }

    private void initEmptyWithBorders() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r == 0 || r == ROWS - 1 || c == 0 || c == COLS - 1) {
                    grid[r][c] = '#';
                } else {
                    grid[r][c] = ' ';
                }
            }
        }
    }

    private boolean addWalls(int count, int length) {
        int maxTriesPerWall = 2000;

        for (int i = 0; i < count; i++) {
            boolean placed = false;

            for (int t = 0; t < maxTriesPerWall && !placed; t++) { //try until finding free space
                boolean horizontal = random.nextBoolean(); //horizontal or vertical

                int startRow, startCol;

                if (horizontal) {
                    startRow = 1 + random.nextInt(ROWS - 2);
                    startCol = 1 + random.nextInt((COLS - 2) - length + 1);
                } else {
                    startRow = 1 + random.nextInt((ROWS - 2) - length + 1);
                    startCol = 1 + random.nextInt(COLS - 2);
                }

                // duvarın basacağı hücreleri topla (geri almak için)
                List<int[]> changed = new ArrayList<>();
                boolean canPlace = true;

                for (int k = 0; k < length; k++) {
                    int rr = horizontal ? startRow : startRow + k;
                    int cc = horizontal ? startCol + k : startCol;

                    if (grid[rr][cc] == '#') { // üst üste bindirmeyelim
                        canPlace = false;
                        break;
                    }
                    changed.add(new int[]{rr, cc});
                }

                if (!canPlace) continue;

                // geçici yerleştir
                for (int[] cell : changed) {
                    grid[cell[0]][cell[1]] = '#';
                }

                // kontroller (CheckArea + CheckConnected)
                if (checkAreaConstraints() && checkConnected()) {
                    placed = true;
                } else {
                    // geri al
                    for (int[] cell : changed) {
                        grid[cell[0]][cell[1]] = ' ';
                    }
                }
            }

            if (!placed) return false; // bu wall segmentini koyamadık
        }

        return true;
    }

    private boolean checkAreaConstraints() {
        // border hariç iç bölgede check yapıyoruz
        if (!checkAreaLimit(2, 2, 3)) return false;
        if (!checkAreaLimit(3, 3, 5)) return false;
        if (!checkAreaLimit(4, 4, 7)) return false;
        if (!checkAreaLimit(6, 6, 15)) return false;

        return true;
    }

    private boolean checkAreaLimit(int h, int w, int maxWalls) {
        // İç alan: satır 1..ROWS-2, sütun 1..COLS-2
        int startRowMin = 1;
        int startRowMax = (ROWS - 2) - h + 1; // inclusive
        int startColMin = 1;
        int startColMax = (COLS - 2) - w + 1; // inclusive

        for (int r = startRowMin; r <= startRowMax; r++) {
            for (int c = startColMin; c <= startColMax; c++) {
                int wallCount = 0;

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (grid[r + i][c + j] == '#') wallCount++;
                        if (wallCount > maxWalls) return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean checkConnected() {
        // İç alandaki tüm "duvar olmayan" hücreler tek parça connected olmalı.
        boolean[][] visited = new boolean[ROWS][COLS];

        int startR = -1, startC = -1;
        int openCount = 0;

        for (int r = 1; r < ROWS - 1; r++) {
            for (int c = 1; c < COLS - 1; c++) {
                if (grid[r][c] != '#') {
                    openCount++;
                    if (startR == -1) {
                        startR = r;
                        startC = c;
                    }
                }
            }
        }

        if (openCount == 0) return false;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int reached = 1;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr <= 0 || nr >= ROWS - 1 || nc <= 0 || nc >= COLS - 1) continue;
                if (visited[nr][nc]) continue;
                if (grid[nr][nc] == '#') continue;

                visited[nr][nc] = true;
                reached++;
                q.add(new int[]{nr, nc});
            }
        }

        return reached == openCount;
    }
}
