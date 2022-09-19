

create table products (
                          id          bigserial primary key,
                          title       varchar(255),
                          price       numeric(8, 2),
                          created_at  timestamp default current_timestamp,
                          updated_at  timestamp default current_timestamp
);


insert into products (title, price) values
                                                     ('Молоко', 100.00),
                                                     ('Колбаса', 250.00),
                                                     ('Помидор', 80.00),
                                                     ('Огурец', 65.00),
                                                     ('Хлеб', 32.00);

