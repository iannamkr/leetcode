```mysql
select 
  e.name name,
  b.bonus bonus
from Employee e
left join Bonus b
  on e.empId = b.empId
where b.bonus < 1000
  or b.bonus is null 
;
```
