import java.util.HashMap;

public enum Jogada
{
    PEDRA(0), PAPEL(1), TESOURA(2), LAGARTO(3), SPOCK(4);

    private static HashMap<Integer, Jogada> jogadas = new HashMap<>();

    static
    {
        for (Jogada jogada: Jogada.values())
        {
            jogadas.put(jogada.valor, jogada);
        }
    }

    public static Jogada getJogada(int valor) {return jogadas.get(valor);}

    private final int valor;

    private Jogada(int valor)
    {
        this.valor = valor;
    }

    public int getValor() {return valor;}
}