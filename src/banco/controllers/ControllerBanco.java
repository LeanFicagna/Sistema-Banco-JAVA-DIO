package banco.controllers;

import java.util.List;

import banco.models.Banco;
import banco.models.Cliente;
import banco.models.Conta;
import banco.repositories.RepositoryBanco;
import banco.repositories.RepositoryCliente;
import banco.repositories.RepositoryConta;

public class ControllerBanco {
    
    private RepositoryBanco repositoryBanco;
    private RepositoryCliente repositoryCliente;
    private RepositoryConta repositoryConta;

    public ControllerBanco() {
        repositoryBanco = new RepositoryBanco();
        repositoryCliente = new RepositoryCliente();
        repositoryConta = new RepositoryConta();
    }

    public boolean inserirCliente(Cliente cliente){
        return repositoryCliente.inserirCliente(cliente);
    }

    public void alterarCliente(Cliente cliente) {
        
    }

    public Cliente buscarCliente(String cpf) {
        return repositoryCliente.buscarCliente(cpf);
    }

    public Cliente buscarCliente(String nome, String cpf) {
        return repositoryCliente.buscarCliente(nome, cpf);
    }

    public boolean excluirCliente(Cliente cliente) {
        return repositoryCliente.deletarCliente(cliente);
    }

    public List<Cliente> getAllCliente() {
        return repositoryCliente.getAll();
    }

    // ================ ==================

    public boolean inserirConta(Conta conta){
        return repositoryConta.inserirConta(conta);
    }

    public void alterarConta(Conta conta) {
        
    }

    public Conta buscarConta(int numero) {
        return repositoryConta.buscarConta(numero);
    }
    
    public boolean excluirConta(Conta conta) {
        return repositoryConta.deletarConta(conta);
    }

    public List<Conta> getAllConta() {
        return repositoryConta.getAll();
    }

    // ======================= ======================

    public boolean inserirBanco(Banco banco){
        return repositoryBanco.inserirBanco(banco);
    }

    public void alterarBanco(Banco banco) {
        
    }

    public Banco buscarBanco(String nome) {
        return repositoryBanco.buscarBanco(nome);
    }

    public boolean excluirBanco(Banco banco) {
        return repositoryBanco.deletarBanco(banco);
    }

    public List<Banco> getAllBanco() {
        return repositoryBanco.getAll();
    }
}
