package br.edu.ifpb.mt.tt.services;

import java.util.ArrayList;
import java.util.List;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import br.edu.ifpb.mt.tt.TecnicasDeTesteException;
import br.edu.ifpb.mt.tt.model.Endereco;
import br.edu.ifpb.mt.tt.util.FormatadorEndereco;

public class CorreiosService {

	private AtendeCliente atendeCliente;

	private FormatadorEndereco formatadorEndereco;

	public CorreiosService() {
	}

	public AtendeCliente getAtendeCliente() {
		return atendeCliente;
	}

	public void setAtendeCliente(AtendeCliente atendeCliente) {
		this.atendeCliente = atendeCliente;
	}

	public FormatadorEndereco getFormatadorEndereco() {
		return formatadorEndereco;
	}

	public void setFormatadorEndereco(FormatadorEndereco formatadorEndereco) {
		this.formatadorEndereco = formatadorEndereco;
	}

	public List<String> recuperarEnderecosCompletosFormatados(String... ceps) throws TecnicasDeTesteException {
		List<String> enderecosCompletosFormatados = new ArrayList<>();
		
		for (String cep : ceps) {
			String enderecoCompletoFormatado = recuperarEnderecoCompletoFormatado(cep);
			enderecosCompletosFormatados.add(enderecoCompletoFormatado);
		}
		
		return enderecosCompletosFormatados;
	}
	
	public String recuperarEnderecoCompletoFormatado(String cep) throws TecnicasDeTesteException {

		Endereco endereco = buscarEnderecoPeloCep(cep);

		String enderecoCompletoFormatado = formatadorEndereco.formatar(endereco);

		return enderecoCompletoFormatado;
	}

	private Endereco buscarEnderecoPeloCep(String cep) throws TecnicasDeTesteException {

		try {
			EnderecoERP consultaCEP = atendeCliente.consultaCEP(cep);
//			EnderecoERP consultaCEP = new EnderecoERP();
//			consultaCEP.setCep(cep);
//			consultaCEP.setCidade("Monteiro");
//			consultaCEP.setUf("PB");
			return traduzirRetornoWS(consultaCEP);
		} catch (SQLException_Exception | SigepClienteException e) {
			throw new TecnicasDeTesteException(
					"Ocorreu algum erro ao tentar recuperar o endereço a partir do cep: " + cep, e);
		}
	}

	private Endereco traduzirRetornoWS(EnderecoERP enderecoERP) {
		Endereco endereco = new Endereco();

		endereco.setBairro(enderecoERP.getBairro());
		endereco.setCep(enderecoERP.getCep());
		endereco.setCidade(enderecoERP.getCidade());
		endereco.setEnd(enderecoERP.getEnd());
		endereco.setUf(enderecoERP.getUf());

		return endereco;
	}

}
