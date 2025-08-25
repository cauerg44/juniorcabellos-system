package br.com.juniorcabellos.barbearia.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class AppointmentServicePK {

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private ServiceEntity service;

    public AppointmentServicePK() {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentServicePK that = (AppointmentServicePK) o;
        return Objects.equals(appointment, that.appointment) && Objects.equals(service, that.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointment, service);
    }
}