package br.edu.ifpb.mt.tt;

public class ClassificacaoTriangulo {

	public static final int INVALIDO = -1;
	public static final int ESCALENO = 1;
	public static final int ISOCELES = 2;
	public static final int EQUILATERO = 3;

	public int getClassificacaoTriangulo(int a1, int b1, int c1) {

		long a = a1;
		long b = b1;
		long c = c1;
		
		if (a <= 0 || b <= 0 || c <= 0) {
			return INVALIDO;
		}

		if (a + b <= c) {
			return INVALIDO;
		}

		if (a + c <= b) {
			return INVALIDO;
		}

		if (c + b <= a) {
			return INVALIDO;
		}

		if (a != b && b != c && c != a) {
			return ESCALENO;
		}

		if (a == b && b == c) {
			return EQUILATERO;
		}

		return ISOCELES;
	}
	
}
