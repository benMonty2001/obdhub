package com.obdhub.obdhub.controller

import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.repos.TagRepository
import com.obdhub.obdhub.request.TagRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class TagController(@Autowired val tagRepository: TagRepository) {

    @GetMapping("/tag")
    @ResponseBody
    fun getTags(): List<Tag> = tagRepository.findAll()

    @PostMapping("/tag")
    @ResponseBody
    fun createTag(@RequestBody tagRequest: TagRequest) {
        val tag = Tag().apply {
            tag = tagRequest.tag
            name = tagRequest.name
        }
        tagRepository.save(tag)
    }
}
