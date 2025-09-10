import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Advent_of_code_6 {

    public static void main(String[] args) {
        List<String> grid = new ArrayList<>();
        try {
            // 파일을 읽는 더 현대적이고 간결한 방법입니다.
            grid = Files.readAllLines(Paths.get("C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\guard's map.txt"));
        } catch (IOException e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
            return;
        }

        if (grid.isEmpty()) {
            System.out.println("파일이 비어있습니다.");
            return;
        }

        final int MAX_ROWS = grid.size();
        final int MAX_COLS = grid.get(0).length(); // 모든 줄의 길이가 같다고 가정
        
        
        List<String> pathGrid = new ArrayList<>(); // 지나간 경로를 표현할 그리드
        for (int i = 0; i < MAX_ROWS; i++) {
        	pathGrid.add("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");		
        }
        
        String guardState = "UP";
        int state 4;
        
        while() {
        	        	
        	switch(State) {
        		case 1 : guardState = "UP"
        			
        		case 2 : guardState = "DOWN"
        			
        		case 3 : guardState = "RIGHT"
        			
        		case 4 : guardState = "LEFT"
        	}
        }

        
    }
}