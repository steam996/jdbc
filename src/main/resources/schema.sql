create schema if not exists CUSTOMERS;

create table if not exists customers.CUSTOMERS
(
    id           serial primary key,
    name         varchar(50),
    surmane      varchar(50),
    age          int8,
    phone_number varchar(50)
);

create table if not exists customers.orders
(
    id           serial primary key,
    date         date,
    customer_id  int,
    product_name varchar(100),
    amount       int,
    FOREIGN KEY (customer_id) references CUSTOMERS.customers (id)
);
