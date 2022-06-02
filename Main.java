import java.util.Random;
import java.util.Scanner;

public class Main
{
    private final static Resultado[][] REGRAS = {
        {Resultado.EMPATOU, Resultado.PERDEU,  Resultado.GANHOU,  Resultado.GANHOU,  Resultado.PERDEU},
        {Resultado.GANHOU,  Resultado.EMPATOU, Resultado.PERDEU,  Resultado.PERDEU,  Resultado.GANHOU},
        {Resultado.PERDEU,  Resultado.GANHOU,  Resultado.EMPATOU, Resultado.GANHOU,  Resultado.PERDEU},
        {Resultado.PERDEU,  Resultado.GANHOU,  Resultado.PERDEU,  Resultado.EMPATOU, Resultado.GANHOU},
        {Resultado.GANHOU,  Resultado.PERDEU,  Resultado.GANHOU,  Resultado.PERDEU,  Resultado.EMPATOU}};

    private final static Scanner scanner = new Scanner(System.in);

    private final static Random random = new Random();

    public static void main(String[] args)
    {
        Jogada jogadaJogador = lerJogadaDoJogador();
        Jogada jogadaComputador = Jogada.getJogada(random.nextInt(Jogada.values().length));
        Resultado resultado = REGRAS[jogadaJogador.getValor()][jogadaComputador.getValor()];

        System.out.printf("\nO computador jogou %s.\n", jogadaComputador.toString());

        switch (resultado)
        {
            case PERDEU:
                System.out.print("Você perdeu.");
                break;
            case EMPATOU:
                System.out.print("Empate.");
                break;
            case GANHOU:
                System.out.print("Você ganhou.");
                break;
        }
    }

    private static Jogada lerJogadaDoJogador()
    {
        Jogada jogada = null;

        while (jogada == null)
        {
            mostrarOpcoes();
            System.out.print("Escolha: ");
            jogada = Jogada.getJogada(scanner.nextInt());
            scanner.nextLine();
        }

        return jogada;
    }

    private static void mostrarOpcoes()
    {
        for (Jogada jogada: Jogada.values())
        {
            System.out.printf("[%d]: %s\n", jogada.getValor(), jogada.toString());
        }
        System.out.print('\n');
    }
}