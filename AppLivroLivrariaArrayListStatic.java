package livrolivrariaarrayliststatic;

import java.util.Scanner;

public class AppLivroLivrariaArrayListStatic {

    public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner entrada = new Scanner(System.in);
	@SuppressWarnings("resource")
	Scanner entradaString = new Scanner(System.in);

	int menu;
	double vInicial, vFinal;
	// ref para a classe LivroLivraria
	LivroLivraria objLivro;

	String titulo, autor, genero;
	float preco;
	int isbn;

	do {
	    exibirMenu();
	    menu = entrada.nextInt();

	    switch (menu) {
	    case 1: // cadastrar livro
		System.out.println("===> Cadastrar livro");
		System.out.println("Digite o título: ");
		titulo = entradaString.nextLine();
		System.out.println("Digite o autor: ");
		autor = entradaString.nextLine();
		System.out.println("Digite o gênero: ");
		genero = entradaString.nextLine();
		System.out.println("Digite o ISBN: ");
		isbn = entrada.nextInt();
		System.out.println("Digite o preço: ");
		preco = entrada.nextFloat();

		// criar objeto da classe
		objLivro = new LivroLivraria(titulo, autor, isbn, genero, preco);

		// guardar no ArrayList
		Acervo.adicionar(objLivro);

		break;
	    case 2: // listar livros
		System.out.println("===> Listagem de livros");
		System.out.println(Acervo.listar());
		break;
	    case 3: // excluir livro
		System.out.println("===> Exclusão do livro");
		System.out.println("Digite título do livro: ");
		titulo = entradaString.nextLine();

		if (!(Acervo.getListaLivros().isEmpty())) { // acervo não vazio
		    if (Acervo.remover(titulo)) {
			System.out.println("Livro removido com sucesso!");
		    } else {
			System.out.println("Título não encontrado!");
		    }
		} else {
		    System.out.println("Não existem livros no acervo!");
		}

		break;
	    case 4: // pesquisar por gênero
		System.out.println("===> Pesquisa pelo gênero");
		System.out.println("Digite o gênero: ");
		genero = entradaString.nextLine();
		System.out.println("Existem " + Acervo.pesquisar(genero) + " livro(s) do gênero " + genero);
		break;
	    case 5: // pesquisar por preço
		System.out.println("===> Pesquisar por faixa de preço");
		System.out.println("Digite a faixa inicial e a final: ");
		vInicial = entrada.nextDouble();
		vFinal = entrada.nextDouble();

		System.out.println("Existem " + Acervo.pesquisar(vInicial, vFinal) + " livro(s) com preço entre "
			+ String.format("R$ %.2f e R$ %.2f \n", vInicial, vFinal));
		break;
	    case 6: // valor total
		System.out.println("===> Total em R$ de livros no acervo");
		System.out.println("O total é: " + String.format("R$ %.2f \n", Acervo.calcularTotalAcervo()));

		break;
	    case 7:
		System.out.println("Volte sempre :D");
		break;

	    default:
		System.out.println("Opção de menu inválida");
	    }

	} while (menu != 7);

    } // fim menu

    static void exibirMenu() {
	System.out.println("=========== LIVRO LIVRARIA ===========");
	System.out.println("1 - CADASTRAR");
	System.out.println("2 - LISTAR");
	System.out.println("3 - EXCLUIR LIVRO");
	System.out.println("4 - PESQUISAR POR GENERO");
	System.out.println("5 - PESQUISAR POR FAIXA DE PREÇO");
	System.out.println("6 - CALCULAR TOTAL DO ACERVO");
	System.out.println("7 - SAIR");
	System.out.println("===> Escolha uma opção: ");
    }
}
