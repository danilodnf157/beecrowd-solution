package bee2312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


class Pais{
	String nome;
	int ouro;
	int prata;
	int bronze;
	
	public Pais(String nome, int ouro, int prata, int bronze) {
		this.nome = nome;
		this.ouro = ouro;
		this.prata = prata;
		this.bronze = bronze;	
	}
	 @Override
	    public String toString() {
	        return nome + " " + ouro + " " + prata + " " + bronze;
	    }
}
public class Main {
	public static void main(String[] args ) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		if(N < 0 || N > 500) {
			System.out.print("numero invalido de paises, deve ser 0 >= N <= 500>");
			return;
		}
		
	
		if(N == 0) {
			System.out.println("nenhum pais encontrado.");
			return;
		}
		
		List<Pais> paises = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String linha = br.readLine();
			String[] partes = linha.split(" ");
		
			String nome = partes [0];
			int ouro = Integer.parseInt(partes[1]);
			int prata = Integer.parseInt(partes[2]);
			int bronze = Integer.parseInt(partes[3]);
			
			Pais pais = new Pais(nome, ouro, prata, bronze);
			paises.add(pais);
		}
		Collections.sort(paises, new Comparator<Pais>(){

			@Override
			public int compare(Pais p1, Pais p2) {
				// TODO Auto-generated method stub
				if(p1.ouro !=  p2.ouro) {
					return p2.ouro - p1.ouro;
				}
				if(p1.prata != p2.prata) {
					return p2.prata - p1.prata;
				}
				if(p1.bronze != p2.bronze) {
					return p2.bronze - p1.bronze;
				}
				return p1.nome.compareTo(p2.nome);
			}
			
		});
		
		for (Pais p : paises) {
			System.out.println(p);
		}
		
		}
	}
