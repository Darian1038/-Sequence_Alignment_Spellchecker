This Java program implements a spellchecker using the sequence alignment algorithm. It takes two strings as input and
computes the minimal alignment between them. The program assigns costs to different types of mismatches, 
such as same symbols, vowels, constants,and different vowels or constants. The goal is to find 
the alignment with the lowest overall cost.

The minimal alignment is computed using the following mismatch costs:
	𝛿 = 2
	Same symbol cost is 0
	Vowel and different vowel cost 1
	Constant and different constant cost 1
	Vowel and constant cost 3

The program takes two string inputs, which represent the sequences that need to be aligned and checked for spelling. 
These strings should contain lowercase alphabet letters only

The program returns the minimal alignment between the two input sequences. The alignment is represented as a single string, 
where each character corresponds to a position in the aligned sequences. The characters in the output string represent the 
aligned symbols from both input sequences. The aligned symbols are separated by a whitespace character (' ').