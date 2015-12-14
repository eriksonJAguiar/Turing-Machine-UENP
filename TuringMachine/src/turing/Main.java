package turing;

import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner teclado = new Scanner(System.in);
		
		//String file = teclado.nextLine();
		
		ArrayList<String> config = Arquivo.lerArquivo("/home/erikson/workspace/TuringMachine/files/duplobal.mt");
		
		//String fileIn = teclado.nextLine();
		
		ArrayList<String> entrada = Arquivo.lerArquivo("/home/erikson/workspace/TuringMachine/files/duplobal.in");
		
		Maquina maquinaTuring = new Maquina();
		
		//separa a configuração inicial
		maquinaTuring.setEstadoIncial(config.get(0));
		maquinaTuring.setEstadoFinal(config.get(1));
		maquinaTuring.setInicioFita(config.get(3));
		maquinaTuring.setFinalFita(config.get(2));
		
		ArrayList<Transicao> listaTransicoes = new ArrayList<>();
		
		//separa as transições 
		int cont = 4;
		while(cont < config.size()){
			
			Transicao transicao = new Transicao();
			
			String[] t = config.get(cont).split(",");
			
			transicao.setFrom(t[0]);
			transicao.setTo(t[4]);
			transicao.setLido(t[1]);
			transicao.setGrava(t[2]);
			transicao.setDirecao(t[3]);
			
			listaTransicoes.add(transicao);
			
			cont++;
		}
		
		maquinaTuring.setTransicao(listaTransicoes);
		
		//pegar varias linhas do arquivo
		for(int i=0;i<entrada.size();i++){
			maquinaTuring.setFita(entrada.get(i));
			
			String fitaAux = maquinaTuring.getFita();
			
			char[] fita = fitaAux.toCharArray();
			
			int cabeca=0;
			String estado = maquinaTuring.getEstadoIncial();			
			
			boolean terminou = false;
			String condicao = new String();
			while(terminou == false){
				
				
				Transicao transition = new Transicao();
				
				int iterator = 0;
				boolean encerrar = false;
				while(iterator < maquinaTuring.getTransicao().size() && encerrar == false){
					Transicao tr = maquinaTuring.getTransicao().get(iterator);
					if(tr.getFrom().equals(estado) && tr.getLido().equals(String.valueOf(fita[cabeca]))){
						transition = tr;
						encerrar = true;
					}
					iterator++;
				}
				
				estado = transition.getTo();
				
				fita[cabeca] = transition.getGrava().charAt(0);
				
				if(transition.getDirecao().equals("D") && cabeca < fita.length){
					cabeca++;
				}
				else if(transition.getDirecao().equals("E") && cabeca != 0){
					cabeca--;
				}
				if(encerrar == false){
					terminou = true;
					condicao = "Rejeitado";
				}
				else if(estado.equals(maquinaTuring.getEstadoFinal()) && fita[cabeca] == maquinaTuring.getFinalFita().charAt(0)){
					terminou = true;
					condicao = "Aceito";
				}
			}
			
			Arquivo.gravarArquivo(fitaAux, condicao, "teste.in");
		}
	}
}
