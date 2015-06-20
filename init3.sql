create table if not exists users(
	usr_id serial primary key,
	usr_email text,
	usr_name text,
	usr_lat_name text,
	usr_password_hash varchar(100)
);

create table if not exists node(
	nod_id	serial primary key,
	nod_lat	real,
	nod_lon	real
);