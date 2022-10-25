package w08.extlib.extlibclient;

import w08.extlib.abstractlib.AbstractExtLib;
import w08.extlib.abstractlib.ExtAbstractLibContentAnalyzer;

public class ExtLibClientV2A extends AbstractExtLib {
	private String content = "Dette er vår setning som skal bli analysert."; 
	
	public static void main(String[] args) {
		System.out.println("ExtLibClientV2A");

		ExtLibClientV2A client = new ExtLibClientV2A();
		
		System.out.println(ExtAbstractLibContentAnalyzer.analyze(client));
	}

	@Override
	public String getContent() {
		return content;
	}
}
