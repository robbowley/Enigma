import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class First_rotor_configured_to_k {
	@Test
	public void firstRotorEncodes() {
		List<Mapping> keyMappings = new ArrayList<Mapping>();
		keyMappings.add(new Mapping('k', 'x'));
		keyMappings.add(new Mapping('l', 'v'));
		keyMappings.add(new Mapping('v', 'q'));
		Rotor rotor = new Rotor(keyMappings);
		
		Machine machine = new Machine(rotor, null, null);
		
		assertEquals(1, machine.positionBasedOnFirstRotor('a'));
	}
	
	@Test
	public void twoRotorsReturnsExpectedPositionOfSecondRotor() {
		Machine machine = new Machine(Rotor.rotor3(), Rotor.rotor2(), null);

		assertEquals(InputPosition.position('r'), machine.positionBasedOnTwoRotors('c'));
	}
	
	@Test
	public void threeRotorsReturnsExpectedPositionOfThirdRotor() {
		Machine machine = new Machine(Rotor.rotor3(), Rotor.rotor2(), Rotor.rotor1());

		assertEquals(InputPosition.position('u'), machine.positionBasedOnThreeRotors('c'));
	}
	
	@Test
	public void threePositionedRotorsReturnsExpectedPositionOfThirdRotor() {
		Rotor rotor3 = Rotor.rotor3().startAt('k');
		Rotor rotor2 = Rotor.rotor2().startAt('c');
		Rotor rotor1 = Rotor.rotor1().startAt('m');
		Machine machine = new Machine(rotor3, rotor2, rotor1);

		assertEquals(InputPosition.position('j'), machine.positionBasedOnThreeRotors('e'));
	}
	
	@Test
	public void rotorCanRotate(){
		List<Mapping> keyMappings = new ArrayList<Mapping>();
		keyMappings.add(new Mapping('k', 'x'));
		keyMappings.add(new Mapping('l', 'v'));
		Rotor rotor = new Rotor(keyMappings);

		assertEquals(new Mapping('k', 'x'), rotor.firstMapping());
		
		rotor.spin();
		
		assertEquals(new Mapping('l', 'v'), rotor.firstMapping());
	}
	
	@Test
	public void rotorCanMap(){
		List<Mapping> keyMappings = new ArrayList<Mapping>();
		keyMappings.add(new Mapping('x', 'z'));
		keyMappings.add(new Mapping('y', 'y'));
		keyMappings.add(new Mapping('z', 'x'));
		keyMappings.add(new Mapping('l', 'v'));
		keyMappings.add(new Mapping('a', 'b'));
		keyMappings.add(new Mapping('v', 'm'));
		keyMappings.add(new Mapping('b', 'c'));
		
		Rotor rotor = new Rotor(keyMappings);
		
		assertEquals(5, rotor.mappedPositionFor('d'));
	}
	
	@Test
	public void rotorCanMapPosition(){
		List<Mapping> keyMappings = new ArrayList<Mapping>();
		keyMappings.add(new Mapping('x', 'z'));
		keyMappings.add(new Mapping('y', 'y'));
		keyMappings.add(new Mapping('z', 'x'));
		keyMappings.add(new Mapping('l', 'v'));
		keyMappings.add(new Mapping('a', 'b'));
		keyMappings.add(new Mapping('v', 'm'));
		keyMappings.add(new Mapping('b', 'c'));
		
		Rotor rotor = new Rotor(keyMappings);
		
		assertEquals(5, rotor.mappedPositionFor(3));
	}
	
	@Test
	public void canWorkOutPositionForInputCharacter(){
		assertEquals(0, InputPosition.position('a'));
		assertEquals(1, InputPosition.position('b'));
		assertEquals(25, InputPosition.position('z'));
	}
	
	@Test
	public void canWorkOutCharacterGivenPosition(){
		assertEquals('a', InputPosition.characterFor(0));
		assertEquals('i', InputPosition.characterFor(8));
		assertEquals('z', InputPosition.characterFor(25));
	}
}
