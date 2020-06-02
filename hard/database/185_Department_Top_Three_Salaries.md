```mysql
select 
  d.name as "Department",
  e.name as "Employee",
  e.salary as "Salary"
from (
  select
    id, name, salary, departmentId,
    dense_rank() over (partition by departmentId order by salary desc) as salary_rank
  from employee
) e
join department d 
on e.departmentId = d.id
where e.salary_rank < 4
;
```

## Ranking Functions

### rank
- rank() over (partition by departmentId order by salary desc)

| salary | rank |
|--------|------|
| 1000   | 1    |
| 2000   | 2    |
| 2000   | 2    |
| 3000   | 4    |

### dense_rank
- dense_rank() over (partition by departmentId order by salary desc)

| salary | rank |
|--------|------|
| 1000   | 1    |
| 2000   | 2    |
| 2000   | 2    |
| 3000   | 3    |

### row_number
- row_number() over (partition by departmentId order by salary desc)

| salary | rank |
|--------|------|
| 1000   | 1    |
| 2000   | 2    |
| 2000   | 3    |
| 3000   | 4    |
