package rh.model.Specification;

import rh.model.Entrada;
import rh.model.Specification.Specification;
import rh.model.Specification.ValidationResult;

import java.math.BigDecimal;

public class ValorSpecification implements Specification<Entrada> {
    @Override
    public ValidationResult isSatisfiedBy(Entrada entrada){
        if (entrada.getValor() != null && entrada.getValor().compareTo(BigDecimal.ZERO) > 0 ){
            return ValidationResult.valid();
        }
        else {
            return ValidationResult.invalid("A entrada deve possuir valor maior que Zero e não pode ser null");
        }
    }
}
