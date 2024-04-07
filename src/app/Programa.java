package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do Quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyy): ");
		Date dataEntrada = sdf.parse(sc.next());
		System.out.print("Data de saída (dd/MM/yyy): ");
		Date dataSaida = sdf.parse(sc.next());
		
		if(!dataSaida.after(dataEntrada)){
			System.out.println("Erro ao fazer a reserva: Data de saída menor que a data de entrada");
		}
		else {
			Reserva reserva = new Reserva(numeroQuarto, dataEntrada, dataSaida);
			System.out.println("Reserva: "+ reserva);
			
			System.out.println();
			
			System.out.println("Entre os dados para atualização da reserva");
			System.out.print("Data de entrada (dd/MM/yyy): ");
			dataEntrada = sdf.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyy): ");
			dataSaida = sdf.parse(sc.next());
			
			Date agora = new Date();
			
			if(dataEntrada.before(agora)|| dataSaida.before(agora)) {
				System.out.println("Erro com atualização: Datas devem ser futuras");
			}
			else if(!dataSaida.after(dataEntrada)) {
				System.out.println("Erro ao fazer a reserva: Data de saída menor que a data de entrada");
			}
			else {
						
			reserva.atualizarReserva(dataEntrada, dataSaida);
			System.out.println("Reserva: "+ reserva);
			}
		}
		
		
		sc.close();

	}

}
