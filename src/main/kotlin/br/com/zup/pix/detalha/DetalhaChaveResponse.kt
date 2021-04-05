package br.com.zup.pix.detalha

import br.com.zup.DetalharChaveReply
import br.com.zup.pix.TipoChaveEnum
import br.com.zup.pix.TipoContaEnum
import io.micronaut.core.annotation.Introspected
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

@Introspected
class DetalhaChaveResponse(response: DetalharChaveReply) {

    val clienteId = response.clienteId
    val pixId = response.pixId
    val chave = response.chave.chave
    val tipoChave = TipoChaveEnum.valueOf(response.chave.tipo.name)

    val criadaEm = response.chave.criadaEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }

    val tipoConta = TipoContaEnum.valueOf(response.chave.conta.tipo.name)

    val conta = mapOf(Pair("tipo", tipoConta),
        Pair("instituicao", response.chave.conta.instituicao),
        Pair("nomeTitular", response.chave.conta.nomeTitular),
        Pair("cpfTitular", response.chave.conta.cpfTitular),
        Pair("agencia", response.chave.conta.agencia),
        Pair("numero", response.chave.conta.numeroConta))

}
