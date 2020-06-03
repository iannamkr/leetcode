```mysql
with src as (
  select s.buyer_id, p.product_name from Product p join Sales s on p.product_id = s.product_id
)
select 
  distinct buyer_id
from src
where product_name = 'S8'
  and buyer_id not in (select buyer_id from src where product_name = 'iPhone' )
;
```
