create table tb_appointment_services (
    appointment_id int not null references tb_appointments(id),
    service_id int not null references tb_services(id),
    price decimal(10,2) not null,
    primary key (appointment_id, service_id)
);