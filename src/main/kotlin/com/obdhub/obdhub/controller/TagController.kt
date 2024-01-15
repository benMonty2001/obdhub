package com.obdhub.obdhub.controller

import com.obdhub.obdhub.response.TagRequest
import com.obdhub.obdhub.response.TagResponse
import com.obdhub.obdhub.service.TagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tag")
class TagController(@Autowired val tagService: TagService) {

    @GetMapping
    @ResponseBody
    fun getTags(): List<TagResponse> {
        val tags = tagService.getTags()
        return tags.map { tag -> {}
            TagResponse(
                tagId = tag.tagId.toString(),
                tag = tag.tag.toString(),
                name = tag.name.toString()
            )
        }
    }

    @PostMapping
    @ResponseBody
    fun postTag(@RequestBody tagRequest: TagRequest): TagResponse {
       return tagService.saveTag(tagRequest)
    }
}
