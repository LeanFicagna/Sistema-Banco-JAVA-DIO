package banco.models;

public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo = 0;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        cliente.addConta(this);
    }
       
    public boolean sacar(double valor) {
        if(this.getSaldo() - valor >= 0){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void depositar(double valor) {
        this.saldo += this.saldo + valor;
    }

    public boolean transferir(double valor, Conta contaDestino) {
        if(this.sacar(valor)) {
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public int getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
}
