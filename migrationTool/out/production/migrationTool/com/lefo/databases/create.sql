CREATE TABLE pelatis (
    pelatis_id INT(4),
    pelatis_Eponymo VARCHAR(25),
    PRIMARY KEY (pelatis_id)
);

CREATE TABLE montelo (
    montelo_id INT(4),
    montelo_marka VARCHAR(20),
    montelo_typos VARCHAR(20),
    montelo_etos YEAR(4),
    montelo_kubismos INT(4),
    PRIMARY KEY (montelo_id)
);

CREATE TABLE autokinito (
    autokinito_id INT(4),
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
    ergasia_id INT(4),
    ergasia_AA INT(4),
    ergasia_xiliometra INT(4),
    ergasia_perigrafi VARCHAR(150),
    ergasia_typos VARCHAR(20),
    ergasia_kostos NUMERIC(15 , 9 ),
    PRIMARY KEY (ergasia_id)
);

-- ALTER TABLE montelo add FOREIGN KEY(ergasia_id) REFERENCES ergasia(ergasia_id);

CREATE TABLE ypalilos (
    ypalilos_id INT(4),
    ypalilos_eponymo VARCHAR(20),
    ypalilos_typos VARCHAR(20),
    PRIMARY KEY (ypalilos_id)
);

CREATE TABLE aitima (
    aitima_id INT(4),
    autokinito_id INT(4),
    syntirisi_perigrafi VARCHAR(150),
    syntirisi_timestamp TIMESTAMP,
    syntirisi_kodikos INT(4),
    syntirisi_oloklirothike BOOLEAN,
    PRIMARY KEY (aitima_id),
    FOREIGN KEY (autokinito_id)
        REFERENCES autokinito (autokinito_id)
);

CREATE TABLE syntirisi (
    syntirisi_id INT(4),
    aitima_id INT(4),
    PRIMARY KEY (syntirisi_id),
    FOREIGN KEY (aitima_id)
        REFERENCES aitima (aitima_id)
);

CREATE TABLE vlavi (
    vlavi_idAutokinito INT(4),
    aitima_id INT(4),
    PRIMARY KEY (vlavi_idAutokinito),
    FOREIGN KEY (aitima_id)
        REFERENCES aitima (aitima_id)
);

CREATE TABLE eksipiretisi_vlavis (
    ypalilos_id INT(4),
    vlavi_idAutokinito INT(4),
    PRIMARY KEY (ypalilos_id , vlavi_idAutokinito),
    FOREIGN KEY (ypalilos_id)
        REFERENCES ypalilos (ypalilos_id),
    FOREIGN KEY (vlavi_idAutokinito)
        REFERENCES vlavi (vlavi_idAutokinito)
);

CREATE TABLE eksipiretisi_syntirisis (
    ypalilos_id INT(4),
    ergasia_id INT(4),
    syntirisi_id INT(4),
    eksypiretisiSyntirisis_timestamp TIMESTAMP,
    PRIMARY KEY (ergasia_id , syntirisi_id),
    FOREIGN KEY (ergasia_id)
        REFERENCES ergasia (ergasia_id),
    FOREIGN KEY (syntirisi_id)
        REFERENCES syntirisi (syntirisi_id),
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