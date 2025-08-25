package br.com.juniorcabellos.barbearia.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(schema = "barbearia", name = "tb_appointment_services")
public class AppointmentServiceEntity {

    @EmbeddedId
    private AppointmentServicePK id = new AppointmentServicePK();

    @ManyToOne
    @MapsId("appointment")
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;

    @ManyToOne
    @MapsId("service")
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    public AppointmentServiceEntity() {
    }

    public AppointmentServiceEntity(AppointmentEntity appointment, ServiceEntity service, BigDecimal price) {
        this.id.setAppointment(appointment);
        this.id.setService(service);
        this.appointment = appointment;
        this.service = service;
        this.price = price;
    }

    public AppointmentServicePK getId() {
        return id;
    }

    public void setId(AppointmentServicePK id) {
        this.id = id;
    }

    public AppointmentEntity getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentEntity appointment) {
        this.appointment = appointment;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppointmentServiceEntity)) return false;
        AppointmentServiceEntity that = (AppointmentServiceEntity) o;
        return Objects.equals(appointment, that.appointment) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointment, service);
    }
}