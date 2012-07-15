import java.util.ArrayList;
import java.util.List;

public class Rotor {
	private List<Mapping> keyMappings;

	public Rotor(List<Mapping> keyMappings) {
		this.keyMappings = keyMappings;
	}

	public Mapping firstMapping() {
		return keyMappings.get(0);
	}

	public void spin() {
		Mapping firstmapping = keyMappings.remove(0);
		
		keyMappings.add(firstmapping);
	}

	public int mappedPositionFor(char inputCharacter) {
		return mappedPositionFor(InputPosition.position(inputCharacter));
	}

	public int mappedPositionFor(int inputPosition) {
		Mapping mapping = keyMappings.get(inputPosition);
		char right = mapping.getRight();
		for (int i = 0; i < keyMappings.size(); i++) {
			if(keyMappings.get(i).getLeft() == right){
				return i;
			}
		}
		throw new RuntimeException("could not get mapping");
	}
	
	public static Rotor rotor1(){
		return createRotorFrom("ekmflgdqvzntowyhxuspaibrcj");
	}
	
	public static Rotor rotor2(){
		return createRotorFrom("ajdksiruxblhwtmcqgznpyfvoe");
	}
	
	public static Rotor rotor3(){
		return createRotorFrom("bdfhjlcprtxvznyeiwgakmusqo");
	}

	private static Rotor createRotorFrom(String rightHandSide) {
		List<Mapping> keyMappings = new ArrayList<Mapping>();
		for (int i = 0; i < 26; i++) {
			keyMappings.add(new Mapping(InputPosition.characterFor(i), rightHandSide.charAt(i)));
		}
		return new Rotor(keyMappings);
	}

	public Rotor startAt(char c) {
		for (int i = 0; i < InputPosition.position(c); i++) {
			spin();
		}
		return this;
	}
}
