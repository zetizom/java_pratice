import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Advent_of_code_4_Part2 {

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        try {
            // 파일을 읽는 더 현대적이고 간결한 방법입니다.
            grid = Files.readAllLines(Paths.get("C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\xmas.txt"));
        } catch (IOException e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
            return;
        }

        if (grid.isEmpty()) {
            System.out.println("파일이 비어있습니다.");
            return;
        }

        // --- 일반화된 탐색 로직 시작 ---
        final int MAX_ROWS = grid.size();
        final int MAX_COLS = grid.get(0).length(); 
  		int count = 0;      

        // 1. 모든 시작 지점 (r, c)을 순회
        for (int r = 1; r < MAX_ROWS - 1; r++) { // 범위 제한은 for문을 통해서 
            for (int c = 1; c < MAX_COLS - 1; c++) {           
            	
            	if(grid.get(r).charAt(c) != 'A') {
            		continue;
            	}
            	
            	char topLeft = grid.get(r-1).charAt(c-1);
            	char topRight = grid.get(r-1).charAt(c+1);
            	char bottomLeft = grid.get(r+1).charAt(c-1);
            	char bottomRight = grid.get(r+1).charAt(c+1);
            	   
            	boolean diagonal1 = (topLeft == 'M' && bottomRight == 'S') || (topLeft == 'S' && bottomRight == 'M');
            	boolean diagonal2 = (topRight == 'M' && bottomLeft == 'S') || (topRight == 'S' && bottomLeft == 'M');
            	
            	if (diagonal1 && diagonal2) {
            		count++;
            	}          	            	   
            }
        }
        
        System.out.println("결과: " + count);
        
    }
}