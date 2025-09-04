import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Advent_of_code_5 {

    public static void main(String[] args) {
        List<String> printing = new ArrayList<>();
        try {
            // 파일을 읽는 더 현대적이고 간결한 방법입니다.
            printing = Files.readAllLines(Paths.get("C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\printing.txt"));
        } catch (IOException e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
            return;
        }

        if (printing.isEmpty()) {
            System.out.println("파일이 비어있습니다.");
            return;
        }
        
        List<String> rules = new ArrayList<>();
        List<String> update = new ArrayList<>();

        // 현재 어느 리스트에 넣을지 결정하는 플래그
        boolean toFirstList = true;

        for (String line : printing) {
            if (line.trim().isEmpty()) {
                // 빈 줄을 만나면 두 번째 리스트로 전환
                toFirstList = false;
                continue;
            }

            if (toFirstList) {
                rules.add(line);
            } else {
                update.add(line);
            }
        }      
       
        int sum = 0;

        // 1. 업데이트 배열 순환 시작
        for (int i = 0; i < update.size(); i++) {
        	String[] print = update.get(i).split(",");
        	List<Integer> numbers = new ArrayList<>();

        	for (String p : print) { // 2. update의 요소를 int 형으로 저장
        		numbers.add(Integer.parseInt(p.trim()));
        	}

        	boolean updater = true;

        	// 3. 규칙들과 비교 시작
        	for (String ruleLine : rules) {
        		String[] ruleParts = ruleLine.split("\\|"); 
        		int a = Integer.parseInt(ruleParts[0].trim());
        		int b = Integer.parseInt(ruleParts[1].trim());

        		//4. 위반 요소 확인 
        		if (numbers.contains(a) && numbers.contains(b)) {
        			if (numbers.indexOf(a) > numbers.indexOf(b)) {
        				updater = false;
        				break; // 위반 요소 발견 시 더 검사 필요 x
        			}
        		}
        	}
        	
        	// 5. 모든 검사 통과 시 가운데 값 추가 
        	if (updater) { 
        		int middle = numbers.get(numbers.size() / 2);
        		sum += middle;
        	}
        }

		System.out.println("합계: " + sum);
  
    }
}