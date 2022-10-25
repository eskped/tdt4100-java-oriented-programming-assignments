package w08.extlib.interfacelib;

public class ExtInterfaceLibContentAnalyser {
	public static String analyze(InterfaceExtLib content) {
		String retVal = null;
		if (content != null) {
			retVal = String.format("\"%s\"\n", content.getContent());
			retVal += String.format("Antall tegn: %d\n", content.getContent().length());
			retVal += String.format("Antall ord: %d\n", content.getContent().trim().split("\\s+").length);
		}
		return retVal;
	}
}
