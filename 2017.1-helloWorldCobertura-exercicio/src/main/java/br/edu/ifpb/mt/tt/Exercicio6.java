package br.edu.ifpb.mt.tt;

public class Exercicio6 {

	private boolean ehPar(int v) {
		return v % 2 == 0;
	}

	private boolean ehImpar(int v) {
		return !ehPar(v);
	}

	public int exercicio6(int A, int B, int X) {
		if (A > 1 && B == 0 && ehPar(X)) {
			X = X / A;
		}

		if (A == 2 || ehImpar(X)) {
			X = X + 1;
		}

		return X;
	}

}
