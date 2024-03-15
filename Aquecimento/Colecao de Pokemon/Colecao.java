
public class Colecao
{
    public static void main ( String[ ] args )
    {
        int quantidade = 0;
        String[] nome;
        int total = 151;

        quantidade = MyIO.readInt();
        nome = new String[quantidade];

        for( int x = 0; x < quantidade; x = x + 1 )
        {
            nome[x] = MyIO.readLine();
        } // end for

        insertionSort( quantidade, nome );

        for( int x = 0; x < quantidade-1; x = x + 1 )
        {
            total = total - 1;
            if( nome[x].equals( nome[x+1] ) )
            {
                total++;
            } // end if
        } // end for

        MyIO.println( "Falta(m) " + total + " pomekon(s)." );
    } // end main ( )

    private static void insertionSort( int n, String[] vetor)
    {
        for (int x = 1; x < n; x++) 
        {
		    String tmp = vetor[x];
            int y = x - 1;

            while( (y >= 0) && (vetor[y].charAt(y) > tmp.charAt(y)) )
            {
                vetor[y + 1] = vetor[y];
                y--;
            } // end while
            vetor[y + 1] = tmp;
        } // end for
    } // end insertionSort ( )
} // enc class
