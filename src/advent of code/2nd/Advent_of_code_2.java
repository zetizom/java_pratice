import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Advent_of_code_2 {
	public static void main(String[] args) {
		
		String fileName = "C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\unusual_data.txt";
		
		boolean toggle = false;
		int result = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while((line = br.readLine()) != null) {
				String arr[] = line.split("\\s");
				int iarr[] = new int[arr.length];
				
				for (int i = 0; i < arr.length; i++) {
					iarr[i] = Integer.parseInt(arr[i]);
					System.out.printf("%d ", iarr[i]);
				}
				System.out.printf("\n");
				
				
				int num = 0;
				for(int i = 0, n = 0; i < iarr.length; i++) {
					if (i+1 < arr.length) {
						
						if (iarr[0] > iarr[1]) { // 증가일 때
								if (iarr[i] - iarr[i+1] <= 0 || iarr[i] - iarr[i+1] >= 4) { 
								toggle = true;
							}
						}
						else { // 감소일 때
							if (iarr[i+1] - iarr[i] <= 0 || iarr[i+1] - iarr[i] >= 4) {
								toggle = true;
							}
						}
					}
				}
				
				if (toggle == false) { // 위 두 경우가 아니면 안전한 데이터
					result += 1; 
				} 
				else { // 맞을 경우 토글 초기화
					toggle = false;
				}
			}
		} catch (IOException e) {
			System.out.println("파일읽기 중 오류 발생: " + e.getMessage());
			return;
		}
		
		System.out.println(result);
	}
}
		
					
					