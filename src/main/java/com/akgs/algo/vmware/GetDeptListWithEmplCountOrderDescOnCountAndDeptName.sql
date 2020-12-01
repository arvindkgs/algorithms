/* HACKERRANK Get list of departments with employee count order on count and department name */
select d.NAME, count(e.ID)
from DEPARTMENT as d left outer join EMPLOYEE as e on d.ID = e.DEPT_ID
group by d.ID
order on count(e.ID), d.NAME