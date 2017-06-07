package lab_four_src;

/**
 * class to test the Message class and its
 * append() and overidden toString() methods
 * using established steps by lectures/book
 * CSE 271, B
 * @author Wallisan
 * Instructor: Dr. Stephan
 * 2/19/2017
 */
public class MessageTester {

	public static void main(String[] args) {
		// test append method
		Message testMessage = new Message("Walter Tracey", "Tristan Migoski");
		System.out.println("testMessage.getMessageBody() should print nothing.");
		System.out.println(testMessage.getMessageBody());
		testMessage.append("Hi Tristan!\nHow are you?!");
		System.out.println("Next getMessageBody() should print:\n"
				+ "Hi Tristan!\nHow are you?!");
		System.out.println("Actual appended body:\n" + testMessage.getMessageBody());

		// test toString() >>>
		// make another message, append some lines, test
		Message testMessageToString = new Message ("Walter Tracey", "Tristan Migoski");
		testMessageToString.append("Hi again Tristan!\nRight now, I'm just going to test my toString() method!\nCool, eh?");
		// test with prints
		System.out.println("toString() should print:\nFrom: Walter Tracey\nTo: Tristan Migoski\n\nHi again Tristan!\nRight now, I'm just going to test my toString() method!\nCool, eh?\n");
		System.out.println("Actual toString():\n" + testMessageToString);
	}

}// end MessageTester class
