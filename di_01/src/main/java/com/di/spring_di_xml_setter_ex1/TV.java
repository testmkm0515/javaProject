package com.di.spring_di_xml_setter_ex1;


//Speaker객체 필요 : DI(setter)
public class TV {
	private Speaker speaker;	

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
