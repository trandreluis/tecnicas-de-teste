package triangulo;

import java.util.Scanner;

public class TesteTriangulo {

	public static String classificaTriangulo(int lado1, int lado2, int lado3) {

		if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {

			if (lado1 == lado2 && lado1 == lado3) {
				return "equilatero";
			}

			else if (lado1 == lado2 && lado1 != lado3 || lado1 == lado3 && lado1 != lado2
					|| lado2 == lado1 && lado2 != lado3 || lado2 == lado3 && lado2 != lado1
					|| lado3 == lado1 && lado3 != lado2 || lado3 == lado2 && lado3 != lado1) {
				return "isosceles";
			}

			else if (lado1 != lado2 && lado1 != lado3 && lado2 != lado3) {
				return "escaleno";
			}
		}

		return "invalido";
	}

	public static void casosDeTeste() {

		// invalido
		System.out.println("Parametros: [1,2,3]");
		System.out.println("Retorno esperado: invalido");
		System.out.println("Retorno obtido: " + classificaTriangulo(1, 2, 3));

		// equilatero
		System.out.println("Parametros: [4,4,4]");
		System.out.println("Retorno esperado: equilatero");
		System.out.println("Retorno obtido: " + classificaTriangulo(4, 4, 4));

		// isosceles
		System.out.println("Parametros: [8,8,12]");
		System.out.println("Retorno esperado: isosceles");
		System.out.println("Retorno obtido: " + classificaTriangulo(12, 8, 12));

		// isosceles
		System.out.println("Parametros: [8,12,8]");
		System.out.println("Retorno esperado: isosceles");
		System.out.println("Retorno obtido: " + classificaTriangulo(12, 8, 12));

		// isosceles
		System.out.println("Parametros: [12,12,8]");
		System.out.println("Retorno esperado: isosceles");
		System.out.println("Retorno obtido: " + classificaTriangulo(12, 8, 12));

		// escaleno
		System.out.println("Parametros: [12,9,11]");
		System.out.println("Retorno esperado: escaleno");
		System.out.println("Retorno obtido: " + classificaTriangulo(12, 9, 11));

	}

	public static void main(String[] args) {

		System.out.println("Pressione:\n1 - Inserir dados manualmente\n2 - Executar casos  de testes cadastrados");

		Scanner s = new Scanner(System.in);

		int opcao = s.nextInt();

		if (opcao == 1) {

			System.out.println("Primeiro lado: ");
			int lado1 = s.nextInt();
			System.out.println("Segundo lado: ");
			int lado2 = s.nextInt();
			System.out.println("Terceiro lado: ");
			int lado3 = s.nextInt();

			System.out.println("");
			System.out.println("----- RESULTADO -----");
			System.out.println("");
			System.out.println(classificaTriangulo(lado1, lado2, lado3));

		}

		else if (opcao == 2) {
			System.out.println("");
			System.out.println("----- RESULTADO -----");
			System.out.println("");
			casosDeTeste();
		}

		else {
			System.out.println("Entrada invalida");
		}

	}

}
