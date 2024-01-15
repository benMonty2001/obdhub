package com.obdhub.obdhub.controller

import com.obdhub.obdhub.response.AbsoluteLoadRequest
import com.obdhub.obdhub.response.AbsoluteLoadResponse
import com.obdhub.obdhub.service.AbsoluteLoadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/absoluteload")
class AbsoluteLoadController(@Autowired val absoluteLoadService: AbsoluteLoadService) {

    @GetMapping
    @ResponseBody
    fun getAbsoluteLoads(): List<AbsoluteLoadResponse> {
        val absoluteLoadList = absoluteLoadService.getAbsoluteLoads()
        return absoluteLoadList.map { absoluteLoad ->
            AbsoluteLoadResponse(
                id = absoluteLoad.id.toString(),
                createdAt = absoluteLoad.createdAt.toString(),
                value = absoluteLoad.value.toString(),
                defaultUnit = absoluteLoad.defaultUnit.toString(),
                uploadId = absoluteLoad.uploadId.toString(),
                tagId = absoluteLoad.tag?.tagId.toString(),
                vehicleId = absoluteLoad.vehicle?.id.toString()
            )
        }
    }

    @PostMapping
    @ResponseBody
    fun postAbsoluteLoad(@RequestBody absoluteLoadRequest: AbsoluteLoadRequest): AbsoluteLoadResponse {
        return absoluteLoadService.saveAbsoluteLoad(absoluteLoadRequest)
    }
}
