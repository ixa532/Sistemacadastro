package sistema;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 

{

    public static void main(String[] args) 
    
    {

        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        int opcao;

        do 
        
        {
            System.out.println("\n=== SISTEMA DE CADASTRAMENTO ===");
            System.out.println("1 - Cadastrar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Editar pessoa");
            System.out.println("4 - Remover pessoa");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) 
            
            {

                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite a idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite o email: ");
                    String email = sc.nextLine();

                    Pessoa novaPessoa = new Pessoa(nome, idade, email);
                    listaPessoas.add(novaPessoa);

                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    if (listaPessoas.isEmpty()) 
                    
                    {
                    	
                        System.out.println("Nenhuma pessoa cadastrada.");
                        
                    } 
                    
                    else 
                    
                    {
                        for (int i = 0; i < listaPessoas.size(); i++) 
                        
                        {
                            Pessoa p = listaPessoas.get(i);
                            System.out.println("ID: " + i);
                            System.out.println("Nome: " + p.getNome());
                            System.out.println("Idade: " + p.getIdade());
                            System.out.println("Email: " + p.getEmail());
                            System.out.println("----------------------");
                        }
                    }
                    
                    break;

                case 3:
                    System.out.print("Digite o ID da pessoa para editar: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();

                    if (idEditar >= 0 && idEditar < listaPessoas.size()) 
                    
                    {

                        Pessoa p = listaPessoas.get(idEditar);

                        System.out.print("Novo nome: ");
                        p.setNome(sc.nextLine());

                        System.out.print("Nova idade: ");
                        p.setIdade(sc.nextInt());
                        sc.nextLine();

                        System.out.print("Novo email: ");
                        p.setEmail(sc.nextLine());

                        System.out.println("Pessoa atualizada com sucesso!");
                    } 
                    
                    else 
                    
                    {
                        System.out.println("ID inválido.");
                        
                    }
                    
                    break;

                case 4:
                    System.out.print("Digite o ID da pessoa para remover: ");
                    int idRemover = sc.nextInt();
                    sc.nextLine();

                    if (idRemover >= 0 && idRemover < listaPessoas.size()) 
                    
                    {
                        listaPessoas.remove(idRemover);
                        System.out.println("Pessoa removida com sucesso!");
                    } 
                    
                    else 
                    
                    {
                        System.out.println("ID inválido.");
                    }
                    
                    break;

                case 5:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } 
        
        while (opcao != 5);

        sc.close();
    }
}