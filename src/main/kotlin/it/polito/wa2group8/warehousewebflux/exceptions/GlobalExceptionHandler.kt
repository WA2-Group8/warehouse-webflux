package it.polito.wa2group8.warehousewebflux.exceptions


import org.springframework.boot.autoconfigure.web.WebProperties
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.reactive.error.ErrorAttributes
import org.springframework.context.ApplicationContext
import org.springframework.core.annotation.Order
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Mono
import java.util.*

@Component
@Order(-2)
class GlobalExceptionHandler(errorAttributes: ErrorAttributes,
                             resourceProperties: WebProperties.Resources,
                             applicationContext: ApplicationContext):
    AbstractErrorWebExceptionHandler(errorAttributes, resourceProperties, applicationContext) {
    /**
     * Create a [RouterFunction] that can route and handle errors as JSON responses
     * or HTML views.
     *
     *
     * If the returned [RouterFunction] doesn't route to a `HandlerFunction`,
     * the original exception is propagated in the pipeline and can be processed by other
     * [org.springframework.web.server.WebExceptionHandler]s.
     * @param errorAttributes the `ErrorAttributes` instance to use to extract error
     * information
     * @return a [RouterFunction] that routes and handles errors
     */

    override fun getRoutingFunction(errorAttributes: ErrorAttributes?): RouterFunction<ServerResponse> {
        return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse)
    }

    private fun formatErrorResponse(request: ServerRequest): Mono<ServerResponse> {
        val errorAttributesMap: Map<String, Any> = getErrorAttributes(request, ErrorAttributeOptions.defaults())
        val status =  Optional.ofNullable(errorAttributesMap["status"]).orElse(500) as Int
        return ServerResponse
            .status(status)
            .contentType(MediaType.APPLICATION_JSON)
            .body(BodyInserters.fromValue(errorAttributesMap))
    }
}