
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

create table if not exists gps_location(
	gps_id serial primary key,
	gps_name_location text,
	gps_latitude real,
	gps_longitude real,
	gps_date timestamp,
	gps_precision real,
	gps_usr_id integer references users(usr_id)
);

create table if not exists user_preferences(
	prf_usr_id serial references users(usr_id),
	prf_time_spending text,
	prf_active_level integer,
	prf_speed real,
	prf_age	integer
);

create table if not exists group_profile(
	grp_id serial primary key,
	grp_active_level integer,
	grp_age	integer,
	grp_speed real
);

create table if not exists group_content(
	con_grp_id	integer references group_profile(grp_id),
	con_usr_id	integer references users(usr_id)
	/*primary key(con_grp_id,con_usr_id)*/	
);

create table if not exists friends(
	fri_usr_id	integer references users(usr_id),
	fri_id	integer  primary key
	/*primary key(fri_usr_id,fri_id)	*/
);


create table if not exists tags(
	tag_id	serial primary key,
	tag_key	text,
	tag_value	text,
	tag_usr_id integer references node(nod_id) /* TODO zmienic nazwe na nazwê odpowadaj¹c¹ to z node */
);

create table if not exists way(
	way_id	serial primary key,
	way_tag_id	integer references tags(tag_id),
	way_index	integer
);

create table if not exists poi_points(
	poi_id	serial primary key,
	poi_nod_id	integer references node(nod_id),
	poi_name	text
);

create table if not exists lately_searched_poi(
	lsp_id	serial primary key,
	lsp_poi_id	integer references poi_points(poi_id),
	lsp_date	timestamp,
	lsp_usr_id	integer references users(usr_id)
);

create table if not exists node_way(
	now_way_id integer references way(way_id),
	now_node_id integer references node(nod_id)
	/*primary key(now_way_id,now_node_id)*/
);

create table if not exists favourite_ways(
	fav_id 		serial primary key,
	fav_name	text,
	fav_way_id	integer references way(way_id),
	fav_date	timestamp,
	fav_usr_id	integer references users(usr_id)
);

create table if not exists ways_history(
	wah_id		serial primary key,
	wah_way_id	integer references way(way_id),
	wah_date	timestamp,
	wah_usr_id	integer references users(usr_id)
);