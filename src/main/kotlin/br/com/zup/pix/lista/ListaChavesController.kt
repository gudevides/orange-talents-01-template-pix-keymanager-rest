package br.com.zup.pix.lista

import br.com.zup.KeymanagerListaGrpcServiceGrpc
import br.com.zup.ListarChavesRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated

@Validated
@Controller("/api/clientes/{clienteId}")
class ListaChavesController(private val listaChavesClient: KeymanagerListaGrpcServiceGrpc.KeymanagerListaGrpcServiceBlockingStub) {

    @Get("/pix")
    fun listaChaves(clienteId: String) : HttpResponse<Any> {

        val response = listaChavesClient.listarChaves(
            ListarChavesRequest.newBuilder()
                .setClienteId(clienteId)
                .build()
        )

        val chaves = response.chavesList.map { ListaChavesResponse(it) }
        return HttpResponse.ok(chaves)
    }
}