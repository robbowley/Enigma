
public class Machine {
	private final Rotor rotor1;
	private final Rotor rotor2;
	private final Rotor rotor3;

	public Machine(Rotor rotor1, Rotor rotor2, Rotor rotor3) {
		this.rotor1= rotor1;
		this.rotor2 = rotor2;
		this.rotor3 = rotor3;
	}

	public int positionBasedOnFirstRotor(char c) {
		rotor1.spin();
		return rotor1.mappedPositionFor(c);
	}

	public int positionBasedOnTwoRotors(char c) {
		rotor1.spin();
		int positionOutOfRotor1 = rotor1.mappedPositionFor(c);
		return rotor2.mappedPositionFor(positionOutOfRotor1);
	}

	public int positionBasedOnThreeRotors(char c) {
		rotor1.spin();
		int positionOutOfRotor1 = rotor1.mappedPositionFor(c);
		int postionOfRota2 = rotor2.mappedPositionFor(positionOutOfRotor1);
		return rotor3.mappedPositionFor(postionOfRota2);
	}
}
