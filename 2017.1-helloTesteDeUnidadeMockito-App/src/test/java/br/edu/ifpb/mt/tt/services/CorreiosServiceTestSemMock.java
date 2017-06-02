package br.edu.ifpb.mt.tt.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.correios.bsb.sigep.master.bean.cliente.AtendeCliente;
import br.com.correios.bsb.sigep.master.bean.cliente.AtendeClienteService;
import br.edu.ifpb.mt.tt.TecnicasDeTesteException;
import br.edu.ifpb.mt.tt.util.FormatadorEndereco;
import br.edu.ifpb.mt.tt.util.FormatadorEnderecoConcatenado;



public class CorreiosServiceTestSemMock {
	
	private CorreiosService correios;
	
	@Before
	public void setUp() {
		AtendeClienteService acs = new AtendeClienteService();
		AtendeCliente atendeCliente = acs.getAtendeClientePort();
		
		FormatadorEndereco formatadorEndereco = new FormatadorEnderecoConcatenado(",");
		
		correios = new CorreiosService();
		correios.setAtendeCliente(atendeCliente);
		correios.setFormatadorEndereco(formatadorEndereco);
	}

	@Test(timeout = 60000)
	public void recuperarEnderecoCompletoFormatadoDeCepGenerico() throws Exception {
		// Preparar
		final String cep = "58500000";
		
		// Executar
		String recebido = correios.recuperarEnderecoCompletoFormatado(cep);
		
		// Checar
		assertEquals("Monteiro, PB, 58500000", recebido);
	}

	@Test(timeout = 60000)
	public void recuperarEnderecoCompletoFormatadoDeCepMaisEspecifico() throws Exception {
		// Preparar
		final String cep = "58500970";
		
		// Executar
		String recebido = correios.recuperarEnderecoCompletoFormatado(cep);
		
		// Checar
		assertEquals("Rua Getúlio Vargas 11, Centro, Monteiro, PB, 58500970", recebido);
	}

	@Test(expected = TecnicasDeTesteException.class, timeout = 60000)
	public void recuperarEnderecoCompletoCepInvalidoNaoDigito() throws Exception {
		// Preparar
		final String cep = "5850097a";
		
		// Executar
		correios.recuperarEnderecoCompletoFormatado(cep);
	}

	@Test(expected = TecnicasDeTesteException.class, timeout = 60000)
	public void recuperarEnderecoCompletoCepInvalidoQuantDigitosErrada() throws Exception {
		// Preparar
		final String cep = "585009700";
		
		// Executar
		correios.recuperarEnderecoCompletoFormatado(cep);
	}
	
	@Test(timeout = 60000)
	public void recuperarEnderecosCompletosFormatadosDeVariosCeps() throws Exception {
		// Preparar
		
		// CEP 1
		final String cep1 = "58500000";
		
		// CEP 2
		final String cep2 = "58500970";
		
		// Executar
		List<String> recebido = correios.recuperarEnderecosCompletosFormatados(cep1, cep2);
		
		// Checar
		assertEquals(Arrays.asList("Monteiro, PB, 58500000", "Rua Getúlio Vargas 11, Centro, Monteiro, PB, 58500970"), recebido);
		
	}
	
}
