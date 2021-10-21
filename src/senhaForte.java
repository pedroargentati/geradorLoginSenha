import java.util.Random;
import java.util.Scanner;

public class senhaForte {

	public static final int SENHA = 20;
	public static final int ALFABETO = 26;
	public static final int DIGITOS = 10;
	public static final int ESPECIAIS = 23;
	public static final int COMBINACOES = 4;

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String Nome = new String();
		String nome = new String();
		String senha = new String();
		StringBuffer login = new StringBuffer();
		String NOMES[] = new String[1];

		System.out.print("Digite seu nome completo: ");
		Nome = teclado.nextLine();
		nome = Nome.toLowerCase();

		NOMES = nome.split(" ");
		login.append(NOMES[0].charAt(0));

		if (NOMES.length > 2) {
			login.append(NOMES[1].charAt(0));
		}
		login.append(NOMES[NOMES.length - 1]);

		senha = gerarSenha();

		System.out.println("\nNome: " + Nome);
		System.out.println("Login: " + login);
		System.out.println("Senha: " + senha);
		teclado.close();

	}

	public static String gerarSenha() {
		Random r = new Random();
		int N;
		int LT, lt, dg, es;
		LT = SENHA/COMBINACOES;
		lt = LT;
		dg = LT;
		es = LT;
		String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String letras = "abcdefghijklmnopqrstuvwxyz";
		String digitos = "0123456789";
		String especiais = "!@#$%*+-=~<>:;?{[(|/)]}";
		String senha = new String();

		for (int i = 0; i < SENHA; i++) {
			switch (r.nextInt(COMBINACOES)) {
				case 0:
					if (LT > 0) {
						N = r.nextInt(ALFABETO);
						senha = senha + LETRAS.charAt(N);
						LT--;
					} else {
						i--;
					}
					break;
	
				case 1:
					if (lt > 0) {
						N = r.nextInt(ALFABETO);
						senha = senha + letras.charAt(N);
						lt--;
					} else {
						i--;
					}
					break;
	
				case 2:
					if (dg > 0) {
						N = r.nextInt(DIGITOS);
						senha = senha + digitos.charAt(N);
						dg--;
					} else {
						i--;
					}
					break;
	
				case 3:
					if (es > 0) {
						N = r.nextInt(ESPECIAIS);
						senha = senha + especiais.charAt(N);
						es--;
					} else {
						i--;
					}
					break;
	
				default:
					break;
	
				}
		}

		return (senha);
	}

}
