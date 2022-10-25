package w08.extlib.extlibclient;

import w08.extlib.contentlib.AnotherContentLib;
import w08.extlib.interfacelib.ExtInterfaceLibContentAnalyser;
import w08.extlib.interfacelib.InterfaceExtLib;

public class ExtLibClientV1B extends AnotherContentLib implements InterfaceExtLib {
	private String content = "Dette er vår setning som skal bli analysert.";
	
	@Override
	public String getYourContent() {
		return content;
	}
	
	@Override
	public String getContent() {
		return getYourContent();
	}
	
	public static void main(String[] args) {
		System.out.println("ExtLibClientV1B");

		ExtLibClientV1B client = new ExtLibClientV1B();
		
		System.out.println(ExtInterfaceLibContentAnalyser.analyze(client));
	}
}
