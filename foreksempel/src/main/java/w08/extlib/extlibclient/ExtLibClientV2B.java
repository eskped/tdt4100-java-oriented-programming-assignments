package w08.extlib.extlibclient;

import w08.extlib.abstractlib.AbstractExtLib;
import w08.extlib.abstractlib.ExtAbstractLibContentAnalyzer;
import w08.extlib.contentlib.AnotherContentLib;

/**
 * Her møter vi på et problem ved at vi egentlig ønsker å arve fra 2 klasser. Så
 * hva gjør vi da? Dette er et forslag til en løsning.
 * 
 * @author steinlt
 *
 */
public class ExtLibClientV2B extends AnotherContentLib {
	private String content = "Dette er vår setning som skal bli analysert.";

	@Override
	public String getYourContent() {
		return content;
	}

	public static void main(String[] args) {
		System.out.println("ExtLibClientV2B");

		ExtLibClientV2B contentClient = new ExtLibClientV2B();
		AbstractExtLibClient innerClient = new AbstractExtLibClient(contentClient);

		System.out.println(ExtAbstractLibContentAnalyzer.analyze(innerClient));
	}

	private static class AbstractExtLibClient extends AbstractExtLib {
		private ExtLibClientV2B content;

		public AbstractExtLibClient(ExtLibClientV2B content) {
			this.content = content;
		}

		public String getContent() {
			return content.getYourContent();
		}
	}
}
