package FileTransfer;

public class Protocol {
	private static final int WAITING = 0;
	private static final int SENTGREETING = 1;

	private int state = WAITING;

	public String processInput(String theInput) {
		String theOutput = null;

		if (state == WAITING) {
			theOutput = "Hi this is Saptarshi!";
			state = SENTGREETING;
		} else if (state == SENTGREETING) {
			if (theInput.equals("ACK")) {
				theOutput = "DONE";
			} else {
				theOutput = "You're supposed to say ACK!";
			}
		}
		return theOutput;
	}
}