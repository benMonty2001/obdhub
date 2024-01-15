package com.obdhub.obdhub.controller

import com.obdhub.obdhub.response.ThrottlePosRequest
import com.obdhub.obdhub.response.ThrottlePosResponse
import com.obdhub.obdhub.service.ThrottlePosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/throttleposition")
class ThrottlePosController(@Autowired val throttlePosService: ThrottlePosService) {

    @GetMapping
    @ResponseBody
    fun getThrottlePos(): List<ThrottlePosResponse> {
        val throttlePosList = throttlePosService.getThrottlePos()
        return throttlePosList.map { throttlePos ->
            ThrottlePosResponse(
                id = throttlePos.id.toString(),
                createdAt = throttlePos.createdAt.toString(),
                value = throttlePos.value.toString(),
                defaultUnit = throttlePos.defaultUnit.toString(),
                uploadId = throttlePos.uploadId.toString(),
                tagId = throttlePos.tag?.tagId.toString(),
                vehicleId = throttlePos.vehicle?.id.toString()
            )
        }
    }

    @PostMapping
    @ResponseBody
    fun postThrottlePos(@RequestBody throttlePosRequest: ThrottlePosRequest): ThrottlePosResponse {
        return throttlePosService.saveThrottlePos(throttlePosRequest)
    }
}
