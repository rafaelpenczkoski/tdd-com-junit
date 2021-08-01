package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    private void beforeEach() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Rafael", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteParaDesempenhoADesejar() {
        this.service.aplicaReajusteDesempenho(this.funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(new BigDecimal("1030.00"), this.funcionario.getSalario());
    }

    @Test
    public void reajusteParaDesempenhoBom() {
        this.service.aplicaReajusteDesempenho(this.funcionario, Desempenho.BOM);

        Assertions.assertEquals(new BigDecimal("1150.00"), this.funcionario.getSalario());
    }

    @Test
    public void reajusteParaDesempenhoOtimo() {
        this.service.aplicaReajusteDesempenho(this.funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(new BigDecimal("1200.00"), this.funcionario.getSalario());
    }
}
