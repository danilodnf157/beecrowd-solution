package atividades_beecrowd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class lista_telefonica {
	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		
		// essa linha sera para a leitura do primeiro numero de entrada que irá dizer a quantidade de numeros 
		// telefonicos que serao comparados 
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t < T; t++) {
		// faz a leitura dos numeros telefonicos 
		int N = Integer.parseInt(in.readLine());
		
		// lê o numero de telefone e armazena em um array
		String[] telefones = new String[N];
		for(int i = 0; i < N; i++) {
		telefones[i] = in.readLine();
		}
		Arrays.sort(telefones);
		
		int prefixoComum = 0; // deve ser igual a zero Inicializado com 0, ele vai contar quantos caracteres consecutivos são iguais a duas strings.
		String primeiro = telefones[0]; //Armazena o primeiro elemento do array.
		String ultimo = telefones[telefones.length -1]; //Armazena o último elemento do array
		
		while(prefixoComum < primeiro.length() && prefixoComum < ultimo.length()) {
			if(primeiro.charAt(prefixoComum) == ultimo.charAt(prefixoComum)) {
				prefixoComum++;
			}else {
				break;
			}
		}
		int economia = prefixoComum * (N - 1);
		
		System.out.println(economia);
		}
	}
}
