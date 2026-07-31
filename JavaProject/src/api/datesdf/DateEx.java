package api.datesdf;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) {
		Date now = new Date(); //객체 생성시간 정보가 저장
		String strNow1 = now.toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); //생성자에 날짜 data의 형식 포맷을 문자열로 전달 
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
	}

}
