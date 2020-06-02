```mysql
select 
  distinct t1.seat_id seat_id
from cinema t1
join cinema t2
  on t1.seat_id + 1 = t2.seat_id and (t1.free = 1 and t2.free = 1)
  or t1.seat_id - 1 = t2.seat_id and (t1.free = 1 and t2.free = 1)
;
```
