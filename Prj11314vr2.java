class Prj11314vr2
/*	Student Name: 	Peter Elliott	Student ID Number:	C00179426		Star Date:	27/1/2014
 	Purpose: 	Project 1 to take in a string of words and return the Palindromes, the number of Palindromes 
 	and the Palindromes with more vowels then constanents*/
{
    public static int Counter(String Palindromes)
  	{
  		int count = 0; //number of Palindromes
  		
  		for(int index=0; index<=Palindromes.length()-1; index++)
  			if(Palindromes.charAt(index) == ' ') // check the sentecnce of Palindromes for spaces add one for each space
  				count++;		
  		return count;
  	}// end of Counter()
  	
    public static String backwards(String Currentword)
    {
    	String Reverse = ""; //the reversed word
    	
    	for(int index =0; index <= Currentword.length()-1; index++)  //will stop word if non-alphabetical characters are in the sentence
		    if(Currentword.charAt(index) >= 'a' && Currentword.charAt(index) <='z' || Currentword.charAt(index) >='A' && Currentword.charAt(index) <='Z')
		    	Reverse = Currentword.charAt(index) + Reverse; // this if will stop the word word from being counted if it not aplhabetical	
    	return Reverse;
    }//end of backwards()
  
  	public static String Checkword(String Sentence)
    {
    	String Currentword = "";
    	String Palindrome = "";
    	
		while(Sentence.length()-1 >= 0)
		{	
	    	Currentword = Sentence.substring(0,Sentence.indexOf(" "));
	    	Sentence = Sentence.substring(Sentence.indexOf(" ")+1);
	    	
	    	if(Currentword.equals(backwards(Currentword)) && Currentword.length()-1 >= 2) // the palindromes now equal current palindrom + the old palindomes
	    		Palindrome = Currentword + " " + Palindrome;// the space help with the Counter()
    	} //end of while loop
    	return Palindrome;
    }// end of Checkword()
  	
  	public static String Vowelcheck(String Palindromes)
  	{
    	String Currentword = "";
    	String Vowels = "";
    	int Vowelcount = 0;
    	int Constantcount = 0;
    	Palindromes = Palindromes + " "; // stops error from occuring 
	
		while(Palindromes.length()-1 >= 0)
		{	
	    	Currentword = Palindromes.substring(0,Palindromes.indexOf(" "));
	    	Palindromes= Palindromes.substring(Palindromes.indexOf(" ")+1);
	    	
	    	for(int index=0; index <= Currentword.length()-1; index ++)  // in case the Palindromes is in Capitals
	    		if(Currentword.charAt(index) =='a'|| Currentword.charAt(index)=='e'|| Currentword.charAt(index)=='i'|| Currentword.charAt(index)=='o'|| Currentword.charAt(index)=='u'|| Currentword.charAt(index)=='A'|| Currentword.charAt(index)=='E'|| Currentword.charAt(index)=='I'|| Currentword.charAt(index)=='O'|| Currentword.charAt(index)=='U')
	    			Vowelcount++;
	    		else 
	    			Constantcount++;
	    	
	    	if(Vowelcount > Constantcount)
	    		Vowels =  Currentword + " " + Vowels;
	    	
	    	//resets the variables
			Vowelcount = 0;
			Constantcount = 0;
    	} //end of while loop
    	return Vowels;
  	}// end of Vowel()
  	
  	public static void main(String[] args)
    {
    	String Palindromes;		//the palindromes from the arangement
    	
    	System.out.println("Please enter a arangement of Palindromes");//default sentence while programing 
        Palindromes = Checkword(EasyIn.getString() +" ");  // +" " stops error from occuring when check each word later
    	//the above ine will take in and process the string entered befor storing the relavent information
    	System.out.println("\n\nThe Palindromes entered are listed below\n" + Palindromes);
    	System.out.println("The number of Palindromes entered is: " + Counter(Palindromes));
    	System.out.println("The Palindromes with more vowels then Constants are: " + Vowelcheck(Palindromes));
    }// end of  main
}// end of class