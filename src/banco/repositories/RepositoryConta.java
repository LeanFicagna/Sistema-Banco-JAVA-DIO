package banco.repositories;

import java.util.ArrayList;
import java.util.List;

import banco.models.Conta;

public class RepositoryConta {
    
    List<Conta> contas;

    public RepositoryConta() {
        contas = new ArrayList<>();
    }

    public boolean inserirConta(Conta conta){
        if(buscarConta(conta.getNumero()) == null) {
            contas.add(conta);
            return true;
        }
        return false;
    }
    
    public void alterarConta(Conta conta) {
        
    }
    
    public boolean deletarConta(Conta conta) {
        return contas.remove(conta);
    }
    
    public Conta buscarConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public List<Conta> getAll() {
        return new ArrayList<>(contas);
    }

}
