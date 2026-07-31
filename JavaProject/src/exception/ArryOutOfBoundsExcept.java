package exception;

public class ArryOutOfBoundsExcept {

	public static void main(String[] args) {
		// ArrayIndexOutOfBoundsException : 실행예외
		// String[] args 매개변수
		
		//main의 매개변수에 문자열 전달 없이 실행 : args배열은 index가 생성되지 않음
		//main()의 args 매개값 전달 : Run > run config... arguments 탭 program arguments
		String data1 = args[0];//args 매개변수 전달 안되면 ArrayIndexOutOfBoundsException
		String data2 = args[1];
		
		System.out.println("args[0]:"+data1);
		System.out.println("args[1]:"+data2);
		
		//배열의 길이를 먼저 조사 후 에러 방지
		if(args.length == 2) {
			data1 = args[0];//args 매개변수 전달 안되면 ArrayIndexOutOfBoundsException
			data2 = args[1];
			
			System.out.println("args[0]:"+data1);
			System.out.println("args[1]:"+data2);
		}else {
			System.out.println("매개변수 문자열 배열의 잘못된 접근");
		}
		
		int[] arr = {1,2,3};
		System.out.println(arr[5]); //실행시점에 해당 인덱스에 접근,index 5 out of bounds for length 3
		

	}

}
