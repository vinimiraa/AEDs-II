/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *   
 *  Teclado Quebrado - Warm-Up - 18 / 03 / 2024
 *  Author: Vinicius Miranda de Araujo
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : gcc -o Teclado Teclado.c
 *       Windows: gcc -o Teclado Teclado.c
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : ./Teclado
 *       Windows: Teclado
 *   
*/

// ---------------------------------------- Dependencias

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------- Metodos

void f1 ( ) // primeira versao
{
    char input[100001];
    char c = '\0';
    bool home = false;
    bool end = true;
    int index = 0;

    while( ( c = getchar( ) ) != EOF )
    {
        if( c == '[' ) 
        {
            home = true;  end  = false;
        } 
        else if( c == ']' ) 
        {
            end  = true;  home = false;
        } 
        else 
        {
            if( !home && !end  ) 
            {
                *(input+index) = c;
                index++;
            } 
            else if( end ) 
            {
                *(input+index) = c;
                index++;
            } 
            else if( home ) 
            {
                int x = 0;
                int y = index-1;
                while( !end )
                {
                    *(input+(y+1)) = *(input+y);
                    *(input+x) = c;
                    y--;
                    x++;
                }
                index++;
            } // end if
        }

        if( c == '\n' || c == EOF )
        {
            printf( "%s\n", input );
            index = 0;
            home = false;
            end = false;
        } // end if
    }
}

void f2( ) // segunda versao
{
    char c = '\0';
    char input[100001];
    bool home = false;
    bool end  = false;
    int index = 0;

    while( c = getchar( ) != EOF )
    {
        if( c == '[' )
        {
            home = true; end = false;
        }
        else if( c == ']' )
        {
            end = true; home = false;
        }
        else
        {
            if( home )
            {
                int len = strlen(input);
                index = 0;
                while( home && c != EOF && c != ']' && c != '\n' )
                {
                    if( input[index] != '\0' )
                    {
                        if( len < 100001 )
                        {
                            for( int x = len; x > index; x = x - 1 )
                            {
                                *(input+x) = *(input+(x-1));
                            }
                        }
                    }
                    *(input+index) = c;
                    index++;
                    c = getchar( );
                }
            }
            else if( end )
            {
                index = strlen(input);
                *(input+index) = c;
                index++;
            }
            else
            {
                *(input+index) = c;
                index++;
            }
        }

        if( c == '\n' || c == EOF )
        {
            printf( "%s\n", input );
            index = 0;
            home = false;
            end = false;
        } // end if
    }
}

/* void f3( )
{
    char c = '\0';
    char input[100001];
    bool home = false;
    bool end  = false;
    int index = 0;

    scanf( "%s", input );

    int len = strlen( input );
    for( int x = 0; x < len; x = x + 1 )
    {
        if( input[x] == '[' )
        {
            int y = x;
            while( input[y] != ']' && input[y] != '\n' && input[x] != EOF )
            {
                y++;
            }
            char *sub = substring( x+1, y-1, input );
            int subLen= strlen(sub);
            for( int z = 1; z < subLen; z++)
            {
                input[z] = input[z-1];
            }
            strcat(sub,input);
        }
    }
}
 */
/**
 *  Funcao principal.
*/
int main( int argc, char const *argv[] )
{
    f2( );
    return ( 0 );
} // end main ( )

