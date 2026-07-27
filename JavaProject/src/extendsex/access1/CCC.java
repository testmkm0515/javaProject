package extendsex.access1;

import extendsex.access.AAA; //public 클래스

public class CCC {
	
	public CCC() {
		AAA a = new AAA();		
		a.field1 = 1;
		a.fiedl2 = 1; //접근제한 default
		a.fiedl3 = 1; //접근제한 private
		a.fiedl4 = 1; //접근제한 protected, 패키지가 다르면 접근 불가능
	
	}
}
