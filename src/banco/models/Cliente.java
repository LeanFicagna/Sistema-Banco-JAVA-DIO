package banco.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Cliente(String nome, String cpf) {
        contas = new ArrayList<>();
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void addConta(Conta conta) {
        contas.add(conta);
    }

    public Conta getConta() {
        try {
            return contas.get(0);
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
    }
}
