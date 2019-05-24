-- a
select * from pelatis;

-- b
SELECT * FROM montelo 
	ORDER BY montelo_kubismos DESC LIMIT 3;
    
-- c
select *
	from ypalilos
    where ypalilos.ypalilos_id in
		(SELECT ypalilos_id 
		FROM eksipiretisi_vlavis
		where eksipiretisi_vlavis.vlavi_id in
			(select vlavi_id 
			from vlavi 
			where vlavi.syntirisi_id in
				(select syntirisi_id
				from aitima
				where aitima.autokinito_id in 
					(select autokinito_id
					from autokinito
					where autokinito.montelo_id in
						(select montelo_id
						from montelo
						where montelo.montelo_etos <= 2014)))));
                        
-- d
select syntirisi.syntirisi_id,syntirisi_oloklirothike, montelo_kubismos
	from syntirisi inner join
		(aitima inner join
			(autokinito inner join
				montelo
			on autokinito.montelo_id = montelo.montelo_id)
		on aitima.autokinito_id = autokinito.autokinito_id)
	on syntirisi.syntirisi_id = aitima.syntirisi_id
    where montelo_kubismos > 1400 and syntirisi_oloklirothike = true;
    
-- e
select count(synt_id), montelo.montelo_id
	from syntirisi inner join
    (aitima inner join
		(autokinito inner join montelo 
			on autokinito.montelo_id = montelo.montelo_id)
		on aitima.autokinito_id = autokinito.autokinito_id)
	on syntirisi.syntirisi_id = aitima.syntirisi_id
    group by montelo_id;
    
-- f
select montelo.montelo_id, count(syntirisi.synt_id)
from montelo inner join
    (autokinito inner join
		(aitima inner join syntirisi 
			on aitima.syntirisi_id = syntirisi.syntirisi_id)
		on autokinito.autokinito_id = aitima.autokinito_id)
	on montelo.montelo_id = autokinito.montelo_id
group by montelo.montelo_id
having count(syntirisi.synt_id) >= 7;

-- g
select ypalilos.ypalilos_id, count(syntirisi.synt_id)
from ypalilos inner join
	(eksipiretisi_syntirisis inner join
		(syntirisi inner join aitima 
			on syntirisi.syntirisi_id = aitima.syntirisi_id)
		on eksipiretisi_syntirisis.synt_id = syntirisi.synt_id)
	on ypalilos.ypalilos_id = eksipiretisi_syntirisis.ypalilos_id
where aitima.syntirisi_timestamp > "2015-01-01 00:00:00"
group by syntirisi.synt_id;

-- h - lathos!!!!!!
select pelatis.pelatis_id, count(vlavi.vlavi_id)
from pelatis inner join
	(autokinito inner join
		(aitima inner join vlavi
			on aitima.syntirisi_id = vlavi.syntirisi_id)
		on autokinito.autokinito_id = aitima.autokinito_id)
	on pelatis.pelatis_id = autokinito.pelatis_id
where aitima.syntirisi_timestamp > "2016-01-01 00:00:00"
group by vlavi.vlavi_id;

-- i
select pelatis.pelatis_id, count(vlavi.vlavi_id)
from pelatis inner join
	(autokinito inner join
		(aitima inner join vlavi
			on aitima.syntirisi_id = vlavi.syntirisi_id)
		on autokinito.autokinito_id = aitima.autokinito_id)
	on pelatis.pelatis_id = autokinito.pelatis_id
group by vlavi.vlavi_id
having count(vlavi.vlavi_id) >= 5;

-- j - Davis
SELECT ypalilos_eponymo
from ypalilos inner join
	(eksipiretisi_syntirisis inner join
		(syntirisi inner join
			(aitima inner join
				(autokinito inner join pelatis on autokinito.pelatis_id = pelatis.pelatis_id
                and pelatis.pelatis_Eponymo = "Davis")
			on aitima.autokinito_id = autokinito.autokinito_id)
		on syntirisi.syntirisi_id = aitima.syntirisi_id)
	on eksipiretisi_syntirisis.synt_id = syntirisi.synt_id)
on ypalilos.ypalilos_id = eksipiretisi_syntirisis.ypalilos_id and ypalilos_typos = "Fanopoios";

-- k - Schultz
SELECT ypalilos_eponymo
from ypalilos inner join
	(eksipiretisi_vlavis inner join
		(vlavi inner join
			(aitima inner join
				(autokinito inner join pelatis on autokinito.pelatis_id = pelatis.pelatis_id
                and pelatis.pelatis_Eponymo = "Schultz")
			on aitima.autokinito_id = autokinito.autokinito_id)
		on vlavi.syntirisi_id = aitima.syntirisi_id)
	on eksipiretisi_vlavis.vlavi_id = vlavi.vlavi_id)
on ypalilos.ypalilos_id = eksipiretisi_vlavis.ypalilos_id and ypalilos_typos = "Hlektrologos";

-- l - Harber
SELECT distinct ypalilos_typos
from ypalilos inner join
	(eksipiretisi_syntirisis inner join
		(syntirisi inner join
			(aitima inner join
				(autokinito inner join pelatis on autokinito.pelatis_id = pelatis.pelatis_id
                and pelatis.pelatis_Eponymo = "Harber")
			on aitima.autokinito_id = autokinito.autokinito_id)
		on syntirisi.syntirisi_id = aitima.syntirisi_id)
	on eksipiretisi_syntirisis.synt_id = syntirisi.synt_id)
on ypalilos.ypalilos_id = eksipiretisi_syntirisis.ypalilos_id
inner join
	(eksipiretisi_vlavis inner join vlavi
	on eksipiretisi_vlavis.vlavi_id = vlavi.vlavi_id)
on ypalilos.ypalilos_id = eksipiretisi_vlavis.ypalilos_id
group by ypalilos_typos;

-- m
SET SQL_SAFE_UPDATES = 0;
update ergasia
set ergasia.ergasia_kostos = ergasia.ergasia_kostos * 1.24
where ergasia.ergasia_xiliometra >= 2000;

-- n
insert into autokinito (autokinito_id,montelo_id)
select 1000,montelo.montelo_id
from montelo
where montelo_marka = "qui" and montelo_typos = "iusto";
insert into aitima (autokinito_id, syntirisi_perigrafi, syntirisi_timestamp, syntirisi_kodikos, syntirisi_oloklirothike)
select  autokinito_id, "new syntirisi", "2019-05-24 13:19:54", 1, false
from autokinito
where autokinito.montelo_id in 
	(select montelo.montelo_id
    from montelo
    where montelo_marka = "qui" and montelo_typos = "iusto");
    
-- o
SET SQL_SAFE_UPDATES = 0;
delete from programma_syntirisis
where montelo_id in
 (select montelo_id
	from montelo
    where montelo_marka = "vitae" and montelo_typos = "illum");