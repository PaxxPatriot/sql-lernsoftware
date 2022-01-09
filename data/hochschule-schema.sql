CREATE TABLE IF NOT EXISTS "Personen" (
 "id"   INTEGER NOT NULL UNIQUE,
 "vorname"  TEXT NOT NULL,
 "nachname" TEXT NOT NULL,
 "plz"   NUMERIC NOT NULL,
 "ort"   TEXT NOT NULL,
 "strasse"  TEXT NOT NULL,
 "HNr"   INTEGER NOT NULL,
 "GebDatum" TEXT NOT NULL,
 PRIMARY KEY("id")
 );
 
CREATE TABLE IF NOT EXISTS "Pers_Telefon" (
 "id"  INTEGER NOT NULL,
 "Telefon"  TEXT NOT NULL,
 PRIMARY KEY("id", "Telefon")
 );
 
CREATE TABLE IF NOT EXISTS "Mitarbeiter" (
 "id"  INTEGER NOT NULL,
 "AngNr"  TEXT NOT NULL UNIQUE,
 "Fachbereich" TEXT,
 "Gehalt"  float,
 "Raum"  INTEGER,
 "Einstellung" TEXT,
 PRIMARY KEY("id")
 );
 
CREATE TABLE IF NOT EXISTS "Professoren" (
 "id" INTEGER NOT NULL,
 "Lehrstuhlbezeichnung" TEXT,
 "Stufe"     TEXT  NOT NULL,
    PRIMARY KEY("id")
 );
 
CREATE TABLE IF NOT EXISTS "Studenten" (
 "id"  INTEGER NOT NULL,
 "Matrikelnummer" TEXT NOT NULL UNIQUE,
 "Studienfach" TEXT  NOT NULL,
 "Immatrikulationsdatum" TEXT NOT NULL,
 PRIMARY KEY("id")
 );
 
CREATE TABLE IF NOT EXISTS "Lehrstuehle" (
 "Lehrstuhlbezeichnung" TEXT NOT NULL,
 "Anzahl_Planstellen" INTEGER,
 PRIMARY KEY("Lehrstuhlbezeichnung")
 );
 
CREATE TABLE IF NOT EXISTS "Vorlesungen" (
 "V_Bezeichnung" TEXT NOT NULL,
 "SWS"   INTEGER,
 "Semester"  INTEGER,
 "Studiengang"  TEXT NOT NULL,
 PRIMARY KEY("V_Bezeichnung")
 );
 
CREATE TABLE IF NOT EXISTS "Buecher" (
 "ISBN"  TEXT NOT NULL,
 "Titel"  TEXT NOT NULL,
 "Verlagsname" TEXT,
 PRIMARY KEY("ISBN")
 );
 
CREATE TABLE IF NOT EXISTS "Buch_Autor" (
 "ISBN"  TEXT NOT NULL,
 "Autor"  TEXT NOT NULL,
 PRIMARY KEY("ISBN", "Autor")
 );
 
CREATE TABLE IF NOT EXISTS "Buch_Stichwort" (
 "ISBN"  TEXT NOT NULL,
 "Stichwort" TEXT NOT NULL,
 PRIMARY KEY("ISBN", "Stichwort")
 );
 
CREATE TABLE IF NOT EXISTS "Buch_Versionen" (
 "ISBN"  TEXT NOT NULL,
 "Auflage" INTEGER  NOT NULL,
 "Jahr"  year,
 "Seiten" INTEGER,
 "Preis"  float,
 PRIMARY KEY("ISBN", "Auflage")
 );
 
CREATE TABLE IF NOT EXISTS "Buch_Exemplare" (
 "Inventarnr" INTEGER NOT NULL,
 "ISBN"  TEXT NOT NULL,
 "Auflage"  INTEGER  NOT NULL,
 PRIMARY KEY("Inventarnr")
 );
 
CREATE TABLE IF NOT EXISTS "Verlage" (
 "Verlagsname" TEXT NOT NULL,
 "Verlagsort" TEXT,
 PRIMARY KEY("Verlagsname")
 );
 
CREATE TABLE IF NOT EXISTS "Ausleihe" (
 "id"  INTEGER NOT NULL,
 "Inventarnr" INTEGER NOT NULL,
 PRIMARY KEY("id", "Inventarnr")
 );
 
CREATE TABLE IF NOT EXISTS "Prueft" (
 "id"   INTEGER  NOT NULL,
 "Matrikelnummer" TEXT NOT NULL,
 "V_Bezeichnung" TEXT NOT NULL,
 "Note"   float,
 PRIMARY KEY("id", "Matrikelnummer", "V_Bezeichnung")
 );
 
CREATE TABLE IF NOT EXISTS "Empfiehlt" (
 "id"   INTEGER  NOT NULL,
 "ISBN"   TEXT NOT NULL,
 "V_Bezeichnung" TEXT NOT NULL,
 PRIMARY KEY("id", "ISBN", "V_Bezeichnung")
 );
 
CREATE TABLE IF NOT EXISTS "Vorl_Voraus" (
 "V_Bezeichnung" TEXT NOT NULL,
 "Voraussetzung" TEXT NOT NULL,
 PRIMARY KEY("V_Bezeichnung", "Voraussetzung")
 );

CREATE TABLE IF NOT EXISTS "Liest" (
 "id"   INTEGER  NOT NULL,
 "V_Bezeichnung" TEXT NOT NULL,
 "Semester"  TEXT NOT NULL,
 PRIMARY KEY("id", "V_Bezeichnung", "Semester")
 );
 
CREATE TABLE IF NOT EXISTS "Hoert" (
 "Matrikelnummer" TEXT NOT NULL,
 "V_Bezeichnung" TEXT NOT NULL,
 "Semester"  INTEGER,
  PRIMARY KEY("Matrikelnummer", "V_Bezeichnung")
 );
  
