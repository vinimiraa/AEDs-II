/*
 *  -------------------------- Documentacao
 *  Pontificia Universidade Catolica de Minas Gerais
 *  Curso de Ciencia da Computacao
 *  Algoritmos e Estruturas de Dados II
 *   
 *  TP01Q02 - 22 / 02 / 2024
 *  Author: Vinicius Miranda de Araujo
 *   
 *  Para compilar em terminal (janela de comandos):
 *       Linux : javac Palindromo.java
 *       Windows: javac Palindromo.java
 *   
 *  Para executar em terminal (janela de comandos):
 *       Linux : java Palindromo
 *       Windows: java Palindromo
 *   
*/

// ---------------------------------------- Dependencias

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------- Metodos

/**
 *  Funcao para verificar se uma string e' um palindromo.
 *  @return true se palindromo, false caso contrario.
 *  @param s - String
*/
isPalindromo ( const char *s )
{
    bool result = true;
    int x = 0, y = 0;
    int length = strlen( s );

    for ( x = 0, y = length-1; x < length/2; x=x+1, y=y-1 )
    {
        if ( s[x] != s[y] ) // verificar se o primeiro caractere e' diferente do ultimo
        {
            result = false;  
            x = length; // interromper a repeticao
        } // end if
    } // end for
    return ( result );
} // end isPalindromo ( )

/**
 *  Funcao Principal
 *  @param agrc
 *  @param agrv
*/
int main( int argc, char const *argv[] )
{
    char *entrada = NULL;

    entrada = (char*) calloc ( 80, sizeof(char) );

    return ( 0 );
} // end main ( )

