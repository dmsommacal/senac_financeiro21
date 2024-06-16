package rh.model;

public class EntradaSpecification implements Specification<Entrada>{

    public ValidationResult isSatisfiedBy(Entrada entrada){
        if (entrada.getValor() != null){
            return ValidationResult.valid();
        }
        else {
            return ValidationResult.invalid("A entrada deve possuir valor maior que Zero e não pode ser null");
        }
    }
}
