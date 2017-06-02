package br.edu.ifpb.mt.tt.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.EnderecoERP;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import br.edu.ifpb.mt.tt.TecnicasDeTesteException;
import br.edu.ifpb.mt.tt.model.Endereco;
import br.edu.ifpb.mt.tt.util.FormatadorEndereco;

@RunWith(MockitoJUnitRunner.class)
public class CorreiosServiceTestComMock {

	private CorreiosService correios;

	@Mock
	private AtendeCliente mockAtendeCliente;

	@Mock
	private FormatadorEndereco mockFormatadorEndereco;

	@Before
	public void setUp() {
		correios = new CorreiosService();
		correios.setAtendeCliente(mockAtendeCliente);
		correios.setFormatadorEndereco(mockFormatadorEndereco);
		
		// OBS: Alguns CEPs de Monteiro: 58500000, 58500970, 58500974, 58500975, 58500976
	}

	private EnderecoERP getEnderecoERP(String cep, String end, String bairro, String cidade, String uf) {
		EnderecoERP enderecoERP = new EnderecoERP();
		enderecoERP.setCidade(cidade);
		enderecoERP.setUf(uf);
		enderecoERP.setCep(cep);
		enderecoERP.setEnd(end);
		enderecoERP.setBairro(bairro);
		return enderecoERP;
	}

	private Endereco getEndereco(String cep, String end, String bairro, String cidade, String uf) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setEnd(end);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setUf(uf);
		return endereco;
	}

	@Test
	public void recuperarEnderecoCompletoFormatadoDeCepGenerico() throws Exception {
		// Preparar
		final String cep = "58500000";
		final String cidade = "Monteiro";
		final String uf = "PB";

		EnderecoERP enderecoERP = getEnderecoERP(cep, null, null, cidade, uf);
		when(mockAtendeCliente.consultaCEP(cep)).thenReturn(enderecoERP);

		Endereco endereco = getEndereco(cep, null, null, cidade, uf);
		when(mockFormatadorEndereco.formatar(endereco)).thenReturn("Monteiro, PB, 58500000");

		// Executar
		String recebido = correios.recuperarEnderecoCompletoFormatado(cep);

		// Checar
		assertEquals("Monteiro, PB, 58500000", recebido);
		verify(mockAtendeCliente).consultaCEP(cep);
		verify(mockFormatadorEndereco).formatar(endereco);
	}

	@Test
	public void recuperarEnderecoCompletoFormatadoDeCepMaisEspecifico() throws Exception {
		// Preparar
		final String cep = "58500970";
		final String end = "Rua Getúlio Vargas, 11";
		final String bairro = "Centro";
		final String cidade = "Monteiro";
		final String uf = "PB";

		EnderecoERP enderecoERP = getEnderecoERP(cep, end, bairro, cidade, uf);
		when(mockAtendeCliente.consultaCEP(cep)).thenReturn(enderecoERP);

		Endereco endereco = getEndereco(cep, end, bairro, cidade, uf);
		when(mockFormatadorEndereco.formatar(endereco))
				.thenReturn("Rua Getúlio Vargas 11, Centro, Monteiro, PB, 58500970");

		// Executar
		String recebido = correios.recuperarEnderecoCompletoFormatado(cep);

		// Checar
		assertEquals("Rua Getúlio Vargas 11, Centro, Monteiro, PB, 58500970", recebido);
		verify(mockAtendeCliente).consultaCEP(cep);
		verify(mockFormatadorEndereco).formatar(endereco);
	}

	@Test(expected = TecnicasDeTesteException.class)
	public void recuperarEnderecoCompletoCepInvalidoNaoDigito() throws Exception {
		// Preparar
		final String cep = "5850097a";

		when(mockAtendeCliente.consultaCEP(cep)).thenThrow(new SigepClienteException("message", "faultInfo"));

		// Executar
		correios.recuperarEnderecoCompletoFormatado(cep);
	}

	@Test(expected = TecnicasDeTesteException.class)
	public void recuperarEnderecoCompletoCepInvalidoQuantDigitosErrada() throws Exception {
		// Preparar
		final String cep = "585009700";

		when(mockAtendeCliente.consultaCEP(cep)).thenThrow(new SigepClienteException("message", "faultInfo"));

		// Executar
		correios.recuperarEnderecoCompletoFormatado(cep);
	}

	@Test
	public void recuperarEnderecosCompletosFormatadosDeVariosCeps() throws Exception {
		// Preparar

		// CEP 1
		final String cep1 = "58500000";
		final String cidade1 = "Monteiro";
		final String uf1 = "PB";

		EnderecoERP enderecoERP1 = getEnderecoERP(cep1, null, null, cidade1, uf1);
		when(mockAtendeCliente.consultaCEP(cep1)).thenReturn(enderecoERP1);

		Endereco endereco1 = getEndereco(cep1, null, null, cidade1, uf1);
		when(mockFormatadorEndereco.formatar(endereco1)).thenReturn("Monteiro, PB, 58500000");

		// CEP 2
		final String cep2 = "58500970";
		final String end2 = "Rua Getúlio Vargas, 11";
		final String bairro2 = "Centro";
		final String cidade2 = "Monteiro";
		final String uf2 = "PB";

		EnderecoERP enderecoERP2 = getEnderecoERP(cep2, end2, bairro2, cidade2, uf2);
		when(mockAtendeCliente.consultaCEP(cep2)).thenReturn(enderecoERP2);

		Endereco endereco2 = getEndereco(cep2, end2, bairro2, cidade2, uf2);
		when(mockFormatadorEndereco.formatar(endereco2))
				.thenReturn("Rua Getúlio Vargas 11, Centro, Monteiro, PB, 58500970");

		// Executar
		List<String> recebido = correios.recuperarEnderecosCompletosFormatados(cep1, cep2);

		// Checar
		List<String> esperado = Arrays.asList("Monteiro, PB, 58500000", "Rua Getúlio Vargas 11, Centro, Monteiro, PB, 58500970");
		assertEquals(esperado, recebido);
		verify(mockAtendeCliente).consultaCEP(cep1);
		verify(mockAtendeCliente).consultaCEP(cep2);
		verify(mockFormatadorEndereco).formatar(endereco1);
		verify(mockFormatadorEndereco).formatar(endereco2);
	}

}
