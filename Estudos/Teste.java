public class Teste extends Lista
{
    Teste(int length) 
    {
        super(length);
    }
    
    public static void main(String[] args) 
    {

        Lista array = new Lista( 10 );   // criar vetor de inteiros com tamanho 10
        array.randValue();                      // atribiur valores aleatorios para o arranjo

        System.out.println( "Lista: " );  
        array.printLista();                     // mostrar o arranjo de inteiros
        
        System.out.println( "Pesquisa Sequencial: " + array.pesquisaSequencial(10) + "\n" );
        
        System.out.println( "Lista: " );
        array.bubbleSortBest();                 // ordenar o arranjo
        array.printLista();                     // mostrar o arranjo de inteiros

        System.out.println( "Pesquisa Binaria: " + array.pesquisaBinaria(10, 0, array.getTam()-1) + "\n" );

        System.out.println( "Lista: " );
        array.printLista();                     // mostrar o arranjo de inteiros
        int valor1 = array.removerInicio();
        int valor2 = array.removerFim();
        array.printLista();                     // mostrar o arranjo de inteiros
        System.out.println( "Valor Removido do Inicio: " + valor1 );
        System.out.println( "Valor Removido do Fim: " + valor2 );
        System.out.println( "Valor a ser Inserido no Inicio do Fim = 10 " );
        array = array.inserirInicio(10);
        array.printLista();
    }
}
