package br.com.juniorcabellos.barbearia.entity;

import br.com.juniorcabellos.barbearia.entity.enums.AppointmentStatus;
import br.com.juniorcabellos.barbearia.entity.enums.PaymentMethod;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(schema = "barbearia", name = "tb_appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "barber_id", nullable = false)
    private BarberEntity barber;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status = AppointmentStatus.AGUARDANDO;

    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "appointment_date", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate appointmentDate = LocalDate.now();

    public AppointmentEntity() {
    }

    public AppointmentEntity(Long id, ClientEntity client, BarberEntity barber, AppointmentStatus status, PaymentMethod paymentMethod) {
        this.id = id;
        this.client = client;
        this.barber = barber;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.appointmentDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public BarberEntity getBarber() {
        return barber;
    }

    public void setBarber(BarberEntity barber) {
        this.barber = barber;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentEntity that = (AppointmentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}