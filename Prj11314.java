class Prj11314
/*	Student Name: 		Peter Elliott	 	Student ID Number:	C00179426
 	Star Date:			27/1/2014 	 		End date:	 29/1/2014	
 	Purpose: 			Project 1 take in a string an out put any Palindromes, then display the	number
 						of Palindromes and then then display the Palindromes with more vowels then constanents
 						A palindrome must be spelled both forwards and backwards, must 3 characters or more in a aphabetical range*/ 					
{	
    public static int Counter(String Palindromes)
  	{//Count the number of Palindromes that were entered & the number of Palindromes with more vowls in them
  		int count = 0; //number of Palindromes
	  	// this if is to stop the program from count the error message if there are no Palindromes or Palindromes with more vowels
  		if(Palindromes != "there were no Palindromes " && Palindromes != "there are no Palindromes with move vowels then Constant ")
	  	{
	  		for(int index=0; index<=Palindromes.length()-1; index++)
	  		{
	  			if(Palindromes.charAt(index) == ' ')
	  			{// check the sentecnce of Palindromes for spaces add one for each space
	  				count++;
	  			}// end of if Palidromes count
	  		}// end of for loop
  		}	
  		return count;
  	}/* end of Counter() */
  	
  	public static String backwards(String Currentword)
    {// Reverse the current word bein checked in Checkword() to see if it is a Palindrome
    	String Reverse = ""; //the reversed word
    	
    	for(int index =0; index <= Currentword.length()-1; index++)
	    {	//will stop word if non-alphabetical characters are in the sentence, so when comparing in Checkword the words will not match
		    if(Currentword.charAt(index) >= 'a' && Currentword.charAt(index) <='z' || Currentword.charAt(index) >='A' && Currentword.charAt(index) <='Z')
		    {// this if will stop the word word from being counted if it not aplhabetical
		    	Reverse = Currentword.charAt(index) + Reverse;
		    }//end of if Checkword
	    }//end for loop
    	return Reverse;
    }/*end of backwards()*/
    
  	public static String Checkword(String Sentence)
    {	// See which words entered are Palindromes
    	String Currentword = "";
    	String Reverseword = ""; 	
    	String Palindrome = "";
    	int Space = 0;
    	
    	while(Sentence.length()-1 >= 0)
		{	
    		Space = Sentence.indexOf(" ");
	    	Currentword = Sentence.substring(0,Space);
	    	Sentence = Sentence.substring(Space+1);
	    	Reverseword = backwards(Currentword);
	    	
	    	if(Currentword.equals(Reverseword) && Currentword.length()-1 >= 2) 
	    	{ // the palindromes now equal current palindrom + the old palindomes
	    		Palindrome = Currentword + " " + Palindrome;// the space help with the Counter()
	    	}// end of Palindrome
    	} //end of while loop
    	if(Palindrome == "")
    	{	// this is an error message for if no Palindromes are entered
    		Palindrome = "there were no Palindromes ";
    	}
    	return Palindrome;
    }/* end of Checkword()*/
    
  	public static String Vowelcheck(String Palindromes)
  	{// Find the number of Palindromes with more vowels the constants
    	String Currentword = "";
    	String Vowels = "";
    	int Vowelcount = 0;
    	int Constantcount = 0;
    	int Space = 0;
    	
		while(Palindromes.length()-1 >= 0)
		{	
    		Space = Palindromes.indexOf(" ");
	    	Currentword = Palindromes.substring(0,Space);
	    	Palindromes= Palindromes.substring(Space+1);
	    	
	    	for(int index=0; index <= Currentword.length()-1; index ++)
	    	{	// in case the Palindromes is in Capitals
	    		if(Currentword.charAt(index) =='a'|| Currentword.charAt(index)=='e'|| Currentword.charAt(index)=='i'|| Currentword.charAt(index)=='o'|| Currentword.charAt(index)=='u'|| Currentword.charAt(index)=='A'|| Currentword.charAt(index)=='E'|| Currentword.charAt(index)=='I'|| Currentword.charAt(index)=='O'|| Currentword.charAt(index)=='U')
	    		{
	    			Vowelcount++;
	    		}
	    		else
	    		{
	    			Constantcount++;
	    		}
	    	}

	    	if(Vowelcount > Constantcount)
	    	{
	    		Vowels =  Currentword + " " + Vowels;
	    	}
			//resets the variables
			Vowelcount = 0;
			Constantcount = 0;
    	} //end of while loop
    	if(Vowels == "")
    	{	//error message for if there are no Palindromes with more vowels then Constant
    		Vowels = "there are no Palindromes with move vowels then Constant "; 
    	}    	
    	return Vowels;
  	}/*end of Vowel()*/
  	
  	public static void main(String[] args)
    {
    	String Palindromes;		
    	
    	System.out.println("Please enter a arangement of Palindromes");
    	Palindromes  = EasyIn.getString() +" "; // +" " stops error from occuring when check each word later
    	
    	Palindromes = Checkword(Palindromes);// a probelm is the Palindromes display in reverse order
    	System.out.println("\n\nThe Palindromes entered are listed below\n" + Palindromes);
    	System.out.println("\nThe number of Palindromes entered is: " + Counter(Palindromes));
    	Palindromes = Vowelcheck(Palindromes); // this seperated the Palindromes with more vowels from the rest of the Palindromes
    	System.out.println("\nThe Palindromes with more vowels then Constants are:\n" + Palindromes);
    	System.out.println("\nThe number of Palindromes with more vowels then Constants is: " + Counter(Palindromes)); // this uses the couter ment twice
    }/* end of main*/
}// end of class