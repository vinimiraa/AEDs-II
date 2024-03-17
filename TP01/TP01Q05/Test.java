public class Test {

    public static void main(String[] args) {
        String input = "2 0 0 and(not(A) , not(B))";
        String teste = "";
        teste = replaceAll("and", 'a', input);
        teste = replaceAll(' ', 'Z', teste);
        System.out.println(teste); // isso tem que ser 200a(not(A),not(B))
    }

    public static String replaceAll( Object base, char newChar, String input ) 
    {
		String result = "";
		int inputLen = input.length();
        String baseString = base.toString();
		int baseLen = baseString.length();
		for( int x = 0; x < inputLen; x = x + 1 ) 
        {
			boolean ok = x < inputLen - baseLen + 1;
            boolean match = isEquals( subString( input, x, x + baseLen ), baseString );
			if( ok && match ) 
            {
				result += newChar;
				x += baseLen - 1;
			} 
            else 
            {
				result += input.charAt(x);
			} // end if
		} // end for
		return ( result );
	} // end replaceAll ( )

    public static String subString( String s, int start, int end )
    {
        String result = "";
        for( int x = start; x < end && x < s.length(); x = x + 1 )
        {
            result += s.charAt(x);
        } // end for
        return ( result );
    } // end subString ( )

    public static boolean isEquals( String obj1, String obj2 )
    {
        boolean result = true;
        if( obj1.length() != obj2.length() )
        {
            result = false;
        }
        else
        {
            for( int x = 0; x < obj1.length() && result; x = x + 1 )
            {
                if( obj1.charAt(x) != obj2.charAt(x) )
                {
                    result = false;
                } // end if
            } // end for
        } // end if
        return ( result );
    } // end isEquals ( )
}
