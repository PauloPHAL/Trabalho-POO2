/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author 2019122760222
 */
public class Nada {
    //Sistema de gerenciamento de estoque: crie um sistema que relaciona as tabelas de produtos, fornecedores e estoque. 
    //Os usuários podem adicionar novos produtos, atualizar quantidades em estoque e visualizar informações de fornecedores.
    //
    //Sistema de gerenciamento de pedidos: crie um sistema que relaciona as tabelas de pedidos, clientes e produtos. 
    //Os usuários podem visualizar informações de clientes, selecionar produtos para pedidos e rastrear o status dos pedidos.
    //
    //Sistema de gerenciamento de tarefas: crie um sistema que relaciona as tabelas de tarefas, usuários e projetos. 
    //Os usuários podem atribuir tarefas a si mesmos ou a outros usuários, visualizar informações de projeto e atualizar o status das tarefas.
    //
    //Sistema de gerenciamento de vendas: crie um sistema que relaciona as tabelas de vendas, clientes e produtos. 
    //Os usuários podem visualizar informações de vendas, selecionar produtos para vendas e rastrear o histórico de compras dos clientes.
    //
    //Sistema de gerenciamento de biblioteca: crie um sistema que relaciona as tabelas de livros, autores e empréstimos. 
    //Os usuários podem adicionar novos livros, visualizar informações de autor e emprestar livros para usuários registrados.
    
    /*
    CREATE TABLE Fabricante (
        idFabricante SERIAL PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        pais VARCHAR(255) NOT NULL,
        dataFundacao DATE NOT NULL,
        logo BYTEA
    );
 
    CREATE TABLE Modelo (
        idModelo SERIAL PRIMARY KEY,
        nome VARCHAR(255) NOT NULL,
        tipo VARCHAR(255) NOT NULL,
        capacidade INT NOT NULL,
        dataModelo DATE NOT NULL,
        fotoModelo BYTEA,
        idFabricante INT NOT NULL,
        FOREIGN KEY (idFabricante) REFERENCES Fabricante(idFabricante)
    );

    CREATE TABLE Aeronave (
        idAeronave SERIAL PRIMARY KEY,
        numeroSerie VARCHAR(255) NOT NULL,
        dataCompra DATE NOT NULL,
        idModelo INT NOT NULL,
        FOREIGN KEY (idModelo) REFERENCES Modelo(idModelo)
    );
    */
   
}
