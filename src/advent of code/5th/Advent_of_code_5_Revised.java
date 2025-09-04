import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

public class Advent_of_code_5_Revised {

    public static void main(String[] args) {
        List<String> allLines = new ArrayList<>();
        try {
            allLines = Files.readAllLines(Paths.get("C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\printing.txt"));
        } catch (IOException e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
            return;
        }

        if (allLines.isEmpty()) {
            System.out.println("파일이 비어있습니다.");
            return;
        }
        
        List<String> ruleStrings = new ArrayList<>();
        List<String> updateStrings = new ArrayList<>();
        boolean isRuleSection = true;

        for (String line : allLines) {
            if (line.trim().isEmpty()) {
                isRuleSection = false;
                continue;
            }
            if (isRuleSection) {
                ruleStrings.add(line);
            } else {
                updateStrings.add(line);
            }
        }

        long totalSumOfMiddles = 0;

        // 1. 각 update 목록을 순회합니다.
        for (String updateLine : updateStrings) {
            // 현재 update에 포함된 페이지들을 List와 Set으로 파싱
            List<Integer> currentUpdatePages = Arrays.stream(updateLine.split(","))
                                                       .map(s -> Integer.parseInt(s.trim()))
                                                       .collect(Collectors.toList());
            Set<Integer> pagesInUpdateSet = new HashSet<>(currentUpdatePages);

            boolean isUpdateValid = true;

            // 2. 현재 update에 대해 모든 규칙을 검사합니다.
            for (String ruleLine : ruleStrings) {
                String[] parts = ruleLine.split("\\|");
                int beforePage = Integer.parseInt(parts[0]);
                int afterPage = Integer.parseInt(parts[1]);

                // 3. 규칙의 두 페이지가 모두 현재 update에 포함되어 있는지 확인합니다.
                if (pagesInUpdateSet.contains(beforePage) && pagesInUpdateSet.contains(afterPage)) {
                    
                    // 4. 순서가 올바른지 확인합니다. 'before'가 'after'보다 뒤에 나오면 규칙 위반입니다.
                    if (currentUpdatePages.indexOf(beforePage) > currentUpdatePages.indexOf(afterPage)) {
                        isUpdateValid = false;
                        break; // 위반을 하나라도 찾으면 더 검사할 필요 없음
                    }
                }
            }

            // 5. 모든 규칙 검사를 통과했다면, 중간 값을 합계에 더합니다.
            if (isUpdateValid) {
                int middleIndex = currentUpdatePages.size() / 2;
                totalSumOfMiddles += currentUpdatePages.get(middleIndex);
            }
        }
        
        System.out.println("결과: " + totalSumOfMiddles);
    }
}