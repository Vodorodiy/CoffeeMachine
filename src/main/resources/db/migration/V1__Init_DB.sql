create sequence hibernate_sequence start 1 increment 1;

create table coffee (coffee_id int8 not null, click_count int4 not null, coffee_name varchar(255), recipe varchar(255), primary key (coffee_id));
create table ingredient (ingredient_id int8 not null, ingredient_name varchar(255), storage_id int8, primary key (ingredient_id));
create table ingredients_in_coffee (ingredient_id int8 not null, coffee_id int8 not null);
create table storage_item (storage_id int8 not null, ingredient_name varchar(255), unit_count int4 not null, unit_type varchar(255), primary key (storage_id));

alter table if exists ingredient add constraint FKk29gdxx1k99tw02u9xnlk3w3r foreign key (storage_id) references storage_item;
alter table if exists ingredients_in_coffee add constraint FK94o87si8ynpfi60ypbagyt49r foreign key (coffee_id) references coffee;
alter table if exists ingredients_in_coffee add constraint FKgv93gugu3snpyy4cowwj19iwi foreign key (ingredient_id) references ingredient;