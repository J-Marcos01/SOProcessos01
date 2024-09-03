package view;
import javax.swing.JOptionPane;

import controller.RedesController;


public class Main 
{

	public static void main(String[] args) 
	{
		RedesController op = new RedesController();
		
		int opc=0;
		while(opc!=9)
		{
			opc=Integer.parseInt(JOptionPane.showInputDialog("Digite :\n 01- checar IP \n 02 - tempo médio ping \n 9-fim"));
		switch (opc)
		{
		case 1:
		{
			op.ip();
			break;
		}
		case 2:
		{
			op.ping();
			break;
		}
		case 9:
		{
			System.out.println("\nFim");
			break;
		}
		default:
		{
			System.err.println("Valor invalido");
			break;
		}
		}
		
		}
				
	}
		
	}


