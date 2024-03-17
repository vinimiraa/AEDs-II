/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *   
 *  TP01Q05 - 15 / 03 / 2024
 *  Author: Vinicius Miranda de Araujo
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : javac AlgebraBooleana.java
 *       Windows: javac AlgebraBooleana.java
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : java AlgebraBooleana
 *       Windows: java AlgebraBooleana
 *   
*/

public class AlgebraBooleana 
{
    /**
     *  Funcao prinicipal.
     *  @param args
     */
    public static void main( String[] args )
    {
        MyIO.setCharset("UTF-8");
        String entrada = "";

        do 
        {
            entrada = MyIO.readLine();
            if( !isEquals( entrada, "0" ) )
            {
                if( solveEquation( entrada ) )
                {
                    MyIO.println( "1" );
                }
                else
                {
                    MyIO.println( "0" );
                } // end if
            } // end if
        } while ( !isEquals( entrada, "0" ) ); // end do while
    } // end main ( )

    public static String treatment( String input )
    {
        String expressao = "";
        int n = 0;

        n = input.charAt(0) - 48; // capturar quantos bits serao utilizados

        expressao = removeBlank( input );                           // remover espacos em branco
        expressao = replaceAll( "and", 'a', expressao );  // trocar "and" por 'a'
        expressao = replaceAll( "or", 'o', expressao  );  // trocar "or" por 'o'
        expressao = replaceAll( "not", 'n', expressao   );  // trocar "not" por 'n'

        // trocar 'A', 'B' e 'C' por seus respectivos bits
        for( int x = 0; x < n; x = x + 1 )
        {
            char c = (char)('A'+x);
            char newC = expressao.charAt(x+1); 
            expressao = replaceAll( c, newC, expressao );
        } // end for

        return ( expressao );
    } // end algebraBooleana ( )

    public static String identifyExp( String input )
    {
        String result = "";
        int inputLen = input.length();
        char operation = input.charAt(0);
        boolean flag = true;
        switch( operation ) 
        {
            case 'a':
                flag = true;
                for( int y = 2; y < inputLen && flag; y = y + 1 )
                {
                    if( input.charAt(y) == '0' )
                    {
                        flag = false;
                        result = "0";
                    } // end if
                } // end for
                break;
            case 'o':
                    flag = false;
                    for( int y = 2; y < inputLen && !flag; y = y + 1 )
                    {
                        if( input.charAt(y) == '1' )
                        {
                            flag = true;
                            result = "1";
                        } // end if
                    } // end for
                    break;
            case 'n':
                if( input.charAt(3) == '0' )
                {
                    result = "1";
                }
                else
                {
                    result = "0";
                } // end if
                break;
            default:
                result = "";
        } // end switch
        return ( result );
    } // end identifyExp ( )

    public static boolean solveEquation( String input )
    {
        boolean result = false;
        String expressao = treatment( input );
		while( expressao.contains( "(" ) )
        {
			int end = expressao.indexOf( ')' );
			int start = expressao.lastIndexOf( '(', end );

			String subExpr = subString( expressao, start-1, end+1 );			
			String resultString = identifyExp( subExpr );
            
			expressao = subString( expressao, 0, start-1 ) + resultString + 
                        subString( expressao, end+1, expressao.length() );	
		} // end while 
		result = expressao.equals("1");										
        return ( result );
    } // end solveEquation ( )

    /**
     *  Funcao para verificar se duas strings sao iguais.
     *  @param obj1 - String.
     *  @param obj2 - String.
     *  @return true se iguais, false caso contrario.
     */
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

    /**
     *  Funcao para pegar parte de uma string.
     *  @param s - String toda.
     *  @param start - Int: Comeco.
     *  @param end - Int: fim.
     *  @return String
     */
    public static String subString( String s, int start, int end )
    {
        String result = "";
        for( int x = start; x < end && x < s.length(); x = x + 1 )
        {
            result += s.charAt(x);
        } // end for
        return ( result );
    } // end subString ( )

    // remover os espacos em branco na string
    public static String removeBlank( String input )
    {
        String result = "";
        for( int x = 0; x < input.length(); x = x + 1 )
        {
            if( input.charAt(x) != ' ' )
            {
                result = result + input.charAt(x);
            } // end if
        } // end for
        return ( result );
    } // end removeBlank ( )

    // substituir uma ocorrencia de string por um caractere
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

} // end class
