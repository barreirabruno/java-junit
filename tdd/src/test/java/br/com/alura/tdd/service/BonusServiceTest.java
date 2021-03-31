package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("12000"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2500"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonus() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("10000"));
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
