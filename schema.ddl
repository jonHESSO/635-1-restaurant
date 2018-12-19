
    alter table Restaurant 
        drop constraint FK_eah4whiaf1ih3b7exqy31igq2

    alter table Restaurant 
        drop constraint FK_rnig6a5umrf4n8htbcvt0nx93

    alter table Restaurant_Rating 
        drop constraint FK_chfvf6yutoxa32hkjtvm6gyk9

    alter table Restaurant_Rating 
        drop constraint FK_eddgugqxnavw3ug2pijqh81j1

    drop table Menu if exists

    drop table Owner if exists

    drop table Rating if exists

    drop table Restaurant if exists

    drop table Restaurant_Rating if exists

    drop sequence hibernate_sequence

    create table Menu (
        id bigint not null,
        content varchar(255),
        primary key (id)
    )

    create table Owner (
        id bigint not null,
        email varchar(255),
        name varchar(255),
        primary key (id)
    )

    create table Rating (
        id bigint not null,
        comment varchar(255),
        mark integer not null,
        primary key (id)
    )

    create table Restaurant (
        id bigint not null,
        adress varchar(255),
        city varchar(255),
        name varchar(255),
        FK_MENU bigint,
        FK_OWNER bigint not null,
        primary key (id)
    )

    create table Restaurant_Rating (
        Restaurant_id bigint not null,
        ratings_id bigint not null,
        primary key (Restaurant_id, ratings_id)
    )

    alter table Restaurant_Rating 
        add constraint UK_chfvf6yutoxa32hkjtvm6gyk9  unique (ratings_id)

    alter table Restaurant 
        add constraint FK_eah4whiaf1ih3b7exqy31igq2 
        foreign key (FK_MENU) 
        references Menu

    alter table Restaurant 
        add constraint FK_rnig6a5umrf4n8htbcvt0nx93 
        foreign key (FK_OWNER) 
        references Owner

    alter table Restaurant_Rating 
        add constraint FK_chfvf6yutoxa32hkjtvm6gyk9 
        foreign key (ratings_id) 
        references Rating

    alter table Restaurant_Rating 
        add constraint FK_eddgugqxnavw3ug2pijqh81j1 
        foreign key (Restaurant_id) 
        references Restaurant

    create sequence hibernate_sequence start with 1
