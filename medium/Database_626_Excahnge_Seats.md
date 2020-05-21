```mysql
select
  (case 
    when mod(t1.id, 2) != 0 and t2.total_seat != t1.id then t1.id + 1
    when mod(t1.id, 2) != 0 and t2.total_seat = t1.id then t1.id
    else t1.id - 1
  end) as "id",
  t1.student
from seat t1,
(select count(1) as total_seat from seat) t2
order by id asc
;
```
