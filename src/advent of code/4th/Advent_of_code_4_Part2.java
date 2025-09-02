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
        final int WORD_LEN = WORD_TO_FIND.length();
        final int MAX_ROWS = grid.size();
        final int MAX_COLS = grid.get(0).length(); 
        int count = 0;
        

        // 1. 모든 시작 지점 (r, c)을 순회
        for (int r = 0; r < MAX_ROWS; r++) {
            for (int c = 0; c < MAX_COLS; c++) {
            	
            	boolean wordFound = false;
            	
            	if(grid.get(r).charAt(c) == 'A') {           		
            		if ( (r-1) < 0 || (r+1) >= MAX_ROWS || (c-1) < 0 || (c+1) >= MAX_COLS) {
            			wordFound = false;
            		}
            		else {
            			if(grid.get(r-1).charAt(c-1) =='M' && grid.get(r+1).charAt(c+1) == 'S') {
            				if(grid.get(r+1).charAt(c-1) == 'M' && grid.get(r-1).charAt(c+1) == 'S') {
            					wordFound = true;
            				}
            				if(grid.get(r+1).charAt(c-1) == 'S' && grid.get(r-1).charAt(c+1) == 'M') {
           						wordFound = true;
            					}
            			}
            			if(grid.get(r-1).charAt(c-1) =='S' && grid.get(r+1).charAt(c+1) == 'M') {
            				if(grid.get(r+1).charAt(c-1) == 'M' && grid.get(r-1).charAt(c+1) == 'S') {
            					wordFound = true;
           					}
           					if(grid.get(r+1).charAt(c-1) == 'S' && grid.get(r-1).charAt(c+1) == 'M') {
           						wordFound = true;
           					}
           				}	
            		}   
            	
            	}
            	else {
            		wordFound = false;
            	}
                
            	if (wordFound) {
            		count++;
                }            	            	   
            }
        }
        
        System.out.println("결과: " + count);
        
    }
}