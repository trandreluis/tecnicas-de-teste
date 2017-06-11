package br.edu.ifpb.mt.tt.temperature;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TemperatureConverterTest {
	
	// TODO Criar casos de testes para a classe TemperatureConverter com JUnit e Hamcrest

	private TemperatureConverter conversor = new TemperatureConverter();
	
	@Test
	public void testFahrenheitParaCelciusZero() {
		double retorno = conversor.fahrenheitToCelcius(32);
		assertThat(retorno, is(0.0));
	}
	
	@Test
	public void testFahrenheitParaCelciusVinte() {
		double retorno = conversor.fahrenheitToCelcius(68);
		assertThat(retorno, is(20.0));
	}
	
	@Test
	public void testCelciusParaFahrenheitTrintaEDois() {
		double retorno = conversor.celciusToFahrenheit(0);
		assertThat(retorno, is(32.0));
	}
	
	@Test
	public void testCelciusParaFahrenheitSessentaEOito() {
		double retorno = conversor.celciusToFahrenheit(20);
		assertThat(retorno, is(68.0));
	}
	
	@Test
	public void celciusParaKelvinVinteETres() {
		double retorno = conversor.celciusToKelvin(-250.15);
		assertEquals(retorno, 23.0, 0.1);
	}
	
	@Test
	public void celciusParaKelvinTrinta() {
		double retorno = conversor.celciusToKelvin(-243.15);
		assertEquals(retorno, 30.0, 0.1);
	}
	
	@Test
	public void kelvinParaCelciusZero() {
		double retorno = conversor.kelvinToCelcius(0);
		assertEquals(retorno, -273.15, 0.1);
	}
	
	@Test
	public void kelvinParaCelciusMenosCentoEVoventaESeis() {
		double retorno = conversor.kelvinToCelcius(77.19);
		assertEquals(retorno, -196.0, 0.1);
	}
	
	@Test
	public void kelvinParaFahrenheitZero() {
		double retorno = conversor.kelvinToFahrenheit(255.4);
		assertEquals(retorno, 0.0, 0.1);
	}
	
	@Test
	public void kelvinParaFahrenheitQuarentaEQuatro() {
		double retorno = conversor.kelvinToFahrenheit(279.9);
		assertEquals(retorno, 44.0, 0.15);
	}
	
}
