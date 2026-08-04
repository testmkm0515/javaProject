package ramda.multiparamreturn;

public class FunctionalEx {

	public static void main(String[] args) {
		// 함수형 인터페이스 구현 객체 구성(람다식)
		MyFunctionalInterface fi;
		//매개변수가 있고 반환문이 있는 추상메서드 구현 하는 람다식
		fi= (int x,int y)->{
			int result = x+y;
			return result;
		};
		fi.method(5,6);
		
		//매개변수 타입 생략 가능
		fi= (x,y)->{
			return x+y;
		};		
		fi.method(5,6);
		
		//람다식 실행블럭이 return 한줄 문장이면 중괄호 return 생략 가능
		fi = (x,y)-> x+y;
		fi.method(5,6);	
		
		//매개변수가 2개 이상인 경우 소괄호 필요
		fi = (x,y) -> x+y;
		fi.method(5,6);			

	}

}
