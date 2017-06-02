package br.edu.ifpb.mt.tt.util;

import br.edu.ifpb.mt.tt.model.Endereco;

public class FormatadorEnderecoConcatenado implements FormatadorEndereco {

	private String separador;
	
	public FormatadorEnderecoConcatenado(String separador) {
		this.separador = separador;
	}
	
	@Override
	public String formatar(Endereco endereco) {
//		return "abc";
		String enderecoCompleto = "";
		
		enderecoCompleto += montarParteEndereco(endereco.getEnd());
		enderecoCompleto += montarParteEndereco(endereco.getBairro());
		enderecoCompleto += montarParteEndereco(endereco.getCidade());
		enderecoCompleto += montarParteEndereco(endereco.getUf());
		enderecoCompleto += montarParteEndereco(endereco.getCep());
		
		
		return enderecoCompleto.isEmpty() ? "" : enderecoCompleto.substring(2);
	}
	
	private String montarParteEndereco(String parte) {
		if (parte != null && !parte.isEmpty()) {
			return separador + " " + parte;
		}
		return  "";
	}

}
