/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *   
 *  TP01Q08 - 13 / 03 / 2024
 *  Author: Vinicius Miranda de Araujo
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : javac Arquivo.java
 *       Windows: javac Arquivo.java
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : java Arquivo
 *       Windows: java Arquivo
 *   
*/

import java.io.RandomAccessFile;

public class Arquivo 
{
    /**
     * Quantidade de numeros reais.
     */
    private static int n = 0;

    /**
     *  Funcao principal
     *  @param args
     */
    public static void main ( String[] args )
    {
        MyIO.setCharset("UTF-8");
        double input = 0.0;
        String filename = "ARQUIVO.TXT";

        n = MyIO.readInt();

        for( int x = 0; x < n; x = x + 1 )
        {
            input = MyIO.readDouble();
            writeDoubleToFile(input, filename);
        } // end for

        readDoubleFromFile( filename );
    } // end main ( )

    /**
     *  Funcao para escrever numero real no arquivo.
     *  @param input - Double: Numero real a ser escrito no arquivo.
     *  @param filename - String: Nome do arquivo.
     */
    public static void writeDoubleToFile( double input, String filename )
    {
        try 
        {
            RandomAccessFile file = new RandomAccessFile( filename, "rw" );
            file.seek( file.length() );
            file.writeDouble( input );
            file.close();
        } 
        catch( Exception e )
        {
            MyIO.println( "ERRO: " + e.getMessage() );
        } // end try catch
    } // end writeDoubleToFile ( )

    /**
     *  Funcao para ler numero real do arquivo e mostrar na tela.
     *  @param filename - String: Nome do Arquivo.
     */
    public static void readDoubleFromFile( String filename )
    {
        double value = 0.0;
        try 
        {
            RandomAccessFile file = new RandomAccessFile( filename, "r" );
            for( int pointer = (int)file.length()-8; pointer >= 0; pointer = pointer - 8 )
            {
                file.seek(pointer);
                value = file.readDouble();
                if( value - (int)value == 0 )
                {  
                    MyIO.println( (int)value );
                }
                else{
                    MyIO.println( value );
                } // end if
            } // end for
            file.close();
        } 
        catch( Exception e )
        {
            MyIO.println( "ERRO: " + e.getMessage() );
        } // end try catch
    } // end readDoubleToFile ( )

} // end class
