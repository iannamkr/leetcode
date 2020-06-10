```mysql
select 
  max(America) as America, 
  max(Asia) as Asia, 
  max(Europe) as Europe 
from (
    select 
      rn,
      case when continent='America' then name else null end as America,
      case when continent='Asia' then name else null end as Asia,
      case when continent='Europe' then name else null end as Europe
    from (
      select 
        name, 
        continent, 
        row_number() over (partition by continent order by name) as rn
      from student
    ) t1
) t2
group by rn
;
```
