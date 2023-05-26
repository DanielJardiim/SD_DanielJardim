package br.inatel.labs.labjpa.dto;

import java.math.BigDecimal;

public class TotalCompradoPorFornecedorDTO {

	private String fornecedorRazaoSocial;
	
	private BigDecimal totalComprado;
	
	public TotalCompradoPorFornecedorDTO(String fornecedorRazaoSocial, BigDecimal totalComprado) {
		this.fornecedorRazaoSocial = fornecedorRazaoSocial;
		this.totalComprado = totalComprado;
	}
	
	public String getFornecedorRazaoSocial() {
		return fornecedorRazaoSocial;
	}

	public void setFornecedorRazaoSocial(String fornecedorRazaoSocial) {
		this.fornecedorRazaoSocial = fornecedorRazaoSocial;
	}

	public BigDecimal getTotalComprado() {
		return totalComprado;
	}

	public void setTotalComprado(BigDecimal totalComprado) {
		this.totalComprado = totalComprado;
	}

	@Override
	public String toString() {
		return "TotalCompradoPorFornecedorDTO [fornecedorRazaoSocial=" + fornecedorRazaoSocial + ", totalComprado="
				+ totalComprado + "]";
	}
	
}
