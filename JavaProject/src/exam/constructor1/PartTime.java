package exam.constructor1;

public class PartTime extends Worker{
	private int hours;
	private int unitPrice;
	
	//상속받은 클래스인 subclass의 객체인스턴스 생성하면, superclass의 인스턴스도 생성
	public PartTime(String joominNo, String name, int hours, int unitPrice) {
		super(joominNo,name);
		this.hours = hours;
		this.unitPrice = unitPrice;
	}
	
	public int calculatePay() {
		return hours * unitPrice;
	}
	
	@Override
	public String toString() {
		return super.toString() +
				"\n시급 : " + unitPrice +" 원" +
				"\n근무시간 : " + hours + " 시간" +
				"\n총 지불액 : " + calculatePay() + " 원";
	}
}












