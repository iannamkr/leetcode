```mysql
select 
  ifnull(round(t2.acceptance / t1.requests, 2), 0) accept_rate
from 
  (select count(distinct sender_id, send_to_id) requests from friend_request) t1,
  (select count(distinct requester_id, accepter_id) acceptance from request_accepted) t2
;
```
