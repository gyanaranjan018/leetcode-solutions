/* Write your T-SQL query statement below */
With cte as (Select *, ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) As r from Person)
delete from cte where r > 1