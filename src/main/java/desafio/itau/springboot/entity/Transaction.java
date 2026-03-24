package desafio.itau.springboot.entity;

import java.time.OffsetDateTime;

public class Transaction {

    private double valor;

    private OffsetDateTime dataHora;

    public Transaction(final double valor, final OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

}
