package br.edu.ifpb.mt.tt.imc;

import static br.edu.ifpb.mt.tt.imc.ClassificacaoIMC.*;

/**
 * Referência: http://www.calcularpesoideal.com.br/
 * 
 * @author jaindsonvs
 *
 */
public class IndiceMassaCorporal {

	public double calcular(double pesoEmKg, int alturaEmCm) {
		double alturaEmM = alturaEmCm / 100.0;
		return pesoEmKg / (alturaEmM * alturaEmM);
	}
	
	public ClassificacaoIMC getClassificacao(double valor) {
		
		if (valor <= 18.4) {
			return ABAIXO;
		} else if (valor > 18.4 && valor <= 24.9) {
			return NORMAL;
		} else if (valor > 24.9 && valor <= 29.9) {
			return SOBREPESO;
		} else if (valor > 29.9 && valor <= 34.9) {
			return OBESIDADE_GRAU_I;
		} else if (valor > 34.9 && valor <= 39.9) {
			return OBESIDADE_GRAU_II;
		}
		
		return OBESIDADE_GRAU_III;
	}
	
	public static void main(String[] args) {
		
		IndiceMassaCorporal imc = new IndiceMassaCorporal();
		System.out.println(imc.getClassificacao(imc.calcular(78, 173)));
		
	}
	
}
