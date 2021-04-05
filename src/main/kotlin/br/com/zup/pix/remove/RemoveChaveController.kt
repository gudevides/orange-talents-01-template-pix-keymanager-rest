package br.com.zup.pix.remove

import br.com.zup.KeymanagerRemoveGrpcServiceGrpc
import br.com.zup.RemoverChaveRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.validation.Validated
import java.util.*

@Validated
@Controller("/api/clientes/{clienteId}")
class RemoveChaveController(private val removeChaveClient: KeymanagerRemoveGrpcServiceGrpc.KeymanagerRemoveGrpcServiceBlockingStub) {

    @Delete("/pix/{pixId}")
    fun removeChave (clienteId: String, pixId: String): HttpResponse<Any> {

        removeChaveClient.removerChave(RemoverChaveRequest.newBuilder().setClienteId(clienteId).setPixId(pixId).build())

        return HttpResponse.ok()
    }
}