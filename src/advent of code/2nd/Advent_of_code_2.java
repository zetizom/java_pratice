import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Advent_of_code_2 {

    /**
     * 주어진 숫자 배열(보고서)이 안전한지 판단하는 함수
     * @param report 정수로 변환된 하나의 보고서
     * @return 안전하면 true, 아니면 false
     */
    private static boolean isReportSafe(int[] report) {
        // 보고서의 수치가 2개 미만이면 판단할 수 없으므로 안전하지 않음
        if (report.length < 2) {
            return false;
        }

        // 1. 초기 방향 결정 (증가: 1, 감소: -1)
        int initialDiff = report[1] - report[0];
        int direction;

        if (initialDiff > 0) {
        } else if (initialDiff < 0) {
            direction = -1; // 감소
        } else {
            return false; // 수치가 같으면 안전하지 않음 (8 6 4 4 1 예시)
        }

        // 첫 번째 차이도 규칙을 지키는지 확인
        if (Math.abs(initialDiff) > 3) {
            return false;
        }

        // 2. 두 번째 숫자부터 끝까지 순회하며 규칙 확인
        for (int i = 1; i < report.length - 1; i++) {
            int currentDiff = report[i+1] - report[i];
            
            // 방향이 바뀌었는지 확인 (부호를 곱해서 음수이면 방향이 바뀐 것)
            if (currentDiff * direction <= 0) { 
                return false; // 방향이 다르거나, 수치가 같으면 안전하지 않음
            }

            // 차이가 1~3 범위를 벗어나는지 확인
            if (Math.abs(currentDiff) > 3) {
                return false;
            }
        }
        
        // 모든 검사를 통과했다면 안전함
        return true;
    }

    public static void main(String[] args) {
        String fileName = "C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\unusual_data.txt";
        int safeReportCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                // Stream API를 사용한 간결한 파싱
                int[] iarr = Arrays.stream(line.split("\\s+"))
                                     .mapToInt(Integer::parseInt)
                                     .toArray();

                if (isReportSafe(iarr)) {
                    safeReportCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
            return;
        }

        System.out.println("안전한 보고서의 총 개수: " + safeReportCount);
    }
}
		
					
					