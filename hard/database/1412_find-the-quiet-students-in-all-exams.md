```mysql
# quite: 최소 한번 시험을 치뤘으나, 최고점/최저점을 받지 않은 학생 
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
