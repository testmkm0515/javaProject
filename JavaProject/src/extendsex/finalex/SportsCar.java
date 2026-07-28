package extendsex.finalex;

public class SportsCar extends MyCar{
	@Override
	public void speedUp() {
		speed += 10;
	}
	
	@Override
	public void stop() { //Cannot override the final method from MyCar
		
	}
}
