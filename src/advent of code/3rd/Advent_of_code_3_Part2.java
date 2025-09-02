import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent_of_code_3_Part2 {

    public static void main(String[] args) {
        long totalSum = 0;
        String fileName = "C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\currupted_memory.txt";

        // 1. 상태 변수를 while 루프 바깥으로 이동!
        // 프로그램 시작 시 기본값은 활성화입니다.
        boolean isEnabled = true;

        // 2. 정규식 패턴도 루프 밖에서 한 번만 컴파일합니다.
        String regex = "(mul\\((\\d{1,3}),(\\d{1,3})\\))|(do\\(\\))|(don't\\(\\))";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                // 3. checkMul... 함수 로직을 main의 while 루프 안으로 가져옵니다.
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    if (matcher.group(1) != null) { // 'mul' 패턴 매칭
                        if (isEnabled) { // isEnabled 상태는 이제 여러 줄에 걸쳐 유지됩니다.
                            int num1 = Integer.parseInt(matcher.group(2));
                            int num2 = Integer.parseInt(matcher.group(3));
                            totalSum += (long) num1 * num2; // totalSum이 long이므로 형변환
                        }
                    } else if (matcher.group(4) != null) { // 'do' 패턴 매칭
                        isEnabled = true;
                    } else if (matcher.group(5) != null) { // 'don't' 패턴 매칭
                        isEnabled = false;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
            return;
        }

        System.out.println("활성화된 곱셈의 총합: " + totalSum);
    }
}