package w08.extlib.abstractlib;

public class ExtAbstractLibContentAnalyzer {
	public static String analyze(AbstractExtLib content) {
		String retVal = null;
		if (content != null) {
			retVal = String.format("\"%s\"\n", content.getContent());
			retVal += String.format("Antall tegn: %d\n", content.getContent().length());
			retVal += String.format("Antall ord: %d\n", content.getContent().trim().split("\\s+").length);
		}
		return retVal;
	}
}
