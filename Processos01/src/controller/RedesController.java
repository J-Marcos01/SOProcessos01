package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/*1) O primeiro, chamado os, que identifica e retorna o nome do Sistema Operacional (Fazê-lo
privado)
2) O segundo, chamado ip, que verifica o Sistema Operacional e, de acordo com o S.O., faz a
chamada de configuração de IP.
A leitura do processo chamado deve verificar cada linha e, imprimir, apenas, o nome do
adaptador de rede e o IPv4, portanto, adaptadores sem IPv4 não devem ser mostrados
3) O terceiro, chamado ping, que verifica o Sistema Operacional e, de acordo com o S.O. e, faz a
chamada de ping em IPv4 com 10 iterações.
A leitura do processo chamado deve verificar as linhas de saída e exibir, apenas, o tempo médio
do ping. O teste de ping deve ser feito com a URL www.google.com.br
A Classe Main.java deve dar as opções de chamadas do método ip ou do método ping com
JOptionPane e, dependendo da escolha, instanciar a Classe RedesController.java e chamar o
método escolhido. A opção de finalizar a aplicação também deve estar disponível.
*/
public class RedesController 
{

	public RedesController() 
	{
		super();
	}

	
	private String os()
	{
		String os=System.getProperty("os.name");//pega propriedade do SO a partir de parametro de entrada.
		System.out.println(os);
		return os;				
	}
	
	public void ip()
	{
	
		String so=os();
		
		if(so.contains("Windows"))
	    	{
			String proc="ipconfig";
			String[] procArr=proc.split(" ");
			try {
				Process p=Runtime.getRuntime().exec(procArr);
				InputStream fluxo =p.getInputStream();
				InputStreamReader leitor=new InputStreamReader(fluxo);
				BufferedReader buffer =new BufferedReader(leitor);
				String linha =buffer.readLine();
				
				while(linha!=null)
				{	
					if(linha.contains("IPv4"))
					{
					System.out.println(linha);
					}
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				}catch (Exception e) {
					String msg= e.getMessage();
					System.err.println(msg);
						 
					 }
					 		
				}
			
		else if(so.contains("Linux"))
		{
			String proc="ip addr";
			String[] procArr=proc.split(" ");
			try {
				Process p=Runtime.getRuntime().exec(procArr);
				InputStream fluxo =p.getInputStream();
				InputStreamReader leitor=new InputStreamReader(fluxo);
				BufferedReader buffer =new BufferedReader(leitor);
				String linha =buffer.readLine();
				while(linha!=null)
				{	
					if(linha.contains("inet")&& !linha.contains("6"))
					{
					System.out.println(linha);
					}
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				}catch (Exception e) {
					String msg= e.getMessage();
					System.err.println(msg);
						 
				}
		}
	}
		
	
		
	public void ping()
	{
	
		String so=os();
		
		if(so.contains("Windows"))
	    	{
			String proc="ping -4 -n 10 www.google.com.br";
			String[] procArr=proc.split(" ");
			try {
				Process p=Runtime.getRuntime().exec(procArr);
				InputStream fluxo =p.getInputStream();
				InputStreamReader leitor=new InputStreamReader(fluxo);
				BufferedReader buffer =new BufferedReader(leitor);
				String linha =buffer.readLine();
				
				while(linha!=null)
				{	
					if(linha.contains("dia"))
					{
					String[] arrTempo = linha.split(",");//duvida , ele não considera os espaços ?
					for (String palavra:arrTempo)
					{
						if(palavra.contains("dia"))
						{
							System.out.print(palavra);
						}
					}
					}
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				}catch (Exception e) {
					String msg= e.getMessage();
					System.err.println(msg);
						 
					 }
					 		
				}
			
		else if(so.contains("Linux"))
		{
			String proc="ping -4 -c 10 www.google.com.br";
			String[] procArr=proc.split(" ");
			try {
				Process p=Runtime.getRuntime().exec(procArr);
				InputStream fluxo =p.getInputStream();
				InputStreamReader leitor=new InputStreamReader(fluxo);
				BufferedReader buffer =new BufferedReader(leitor);
				String linha =buffer.readLine();
				while(linha!=null)
				{	
					if(linha.contains("rtt"))
					{
					String []arrLinha=linha.split("/");
					System.out.print("Tempo médio de ping :"+arrLinha[6]);
					}
					linha=buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				}catch (Exception e) {
					String msg= e.getMessage();
					System.err.println(msg);
						 
				}
		}
		
		
	}
	
	
}
