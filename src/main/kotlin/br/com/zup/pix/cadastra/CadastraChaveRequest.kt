package br.com.zup.pix.cadastra

import br.com.zup.CadastrarChaveRequest
import br.com.zup.ChaveEnum
import br.com.zup.ContaEnum
import br.com.zup.configuration.validation.ValidaChavePix
import br.com.zup.pix.TipoChaveEnum
import br.com.zup.pix.TipoContaEnum
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@ValidaChavePix
@Introspected
class CadastraChaveRequest(
    @field:NotNull
    val tipoChave: TipoChaveEnum,
    @field:Size(max = 77)
    val valorChave: String,
    @field:NotNull
    val tipoConta: TipoContaEnum
) {
    fun toModel(clienteId: String): CadastrarChaveRequest? {
        return CadastrarChaveRequest.newBuilder().setCliente(clienteId)
            .setTipoChave(ChaveEnum.valueOf(tipoChave.name))
            .setTipoConta(ContaEnum.valueOf(tipoConta.name))
            .setValorChave(valorChave)
            .build()
    }

}
