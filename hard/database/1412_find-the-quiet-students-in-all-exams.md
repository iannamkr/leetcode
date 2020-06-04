quite student: 최소 한번 시험을 치뤘으나, 매 시험마다 최고점 또는 최저점을 받지 않고 항상 중간(?) 점수를 받은 학생을 찾아봐라

### 1
```mysql
select 
  student_id, 
  student_name 
from Student 
where student_id not in (
    select
      distinct e1.student_id
    from Exam e1
    join (
        select
          exam_id, 
          min(score) min_score, 
          max(score) max_score
        from Exam
        group by exam_id
    ) e2
    on e1.exam_id = e2.exam_id
    where e1.score = e2.min_score 
      or e1.score = e2.max_score
)
  and student_id in (select distinct student_id from Exam)
;
```

### 2
```mysql
with e as (
  select 
    exam_id, 
    student_id,
    rank() over(partition by exam_id order by score asc) rank1,
    rank() over(partition by exam_id order by score desc) rank2
  from Exam
)
select 
  max(s.student_id) student_id, 
  max(s.student_name) student_name
from e
left join Student s
  on e.student_id = s.student_id
where e.student_id not in (select student_id from e where rank1 = 1 or rank2 = 1)
group by s.student_id, s.student_name
```
