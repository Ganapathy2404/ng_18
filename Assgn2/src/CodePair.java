
public class CodePair {

	private char c;
	private String code;
	public CodePair(char c, String code) {
		this.c = c;
		this.code = code;
		
		
		// TODO Auto-generated constructor stub
	}
	
	public String getCode() {
		return this.code;	
	}
	
	public char getCharacter() {
		return this.c;
	}
	
	public void setCharacter(char c) {
		this.c = c;
	}
	public void setCode(String code) {
		this.code = code;
		
	}
	
	public boolean equals (CodePair anotherPair) {
		if ((this.c == anotherPair.c) && (this.code.equals(anotherPair.code))){
			return true;		
		}else {
			return false;
		}
		
	}

}
