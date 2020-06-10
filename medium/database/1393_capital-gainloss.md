```mysql
# query to report the Capital gain/loss for each stock.
# total gain or loss after buying and selling the stock one or many times.
select 
  stock_name,
  sum(price) capital_gain_loss
from (
  select
    stock_name,
    case 
      when operation = 'Buy' then price * -1
      when operation = 'Sell' then price
    end as price
  from Stocks
) t
group by stock_name
order by stock_name asc
;
```
