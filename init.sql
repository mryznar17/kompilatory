create schema if not exists swt;

create table if not exists swt.users(
	usr_id serial primary key,
	usr_email text,
	usr_name text,
	usr_lat_name text,
	usr_password_hash varchar(100)
);

create table if not exists swt.node(
	nod_id	serial primary key,
	nod_lat	real,
	nod_lon	real
);

create table if not exists swt.gps_location(
	gps_id serial primary key,
	gps_name_location text,
	gps_latitude real,
	gps_longitude real,
	gps_date timestamp,
	gps_precision real,
	gps_usr_id integer references swt.users(usr_id)
);

create table if not exists swt.user_preferences(
	prf_usr_id serial primary key references swt.users(usr_id),
	prf_time_spending text,
	prf_active_level integer,
	prf_speed numeric(7,2),
	prf_age	integer
);

create table if not exists swt.group_profile(
	grp_id serial primary key,
	grp_active_level integer,
	grp_age	integer,
	grp_speed numeric(7,2)
);

create table if not exists swt.group_content(
	con_grp_id	integer references swt.group_profile(grp_id),
	con_usr_id	integer references swt.users(usr_id),
	primary key(con_grp_id,con_usr_id)	
);

create table if not exists swt.friends(
	fri_usr_id	integer references swt.users(usr_id),
	fri_id	integer,
	primary key(fri_usr_id,fri_id)	
);


create table if not exists swt.tags(
	tag_id	serial primary key,
	tag_key	text,
	tag_value	text,
	tag_usr_id integer references swt.node(nod_id) /* TODO zmienic nazwe na nazwê odpowadaj¹c¹ to z node */
);

create table if not exists swt.way(
	way_id	serial primary key,
	way_tag_id	integer references swt.tags(tag_id),
	way_index	integer
);

create table if not exists swt.poi_points(
	poi_id	serial primary key,
	poi_nod_id	integer references swt.node(nod_id),
	poi_name	text
);

create table if not exists swt.lately_searched_poi(
	lsp_id	serial primary key,
	lsp_poi_id	integer references swt.poi_points(poi_id),
	lsp_date	timestamp,
	lsp_usr_id	integer references swt.users(usr_id)
);

create table if not exists swt.node_way(
	now_way_id integer references swt.way(way_id),
	now_node_id integer references swt.node(nod_id),
	primary key(now_way_id,now_node_id)
);

create table if not exists swt.favourite_ways(
	fav_id 		serial primary key,
	fav_name	text,
	fav_way_id	integer references swt.way(way_id),
	fav_date	timestamp,
	fav_usr_id	integer references swt.users(usr_id)
);

create table if not exists swt.ways_history(
	wah_id		serial primary key,
	wah_way_id	integer references swt.way(way_id),
	wah_date	timestamp,
	wah_usr_id	integer references swt.users(usr_id)
);

create table if not exists swt.weather(
	wea_id_city	serial primary key,
	wea_name	text,
	wea_country	text,
	wea_lat	real,
	wea_lon	real,
	wea_cnt	integer,
	wea_dt	timestamp,
	wea_temp	integer,
	wea_humindity	integer,
	wea_temp_min	integer,
	wea_temp_max	integer,
	wea_pressure	integer,
	wea_sea_level	integer,
	wea_grnd_level	integer,
	wea_speed	integer,
	wea_deg	integer,
	wea_gust	integer,
	wea_all	integer,
	wea_id_condition	integer,
	wea_main	text,
	wea_descripton	text,
	wea_icon	integer,
	wea_3h_rain	integer,
	wea_3h_snow	integer
);