package com.dzen.campfire.api_media.requests

import com.sup.dev.java.libs.api_simple.client.ApiClient
import com.sup.dev.java.libs.api_simple.client.Request
import com.sup.dev.java.libs.json.Json

open class RResourcesGet(
        var resourceId: Long
) : Request<RResourcesGet.Response>() {

    init {
        cashAvailable = false
        requestType = ApiClient.REQUEST_TYPE_DATA_LOAD
    }

    override fun jsonSub(inp: Boolean, json: Json) {
        resourceId = json.m(inp, "resourceId", resourceId)
    }

    override fun instanceResponse(data:ByteArray): Response {
        return Response(data)
    }


    class Response(var bytes:ByteArray) : Request.Response() {

        override fun getData():ByteArray? {
            return bytes
        }
    }

}