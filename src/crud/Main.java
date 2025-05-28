package crud;

import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner (System.in);
		conexao.conectar();
		
		int opcao;
		
		// repete até o usuário escolher sair
		do {
			// mostra as opções
			System.out.println("\n===== MENU DE MAQUIAGENS =====");
			System.out.println("1 - Adicionar Maquiagem");
			System.out.println("2 - Listar Maquiagens");
			System.out.println("3 - Atualizar Maquiagem");
			System.out.println("4 - Remover Maquiagem");
			System.out.println("0 - Sair");
			System.out.print("Escolha: ");
			opcao = sc.nextInt();
			sc.nextLine(); //limpa quebra de linha
		
		
		switch (opcao) {
		case 1:
			
			System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Tipo: ");
            String tipo = sc.nextLine();
            System.out.print("Cor: ");
            String cor = sc.nextLine();
            
         // ID será gerado automaticamente pelo banco
            Maquiagem nova = new Maquiagem(0, marca, tipo, cor);
            MaquiagemCrud.criar(nova);
			break;
			
		case 2:
			List<Maquiagem> lista = MaquiagemCrud.lerMaquiagens();
			System.out.println("\n--- Lista de Maquiagens ---");
            for (Maquiagem m : lista) {
                System.out.printf("ID: %d | Marca: %s | Tipo: %s | Cor: %s\n",
                        m.getId(), m.getMarca(), m.getTipo(), m.getCor());
            }
            break;
            
		case 3:
            // pede ID da maquiagem a ser atualizada
            System.out.print("ID da maquiagem a atualizar: ");
            int idAtualizar = sc.nextInt();
            sc.nextLine();
            System.out.print("Nova marca: ");
            String novaMarca = sc.nextLine();
            System.out.print("Novo tipo: ");
            String novoTipo = sc.nextLine();
            System.out.print("Nova cor: ");
            String novaCor = sc.nextLine();
            
            // cria nova maquiagem com o mesmo ID e atualiza
            Maquiagem atualizada = new Maquiagem(idAtualizar, novaMarca, novoTipo, novaCor);
            MaquiagemCrud.atualizarMaquiagem(idAtualizar, atualizada);
            System.out.println("✅ Atualizado com sucesso!");
            break;
            
		 case 4:
             // pede ID da maquiagem a remover
             System.out.print("ID da maquiagem a remover: ");
             int idRemover = sc.nextInt();
             MaquiagemCrud.deletarMaquiagem(idRemover);
             System.out.println(" Removida com sucesso!");
             break;
             
		 case 0:
             // encerra o programa
             System.out.println("Saindo... até mais!");
             break;

         default:
             // caso a pessoa digite número inválido
             System.out.println("❌ Opção inválida!");

			}	
		} while (opcao != 0); // repete até digitar 0

		sc.close();
	}

}
