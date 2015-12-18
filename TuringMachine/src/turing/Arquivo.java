package turing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Arquivo {
	public static ArrayList<String> lerArquivo(String arquivo){
	try {
			FileReader file = new FileReader(arquivo);
			
			BufferedReader br = new BufferedReader(file);
			
			ArrayList<String> linha = new ArrayList<>();
			
			while(br.ready()){
				linha.add(br.readLine());
			}
			
			return linha;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void gravarArquivo(String entrada,String fitaSaida,String condicao,String nomeArquivo){
		try {
			FileWriter file = new FileWriter(nomeArquivo+".out",true);
			
			PrintWriter escreve = new PrintWriter(file);
			
			escreve.print(entrada+";"+fitaSaida+";"+condicao+"\n");
			
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
