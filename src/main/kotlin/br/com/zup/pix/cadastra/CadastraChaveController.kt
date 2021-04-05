package br.com.zup.pix.cadastra

import br.com.zup.KeymanagerCadastraGrpcServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/api/clientes/{clienteId}")
class CadastraChaveController(private val cadastraChaveClient: KeymanagerCadastraGrpcServiceGrpc.KeymanagerCadastraGrpcServiceBlockingStub) {

    @Post("/pix")
    fun cadastraChave(clienteId: String, @Valid @Body request: CadastraChaveRequest): HttpResponse<Any> {

        val response = cadastraChaveClient.cadastrarChave(request.toModel(clienteId))

        val location = HttpResponse.uri("/api/clientes/${clienteId}/pix/${response.pixId}")
        return HttpResponse.created(location)
    }
}