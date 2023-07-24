create table sul(
                    sno           int                auto_increment,
                    sname       varchar(18)    unique,
                    kind          varchar(8)      unique,
                    base         varchar(30)    not null,
                    ptg           varchar(5)      not null,
                    intro         text               not null,
                    bno               int    not null,
                    tag           varchar(15)    not null,
                    primary key (sno)
);

create table online(
                       ono            int                auto_increment,
                       store         varchar(18)      not null,
                       tel             varchar(14)      not null,
                       waddr         varchar(100)      not null,
                       primary key (ono)
);

create table offline(
                        fno            int                auto_increment,
                        store         varchar(18)      not null,
                        tel             varchar(14)      not null,
                        opt            varchar(100)      not null,
                        primary key (fno)
);

create table brewery(
                        bno            int                auto_increment,
                        brname       varchar(18)      not null,
                        addr           varchar(14)      not null,
                        kind            varchar(8)      not null,
                        tel              varchar(14)      not null,
                        waddr         varchar(100)      not null,
                        sno                 int             not null,
                        pno                 int             not null,
                            primary key (bno)
);

--  술 이름 외래키
alter table brewery
    add constraint fksno
        foreign key (sno) references sul (sno);
--  양조장 이름 외래키
alter table sul
    add constraint fkbno
        foreign key (bno) references brewery (bno);
--  주종 이름 외래키
alter table anju
    add constraint fkasno
        foreign key (sno) references sul (sno);
--  프로그램명 외래키
alter table brewery
    add constraint fkpno
        foreign key (pno) references program (pno);

create table program(
                        pno                 int                 auto_increment,
                        pname            varchar(20),
                        place             varchar(18)      not null,
                        contents       text                  not null,
                        time             varchar(20)      not null,
                        cost             varchar(14)      not null,
                        primary key (pno)
);

create table anju(
                     ano            int                 auto_increment,
                     aname       varchar(18)            not null,
                     sno           int                   ,
                     primary key (ano)
);
drop table anju;
create table cocktail(
                         cno            int                 auto_increment,
                         cname       varchar(18)      not null,
                         mix            varchar(20)      not null,
                         comment     text               not null,
                         recipe          varchar(50)      not null,
                         primary key (cno)
);