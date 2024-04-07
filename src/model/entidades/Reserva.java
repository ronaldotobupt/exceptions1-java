package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroDoQuarto;
	private Date dataEntrada;
	private Date dataSaida;
	
	private static SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}
	
	public Reserva(Integer numeroDoQuarto, Date dataEntrada, Date dataSaida) {
		
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
	}


	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}


	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}


	public Date getDataEntrada() {
		return dataEntrada;
	}


	


	public Date getDataSaida() {
		return dataSaida;
	}


	public long duracao() {
		long dif = dataSaida.getTime()-dataEntrada.getTime();
		return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS);
	}
	
	public void atualizarReserva(Date entrada, Date saida) {
		this.dataEntrada = entrada;
		this.dataSaida = saida;
	}
	
	@Override
	public String toString() {
		return "Quarto "+
				numeroDoQuarto +
				", Entrada:  "+
				sdf.format(dataEntrada)+
				", data de saida:  "+
				sdf.format(dataSaida)+
				", "+
				duracao()+
				" noites";
	}
	
	
	
}
