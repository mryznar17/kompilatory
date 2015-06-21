create table if not exists klienci(
	kli_idklienta varchar(10) primary key,
	kli_nazwa varchar(40),
	kli_miasto varchar(40), 
	kli_adres varchar(40),
	kli_email varchar(40),
	kli_telefon varchar(16),
	kli_fax varchar(16),
	kli_nip varchar(13),
	kli_regon varchar(9)
);

create table if not exists kompozycje(
	kom_idkompozycji varchar(5) primary key,
	kom_nazwa varchar(40),
	kom_opis varchar(100),
	kom_cena real
);

create table if not exists czas(
	czs_idczasu serial primary key,
	czs_godzina integer ,
	czs_minuta integer,
	czs_sekunda integer,
	czs_dzien integer,
	czs_miesiac integer,
	czs_rok integer,
	czs_tydzien integer,
	czs_kwartal integer
);

create table if not exists odbiorcy(
	odb_idodbiorcy integer primary key,
	odb_nazwa varchar(40),
	odb_miasto varchar(40),
	odb_adres varchar(40)
);

create table if not exists sprzedaz(
	spr_idsprzedazy serial primary key,
	spr_idklienta varchar(10) references klienci(kli_idklienta),
	spr_idodbiorcy integer references odbiorcy(odb_idodbiorcy),
	spr_idkompozycji varchar(5) references kompozycje(kom_idkompozycji),
	spr_idczasu integer references czas(czs_idczasu),
	spr_zaplacone real,
	spr_cena real
);

