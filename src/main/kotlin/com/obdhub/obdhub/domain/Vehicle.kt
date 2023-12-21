package com.obdhub.obdhub.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID
import org.hibernate.annotations.GenericGenerator


@Entity
class Vehicle {

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

    @Column(
        nullable = false,
        columnDefinition = "text"
    )
    var vin: String? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleAbsoluteLoads: MutableSet<AbsoluteLoad>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleAirIntakeTemperatures: MutableSet<AirIntakeTemperature>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleAirflows: MutableSet<Airflow>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleAmbientAirTemperatures: MutableSet<AmbientAirTemperature>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleBarometricPressures: MutableSet<BarometricPressure>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleEgrs: MutableSet<Egr>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleEngineCoolantTemperatures: MutableSet<EngineCoolantTemperature>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleEngineLoads: MutableSet<EngineLoad>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleEthanolLevels: MutableSet<EthanolLevel>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleFuelConsumptionRates: MutableSet<FuelConsumptionRate>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleFuelLevels: MutableSet<FuelLevel>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleFuelRailGaugePressures: MutableSet<FuelRailGaugePressure>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleFuelRailPressures: MutableSet<FuelRailPressure>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleFuelTrims: MutableSet<FuelTrim>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleFuelTypes: MutableSet<FuelType>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleIntakeManifoldPressures: MutableSet<IntakeManifoldPressure>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleModuleVoltages: MutableSet<ModuleVoltage>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleOilTemperatures: MutableSet<OilTemperature>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleRelativeThrottlePoses: MutableSet<RelativeThrottlePos>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleRpms: MutableSet<Rpm>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleRuntimes: MutableSet<Runtime>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleSpeeds: MutableSet<Speed>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleThrottlePoses: MutableSet<ThrottlePos>? = null

    @OneToMany(mappedBy = "vehicle")
    var vehicleTimingAdvances: MutableSet<TimingAdvance>? = null

}
