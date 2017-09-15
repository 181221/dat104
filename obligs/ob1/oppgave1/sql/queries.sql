SET SEARCH_PATH TO handleliste;
SELECT brukernavn, navn from vare v
  JOIN kurv k ON
                v.kurv_id = k.kurv_id
  JOIN bruker b ON
                  k.bruker_id = b.bruker_id
where b.bruker_id = 1


