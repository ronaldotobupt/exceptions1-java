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
	
	public String atualizarReserva(Date entrada, Date saida) {
		Date agora = new Date();
		if(entrada.before(agora)|| saida.before(agora)) {
			return "Erro com atualização: Datas devem ser futuras";
		}
		if(!saida.after(entrada)) {
			return "Erro ao fazer a reserva: Data de saída menor que a data de entrada, tente novamente";
		}
		
		this.dataEntrada = entrada;
		this.dataSaida = saida;
		return null;
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
