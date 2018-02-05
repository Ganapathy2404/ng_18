
public class Compress {

	public static void main(String[] args) {
		System.out.println("Name of file to compress: "+ args[0]); 
		System.out.println("Name of file storing compression codes: "+ args[1]);
		//String outputName = args[0].substring(0, args[0].length() - 3) + "zzz";
		String textFileName = args[0];
		String codeFileName = args[1];
		
		TextFile inFile;
		TextFile codeFile;
		TextFile outFile;
		ArrayCode myPairs;
		
		inFile = new TextFile(textFileName, "read");
		codeFile = new TextFile(codeFileName,"read");
		outFile = new TextFile("out.txt","write");
		myPairs = new ArrayCode(20);
		
		boolean endOfFile = false;
		
		while (endOfFile == false) {
			char codeStart = codeFile.readChar();
			String actualCode = codeFile.readLine();
			
			if (actualCode != null) {
				CodePair pair = new CodePair(codeStart, actualCode);
				//System.out.println(pair.getCharacter());
				myPairs.add(pair);
			}
			else {
				endOfFile = true;
				
			}
		}

		endOfFile = false;
		
		while (endOfFile == false) {
			char c = inFile.readChar();
			int codePost = myPairs.findCharacter(c);
			if (codePost != -1) {
				String code = myPairs.getCode(codePost);
				//System.out.println(codePost);
				
				for (int i = 0; i < code.length(); i ++) {
					outFile.writeChar(code.charAt(i));
					System.out.println(code.charAt(i));
					
				}
				
			}
			
			else
				endOfFile = true;
		}
		outFile.close();
		
		
		
	}

}
