package com.ifrr.projetojpamaven.util; // Declara o pacote onde a classe JpaUtil está localizada.

import javax.persistence.EntityManager; // Importa a classe EntityManager para gerenciar entidades.
import javax.persistence.EntityManagerFactory; // Importa a classe EntityManagerFactory para criar EntityManagers.
import javax.persistence.Persistence; // Importa a classe Persistence para obter a unidade de persistência.

public class JpaUtil { // Declara a classe JpaUtil, utilizada para gerenciar a criação do EntityManagerFactory.

    private static EntityManagerFactory factory; // Declara uma variável estática para armazenar a fábrica de EntityManagers.

    // Bloco estático para inicializar o EntityManagerFactory uma única vez ao carregar a classe.
    static {
        try {
            // Tenta criar o EntityManagerFactory usando o nome da unidade de persistência "jpa".
            factory = Persistence.createEntityManagerFactory("jpa");
        } catch (Exception e) { // Captura qualquer exceção lançada durante a criação do EntityManagerFactory.
            // Imprime uma mensagem de erro caso ocorra uma falha na criação do EntityManagerFactory.
            System.err.println("Erro ao criar EntityManagerFactory: " + e.getMessage());
            // Lança uma exceção fatal para encerrar a aplicação em caso de falha.
            throw new ExceptionInInitializerError(e);
        }
    }

    // Método para obter um novo EntityManager.
    public static EntityManager getEntityManager() {
        // Verifica se o factory foi inicializado corretamente antes de criar um EntityManager.
        if (factory == null) {
            // Lança uma exceção se o factory não foi criado.
            throw new IllegalStateException("EntityManagerFactory não está inicializado.");
        }
        // Cria e retorna um novo EntityManager a partir do factory.
        return factory.createEntityManager();
    }

    // Método para fechar o EntityManager de forma segura.
    public static void closeEntityManager(EntityManager entityManager) {
        // Verifica se o EntityManager passado não é nulo e está aberto.
        if (entityManager != null && entityManager.isOpen()) {
            // Fecha o EntityManager para liberar recursos.
            entityManager.close();
        }
    }

    // Método para fechar o EntityManagerFactory de forma segura.
    public static void closeFactory() {
        // Verifica se o factory não é nulo e está aberto.
        if (factory != null && factory.isOpen()) {
            // Fecha o EntityManagerFactory para liberar recursos ao final da aplicação.
            factory.close();
        }
    }

    // Bloco estático para registrar um "Shutdown Hook" no Runtime.
    static {
        // Adiciona um "Shutdown Hook" para garantir que o factory seja fechado ao encerrar a aplicação.
        Runtime.getRuntime().addShutdownHook(new Thread(JpaUtil::closeFactory));
    }
}
