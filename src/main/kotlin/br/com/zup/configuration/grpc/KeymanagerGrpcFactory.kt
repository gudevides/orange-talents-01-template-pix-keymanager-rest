package br.com.zup.configuration.grpc

import br.com.zup.KeymanagerCadastraGrpcServiceGrpc
import br.com.zup.KeymanagerDetalhaGrpcServiceGrpc
import br.com.zup.KeymanagerListaGrpcServiceGrpc
import br.com.zup.KeymanagerRemoveGrpcServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class KeymanagerGrpcFactory(@GrpcChannel("keyManager") val channel: ManagedChannel) {

    @Singleton
    fun cadastraChave() = KeymanagerCadastraGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun deletaChave() = KeymanagerRemoveGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun detalhaChave() = KeymanagerDetalhaGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChaves() = KeymanagerListaGrpcServiceGrpc.newBlockingStub(channel)
}