with first_year_sales as (
    select
        product_id,
        min(year) first_year
    from sales
    group by product_id
)

select  s.product_id,
        f.first_year,
        s.quantity,
        s.price
from first_year_sales f join sales s
on f.product_id = s.product_id
and s.year = f.first_year



