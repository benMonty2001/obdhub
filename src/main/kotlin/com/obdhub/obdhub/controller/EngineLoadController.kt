package com.obdhub.obdhub.controller

import com.obdhub.obdhub.request.EngineLoadRequest
import com.obdhub.obdhub.response.EngineLoadResponse
import com.obdhub.obdhub.service.EngineLoadService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/engineload")
class EngineLoadController(@Autowired val engineLoadService: EngineLoadService) {

    @GetMapping
    @ResponseBody
    fun getEngineLoads(): List<EngineLoadResponse> {
        val engineLoadList = engineLoadService.getEngineLoads()
        return engineLoadList.map { engineLoad ->
            EngineLoadResponse(
                id = engineLoad.id.toString(),
                createdAt = engineLoad.createdAt.toString(),
                value = engineLoad.value.toString(),
                defaultUnit = engineLoad.defaultUnit.toString(),
                uploadId = engineLoad.uploadId.toString(),
                tagId = engineLoad.tag?.tagId.toString(),
                vehicleId = engineLoad.vehicle?.id.toString()
            )
        }
    }

    @PostMapping
    @ResponseBody
    fun postEngineLoad(@RequestBody engineLoadRequest: EngineLoadRequest): EngineLoadResponse {
        return engineLoadService.saveEngineLoad(engineLoadRequest)
    }
}
