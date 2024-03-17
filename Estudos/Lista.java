import java.util.Random;

public class Lista 
{
    // atributos
    private static int[] array;
    private static int   tam;

    Lista( int length )
    {
        if( length > 0 )
        {
            tam = length;
            array = new int[tam];
        } // end if
    } // end Lista ( )

    public int getTam( )
    {
        return ( tam );
    }

    public int[] getArray()
    {
        return array;
    }

    public void set(int index, int value)
    {
        array[index] = value;
    }

    public int get( int index )
    {
        int value = 0;
        if( index >= 0 && index < tam )
        {
            value = array[index];
        }
        return ( value );
    }

    public void randValue() 
    {
        Random gerador = new Random( );
        for( int x = 0; x < tam; x = x + 1 )
        {
            array[x] = Math.abs( gerador.nextInt( ) % 50 );
        }
    }

    public void printLista( )
    {
        System.out.print( "[ " );
        for( int x = 0; x < tam; x = x + 1 )
        {
            System.out.print( array[x] + " " );
        }
        System.out.print( "]\n" );
    }

    public boolean pesquisaSequencial( int value )
    {
        boolean result = false;
        for( int x = 0; x < tam && !result; x = x + 1 )
        {
            if( array[x] == value )
            {
                result = true;
            }
        }
        return ( result );
    }

    public int pesquisaBinaria( int value, int esq, int dir )
    {
        if( esq > dir )
        {
            return -1; // nao encontrado
        }
        else
        {
            int meio = ( esq+dir ) / 2;
            if (value == array[meio] )
            {
                return meio;
            } 
            else if( value > array[meio] )
            {
                return pesquisaBinaria( value, meio + 1, dir );
            } 
            else 
            {
                return pesquisaBinaria( value, esq, meio - 1 );
            } // end if	
        } // end if
    } // end pesquisaBinaria ( )

    public void bubbleSort( )
    {
        for( int x = 1; x < tam; x = x + 1 )
        {
            for( int y = 1; y < tam; y = y + 1 )
            {
                if( array[y] > array[y+1] )
                {
                    int temp = array[y+1];
                    array[y+1] = array[y];
                    array[y] = temp;
                } // end if
            } // end for
        } // end for
    } // end bubbleSort ( )

    public void bubbleSortBest( )
    {
        boolean houveTroca = true;
        for( int x = 0; x < tam-1 && houveTroca; x = x + 1 )
        {
            houveTroca = false;
            for( int y = 0; y < tam-x-1; y = y + 1 )
            {
                if( array[y] > array[y+1] )
                {
                    int temp = array[y+1];
                    array[y+1] = array[y];
                    array[y] = temp;
                    houveTroca = true;
                } // end if
            } // end for
        } // end for
    } // end bubbleSort ( )

    public void insertionSort( )
    {
        for( int x = 1; x < array.length; x = x + 1 ) 
        {
            int y = x;
            while( y >= 0 && array[y-1] > array[y] ) 
            {
                int temp = array[y-1];
                array[y-1] = array[y];
                array[y] = temp;
                y--;
            } // end while
        } // end for
    } // end insertionSort ( )

    public int removerInicio( )
    {
        int value = 0;
        if( tam > 0 )
        {
            value = array[0];
            for( int x = 1; x < tam; x = x + 1 )
            {
                array[x-1] = array[x];
            } // end for
            tam--;
        } // end if
        return ( value );
    } // end removerInicio ( )

    public int removerFim( )
    {
        int value = 0;
        if( tam > 0 )
        {
            value = array[tam];
            tam--;
        } // end if
        return ( value );
    } // removerFim ( )

    public Lista inserirInicio( int value )
    {
        Lista array = new Lista(tam+1);
        if( array != null )
        {
            array = this;
            for( int x = tam; x >= 0 ; x = x - 1 )
            {
                set( x+1, get(x) );
            }
            set( 0, value);
        }
        return ( array );
    } // end inserirInicio ( )
}


