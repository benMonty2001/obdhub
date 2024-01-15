package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.repos.TagRepository
import com.obdhub.obdhub.response.TagRequest
import com.obdhub.obdhub.response.TagResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TagService(@Autowired val tagRepository: TagRepository) {
    fun getTags(): List<Tag> = tagRepository.findAll()
    fun saveTag(tagRequest: TagRequest): TagResponse {
        val tag = tagRepository.save(
            Tag().apply {
                tag = tagRequest.tag
                name = tagRequest.name
            }
        )

        return TagResponse(
            tagId = tag.tagId.toString(),
            tag = tag.tag.toString(),
            name = tag.name.toString()
        )
    }
}
