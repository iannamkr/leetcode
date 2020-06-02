```mysql
delete t2
from Person t1
join Person t2
  on t1.email = t2.email
where t1.Id < t2.Id
;
```
