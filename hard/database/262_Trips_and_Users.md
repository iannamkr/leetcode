```mysql
# find the cancellation rate of requests.
# cond_1: both client and driver must be unbanned.
# cond_2: between Oct 1, 2013 and Oct 3, 2013.
# cond_3: The cancellation rate = canceled requests / total number of requests

select 
  t.request_at as "Day",
  round(sum(case when t.status like 'cancelled_%' then 1 else 0 end) / count(1), 2) as "Cancellation Rate"
from (
  select 
    id, client_id, driver_id, city_id, request_at, `status`
  from Trips 
  where date(request_at) between '2013-10-01' and '2013-10-03'
) t
join (
  select
    users_id, role 
  from Users 
  where banned = 'No'
) u
on t.client_id = u.users_id
group by t.request_at 
```
