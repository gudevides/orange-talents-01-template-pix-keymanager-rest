package br.com.zup.pix.detalha

import br.com.zup.DetalharChaveRequest
import br.com.zup.KeymanagerDetalhaGrpcServiceGrpc
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated

@Validated
@Controller("/api/clientes/{clienteId}")
class DetalhaChaveController(private val detalhaChaveClient: KeymanagerDetalhaGrpcServiceGrpc.KeymanagerDetalhaGrpcServiceBlockingStub) {

    @Get("/pix/{pixId}")
    fun detalhaChave(clienteId: String, pixId: String) : HttpResponse<Any> {

        val response = detalhaChaveClient.detalharChave(
            DetalharChaveRequest.newBuilder().setPixId(
                DetalharChaveRequest.FiltroPorPixId.newBuilder()
                    .setClienteId(clienteId)
                    .setPixId(pixId)
                    .build()
            ).build())

        return HttpResponse.ok(DetalhaChaveResponse(response))
    }
}