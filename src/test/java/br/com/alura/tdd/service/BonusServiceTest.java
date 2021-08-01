package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void bonusZeroParaSalarioMuitoAlto() {
        BonusService service = new BonusService();
        Executable methodCall = () -> service.calcularBonus(new Funcionario("Rafael", LocalDate.of(2021, Month.JULY, 1), new BigDecimal(10500)));
        assertThrows(IllegalArgumentException.class, methodCall);
    }

    @Test
    void bonusIgualDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rafael", LocalDate.of(2021, Month.JULY, 1), new BigDecimal(2500)));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusParaSalarioExatamenteDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rafael", LocalDate.of(2021, Month.JULY, 1), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
