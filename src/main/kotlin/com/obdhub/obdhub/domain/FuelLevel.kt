package com.obdhub.obdhub.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.OffsetDateTime
import java.util.UUID
import org.hibernate.annotations.GenericGenerator


@Entity
class FuelLevel {

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
