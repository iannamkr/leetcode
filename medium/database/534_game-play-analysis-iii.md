```mysql
# Write your MySQL query statement below
select 
  t1.player_id,
  t1.event_date,
  sum(t2.games_played) games_played_so_far
from Activity t1
join Activity t2
  on t1.player_id = t2.player_id
where t1.event_date >= t2.event_date
group by t1.player_id, t1.event_date
;
```
