import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 정규식과 관련 메서드 사용을 위해서 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent_of_code_3 {
	
	
	// 한줄을 받아 줄 안의 유효한 mul 계산 값을 더한 후 그 결과를 반환하는 함수
	// main이 static이니 이 메서드도 static
	public static int checkMul(String line) {
		int lineTotal = 0;
		
		// 찾을 정규식 패턴 정의 
		String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
		
		// 패턴을 컴파일
		Pattern pattern = Pattern.compile(regex);
		
		// 문자열에서 패턴 검색
		Matcher matcher = pattern.matcher(line);
		
		 
		
		while (matcher.find()) {
			String numStr1 = matcher.group(1);
			String numStr2 = matcher.group(2);
		
			int num1 = Integer.parseInt(numStr1);
			int num2 = Integer.parseInt(numStr2);
			
			lineTotal += num1 * num2;
		}
		return lineTotal;
	}
	
	
	public static void main(String[] args) {
		
		int sum = 0;
		
		String fileName = "C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\currupted_memory.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			
			while((line = br.readLine()) != null) {
				if (line.isBlank()) { continue; }
				
				sum += checkMul(line);
			}
			
		} catch (IOException e) {
			System.out.println("파일 읽기 중 오류 발생: " + e.getMessage());
			return;
		}
		
		System.out.println("총합: " + sum);
	}
}