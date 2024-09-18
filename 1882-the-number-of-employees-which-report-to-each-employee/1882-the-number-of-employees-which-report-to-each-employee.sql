# Write your MySQL query statement below
select m.employee_id, m.name, Count(e.employee_id) as reports_count, ROUND(AVG(e.age)) as average_age
from Employees e 
join Employees m
on e.reports_to = m.employee_id
Group by employee_id
order by employee_id