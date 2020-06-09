```mysql
with s as (
  select
      o1.order_date, o1.item_id, o1.seller_id
  from Orders o1
  join Orders o2
    on o1.seller_id = o2.seller_id
    and o1.order_date > o2.order_date
  group by o1.seller_id, o1.order_date
  having count(o1.order_id) = 1
)
select 
  u.user_id seller_id,
  case when i.item_brand = u.favorite_brand then "yes" else "no" end as 2nd_item_fav_brand
from Users u
left join s
  on u.user_id = s.seller_id
left join Items i
  on i.item_id = s.item_id
order by u.user_id
;
```
