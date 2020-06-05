```mysql
/*
rules of the scores
3: win
1: draw
0: lose
*/
select
  t.team_id,
  t.team_name,
  coalesce(sum(
    case 
      when m.host_team = t.team_id then 
        case 
          when host_goals > guest_goals then 3 
          when host_goals = guest_goals then 1
          else 0
        end
       when m.guest_team = t.team_id then
        case 
          when host_goals < guest_goals then 3 
          when host_goals = guest_goals then 1
          else 0
        end
    end
  ), 0) as num_points
from Teams t
left join Matches m
  on t.team_id = m.host_team
  or t.team_id = m.guest_team
group by t.team_id
order by num_points desc, team_id asc
;
```
