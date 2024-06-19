package rh.model.Specification;

import rh.model.Entrada;

import java.math.BigDecimal;

public class EntradaSpecification implements Specification<Entrada> {

    @Override
    public ValidationResult isSatisfiedBy(Entrada entrada){
        if (entrada.getValor().compareTo(BigDecimal.ZERO) > 0){
            return ValidationResult.valid();
        }
        else {
            return ValidationResult.invalid("A entrada deve possuir valor maior que ZERO e nao pode ser NULL.");
        }
    }
}
