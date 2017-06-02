package br.edu.ifpb.mt.tt;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.edu.ifpb.mt.tt.services.CorreiosService;
import br.edu.ifpb.mt.tt.util.FormatadorEndereco;
import br.edu.ifpb.mt.tt.util.FormatadorEnderecoConcatenado;

public class MainCorreiosService {

	public static void main(String[] args) throws Exception {
		
		AtendeClienteService acs = new AtendeClienteService();
		AtendeCliente atendeCliente = acs.getAtendeClientePort();
		
		FormatadorEndereco formatadorEndereco = new FormatadorEnderecoConcatenado(",");
		
		CorreiosService correiosService = new CorreiosService();
		correiosService.setAtendeCliente(atendeCliente);
		correiosService.setFormatadorEndereco(formatadorEndereco);
		
		System.out.println(correiosService.recuperarEnderecoCompletoFormatado("58500000"));
		System.out.println(correiosService.recuperarEnderecoCompletoFormatado("58500970"));
		System.out.println(correiosService.recuperarEnderecoCompletoFormatado("58500974"));
		System.out.println(correiosService.recuperarEnderecoCompletoFormatado("58500975"));
		System.out.println(correiosService.recuperarEnderecoCompletoFormatado("58500976"));
		
	}
	
}
