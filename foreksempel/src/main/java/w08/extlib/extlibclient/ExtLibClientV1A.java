package w08.extlib.extlibclient;

import w08.extlib.interfacelib.ExtInterfaceLibContentAnalyser;
import w08.extlib.interfacelib.InterfaceExtLib;

public class ExtLibClientV1A implements InterfaceExtLib {
	private String content = "Dette er vår setning som skal bli analysert."; 
	
	public static void main(String[] args) {
		System.out.println("ExtLibClientV1A");

		ExtLibClientV1A client = new ExtLibClientV1A();
		
		System.out.println(ExtInterfaceLibContentAnalyser.analyze(client));		
	}

	@Override
	public String getContent() {
		return content;
	}
}
