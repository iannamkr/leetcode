```mysql
(
    select u.name results
    from Movie_Rating r
    join Users u
      on r.user_id = u.user_id
    group by r.user_id
    order by count(r.movie_id) desc, u.name asc
    limit 1
)
union all 
(
    select m.title results
    from Movie_Rating r 
    join Movies m
      on r.movie_id = m.movie_id
    where substr(r.created_at, 1, 7) = '2020-02'
    group by r.movie_id
    order by avg(r.rating) desc, m.title asc
    limit 1
)
;
```
