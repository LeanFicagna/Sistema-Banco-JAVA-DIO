package banco.repositories;

import java.util.ArrayList;
import java.util.List;

import banco.models.Cliente;

public class RepositoryCliente {
    
    List<Cliente> clientes;

    public RepositoryCliente() {
        clientes = new ArrayList<>();
    }

    public boolean inserirCliente(Cliente cliente){
        if(buscarCliente(cliente.getCpf()) == null) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }
    
    public void alterarCliente(Cliente cliente) {
        
    }
    
    public boolean deletarCliente(Cliente cliente) {
        return clientes.remove(cliente);
    }
    
    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    
    public Cliente buscarCliente(String nome, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
        }
        return null;
    }
    
    public List<Cliente> getAll() {
        return new ArrayList<>(clientes);
    }

}
