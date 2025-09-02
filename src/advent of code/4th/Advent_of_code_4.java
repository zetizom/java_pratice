import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Advent_of_code_4 {
	public static void main(String[] args) {
		ArrayList<String> lineList = new ArrayList<>();
	
		try {
			File file = new File("C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\xmas.txt");
			
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				lineList.add(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("읽기 실패: " + e);
		}
		
		int sum = 0;
		
		String regex = "(?=(XMAS))|(?=(SAMX))";
		Pattern pattern = Pattern.compile(regex);
		
		// 행 채크
		for(int i = 0; i < lineList.size(); i++) { 
			String line = lineList.get(i); 
			Matcher matcher = pattern.matcher(line);
			
			while(matcher.find()) {
				if (matcher.group(1) != null) {
					++sum;
				}
				if (matcher.group(2) != null) {
					++sum;
				} 
			}
		}
			
		// 열 채크
		for (int i = 0; i < lineList.size(); i++) {
			String line = lineList.get(i);
			for (int n = 0; n < line.length(); n++) {
				if (line.charAt(n) == 'X' && i + 3 < lineList.size()) {
					String line2 = lineList.get(i + 1);
					String line3 = lineList.get(i + 2);
					String line4 = lineList.get(i + 3);

					// 각 줄이 n번째 인덱스를 안전하게 가지고 있는지 확인
					if (line2.length() > n && line3.length() > n && line4.length() > n) {
						if (line2.charAt(n) == 'M' && line3.charAt(n) == 'A' && line4.charAt(n) == 'S') {
							++sum;
						}
					}	
				}

				if (line.charAt(n) == 'S' && i + 3 < lineList.size()) {
					String line2 = lineList.get(i + 1);
					String line3 = lineList.get(i + 2);
					String line4 = lineList.get(i + 3);

					if (line2.length() > n && line3.length() > n && line4.length() > n) {
						if (line2.charAt(n) == 'A' && line3.charAt(n) == 'M' && line4.charAt(n) == 'X') {
							++sum;
						}
					}
				}
			}
		}
		
		//대각선 채크
		
		for (int i = 0; i < lineList.size(); i++) {
			String line = lineList.get(i);
			for (int n = 0; n < line.length(); n++) {
				if (line.charAt(n) == 'X' && i + 3 < lineList.size()) {
					String line2 = lineList.get(i + 1);
					String line3 = lineList.get(i + 2);
					String line4 = lineList.get(i + 3);

					// 각 줄이 n번째 인덱스를 안전하게 가지고 있는지 확인
					if (line2.length() > n+1 && line3.length() > n+2 && line4.length() > n+3) {
						if (line2.charAt(n+1) == 'M' && line3.charAt(n+2) == 'A' && line4.charAt(n+3) == 'S') {
							++sum;
						}
					}
					
					if (n >= 3 && n - 1 < line2.length() && n - 2 < line3.length() && n - 3 < line4.length()) {
						if (line2.charAt(n-1) == 'M' && line3.charAt(n-2) == 'A' && line4.charAt(n-3) == 'S') {
							++sum;
						}
					}
				}

				if (line.charAt(n) == 'S' && i + 3 < lineList.size()) {
					String line2 = lineList.get(i + 1);
					String line3 = lineList.get(i + 2);
					String line4 = lineList.get(i + 3);

					if (line2.length() > n+1 && line3.length() > n+2 && line4.length() > n+3) {
						if (line2.charAt(n+1) == 'A' && line3.charAt(n+2) == 'M' && line4.charAt(n+3) == 'X') {
							++sum;
						}
					}
					
					if (n >= 3 && n - 1 < line2.length() && n - 2 < line3.length() && n - 3 < line4.length()) {
						if (line2.charAt(n-1) == 'A' && line3.charAt(n-2) == 'M' && line4.charAt(n-3) == 'X') {
							++sum;
						}
					}
				}
			}
		}
		
		System.out.println("결과: " + sum);
	}
}
		