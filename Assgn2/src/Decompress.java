
public class Decompress {


	public static void main(String[] args) {
		System.out.println("Name of file to compress: "+ args[0]); 
		System.out.println("Name of file storing compression codes: "+ args[1]);
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
			char c = inFile.readBit();
			int codePost = myPairs.findCode(c);
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
