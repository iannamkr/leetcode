```mysql
select 
  s.id as "id", 
  s.visit_date as "visit_date", 
  s.people as "people" 
from stadium s
left join stadium s1
  on s.id - 1 = s1.id
left join stadium s2
  on s.id - 2 = s2.id
left join stadium p1 
  on s.id + 1 = p1.id
left join stadium p2
  on s.id + 2 = p2.id
where (s.people >= 100 and s1.people >= 100 and s2.people >= 100)
  or (s.people >= 100 and p1.people >= 100 and p2.people >= 100)
  or (s.people >= 100 and s1.people >= 100 and p1.people >= 100)
order by id
;
```
