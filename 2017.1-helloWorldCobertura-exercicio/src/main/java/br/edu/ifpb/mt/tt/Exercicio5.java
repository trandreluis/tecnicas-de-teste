package br.edu.ifpb.mt.tt;

public class Exercicio5 {

	public int exercicio5(int A, int B, int X) {
		if (A > 1 && B == 0) {
			X = X / A;
		}
		
		if (A == 2 || X > 1) {
			X = X + 1;
		}
		
		return X;
	}
	
}
