import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Advent_of_code_1 {
	public static void main(String[] args) {
		// 1. ArrayList를 사용하여 데이터 크기에 유연하게 대처
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		System.out.println("현재 작업 디렉토리: " + System.getProperty("user.dir"));
		
		// 2. try-with-resources로 파일을 안전하게 열기 (경로는 상대 경로를 추천)
		String filePath = "C:/Users/User/IdeaProjects/untitled1/resources/location_IDs.txt"; // 예시 경로
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) { // 더 간결한 while 루프
				// 공백 라인 등 예외 처리 추가 가능
				if (line.isBlank()) continue;

				list1.add(Integer.parseInt(line.substring(0, 5)));
				list2.add(Integer.parseInt(line.substring(8)));
			}
		} catch (IOException e) {
			// 파일 읽기 중 오류 발생 시 처리
			System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
			return; // 프로그램 종료
		}

		// 각 리스트 정렬
		Collections.sort(list1);
		Collections.sort(list2);

		long sum = 0; // 합계가 int 범위를 넘어갈 수 있으므로 long 타입 사용을 고려
		for (int i = 0; i < list1.size(); i++) {
			// 3. Math.abs()로 절댓값 계산
			sum += Math.abs((long)list1.get(i) - list2.get(i));
		}

		System.out.println(sum);
	}
}

