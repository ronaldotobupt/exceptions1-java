package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecao.ExcecaoDominio;

public class Programa {

	public static void main(String[] args)  {
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do Quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyy): ");
			Date dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyy): ");
			Date dataSaida = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println();
			
			System.out.println("Entre os dados para atualização da reserva");
			System.out.print("Data de entrada (dd/MM/yyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyy): ");
			dataSaida = sdf.parse(sc.next());
			
			reserva.atualizarReserva(dataEntrada, dataSaida);
			System.out.println("Reserva: "+ reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválido");
		}
		catch (ExcecaoDominio e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
			
		
		sc.close();
		}
		
	
		

	}


