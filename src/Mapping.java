
public class Mapping {
	private final char left;
	private final char right;

	public Mapping(char left, char right) {
		this.left = left;
		this.right = right;
	}

	public char getRight() {
		return right;
	}
	
	public char getLeft() {
		return left;
	}
	
	@Override
	public String toString() {
		return "Mapping [left=" + left + ", right=" + right + "]";
	}
	
	public char mapTowardsMirror(char character) {
		return 'A';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + left;
		result = prime * result + right;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mapping other = (Mapping) obj;
		if (left != other.left)
			return false;
		if (right != other.right)
			return false;
		return true;
	}
}
