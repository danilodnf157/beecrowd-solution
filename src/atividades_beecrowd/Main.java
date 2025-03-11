package atividades_beecrowd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
			inputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(ir);

			int N = Integer.parseInt(in.readLine());
			
			for(int k= 0; k < N; k++) {
				// ler nomero casos teste que serao processados de alunos 
				int M = Integer.parseInt(in.readLine());
				
				// ler as notas dos alunos na ordem de chegada
				//crio um array "alunos", é feita a leitura, trim() remore os espaçoes em brancoe o split() divide a string em partes usando o espaço como delimitador 
				 String[] alunos = in.readLine().trim().split(" ");
				 	// um novo array (notas) é criado com um tamanho (M) que sera o numeor de elementos esperados
		            Integer[] notas = new Integer[M];
		            for(int i = 0; i < M; ++i){
		                notas[i] = Integer.parseInt(alunos[i]);
		            }

		            Arrays.sort(notas, Collections.reverseOrder());

		            int resposta = 0;
		            for(int i = 0; i < M; ++i){
		                if(Integer.parseInt(alunos[i]) == notas[i]){
		                    resposta += 1;
		                }
		            }
		            System.out.println(resposta);
		        }
		    }
		}