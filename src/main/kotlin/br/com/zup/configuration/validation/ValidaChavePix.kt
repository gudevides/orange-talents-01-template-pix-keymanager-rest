package br.com.zup.configuration.validation

import br.com.zup.pix.cadastra.CadastraChaveRequest
import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ValidaChavePixValidator::class])
annotation class ValidaChavePix(
    val message: String = "Chave Pix inválida",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
)

@Singleton
class ValidaChavePixValidator : ConstraintValidator<ValidaChavePix, CadastraChaveRequest> {

    override fun isValid(
        value: CadastraChaveRequest?,
        annotationMetadata: AnnotationValue<ValidaChavePix>,
        context: ConstraintValidatorContext
    ): Boolean {

        if (value?.tipoChave == null){
            return false
        }

        return value.tipoChave.valida(value.valorChave)
    }


}

