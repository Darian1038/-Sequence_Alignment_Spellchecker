/* Darian Torres
 */


public class SequenceAlignment {
	int gap = 2;
	int m;
	int n;
	int diffV = 1;
	int diffC = 1;
	int same = 0;
	int VC = 3;
	String word1;
	String word2;
	int A[][];
	
	
	public SequenceAlignment(String word1, String word2) {
		//taking in strings
		this.word1 = word1;
		this.word2 = word2;
		
		//taking size of the strings
		m = word1.length() + 1;
		n = word2.length() + 1;
		
		A = new int[m][n];
		
		//initialize
		for (int i = 0; i < m; i++)
			A[i][0] = i * gap;
		for (int j = 0; j < n; j++)
			A[0][j] = j * gap;
		
	}
	
	public int computeAlignment(int delta) {
		int alpha;
		//tabulating through characters to find similar characters
		for (int j = 1; j < n; j++) {
			//grabbing our current character from word2
			char cc2 = word2.charAt(j-1);
			for(int i = 1; i < m; i++) {
				//grabbing our current character from word1
				char cc1 = word1.charAt(i-1);
				alpha = computeAlpha(cc1, cc2);
				
				A[i][j] = Math.min(alpha + A[i-1][j-1], Math.min(gap + A[i-1][j], gap + A[i][j-1]));
			}
		}
		return A[m-1][n-1];
		
	}
	
	public String getAlignment() {
		StringBuilder wd1 = new StringBuilder();
		StringBuilder wd2 = new StringBuilder();
		int alpha;
		//goes backwards and finds the optial path
		while(m-1 > 0 && n-1 > 0) {
			//get alpha to utilize in if statements
			alpha = computeAlpha(word1.charAt(m-2), word2.charAt(n-2) );
			if(m>0 && n>0 && A[m-1][n-1] == A[m-2][n-2] + alpha){
				wd1.insert(0, word1.charAt(m-2));
				wd2.insert(0, word2.charAt(n-2));
				m--;
				n--;
			}
			else if (m > 0 && A[m-1][n-1] == A[m-2][n-1] + gap) {
				wd1.insert(0, word1.charAt(m-2));
				wd2.insert(0, '-');
				m--;
			}

			else if (m > 0 && A[m-1][n-1] == A[m-1][n-2] + gap) {
				wd1.insert(0, '-');
				wd2.insert(0, word2.charAt(n-2));
				n--;
			}			
		}
		return wd1 + " " + wd2;
		
	}
	
	public int computeAlpha(char c1, char c2) {
		if(c1 == c2)
			return same;
		else if (isVowel(c1) && isVowel(c2) )
			return diffV;
		else if (!isVowel(c1) && !isVowel(c2))
			return  diffC;
		else
			return VC;
		
		
	}
	
	//determines if the inputed character is a vowel or not
	public boolean isVowel(char v) {
		if( v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u')
			return true;
		else
			return false;
	}
	
}
