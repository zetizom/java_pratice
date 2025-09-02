import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

public class Advent_of_code_4_Revised {

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

        final String WORD_TO_FIND = "XMAS";
        final int WORD_LEN = WORD_TO_FIND.length();
        final int MAX_ROWS = grid.size();
        final int MAX_COLS = grid.get(0).length(); // 모든 줄의 길이가 같다고 가정
        
        int count = 0;

        // 8가지 방향에 대한 row, col 변화량 정의
        int[] dr = {-1, -1, -1,  0, 0,  1, 1, 1}; // row change
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1}; // col change

        // 1. 모든 시작 지점 (r, c)을 순회
        for (int r = 0; r < MAX_ROWS; r++) {
            for (int c = 0; c < MAX_COLS; c++) {
                
                // 2. 8가지 모든 방향을 순회
                for (int d = 0; d < 8; d++) {
                    boolean wordFound = true;
                    
                    // 3. 해당 방향으로 단어 길이만큼 글자를 확인
                    for (int k = 0; k < WORD_LEN; k++) {
                        int nextR = r + k * dr[d];
                        int nextC = c + k * dc[d];

                        // 그리드 범위를 벗어나는지 확인
                        if (nextR < 0 || nextR >= MAX_ROWS || nextC < 0 || nextC >= MAX_COLS) {
                            wordFound = false;
                            break;
                        }
                        
                        // 단어의 k번째 글자와 일치하는지 확인
                        if (grid.get(nextR).charAt(nextC) != WORD_TO_FIND.charAt(k)) {
                            wordFound = false;
                            break;
                        }
                    }

                    if (wordFound) {
                        count++;
                    }
                }
            }
        }
        
        System.out.println("결과: " + count);
        
    }
}