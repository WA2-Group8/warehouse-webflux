package it.polito.wa2group8.warehousewebflux.exceptions

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class CustomAttributes: DefaultErrorAttributes() {

    override fun getErrorAttributes(request: ServerRequest?, options: ErrorAttributeOptions?): MutableMap<String, Any> {
        val errorAttributesMap = super.getErrorAttributes(request, options)
        val throwable = getError(request)
        if(throwable is BadRequestException || throwable is NotFoundException)
            errorAttributesMap["message"] = throwable.message
        return errorAttributesMap
    }
}