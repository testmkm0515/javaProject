package recursion;

public class Recurision1 {
	//SUM(n) = n+(n-1)+(n-2)+(n-3)+....+1
	//SUM(5) = 5+SUM(4)
	//SUM(4) = 4+SUM(3)
	//SUM(3) = 3+SUM(2)
	//SUM(2) = 2+SUM(1)
	//SUM(1) = 1+SUM(0)
	//SUM(0) : return 0
	
	public static void main(String[] args) {
		System.out.println(sum(5));
	}
	static int sum(int n) {
		if(n==0) {
			return 0;			
		}else {
			return n+sum(n-1);
		}
	}

}
