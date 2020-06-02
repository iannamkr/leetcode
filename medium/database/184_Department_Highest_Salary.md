```mysql
select
  d.Name as "Department",
  e1.Name as "Employee",
  e1.Salary as "Salary"
from employee e1
join (select DepartmentId, MAX(salary) as "max_salary" from employee group by departmentId) e2
  on e1.DepartmentId = e2.DepartmentId
  and e1.salary = e2.max_salary
join department d
  on e1.DepartmentId = d.id
;
```
