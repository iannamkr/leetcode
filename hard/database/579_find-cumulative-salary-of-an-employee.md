### 최근 3개월 동안 각 직원에게 지급된 합산급여를 계산하되, 최근 월은 제외해라.

```mysql
select 
  e.id,
  e.month,
  sum(e.salary) over (partition by e.id order by e.month desc rows between current row and 2 following) salary
from Employee e
join (
    select
      id, 
      max(month) month
    from Employee
    group by id
) r
on e.id = r.id
where e.month < r.month
order by e.id asc, e.month desc
;
```
