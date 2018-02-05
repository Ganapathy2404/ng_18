public class ArrayCode {

	private CodePair[] myPairs;
	private int size;
	private int numberOfPairs;

	public ArrayCode(int size) {
		myPairs = new CodePair[size];
		this.size = size;
		numberOfPairs = 0;

		// TODO Auto-generated constructor stub
	}

	private void expandCapacity() {
		if (myPairs.length <= 100) {
			CodePair[] largermyPairs = new CodePair[size * 2];
			size = size * 2;
			for (int i = 0; i < myPairs.length; i++) {
				largermyPairs[i] = myPairs[i];
			}
			myPairs = largermyPairs;
		} else {
			CodePair[] largermyPairs = new CodePair[size + 20];
			size = size +20;
			for (int i = 0; i < myPairs.length; i++) {
				largermyPairs[i] = myPairs[i];
				
			}
			myPairs = largermyPairs;
		}

	}

	public void add(CodePair pair) {
		if (numberOfPairs == myPairs.length) {
			//expandCapacity();
			expandCapacity();
		}
		myPairs[numberOfPairs] = pair;
		numberOfPairs++;
		
	}

	private void decreaseCapacity() {
		if (numberOfPairs < (size / 4)) {
			CodePair[] smallermyPairs = new CodePair[size / 2];
			size = size / 2;
			for (int i = 0; i < smallermyPairs.length; i++) {
				smallermyPairs[i] = myPairs[i];
				myPairs = smallermyPairs;
			}
		}

	}

	public void remove(CodePair pairToRemove) {

		for (int i = 0; i < numberOfPairs; i++) {

			if (myPairs[i].equals(pairToRemove)) {
				myPairs[i] = myPairs[numberOfPairs - 1];
				// CodePair[] removedPairs = new CodePair [numberOfPairs];
				// myPairs[numberOfPairs] = null;
				// for (int j = 0; j < myPairs.length-2; j ++)
				// myPairs[j]= removedPairs[i];
				numberOfPairs--;
			}
		}
		//numberOfPairs--;
		decreaseCapacity();

	}

	public int findCode(String code) {
		int var = -1;
		for (int i = 0; i < size; i++) {
			if (myPairs[i].getCode().equals(code)) {
				return i;
			}

		}
		return var;

	}

	public int findCharacter(char c) {

		for (int i = 0; i < size; i++) {
			if (myPairs[i].getCharacter() == c) {
				return i;
			}
		}
		return -1;
	}

	public String getCode(int i) {
		if (i < size && i >= 0) {
			return myPairs[i].getCode();
		}
		return null;
	}

	public char getCharacter(int i) {
		if (i < numberOfPairs && i >= 0) {
			return myPairs[i].getCharacter();
		}
		return 0;

	}

	public int getSize() {
		return size;
	}

	public int getNumPairs() {
		return this.numberOfPairs;
	}

}
