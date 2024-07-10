package rh.model.Specification;
import rh.model.Solicitacao;

import java.math.BigDecimal;

public class SolicitacaoSpecification implements Specification<Solicitacao>{
    @Override
    public ValidationResult isSatisfiedBy(Solicitacao solicitacao){
        if (solicitacao.getValorSolicitado().compareTo(BigDecimal.ZERO) > 0){
            return ValidationResult.valid();
        }
        else {
            return ValidationResult.invalid("A solicitacao deve possuir valor maior que ZERO e nao pode ser NULL.");
        }
    }
}
