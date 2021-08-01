package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {
    public void aplicaReajusteDesempenho(Funcionario func, Desempenho desempenho) {
        BigDecimal reajuste = func.getSalario().multiply(desempenho.percentualReajuste());
        func.reajustarSalario(reajuste);
    }
}
