--------------------------------------------------------
--  File created - œroda-czerwiec-05-2019   
--------------------------------------------------------
DROP TABLE "KRZYS"."ADRESY" cascade constraints;
DROP TABLE "KRZYS"."CZLONKOSTWA" cascade constraints;
DROP TABLE "KRZYS"."KARNETY" cascade constraints;
DROP TABLE "KRZYS"."KATEGORIE_ZAJEC" cascade constraints;
DROP TABLE "KRZYS"."KLIENCI" cascade constraints;
DROP TABLE "KRZYS"."KLIENT_ZAJECIA" cascade constraints;
DROP TABLE "KRZYS"."LOGOWANIE" cascade constraints;
DROP TABLE "KRZYS"."PERSONEL" cascade constraints;
DROP TABLE "KRZYS"."PRODUKTY" cascade constraints;
DROP TABLE "KRZYS"."REZERWACJE_ZAJEC" cascade constraints;
DROP TABLE "KRZYS"."ZAMOWIENIA" cascade constraints;
DROP SEQUENCE "KRZYS"."ADREESY_SEQ";
DROP SEQUENCE "KRZYS"."CZLONKOSTWA_SEQ";
DROP SEQUENCE "KRZYS"."KARNETY_SEQ";
DROP SEQUENCE "KRZYS"."KATEGORIE_ZAJEC_SEQ";
DROP SEQUENCE "KRZYS"."KLIENCI_SEQ";
DROP SEQUENCE "KRZYS"."PERSONEL_SEQ";
DROP SEQUENCE "KRZYS"."REZERWACJE_ZAJEC_SEQ";
DROP PROCEDURE "KRZYS"."DELETEADRESY";
DROP PROCEDURE "KRZYS"."DELETECZLONKOSTWA";
DROP PROCEDURE "KRZYS"."DELETEKARNETY";
DROP PROCEDURE "KRZYS"."DELETEKATEGORIE_ZAJEC";
DROP PROCEDURE "KRZYS"."DELETEKLIENCI";
DROP PROCEDURE "KRZYS"."DELETEREZERWACJE_ZAJEC";
DROP PROCEDURE "KRZYS"."GETCZLONKOSTWA";
DROP PROCEDURE "KRZYS"."GETKARNETY";
DROP PROCEDURE "KRZYS"."GETKATEGORIEZAJEC";
DROP PROCEDURE "KRZYS"."GETKLIENCI";
DROP PROCEDURE "KRZYS"."GETKLIENT_ZAJECIA";
DROP PROCEDURE "KRZYS"."GETPERSONEL";
DROP PROCEDURE "KRZYS"."GETREZERWACJE_ZAJEC";
DROP PROCEDURE "KRZYS"."INSERTADRESY";
DROP PROCEDURE "KRZYS"."INSERTCZLONKOSTWA";
DROP PROCEDURE "KRZYS"."INSERTKARNETY";
DROP PROCEDURE "KRZYS"."INSERTKATEGORIE_ZAJEC";
DROP PROCEDURE "KRZYS"."INSERTKLIENCI";
DROP PROCEDURE "KRZYS"."INSERTKLIENT_ZAJECIA";
DROP PROCEDURE "KRZYS"."INSERTPERSONEL";
DROP PROCEDURE "KRZYS"."INSERTREZERWACJE_ZAJEC";
DROP PROCEDURE "KRZYS"."UPDATEADRESY";
DROP PROCEDURE "KRZYS"."UPDATECZLONKOSTWA";
DROP PROCEDURE "KRZYS"."UPDATEKARNETY";
DROP PROCEDURE "KRZYS"."UPDATEKATEGORIE_ZAJEC";
DROP PROCEDURE "KRZYS"."UPDATEKLIENCI";
DROP PROCEDURE "KRZYS"."UPDATEPERSONEL";
--------------------------------------------------------
--  DDL for Sequence ADREESY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."ADREESY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 17 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence CZLONKOSTWA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."CZLONKOSTWA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 4 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence KARNETY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."KARNETY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 7 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence KATEGORIE_ZAJEC_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."KATEGORIE_ZAJEC_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 5 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence KLIENCI_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."KLIENCI_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 5 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence PERSONEL_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."PERSONEL_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 4 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence REZERWACJE_ZAJEC_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "KRZYS"."REZERWACJE_ZAJEC_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 5 NOCACHE  NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Table ADRESY
--------------------------------------------------------

  CREATE TABLE "KRZYS"."ADRESY" 
   (	"ID_ADRESU" NUMBER(*,0), 
	"WOJEWODZTWO" VARCHAR2(20 BYTE), 
	"POWIAT" VARCHAR2(20 BYTE), 
	"MIEJSCOWOSC" VARCHAR2(20 BYTE), 
	"ULICA" VARCHAR2(20 BYTE), 
	"NR_DOMU" VARCHAR2(20 BYTE), 
	"KOD_POCZTOWY" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table CZLONKOSTWA
--------------------------------------------------------

  CREATE TABLE "KRZYS"."CZLONKOSTWA" 
   (	"ID_CZLONKOSTWA" NUMBER(*,0), 
	"ID_KARNETU" NUMBER(*,0), 
	"ID_KLIENTA" NUMBER(*,0), 
	"DATA_ROZPOCZECIA" DATE, 
	"DATA_ZAKONCZENIA" DATE, 
	"STATUS" NVARCHAR2(20)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table KARNETY
--------------------------------------------------------

  CREATE TABLE "KRZYS"."KARNETY" 
   (	"ID_KARNETU" NUMBER(*,0), 
	"NAZWA" VARCHAR2(20 BYTE), 
	"WAZNOSC" NUMBER(*,0), 
	"CENA" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table KATEGORIE_ZAJEC
--------------------------------------------------------

  CREATE TABLE "KRZYS"."KATEGORIE_ZAJEC" 
   (	"ID_ZAJEC" NUMBER, 
	"NAZWA_ZAJEC" VARCHAR2(20 BYTE), 
	"RODZAJ_ZAJEC" VARCHAR2(20 BYTE), 
	"OPIS" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table KLIENCI
--------------------------------------------------------

  CREATE TABLE "KRZYS"."KLIENCI" 
   (	"ID_KLIENTA" NUMBER(*,0), 
	"ID_ADRESU" NUMBER(*,0), 
	"IMIE" VARCHAR2(30 BYTE), 
	"NAZWISKO" VARCHAR2(30 BYTE), 
	"NR_TELEFONU" VARCHAR2(9 BYTE), 
	"DATA_URODZENIA" DATE, 
	"E_MAIL" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table KLIENT_ZAJECIA
--------------------------------------------------------

  CREATE TABLE "KRZYS"."KLIENT_ZAJECIA" 
   (	"ID_KLIENTA" NUMBER(*,0), 
	"ID_REZERWACJI" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOGOWANIE
--------------------------------------------------------

  CREATE TABLE "KRZYS"."LOGOWANIE" 
   (	"ID_PRACOWNIKA" NUMBER(*,0), 
	"LOGIN" VARCHAR2(20 BYTE), 
	"HASLO" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PERSONEL
--------------------------------------------------------

  CREATE TABLE "KRZYS"."PERSONEL" 
   (	"ID_PRACOWNIKA" NUMBER(*,0), 
	"ID_ADRESU" NUMBER(*,0), 
	"IMIE" VARCHAR2(30 BYTE), 
	"NAZWISKO" VARCHAR2(30 BYTE), 
	"DATA_URODZENIA" DATE, 
	"FUNKCJA" VARCHAR2(20 BYTE), 
	"NR_TELEFONU" VARCHAR2(9 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUKTY
--------------------------------------------------------

  CREATE TABLE "KRZYS"."PRODUKTY" 
   (	"ID_PRODUKTU" NUMBER(*,0), 
	"NAZWA" VARCHAR2(20 BYTE), 
	"CENA" FLOAT(126), 
	"STAN_MAGAZYNU" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REZERWACJE_ZAJEC
--------------------------------------------------------

  CREATE TABLE "KRZYS"."REZERWACJE_ZAJEC" 
   (	"ID_REZERWACJI" NUMBER(*,0), 
	"ID_PRACOWNIKA" NUMBER(*,0), 
	"ID_ZAJEC" NUMBER(*,0), 
	"DZIEN" VARCHAR2(15 BYTE), 
	"GODZINA" VARCHAR2(15 BYTE), 
	"MAX_ILOSC_OSOB" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ZAMOWIENIA
--------------------------------------------------------

  CREATE TABLE "KRZYS"."ZAMOWIENIA" 
   (	"ID_ZAMOWIENIA" NUMBER(*,0), 
	"ID_PRODUKTU" NUMBER(*,0), 
	"ID_KLIENTA" NUMBER(*,0), 
	"DATA_KUPNA" DATE, 
	"ILOSC" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into KRZYS.ADRESY
SET DEFINE OFF;
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('7','Lubelskie',null,'Janów Lubelski',null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('11','Lubuskie',null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('102',null,null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('601','dsa','dsa','d','asd','asd','as');
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('103',null,null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('302','Podkarpackie','rzeszowski','rzeszow','rejtana',null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('401',null,null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('406',null,null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('101',null,null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('3','Podkarpackie','przemyski','Bircza',null,'12',null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('5','Podkarpackie','kroœnienski','Krosno','Pigonia','1','36-030');
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('15',null,null,null,null,null,null);
Insert into KRZYS.ADRESY (ID_ADRESU,WOJEWODZTWO,POWIAT,MIEJSCOWOSC,ULICA,NR_DOMU,KOD_POCZTOWY) values ('13','Lubuskie',null,null,null,null,null);
REM INSERTING into KRZYS.CZLONKOSTWA
SET DEFINE OFF;
Insert into KRZYS.CZLONKOSTWA (ID_CZLONKOSTWA,ID_KARNETU,ID_KLIENTA,DATA_ROZPOCZECIA,DATA_ZAKONCZENIA,STATUS) values ('2','4','1',to_date('19/06/05','RR/MM/DD'),to_date('19/07/05','RR/MM/DD'),null);
REM INSERTING into KRZYS.KARNETY
SET DEFINE OFF;
Insert into KRZYS.KARNETY (ID_KARNETU,NAZWA,WAZNOSC,CENA) values ('1','Jednodniowy','1','20');
Insert into KRZYS.KARNETY (ID_KARNETU,NAZWA,WAZNOSC,CENA) values ('2','Trzydniowy','3','30');
Insert into KRZYS.KARNETY (ID_KARNETU,NAZWA,WAZNOSC,CENA) values ('3','Tygodniowy','7','40');
Insert into KRZYS.KARNETY (ID_KARNETU,NAZWA,WAZNOSC,CENA) values ('4','Miesieczny','30','120');
Insert into KRZYS.KARNETY (ID_KARNETU,NAZWA,WAZNOSC,CENA) values ('5','Roczny','365','1200');
REM INSERTING into KRZYS.KATEGORIE_ZAJEC
SET DEFINE OFF;
Insert into KRZYS.KATEGORIE_ZAJEC (ID_ZAJEC,NAZWA_ZAJEC,RODZAJ_ZAJEC,OPIS) values ('2','Joga','Relaksacyjny','Odpoczynek');
Insert into KRZYS.KATEGORIE_ZAJEC (ID_ZAJEC,NAZWA_ZAJEC,RODZAJ_ZAJEC,OPIS) values ('4','Pilates','Gimnastyka','Polaczenie jogi, baletu');
Insert into KRZYS.KATEGORIE_ZAJEC (ID_ZAJEC,NAZWA_ZAJEC,RODZAJ_ZAJEC,OPIS) values ('3','Trening obwodowy','Wytrzyma³osciowe',null);
Insert into KRZYS.KATEGORIE_ZAJEC (ID_ZAJEC,NAZWA_ZAJEC,RODZAJ_ZAJEC,OPIS) values ('1','Aerobik','Wydolnoœciowe','Poprawa wydolnosci');
REM INSERTING into KRZYS.KLIENCI
SET DEFINE OFF;
Insert into KRZYS.KLIENCI (ID_KLIENTA,ID_ADRESU,IMIE,NAZWISKO,NR_TELEFONU,DATA_URODZENIA,E_MAIL) values ('4','15','Piotr','Testowy',null,to_date('99/06/11','RR/MM/DD'),null);
Insert into KRZYS.KLIENCI (ID_KLIENTA,ID_ADRESU,IMIE,NAZWISKO,NR_TELEFONU,DATA_URODZENIA,E_MAIL) values ('2','7','Krzysztof','Polak','32312211',to_date('96/06/07','RR/MM/DD'),null);
Insert into KRZYS.KLIENCI (ID_KLIENTA,ID_ADRESU,IMIE,NAZWISKO,NR_TELEFONU,DATA_URODZENIA,E_MAIL) values ('1','5','Piotr','Kowalewski','32166327',to_date('93/06/30','RR/MM/DD'),'testowy@onet.pl');
REM INSERTING into KRZYS.KLIENT_ZAJECIA
SET DEFINE OFF;
Insert into KRZYS.KLIENT_ZAJECIA (ID_KLIENTA,ID_REZERWACJI) values ('4','2');
REM INSERTING into KRZYS.LOGOWANIE
SET DEFINE OFF;
REM INSERTING into KRZYS.PERSONEL
SET DEFINE OFF;
Insert into KRZYS.PERSONEL (ID_PRACOWNIKA,ID_ADRESU,IMIE,NAZWISKO,DATA_URODZENIA,FUNKCJA,NR_TELEFONU) values ('3','13','Micha³','Nowak',to_date('88/06/23','RR/MM/DD'),'Trener','231231231');
Insert into KRZYS.PERSONEL (ID_PRACOWNIKA,ID_ADRESU,IMIE,NAZWISKO,DATA_URODZENIA,FUNKCJA,NR_TELEFONU) values ('1','3','Micha³','Kowalski',to_date('91/05/03','RR/MM/DD'),'Trener','123455667');
REM INSERTING into KRZYS.PRODUKTY
SET DEFINE OFF;
REM INSERTING into KRZYS.REZERWACJE_ZAJEC
SET DEFINE OFF;
Insert into KRZYS.REZERWACJE_ZAJEC (ID_REZERWACJI,ID_PRACOWNIKA,ID_ZAJEC,DZIEN,GODZINA,MAX_ILOSC_OSOB) values ('2','3','4','Poniedzialek','12:00','12');
REM INSERTING into KRZYS.ZAMOWIENIA
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index IFK_REL_07
--------------------------------------------------------

  CREATE INDEX "KRZYS"."IFK_REL_07" ON "KRZYS"."CZLONKOSTWA" ("ID_KARNETU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IFK_REL_08
--------------------------------------------------------

  CREATE INDEX "KRZYS"."IFK_REL_08" ON "KRZYS"."CZLONKOSTWA" ("ID_KLIENTA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index LOGOWANIE_FKINDEX1
--------------------------------------------------------

  CREATE INDEX "KRZYS"."LOGOWANIE_FKINDEX1" ON "KRZYS"."LOGOWANIE" ("ID_PRACOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IFK_REL_01
--------------------------------------------------------

  CREATE INDEX "KRZYS"."IFK_REL_01" ON "KRZYS"."KLIENCI" ("ID_ADRESU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IFK_REL_04
--------------------------------------------------------

  CREATE INDEX "KRZYS"."IFK_REL_04" ON "KRZYS"."REZERWACJE_ZAJEC" ("ID_ZAJEC") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PERSONEL_FKINDEX1
--------------------------------------------------------

  CREATE INDEX "KRZYS"."PERSONEL_FKINDEX1" ON "KRZYS"."PERSONEL" ("ID_ADRESU") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IFK_REL_05
--------------------------------------------------------

  CREATE INDEX "KRZYS"."IFK_REL_05" ON "KRZYS"."REZERWACJE_ZAJEC" ("ID_PRACOWNIKA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index KATEGORIE_ZAJEC_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "KRZYS"."KATEGORIE_ZAJEC_PK" ON "KRZYS"."KATEGORIE_ZAJEC" ("ID_ZAJEC") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PERSONEL
--------------------------------------------------------

  ALTER TABLE "KRZYS"."PERSONEL" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."PERSONEL" MODIFY ("ID_ADRESU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."PERSONEL" ADD PRIMARY KEY ("ID_PRACOWNIKA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUKTY
--------------------------------------------------------

  ALTER TABLE "KRZYS"."PRODUKTY" MODIFY ("ID_PRODUKTU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."PRODUKTY" ADD PRIMARY KEY ("ID_PRODUKTU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ZAMOWIENIA
--------------------------------------------------------

  ALTER TABLE "KRZYS"."ZAMOWIENIA" MODIFY ("ID_ZAMOWIENIA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."ZAMOWIENIA" MODIFY ("ID_PRODUKTU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."ZAMOWIENIA" MODIFY ("ID_KLIENTA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."ZAMOWIENIA" ADD PRIMARY KEY ("ID_ZAMOWIENIA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table KATEGORIE_ZAJEC
--------------------------------------------------------

  ALTER TABLE "KRZYS"."KATEGORIE_ZAJEC" MODIFY ("ID_ZAJEC" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."KATEGORIE_ZAJEC" ADD CONSTRAINT "KATEGORIE_ZAJEC_PK" PRIMARY KEY ("ID_ZAJEC")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ADRESY
--------------------------------------------------------

  ALTER TABLE "KRZYS"."ADRESY" MODIFY ("ID_ADRESU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."ADRESY" ADD PRIMARY KEY ("ID_ADRESU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOGOWANIE
--------------------------------------------------------

  ALTER TABLE "KRZYS"."LOGOWANIE" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table KLIENCI
--------------------------------------------------------

  ALTER TABLE "KRZYS"."KLIENCI" MODIFY ("ID_KLIENTA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."KLIENCI" MODIFY ("ID_ADRESU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."KLIENCI" ADD PRIMARY KEY ("ID_KLIENTA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REZERWACJE_ZAJEC
--------------------------------------------------------

  ALTER TABLE "KRZYS"."REZERWACJE_ZAJEC" MODIFY ("ID_REZERWACJI" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."REZERWACJE_ZAJEC" MODIFY ("ID_PRACOWNIKA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."REZERWACJE_ZAJEC" MODIFY ("ID_ZAJEC" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."REZERWACJE_ZAJEC" ADD PRIMARY KEY ("ID_REZERWACJI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table KARNETY
--------------------------------------------------------

  ALTER TABLE "KRZYS"."KARNETY" MODIFY ("ID_KARNETU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."KARNETY" ADD PRIMARY KEY ("ID_KARNETU")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table KLIENT_ZAJECIA
--------------------------------------------------------

  ALTER TABLE "KRZYS"."KLIENT_ZAJECIA" MODIFY ("ID_REZERWACJI" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."KLIENT_ZAJECIA" MODIFY ("ID_KLIENTA" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CZLONKOSTWA
--------------------------------------------------------

  ALTER TABLE "KRZYS"."CZLONKOSTWA" MODIFY ("ID_CZLONKOSTWA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."CZLONKOSTWA" MODIFY ("ID_KARNETU" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."CZLONKOSTWA" MODIFY ("ID_KLIENTA" NOT NULL ENABLE);
  ALTER TABLE "KRZYS"."CZLONKOSTWA" ADD PRIMARY KEY ("ID_CZLONKOSTWA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table CZLONKOSTWA
--------------------------------------------------------

  ALTER TABLE "KRZYS"."CZLONKOSTWA" ADD CONSTRAINT "SYS_C009879" FOREIGN KEY ("ID_KLIENTA")
	  REFERENCES "KRZYS"."KLIENCI" ("ID_KLIENTA") ON DELETE CASCADE ENABLE;
  ALTER TABLE "KRZYS"."CZLONKOSTWA" ADD CONSTRAINT "SYS_C009880" FOREIGN KEY ("ID_KARNETU")
	  REFERENCES "KRZYS"."KARNETY" ("ID_KARNETU") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table KLIENCI
--------------------------------------------------------

  ALTER TABLE "KRZYS"."KLIENCI" ADD CONSTRAINT "SYS_C009868" FOREIGN KEY ("ID_ADRESU")
	  REFERENCES "KRZYS"."ADRESY" ("ID_ADRESU") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table KLIENT_ZAJECIA
--------------------------------------------------------

  ALTER TABLE "KRZYS"."KLIENT_ZAJECIA" ADD CONSTRAINT "KLIENT_ZAJECIA_KLIENCI_FK1" FOREIGN KEY ("ID_KLIENTA")
	  REFERENCES "KRZYS"."KLIENCI" ("ID_KLIENTA") ON DELETE CASCADE ENABLE;
  ALTER TABLE "KRZYS"."KLIENT_ZAJECIA" ADD CONSTRAINT "REZERWACJA_ZAJECIA_FK1" FOREIGN KEY ("ID_REZERWACJI")
	  REFERENCES "KRZYS"."REZERWACJE_ZAJEC" ("ID_REZERWACJI") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOGOWANIE
--------------------------------------------------------

  ALTER TABLE "KRZYS"."LOGOWANIE" ADD FOREIGN KEY ("ID_PRACOWNIKA")
	  REFERENCES "KRZYS"."PERSONEL" ("ID_PRACOWNIKA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PERSONEL
--------------------------------------------------------

  ALTER TABLE "KRZYS"."PERSONEL" ADD CONSTRAINT "ID_ADRESU" FOREIGN KEY ("ID_ADRESU")
	  REFERENCES "KRZYS"."ADRESY" ("ID_ADRESU") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REZERWACJE_ZAJEC
--------------------------------------------------------

  ALTER TABLE "KRZYS"."REZERWACJE_ZAJEC" ADD FOREIGN KEY ("ID_ZAJEC")
	  REFERENCES "KRZYS"."KATEGORIE_ZAJEC" ("ID_ZAJEC") ENABLE;
  ALTER TABLE "KRZYS"."REZERWACJE_ZAJEC" ADD FOREIGN KEY ("ID_PRACOWNIKA")
	  REFERENCES "KRZYS"."PERSONEL" ("ID_PRACOWNIKA") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ZAMOWIENIA
--------------------------------------------------------

  ALTER TABLE "KRZYS"."ZAMOWIENIA" ADD FOREIGN KEY ("ID_KLIENTA")
	  REFERENCES "KRZYS"."KLIENCI" ("ID_KLIENTA") ENABLE;
  ALTER TABLE "KRZYS"."ZAMOWIENIA" ADD FOREIGN KEY ("ID_PRODUKTU")
	  REFERENCES "KRZYS"."PRODUKTY" ("ID_PRODUKTU") ENABLE;
--------------------------------------------------------
--  DDL for Procedure DELETEADRESY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."DELETEADRESY" (
id_a IN adresy.id_adresu%TYPE
)
as
begin
delete Adresy where id_adresu = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure DELETECZLONKOSTWA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."DELETECZLONKOSTWA" (
id_a IN czlonkostwa.id_czlonkostwa%TYPE
)
as
begin
delete Czlonkostwa where id_czlonkostwa = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure DELETEKARNETY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."DELETEKARNETY" (
id_a IN karnety.id_karnetu%TYPE
)
as
begin
delete Karnety where id_karnetu = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure DELETEKATEGORIE_ZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."DELETEKATEGORIE_ZAJEC" (
id_a IN kategorie_zajec.id_zajec%TYPE
)
as
begin
delete kategorie_zajec where id_zajec = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure DELETEKLIENCI
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."DELETEKLIENCI" (
id_a IN adresy.id_adresu%TYPE
)
as
begin
delete Adresy where id_adresu = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure DELETEREZERWACJE_ZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."DELETEREZERWACJE_ZAJEC" (
id_a IN REZERWACJE_ZAJEC.id_rezerwacji%TYPE
)
as
begin
delete REZERWACJE_ZAJEC where id_rezerwacji = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure GETCZLONKOSTWA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETCZLONKOSTWA" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select cz.id_czlonkostwa, cz.id_karnetu, cz.id_klienta, cz.data_rozpoczecia, cz.data_zakonczenia, k.nazwa, k.id_karnetu, k.waznosc, kl.id_klienta, kl.imie, kl.nazwisko from czlonkostwa cz, karnety k, klienci kl
where cz.id_klienta = kl.id_klienta and cz.id_karnetu = k.id_karnetu;
end GETCZLONKOSTWA;

/
--------------------------------------------------------
--  DDL for Procedure GETKARNETY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETKARNETY" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select id_karnetu, nazwa, waznosc, cena from karnety;  
end GETKARNETY;

/
--------------------------------------------------------
--  DDL for Procedure GETKATEGORIEZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETKATEGORIEZAJEC" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select id_zajec, nazwa_zajec,rodzaj_zajec, opis from kategorie_zajec;
end getKATEGORIEZAJEC;

/
--------------------------------------------------------
--  DDL for Procedure GETKLIENCI
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETKLIENCI" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select klienci.id_klienta, klienci.imie, klienci.nazwisko, klienci.nr_telefonu, klienci.data_urodzenia, klienci.e_mail, adresy.id_adresu, adresy.powiat, adresy.miejscowosc, adresy.ulica, adresy.wojewodztwo, adresy.nr_domu, adresy.kod_pocztowy from klienci inner join adresy on klienci.id_adresu = adresy.id_adresu;  
end GETKLIENCI;

/
--------------------------------------------------------
--  DDL for Procedure GETKLIENT_ZAJECIA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETKLIENT_ZAJECIA" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select k.id_klienta, k.imie, k.nazwisko, r.id_rezerwacji, kz.id_klienta, kz.id_rezerwacji from klienci k, rezerwacje_zajec r, klient_zajecia kz  where  k.id_klienta = kz.id_klienta and kz.id_rezerwacji = r.id_rezerwacji;
end GETKLIENT_ZAJECIA;

/
--------------------------------------------------------
--  DDL for Procedure GETPERSONEL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETPERSONEL" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select personel.id_pracownika, personel.imie, personel.nazwisko, personel.nr_telefonu, personel.funkcja, personel.data_urodzenia, adresy.id_adresu, adresy.powiat, adresy.miejscowosc, adresy.ulica, adresy.wojewodztwo, adresy.nr_domu, adresy.kod_pocztowy from personel inner join adresy on personel.id_adresu = adresy.id_adresu;  
end GETPERSONEL;

/
--------------------------------------------------------
--  DDL for Procedure GETREZERWACJE_ZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."GETREZERWACJE_ZAJEC" 
(rekordy out sys_refcursor)
as 
begin 
open rekordy for
select r.id_rezerwacji, r.id_zajec, r.id_pracownika, r.max_ilosc_osob,r.dzien, r.godzina, k.nazwa_zajec, k.id_zajec, p.id_pracownika, p.imie, p.nazwisko from rezerwacje_zajec r, personel p, kategorie_zajec k
where r.id_pracownika = p.id_pracownika and r.id_zajec = k.id_zajec;
end GETREZERWACJE_ZAJEC;

/
--------------------------------------------------------
--  DDL for Procedure INSERTADRESY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTADRESY" (
WOJEWODZTWO IN ADRESY.WOJEWODZTWO%TYPE,
POWIAT IN adresy.powiat%TYPE,
MIEJSCOWOSC IN adresy.miejscowosc%TYPE,
ULICA IN adresy.ulica%TYPE,
NR_DOMU IN adresy.nr_domu%TYPE,
KOD_POCZTOWY IN adresy.kod_pocztowy%TYPE
)
is
begin
INSERT INTO ADRESY ("ID_ADRESU", "WOJEWODZTWO", "POWIAT", "MIEJSCOWOSC", "ULICA", "NR_DOMU", "KOD_POCZTOWY")
values (ADREESY_SEQ.nextval, WOJEWODZTWO, POWIAT, MIEJSCOWOSC, ULICA, NR_DOMU, KOD_POCZTOWY); 
commit;
end;  

/
--------------------------------------------------------
--  DDL for Procedure INSERTCZLONKOSTWA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTCZLONKOSTWA" (
id_karnetu IN czlonkostwa.id_karnetu%TYPE,
id_klienta IN czlonkostwa.id_klienta%TYPE,
data_rozpoczecia in czlonkostwa.data_rozpoczecia%TYPE,
data_zakonczenia in czlonkostwa.data_zakonczenia%TYPE
)
is
begin
INSERT INTO CZLONKOSTWA ("ID_CZLONKOSTWA", "ID_KARNETU", "ID_KLIENTA", data_rozpoczecia, data_zakonczenia)
values(CZLONKOSTWA_SEQ.nextval, id_karnetu, id_klienta, data_rozpoczecia, data_zakonczenia);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERTKARNETY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTKARNETY" (
nazwa IN karnety.nazwa%TYPE,
waznosc IN karnety.waznosc%TYPE,
cena IN karnety.cena %TYPE
)
is
begin
INSERT INTO KARNETY ("ID_KARNETU", "NAZWA", "WAZNOSC", "CENA")
values (KARNETY_SEQ.nextval, nazwa, waznosc, cena);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERTKATEGORIE_ZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTKATEGORIE_ZAJEC" (
NAZWA_ZAJEC IN KATEGORIE_ZAJEC.NAZWA_ZAJEC%TYPE,
RODZAJ_ZAJEC IN KATEGORIE_ZAJEC.RODZAJ_ZAJEC%TYPE,
OPIS IN KATEGORIE_ZAJEC.OPIS%TYPE)
is
begin
INSERT INTO KATEGORIE_ZAJEC ("ID_ZAJEC", "NAZWA_ZAJEC", "RODZAJ_ZAJEC", "OPIS")
values(KATEGORIE_ZAJEC_SEQ.nextval, NAZWA_ZAJEC, RODZAJ_ZAJEC, OPIS);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERTKLIENCI
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTKLIENCI" (
IMIE IN KLIENCI.IMIE%TYPE,
NAZWISKO IN KLIENCI.NAZWISKO%TYPE,
NR_TELEFONU IN klienci.nr_telefonu%TYPE,
DATA_URODZENIA IN klienci.data_urodzenia%TYPE,
E_MAIL IN klienci.e_mail%TYPE
)
is
begin
INSERT INTO KLIENCI ("ID_KLIENTA","ID_ADRESU", "IMIE", "NAZWISKO", "NR_TELEFONU", DATA_URODZENIA, "E_MAIL")
values(KLIENCI_SEQ.nextval, ADREESY_SEQ.nextval -1, IMIE, NAZWISKO, NR_TELEFONU, DATA_URODZENIA, E_MAIL);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERTKLIENT_ZAJECIA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTKLIENT_ZAJECIA" (
id_klienta IN KLIENT_ZAJECIA.id_klienta%TYPE,
id_rezerwacji IN klient_zajecia.id_rezerwacji%TYPE)
is
begin
INSERT INTO KLIENT_ZAJECIA ("ID_KLIENTA", "ID_REZERWACJI")
values(id_klienta, id_rezerwacji);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERTPERSONEL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTPERSONEL" (
IMIE IN PERSONEL.IMIE%TYPE,
NAZWISKO IN PERSONEL.NAZWISKO%TYPE,
DATA_URODZENIA IN PERSONEL.data_urodzenia%TYPE,
FUNKCJA IN PERSONEL.funkcja%TYPE,
NR_TELEFONU IN PERSONEL.nr_telefonu%TYPE
)
is
begin
INSERT INTO PERSONEL ("ID_PRACOWNIKA","ID_ADRESU", "IMIE", "NAZWISKO", DATA_URODZENIA, "FUNKCJA", "NR_TELEFONU")
values(PERSONEL_SEQ.nextval, ADREESY_SEQ.nextval -1, IMIE, NAZWISKO, DATA_URODZENIA, FUNKCJA, NR_TELEFONU);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure INSERTREZERWACJE_ZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."INSERTREZERWACJE_ZAJEC" (
id_zajec IN REZERWACJE_ZAJEC.id_zajec%TYPE,
id_pracownika IN REZERWACJE_ZAJEC.id_pracownika%TYPE,
dzien in REZERWACJE_ZAJEC.dzien%TYPE,
godzina in REZERWACJE_ZAJEC.godzina%TYPE,
ilosc in REZERWACJE_ZAJEC.max_ilosc_osob%TYPE
)
is
begin
INSERT INTO REZERWACJE_ZAJEC ("ID_REZERWACJI", "ID_ZAJEC", "ID_PRACOWNIKA","DZIEN","GODZINA", "MAX_ILOSC_OSOB")
values(REZERWACJE_ZAJEC_SEQ.nextval, id_zajec, id_pracownika, dzien, godzina, ilosc);
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEADRESY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."UPDATEADRESY" (
id_a IN adresy.id_adresu%TYPE,
wojewodztwo1 IN adresy.wojewodztwo%TYPE,
powiat1 IN adresy.powiat%TYPE,
miejscowosc1 IN adresy.miejscowosc%TYPE,
ulica1 IN adresy.ulica%TYPE,
nr_domu1 IN adresy.nr_domu%TYPE,
kod_pocztowy1 IN adresy.kod_pocztowy%TYPE
)
as
begin
update Adresy set
wojewodztwo= wojewodztwo1,
powiat=powiat1,
miejscowosc = miejscowosc1,
ulica = ulica1,
nr_domu = nr_domu1,
kod_pocztowy = kod_pocztowy1
where id_adresu = id_a;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATECZLONKOSTWA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."UPDATECZLONKOSTWA" (
id_cz IN czlonkostwa.id_czlonkostwa%TYPE,
karnet IN czlonkostwa.id_karnetu%TYPE,
dataod IN czlonkostwa.data_rozpoczecia%TYPE,
datado IN czlonkostwa.data_zakonczenia%TYPE
)
as
begin
update Czlonkostwa set
id_karnetu = karnet,
data_rozpoczecia = dataod,
data_zakonczenia = datado
where id_czlonkostwa = id_cz;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEKARNETY
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."UPDATEKARNETY" (
id_k IN karnety.id_karnetu%TYPE,
nazwak IN karnety.nazwa%TYPE,
waznosck IN karnety.waznosc%TYPE,
cenak IN karnety.cena %TYPE
)
as
begin
update KARNETY set
nazwa = nazwak,
waznosc = waznosck,
cena = cenak
where id_karnetu = id_k;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEKATEGORIE_ZAJEC
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."UPDATEKATEGORIE_ZAJEC" (
id_z IN kategorie_zajec.id_zajec%TYPE,
nazwa IN kategorie_zajec.nazwa_zajec%TYPE,
rodzaj IN kategorie_zajec.rodzaj_zajec%TYPE,
opiss IN kategorie_zajec.opis%TYPE
)
as
begin
update KATEGORIE_ZAJEC set
nazwa_zajec= nazwa,
rodzaj_zajec= rodzaj,
opis = opiss
where id_zajec = id_z;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEKLIENCI
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."UPDATEKLIENCI" (
id_k IN klienci.id_klienta%TYPE,
IMIEe IN KLIENCI.IMIE%TYPE,
NAZWISKOo IN KLIENCI.NAZWISKO%TYPE,
NR_TELEFONUu IN klienci.nr_telefonu%TYPE
)
as
begin
update Klienci set
imie=IMIEe,
nazwisko=NAZWISKOo,
nr_telefonu = NR_TELEFONUu
where klienci.id_klienta = id_k;
commit;
end;

/
--------------------------------------------------------
--  DDL for Procedure UPDATEPERSONEL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "KRZYS"."UPDATEPERSONEL" (
id_k IN personel.id_pracownika%TYPE,
IMIEe IN personel.IMIE%TYPE,
NAZWISKOo IN personel.NAZWISKO%TYPE,
FUNKCJAa IN personel.funkcja%TYPE,
NR_TELEFONUu IN personel.nr_telefonu%TYPE
)
as
begin
update Personel set
imie=IMIEe,
nazwisko=NAZWISKOo,
funkcja = FUNKCJAa,
nr_telefonu = NR_TELEFONUu
where id_pracownika = id_k;
commit;
end;

/
