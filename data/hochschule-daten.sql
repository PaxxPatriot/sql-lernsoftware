/*
Table data for unibeispiel.ausleihe
*/

INSERT INTO `Ausleihe` VALUES (7754,1) , (9912,85) , (5588,101) , (9912,102) , (7754,140) , (4711,141) ;

/*
Table data for unibeispiel.buch_autor
*/

INSERT INTO `Buch_Autor` VALUES ("0-201-53771-0","Abiteboul") , ("0-201-53771-0","Hull") , ("0-201-53771-0","Vianu") , ("0-8053-1753-8","Elmasri") , ("0-8053-1753-8","Navathe") , ("3-89319-175-5","Vossen") , ("3-89319-175-5","Witt") , ("3-929821-31-1","Heuer") , ("3-929821-31-1","Saake") ;

/*
Table data for unibeispiel.buch_exemplare
*/

INSERT INTO `Buch_Exemplare` VALUES (101,"0-201-53771-0",1) , (102,"0-201-53771-0",1) , (5,"0-8053-1753-8",1) , (84,"0-8053-1753-8",1) , (85,"0-8053-1753-8",2) , (1,"3-89319-175-5",1) , (138,"3-929821-31-1",1) , (139,"3-929821-31-1",1) , (140,"3-929821-31-1",1) , (141,"3-929821-31-1",1) ;

/*
Table data for unibeispiel.buch_stichwort
*/

INSERT INTO `Buch_Stichwort` VALUES ("0-201-53771-0","RDB") , ("0-201-53771-0","Theorie") , ("0-8053-1753-8","ER") , ("0-8053-1753-8","Lehrbuch") , ("0-8053-1753-8","RDB") , ("3-89319-175-5","RDB") , ("3-929821-31-1","ER") , ("3-929821-31-1","Lehrbuch") , ("3-929821-31-1","OODB") , ("3-929821-31-1","RDB") ;

/*
Table data for unibeispiel.buch_versionen
*/

INSERT INTO `Buch_Versionen` VALUES ("0-201-53771-0",1,1995,685,87) , ("0-8053-1753-8",1,1989,802,72) , ("0-8053-1753-8",2,1994,873,88) , ("3-89319-175-5",1,1990,288,79) , ("3-929821-31-1",1,1995,510,59) ;

/*
Table data for unibeispiel.buecher
*/

INSERT INTO `Buecher` VALUES ("0-201-53771-0","Foundations of DB","Addison-Wesley") , ("0-8053-1753-8","Princ. of DBS","Benjamin-Cummings") , ("3-89319-175-5","Das DB2-Handbuch","Addison-Wesley") , ("3-929821-31-1","Datenbanken","Thomson") ;

/*
Table data for unibeispiel.empfiehlt
*/

INSERT INTO `Empfiehlt` VALUES (4711,"0-201-53771-0","Theorie relationaler Datenbanken") , (4711,"0-8053-1753-8","Datenbanken I") , (4711,"0-8053-1753-8","Datenbanken II") , (5588,"0-8053-1753-8","Datenbanken I") , (5588,"0-8053-1753-8","Datenbanken II") , (5588,"3-89319-175-5","Datenbanken fuer Ingenieure") , (4711,"3-929821-31-1","Datenbanken I") , (5588,"3-929821-31-1","Datenbanken I") ;

/*
Table data for unibeispiel.hoert
*/

INSERT INTO `Hoert` VALUES ("HRO-912291","Datenbanken I",5) , ("HRO-912291","Datenbanken II",8) , ("HRO-912291","Objektorientierte Datenbanken",6) , ("MD-891372","Datenbanken I",5) , ("MD-891372","Spezifikationsmethoden",6) , ("MD-891372","Verteilte Datenbanken",6) ;

/*
Table data for unibeispiel.lehrstuehle
*/

INSERT INTO `Lehrstuehle` VALUES ("Datenbank- und Informationssysteme",4) , ("Datenbanken und Informationssysteme",5) , ("Rechnernetze",2) ;

/*
Table data for unibeispiel.liest
*/

INSERT INTO `Liest` VALUES (5588,"Datenbanken fuer Ingenieure","WS 95/96") , (4711,"Datenbanken I","WS 95/96") , (5588,"Datenbanken I","WS 95/96") , (4711,"Datenbanken II","SS 96") , (4711,"Objektorientierte Datenbanken","SS 96") , (5588,"Spezifikationsmethoden","SS 96") , (4711,"Theorie relationaler Datenbanken","WS 95/96") , (5588,"Verteilte Datenbanken","SS 96") ;

/*
Table data for unibeispiel.mitarbeiter
*/

INSERT INTO `Mitarbeiter` VALUES (4711,"HRO-3447","Informatik",6000,209,"1994-03-01") , (5588,"MD-5267","Informatik",6000,304,"1994-04-01") , (6834,"MD-77185","Mathematik",750,309,"1994-09-01") , (7754,"HRO-18532","Informatik",550,218,"1994-10-01") , (8832,"MD-4567","Informatik",2800,302,"1994-08-01") , (9912,"HRO-8134","Linguistik",2600,8,"1993-01-01") ;

/*
Table data for unibeispiel.pers_telefon
*/

INSERT INTO `Pers_Telefon` VALUES (4711,"0381-498-3401") , (4711,"0381-498-3427") , (4711,"038203-12230") , (5588,"0391-345677") , (5588,"0391-5592-3800") , (9999,"06221-400177") ;

/*
Table data for unibeispiel.personen
*/

INSERT INTO `Personen` VALUES (4711,"Andreas","Heuer","18209","DBR","BHS",15,"1958-10-31") , (5588,"Gunter","Saake","39106","MD","STS",55,"1960-10-05") , (6834,"Michael","Korn","39104","MD","BS",41,"1974-09-24") , (7754,"Andreas","Moeller","18209","DBR","RS",31,"1976-02-25") , (8832,"Tamara","Jagellovsk","38106","BS","GS",12,"1973-11-11") , (9912,"Antje","Hellhof","18059","HRO","AES",21,"1970-04-04") , (9999,"Christa","Loeser","69121","HD","TS",38,"1969-05-10") ;

/*
Table data for unibeispiel.professoren
*/

INSERT INTO `Professoren` VALUES (4711,"Datenbank- und Informationssysteme","C4") , (5588,"Datenbanken und Informationssysteme","C4") ;

/*
Table data for unibeispiel.prueft
*/

INSERT INTO `Prueft` VALUES (4711,"HRO-912291","Datenbanken I",2) , (4711,"HRO-912291","Objektorientierte Datenbanken",2.3) , (5588,"MD-891372","Datenbanken I",1.3) , (5588,"MD-891372","Spezifikationsmethoden",2.7) ;

/*
Table data for unibeispiel.studenten
*/

INSERT INTO `Studenten` VALUES (6834,"MD-891372","Informatik","1989-10-01") , (7754,"HRO-912291","Informatik","1991-10-01") ;

/*
Table data for unibeispiel.verlage
*/

INSERT INTO `Verlage` VALUES ("Addison-Wesley","Bonn") , ("Benjamin-Cummings","Redwood City") , ("Thomson","Bonn") ;

/*
Table data for unibeispiel.vorl_voraus
*/

INSERT INTO `Vorl_Voraus` VALUES ("Datenbanken II","Datenbanken I") , ("Objektorientierte Datenbanken","Datenbanken I") , ("Theorie relationaler Datenbanken","Datenbanken I") , ("Verteilte Datenbanken","Datenbanken II") , ("Spezifikationsmethoden","Objektorientierte Datenbanken") , ("Verteilte Datenbanken","Objektorientierte Datenbanken") , ("Spezifikationsmethoden","Theorie relationaler Datenbanken") ;

/*
Table data for unibeispiel.vorlesungen
*/

INSERT INTO `Vorlesungen` VALUES ("Datenbanken",3,7,"Mathematik") , ("Datenbanken fuer Ingenieure",2,7,"Elektrotechnik") , ("Datenbanken I",4,5,"Informatik") , ("Datenbanken II",4,6,"Informatik") , ("Objektorientierte Datenbanken",4,6,"Informatik") , ("Spezifikationsmethoden",3,10,"Informatik") , ("Theorie relationaler Datenbanken",3,9,"Informatik") , ("Verteilte Datenbanken",2,8,"Informatik") ;