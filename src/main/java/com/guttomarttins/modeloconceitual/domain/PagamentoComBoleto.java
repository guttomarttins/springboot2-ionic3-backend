package com.guttomarttins.modeloconceitual.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.guttomarttins.modeloconceitual.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Date dataPagamentoVencimento;
	
	public PagamentoComBoleto() {
	}
	
	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamentoVencimento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamentoVencimento = dataPagamentoVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamentoVencimento() {
		return dataPagamentoVencimento;
	}

	public void setDataPagamentoVencimento(Date dataPagamentoVencimento) {
		this.dataPagamentoVencimento = dataPagamentoVencimento;
	}
	
	

}
