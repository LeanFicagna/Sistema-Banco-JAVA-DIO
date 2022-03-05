package banco.repositories;

import java.util.ArrayList;
import java.util.List;

import banco.models.Banco;

public class RepositoryBanco {
    
    List<Banco> bancos;

    public RepositoryBanco() {
        bancos = new ArrayList<>();
    }

    public boolean inserirBanco(Banco banco){
        if(buscarBanco(banco.getNome()) == null) {
            bancos.add(banco);
            return true;
        }
        return false;
    }
    
    public boolean deletarBanco(Banco banco) {
        return bancos.remove(banco);
    }
    
    public void alterarCliente(Banco banco) {
        
    }
    
    public Banco buscarBanco(String nome) {
        for (Banco banco : bancos) {
            if (banco.getNome().equals(nome)) {
                return banco;
            }
        }
        return null;
    }
    
    public List<Banco> getAll() {
        return new ArrayList<>(bancos);
    }

}
