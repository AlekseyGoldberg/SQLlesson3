create table CUSTOMERS (
                           id serial,
                           name varchar(255),
                           surname varchar(255),
                           age integer,
                           phone_number bigint,
                           primary key (id)
);

create table ORDERS
(
    id           serial,
    date         timestamp not null default now(),
    customer_id  integer references customers (id),
    product_name varchar(255),
    amount       decimal,
    primary key (id)
);




