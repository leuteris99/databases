select * from pelatis;
SELECT * FROM montelo 
	ORDER BY montelo_kubismos DESC LIMIT 3;
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
select *
	from syntirisi
    where syntirisi.syntirisi_id in
		(select syntirisi_id
        from aitima
        where syntirisi_oloklirothike = true and aitima.autokinito_id in
			(select autokinito_id
            from autokinito
            where autokinito.montelo_id in
				(select montelo_id
                from montelo 
                where montelo.montelo_kubismos > 1400)));