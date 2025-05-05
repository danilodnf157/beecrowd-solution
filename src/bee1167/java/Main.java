import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line.trim());
            if (n == 0) break;
            out.append(simulaJogo(n, in));
        }

        in.close();
        System.out.print(out);
    }

    private static String simulaJogo(int n, BufferedReader in) throws IOException {
        StringTokenizer st;
        String[] nomes          = new String[n];
        int[]    valores        = new int[n];
        boolean[] estaNoCirculo = new boolean[n];

        // Leitura dos participantes
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            nomes[i]          = st.nextToken();
            valores[i]        = Integer.parseInt(st.nextToken());
            estaNoCirculo[i]  = true;
        }

        int posicaoAtual  = 0;
        int valorDaFicha  = valores[0];
        int numParticipantes = n;

        // Elimina até sobrar um
        while (numParticipantes > 1) {
            boolean sentidoHorario = (valorDaFicha % 2 == 0);
            int passos            = valorDaFicha;
            int contadorPassos    = 0;

            // Percorre 'passos' posições válidas
            while (contadorPassos < passos) {
                posicaoAtual = sentidoHorario
                    ? (posicaoAtual + 1) % n
                    : (posicaoAtual - 1 + n) % n;
                if (estaNoCirculo[posicaoAtual]) {
                    contadorPassos++;
                }
            }

            // Elimina e atualiza ficha
            estaNoCirculo[posicaoAtual] = false;
            valorDaFicha = valores[posicaoAtual];
            numParticipantes--;
        }

        // Encontra o vencedor
        String vencedor = "";
        for (int i = 0; i < n; i++) {
            if (estaNoCirculo[i]) {
                vencedor = nomes[i];
                break;
            }
        }

        return "Vencedor(a): " + vencedor + "\n";
    }
}
