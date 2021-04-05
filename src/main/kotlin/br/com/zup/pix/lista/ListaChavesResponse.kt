package br.com.zup.pix.lista

import br.com.zup.ListarChavesReply
import br.com.zup.pix.TipoContaEnum
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

class ListaChavesResponse(chaves: ListarChavesReply.ChavesPix) {

    val pixId = chaves.pixId
    val tipo = chaves.tipo
    val chave = chaves.chave
    val tipoConta = TipoContaEnum.valueOf(chaves.tipoConta.name)
    val criadaEm = chaves.criadaEm.let {
        LocalDateTime.ofInstant(Instant.ofEpochSecond(it.seconds, it.nanos.toLong()), ZoneOffset.UTC)
    }
}
