import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class advent {
	public static void main(String[] args) {
	
		String fileName = "C:\\Users\\User\\IdeaProjects\\untitled1\\resources\\currupted_memory.txt";
		String regex = "(mul)\\((\\d{1,3}),(\\d{1,3})\\)|(don't)|(do)";  
		Pattern pattern = Pattern.compile(regex);
		int lineTotal = 0;	
	
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;			
			boolean isEnable = true;
			
			while((line = br.readLine()) != null) {
			
				Matcher matcher = pattern.matcher(line);
			
				while(matcher.find()) {	
					if(matcher.group(1) != null) { // mul이 존재
						if(isEnable == true) {
							String numStr1 = matcher.group(2);
							String numStr2 = matcher.group(3);
						
							int num1 = Integer.parseInt(numStr1);
							int num2 = Integer.parseInt(numStr2);
						
							lineTotal += num1 * num2;
						}
					}
					else if(matcher.group(4) != null) { // don't 존재
						isEnable  = false;
					}
					else if(matcher.group(5) != null) { // do 존재
						isEnable = true;
					}
					else {
						break;
					}
				}
			}
		} catch(IOException e) {
			System.out.println("오류발생: " + e);
			return ;
		}
	
		System.out.println("결과: " + lineTotal);
	}
}
 		
		