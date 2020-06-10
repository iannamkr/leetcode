```mysql
# 스팸으로 신고 된 후 삭제 된 게시물의 일일 비율에 대한 평균을 구해라
select
  round(sum(t.daily_avg)/count(t.action_date),2) as average_daily_percent
from (
  select
    a.action_date,
   (count(distinct case when r.remove_date is not null then a.post_id else null end) / count(distinct a.post_id) * 100) as daily_avg
  from Actions a
  left join Removals r
    on a.post_id = r.post_id
  where a.extra = 'spam'
  group by a.action_date
) t
;

```
