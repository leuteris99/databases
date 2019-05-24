CREATE TABLE pelatis (
    pelatis_id INT(4) AUTO_INCREMENT,
    pelatis_Eponymo VARCHAR(25),
    PRIMARY KEY (pelatis_id)
);

CREATE TABLE montelo (
    montelo_id INT(4) AUTO_INCREMENT,
    montelo_marka VARCHAR(20),
    montelo_typos VARCHAR(20),
    montelo_etos YEAR(4),
    montelo_kubismos INT(4),
    PRIMARY KEY (montelo_id)
);

CREATE TABLE autokinito (
    autokinito_id INT(4) AUTO_INCREMENT,
    autokinito_arithmosKykloforias VARCHAR(10),
    montelo_id INT(4),
    pelatis_id INT(4),
    PRIMARY KEY (autokinito_id),
    FOREIGN KEY (pelatis_id)
        REFERENCES pelatis (pelatis_id),
    FOREIGN KEY (montelo_id)
        REFERENCES montelo (montelo_id)
);

CREATE TABLE ergasia (
    ergasia_id INT(4) AUTO_INCREMENT,
    ergasia_AA INT(4),
    ergasia_xiliometra INT(4),
    ergasia_perigrafi VARCHAR(150),
    ergasia_typos VARCHAR(20),
    ergasia_kostos NUMERIC(15 , 9 ),
    PRIMARY KEY (ergasia_id)
);


CREATE TABLE ypalilos (
    ypalilos_id INT(4) AUTO_INCREMENT,
    ypalilos_eponymo VARCHAR(20),
    ypalilos_typos VARCHAR(20),
    PRIMARY KEY (ypalilos_id)
);

CREATE TABLE aitima (
    syntirisi_id INT(4) AUTO_INCREMENT,
    autokinito_id INT(4),
    syntirisi_perigrafi VARCHAR(150),
    syntirisi_timestamp TIMESTAMP,
    syntirisi_kodikos INT(4),
    syntirisi_oloklirothike BOOLEAN,
    PRIMARY KEY (syntirisi_id),
    FOREIGN KEY (autokinito_id)
        REFERENCES autokinito (autokinito_id)
);

CREATE TABLE syntirisi (
    synt_id INT(4) AUTO_INCREMENT,
    syntirisi_id INT(4),
    PRIMARY KEY (synt_id),
    FOREIGN KEY (syntirisi_id)
        REFERENCES aitima (syntirisi_id)
);

CREATE TABLE vlavi (
    vlavi_id INT(4) AUTO_INCREMENT,
    syntirisi_id INT(4),
    PRIMARY KEY (vlavi_id),
    FOREIGN KEY (syntirisi_id)
        REFERENCES aitima (syntirisi_id)
);

CREATE TABLE eksipiretisi_vlavis (
    ypalilos_id INT(4),
    vlavi_id INT(4),
    PRIMARY KEY (ypalilos_id , vlavi_id),
    FOREIGN KEY (ypalilos_id)
        REFERENCES ypalilos (ypalilos_id),
    FOREIGN KEY (vlavi_id)
        REFERENCES vlavi (vlavi_id)
);

CREATE TABLE eksipiretisi_syntirisis (
    ypalilos_id INT(4),
    ergasia_id INT(4),
    synt_id INT(4),
    eksypiretisiSyntirisis_timestamp TIMESTAMP,
    PRIMARY KEY (ergasia_id , synt_id),
    FOREIGN KEY (ergasia_id)
        REFERENCES ergasia (ergasia_id),
    FOREIGN KEY (synt_id)
        REFERENCES syntirisi (synt_id),
    FOREIGN KEY (ypalilos_id)
        REFERENCES ypalilos (ypalilos_id)
);

CREATE TABLE programma_syntirisis (
    ergasia_id INT(4),
    montelo_id INT(4),
    PRIMARY KEY (ergasia_id , montelo_id),
    FOREIGN KEY (ergasia_id)
        REFERENCES ergasia (ergasia_id),
    FOREIGN KEY (montelo_id)
        REFERENCES montelo (montelo_id)
);