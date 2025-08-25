create table tb_appointments (
    id serial primary key,
    client_id int not null references tb_clients(id),
    barber_id int not null references tb_barbers(id),
    status varchar(20) not null,
    payment_method varchar(50),
    appointment_date date not null default current_date
);