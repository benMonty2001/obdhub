package com.obdhub.obdhub.domain

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.time.OffsetDateTime
import java.util.*


@Entity
class AbsoluteLoad {

    @Id
    @Column(
        nullable = false,
        updatable = false
    )
    @GenericGenerator(
        name = "uuid",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @GeneratedValue(generator = "uuid")
    var id: UUID? = null

    @Column(nullable = false)
    var createdAt: OffsetDateTime? = null

    @Column
    var `value`: Double? = null

    @Column(columnDefinition = "text")
    var defaultUnit: String? = null

    @Column
    var uploadId: UUID? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    var tag: Tag? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "vehicle_id",
        nullable = false
    )
    var vehicle: Vehicle? = null

}
