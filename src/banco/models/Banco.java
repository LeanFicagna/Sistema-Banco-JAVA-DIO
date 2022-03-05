package banco.models;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        contas = new ArrayList<>();
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void addConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return this.contas;
    }
}
