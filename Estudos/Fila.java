public class Fila 
{
    // ---------------------------------------- atributos
    
    int[] array;
    int   primeiro; // remover
    int   ultimo;   // inserir
    // private int   contador = 0;   // contador
    
    // ---------------------------------------- Construtores

    Fila( )
    {
        this( 5 );
    } // end Fila ( )

    Fila( int length )
    {
        array = new int[length+1];
        primeiro = ultimo = 0;
    } // end Fila ( )

    public void inserir( int value ) throws Exception
    {
        if (((ultimo + 1) % array.length) == primeiro)
        {
            throw new Exception("Erro!");
        }
        array[ultimo] = value;
        ultimo = (ultimo + 1) % array.length;
    } // end inserir ( )

    public int remover( ) throws Exception
    {
        int value = 0;
        if( primeiro == ultimo )
        {
            throw new Exception("Erro!");
        } // end if
        value = array[primeiro];
        primeiro = (primeiro + 1) % array.length;

        return ( value );
    } // end remover ( )

    public void printFila( )
    {
        int x = primeiro;
        System.out.print( "[ " );
        while( x != ultimo )
        {
            System.out.print( array[x] + " " );
            x = (x + 1) % array.length;
        } // end while
        System.out.println( "]" );
    } // end printFila ( )

    public static void main(String[] args) throws Exception
    {
        Fila a = new Fila( 5 );
        a.inserir(1);
        a.printFila();

        a.inserir(3);
        a.printFila();

        a.inserir(5);
        a.printFila();

        a.inserir(7);
        a.printFila();

        a.inserir(9);
        a.printFila();

        // a.inserir(2);
        a.printFila();

        a.remover();
        a.printFila();

        a.remover();
        a.printFila();

        a.inserir(4);
        a.printFila();

        a.inserir(6);
        a.printFila();

        a.remover();
        a.printFila();

        a.inserir(8);
        a.printFila();

        a.printFila();
    } // end main ( )
} // end class 
