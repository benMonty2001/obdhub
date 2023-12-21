package com.obdhub.obdhub.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID
import org.hibernate.annotations.GenericGenerator


@Entity
class Tag {

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
    var tagId: UUID? = null

    @Column(
        nullable = false,
        columnDefinition = "text"
    )
    var tag: String? = null

    @Column(columnDefinition = "text")
    var name: String? = null

    @OneToMany(mappedBy = "tag")
    var tagAbsoluteLoads: MutableSet<AbsoluteLoad>? = null

    @OneToMany(mappedBy = "tag")
    var tagAirIntakeTemperatures: MutableSet<AirIntakeTemperature>? = null

    @OneToMany(mappedBy = "tag")
    var tagAirflows: MutableSet<Airflow>? = null

    @OneToMany(mappedBy = "tag")
    var tagAmbientAirTemperatures: MutableSet<AmbientAirTemperature>? = null

    @OneToMany(mappedBy = "tag")
    var tagBarometricPressures: MutableSet<BarometricPressure>? = null

    @OneToMany(mappedBy = "tag")
    var tagEgrs: MutableSet<Egr>? = null

    @OneToMany(mappedBy = "tag")
    var tagEngineCoolantTemperatures: MutableSet<EngineCoolantTemperature>? = null

    @OneToMany(mappedBy = "tag")
    var tagEngineLoads: MutableSet<EngineLoad>? = null

    @OneToMany(mappedBy = "tag")
    var tagEthanolLevels: MutableSet<EthanolLevel>? = null

    @OneToMany(mappedBy = "tag")
    var tagFuelConsumptionRates: MutableSet<FuelConsumptionRate>? = null

    @OneToMany(mappedBy = "tag")
    var tagFuelLevels: MutableSet<FuelLevel>? = null

    @OneToMany(mappedBy = "tag")
    var tagFuelRailGaugePressures: MutableSet<FuelRailGaugePressure>? = null

    @OneToMany(mappedBy = "tag")
    var tagFuelRailPressures: MutableSet<FuelRailPressure>? = null

    @OneToMany(mappedBy = "tag")
    var tagFuelTrims: MutableSet<FuelTrim>? = null

    @OneToMany(mappedBy = "tag")
    var tagFuelTypes: MutableSet<FuelType>? = null

    @OneToMany(mappedBy = "tag")
    var tagIntakeManifoldPressures: MutableSet<IntakeManifoldPressure>? = null

    @OneToMany(mappedBy = "tag")
    var tagModuleVoltages: MutableSet<ModuleVoltage>? = null

    @OneToMany(mappedBy = "tag")
    var tagOilTemperatures: MutableSet<OilTemperature>? = null

    @OneToMany(mappedBy = "tag")
    var tagRelativeThrottlePoses: MutableSet<RelativeThrottlePos>? = null

    @OneToMany(mappedBy = "tag")
    var tagRpms: MutableSet<Rpm>? = null

    @OneToMany(mappedBy = "tag")
    var tagRuntimes: MutableSet<Runtime>? = null

    @OneToMany(mappedBy = "tag")
    var tagSpeeds: MutableSet<Speed>? = null

    @OneToMany(mappedBy = "tag")
    var tagThrottlePoses: MutableSet<ThrottlePos>? = null

    @OneToMany(mappedBy = "tag")
    var tagTimingAdvances: MutableSet<TimingAdvance>? = null

}
