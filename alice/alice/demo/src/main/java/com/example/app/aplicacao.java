package com.example.app;

import java.util.List;

import com.example.dao.DAO;
import com.example.dao.DAOProduto;
import com.example.model.Produto;

public class aplicacao {

    public static void main(String[] args) {
        DAOProduto dao = new DAOProduto();

        Produto p = new Produto("linguica", 20f, "12345678901234");
        System.out.println("Inserindo produto: " + p);
        dao.insert(p);

        System.out.println("Listando produtos com nome 'linguica':");
        List<Produto> produtos = dao.selectByName("linguica");
        produtos.forEach(System.out::println);

        Produto p2 = produtos.get(0);
        System.out.println("Atualizando produto: " + p2);
        p2.setPreco(50f);
        dao.update(p2);

        System.out.println("Listando produtos após atualização:");
        produtos = dao.selectByName("linguica");
        produtos.forEach(System.out::println);

        Produto p3 = produtos.get(0);
        System.out.println("Deletando produto: " + p3);
        dao.delete(p3.getId());

        System.out.println("Listando todos os produtos restantes:");
        produtos = dao.selectAll();
        produtos.forEach(System.out::println);
    }

}
