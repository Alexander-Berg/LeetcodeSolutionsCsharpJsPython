Recyclable and Low Fat Products
# Write an SQL query to find the ids of products that are both low fat and recyclable.
# Return the result table in any order.

SELECT product_id FROM products WHERE (low_fats='Y' AND recyclable='Y') ;




Find Customer Referee
# Write an SQL query to report the names of the customer that are not referred by the customer with id = 2.
# Return the result table in any order.


select name from customer where referee_id!=2 or referee_id is null


Big Countries
# A country is big if:
# it has an area of at least three million (i.e., 3000000 km2), or
# it has a population of at least twenty-five million (i.e., 25000000).
# Write an SQL query to report the name, population, and area of the big countries.
# Return the result table in any order.

Select name,population,area from world 
where area >= 3000000 or population >=25000000


Article Views
# Write an SQL query to find all the authors that viewed at least one of their own articles.
# Return the result table sorted by id in ascending order.
# The query result format is in the following example.

Select  distinct author_id as id  from Views
where author_id = viewer_id 
order by id



Replace Employee ID With The Unique Identifier
# Write an SQL query to show the unique ID of each user, If a user does not have a unique ID replace just show null.
# Return the result table in any order.


SELECT  unique_id, name

FROM Employees

LEFT JOIN EmployeeUNI

ON Employees.id = EmployeeUNI.id



# Write an SQL query that reports the product_name, year, and price for each sale_id in the Sales table.
# Return the resulting table in any order.


select P.product_name,S.year,S.price from Sales S,Product P where S.product_id=P.product_id;



Customer Who Visited but Did Not Make Any Transactions
# Write a SQL query to find the IDs of the users who visited without making any transactions and the number of times they made these types of visits.
# Return the result table sorted in any order.

SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans 
from Visits v 
LEFT JOIN Transactions t 
ON v.visit_id = t.visit_id  
WHERE t.transaction_id IS NULL 
GROUP BY v.customer_id; 

Rising Temperature
# Write an SQL query to find all dates Id with higher temperatures compared to its previous dates (yesterday).
# Return the result table in any order.

select x.id from weather x,weather y
where x.temperature>y.temperature and DATEDIFF(x.recordDate,y.recordDate)=1



Average Time of Process per Machine:
# There is a factory website that has several machines each running the same number of processes.
# Write an SQL query to find the average time each machine takes to complete a process.
# The time to complete a process is the 'end' timestamp minus the 'start' timestamp.
# The average time is calculated by the total time to complete every process on the machine divided by the number of processes that were run.
# The resulting table should have the machine_id along with the average time as processing_time, which should be rounded to 3 decimal places.

select machine_id, Round(avg(
  case
when activity_type="start" then timestamp
when activity_type="end" then -timestamp
end
)*(-2),3)as processing_time
from activity
group by machine_id


Employee Bonus
# Write an SQL query to report the name and bonus amount of each employee with a bonus less than 1000.
# Return the result table in any order:


select e.name, b.bonus from Employee as e left join Bonus as b on e.empId= b.empId where b.bonus<1000 or b.bonus is null;


Students and Examinations
# Write an SQL query to find the number of times each student attended each exam.
# Return the result table ordered by student_id and subject_name.


SELECT
    Students.student_id,
    Students.student_name,
    Subjects.subject_name,
    COUNT(Examinations.subject_name) AS attended_exams
FROM Students
JOIN Subjects
LEFT JOIN Examinations
ON Students.student_id = Examinations.student_id
AND Subjects.subject_name = Examinations.subject_name
GROUP BY Students.student_id, Subjects.subject_name
ORDER BY student_id ASC, subject_name ASC


Managers with at Least 5 Direct Reports
# Write an SQL query to report the managers with at least five direct reports.
# Return the result table in any order.

SELECT      E2.name
FROM        Employee E1, Employee E2
WHERE       E1.managerId  = E2.id  
GROUP BY    E1.managerId
HAVING      COUNT(E1.managerId) >= 5 


Confirmation Rate
# The confirmation rate of a user is the number of 'confirmed' messages divided by the total number of requested confirmation messages.
# The confirmation rate of a user that did not request any confirmation messages is 0.
# Round the confirmation rate to two decimal places.
# Write an SQL query to find the confirmation rate of each user.
# Return the result table in any order.


SELECT 
    user_id,
    ROUND(AVG(IF(action = 'confirmed', 1, 0)), 2) AS confirmation_rate
FROM Signups LEFT JOIN Confirmations USING (user_id)
GROUP BY 1
ORDER BY 1


Not Boring Movies
# Write an SQL query to report the movies with an odd-numbered ID and a description that is not "boring".
# Return the result table ordered by rating in descending order.


select * from Cinema where id % 2!=0 and description!="boring" order by rating desc;


Average Selling Price
# Write an SQL query to find the average selling price for each product. average_price should be rounded to 2 decimal places.
# Return the result table in any order.


select prices.product_id, ROUND(SUM(price * units) / SUM(units), 2) as average_price
from Prices join UnitsSold 
on prices.product_id = unitssold.product_id
and purchase_date between start_date and end_date
group by product_id


Percentage of Users Attended a Contest
# Write an SQL query to find the percentage of the users registered in each contest rounded to two decimals.
# Return the result table ordered by percentage in descending order. In case of a tie, order it by contest_id in ascending order.


WITH user_count as (
    SELECT COUNT(*) as total_users
    FROM Users
    )

SELECT contest_id, 
       ROUND(COUNT(user_id) / total_users * 100, 2) as "percentage"
FROM Register
JOIN user_count
GROUP BY contest_id
ORDER BY percentage DESC, contest_id;


Queries Quality and Percentage
# We define query quality as:
# The average of the ratio between query rating and its position.
# We also define poor query percentage as:
# The percentage of all queries with rating less than 3.
# Write an SQL query to find each query_name, the quality and poor_query_percentage.
# Both quality and poor_query_percentage should be rounded to 2 decimal places.
# Return the result table in any order.

SELECT
    query_name,
    ROUND(AVG(rating/position), 2) AS quality,
    ROUND(AVG(rating < 3)*100, 2) AS poor_query_percentage
FROM Queries
GROUP BY query_name


Monthly Transactions
# Write an SQL query to find for each month and country, the number of transactions and their total amount, the number of approved transactions and their total amount.
# Return the result table in any order.



select date_format(trans_date, '%Y-%m') as month, 
country, count(id) as trans_count, 
sum(case when state = 'approved' then 1 else 0 end) as approved_count, sum(amount) as trans_total_amount, 
sum(case when state = 'approved' then amount else 0 end) as approved_total_amount
from transactions
group by country, month


Immediate Food Delivery
# If the customers preferred delivery date is the same as the order date, then the order is called immediate; otherwise, it is called scheduled.
# The first order of a customer is the order with the earliest order date that the customer made. It is guaranteed that a customer has precisely one first order.
# Write an SQL query to find the percentage of immediate orders in the first orders of all customers, rounded to 2 decimal places.


select ROUND(AVG(order_date = customer_pref_delivery_date) * 100, 2) as immediate_percentage
from delivery where (customer_id, order_date) IN
(select customer_id, min(order_date) as first_order
from delivery
group by customer_id)


Game Play Analysis
# Write an SQL query to report the fraction of players that logged in again on the day after the day they first logged in, rounded to 2 decimal places.
# In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date,
# then divide that number by the total number of players.


select round(count(distinct player_id )/(select count(distinct player_id) from activity),2) as fraction
from (
select player_id,event_date,
min(event_date) over (partition by player_id order by event_date) firstlog
from activity ) a
where datediff(event_date,firstlog) = 1


Number of Unique Subjects Taught by Each Teacher
# Write an SQL query to report the number of unique subjects each teacher teaches in the university.
# Return the result table in any order.

select teacher_id,count(distinct subject_id) as cnt
from teacher
group by 1


User Activity for the Past 30 Days
# Write an SQL query to find the daily active user count for a period of 30 days ending 2019-07-27 inclusively.
# A user was active on someday if they made at least one activity on that day.
# Return the result table in any order.

select distinct activity_date as day,count(distinct user_id)  as active_users
from Activity 
where activity_date between '2019-06-28' and '2019-07-27'
group by activity_date



Product Sales Analysis
# Write an SQL query that selects the product id, year, quantity, and price for the first year of every product sold.
# Return the resulting table in any order.



select product_id, year as first_year, quantity, price
from Sales
where (product_id, year) 
in (select product_id, min(year) from Sales group by 1);


Classes More Than 5 Students
# Write an SQL query to report all the classes that have at least five students.
# Return the result table in any order.

SELECT class FROM Courses GROUP BY class
HAVING COUNT(class) >= 5;


Find Followers Count
# Write an SQL query that will, for each user, return the number of followers.
# Return the result table ordered by user_id in ascending order.


SELECT DISTINCT user_id,
COUNT(DISTINCT follower_id) AS followers_count
FROM Followers
GROUP BY user_id
ORDER BY user_id;

Biggest Single Number
# A single number is a number that appeared only once in the MyNumbers table.
# Write an SQL query to report the largest single number. If there is no single number, report null.


SELECT MAX(num) AS num
FROM MyNumbers
WHERE num IN (SELECT num
FROM MyNumbers
GROUP BY num
HAVING COUNT(*) = 1);


Customers Who Bought All Products
# Write an SQL query to report the customer ids from the Customer table that bought all the products in the Product table.
# Return the result table in any order.


SELECT                                      
    customer_id
FROM Customer
GROUP BY customer_id
HAVING SUM(DISTINCT product_key) = (
    SELECT
        SUM(product_key)
    FROM Product
); 

The Number of Employees Which Report to Each Employee
# For this problem, we will consider a manager an employee who has at least 1 other employee reporting to them.
# Write an SQL query to report the ids and the names of all managers, the number of employees who report directly to them, and the average age of the reports rounded to the nearest integer.
# Return the result table ordered by employee_id.


SELECT 
    b.employee_id AS employee_id, 
    b.name AS name, 
    COUNT(*) AS reports_count, 
    ROUND(AVG(a.age)) AS average_age
FROM 
    Employees a JOIN Employees b ON a.reports_to = b.employee_id
GROUP BY 1
ORDER BY 1


 Primary Department for Each Employee
# Employees can belong to multiple departments. When the employee joins other departments, they need to decide which department is their primary department.
# Note that when an employee belongs to only one department, their primary column is 'N'.
# Write an SQL query to report all the employees with their primary department. For employees who belong to one department, report their only department.
# Return the result table in any order.


SELECT 
    employee_id,
    IFNULL(MAX(CASE WHEN primary_flag="Y" THEN department_id END),department_id) as department_id
    
FROM Employee
GROUP BY employee_id;



Triangle Judgement
# Write an SQL query to report for every three line segments whether they can form a triangle.
# Return the result table in any order.

select  *,If(x+y>z and x+z>y and y+z>x,"Yes","No") as triangle from Triangle;


Consecutive Numbers
# Write an SQL query to find all numbers that appear at least three times consecutively.
# Return the result table in any order.

SELECT DISTINCT l1.num AS ConsecutiveNums
FROM Logs l1
JOIN Logs l2 ON l1.id = l2.id - 1
JOIN Logs l3 ON l1.id = l3.id - 2
WHERE l1.num = l2.num AND l2.num = l3.num;


Product Price at a Given Date
# Write an SQL query to find the prices of all products on 2019-08-16. Assume the price of all products before any change is 10.
# Return the result table in any order.


SELECT product_id, FIRST_VALUE(new_price) OVER(PARTITION BY product_id ORDER BY change_date DESC) AS price
FROM Products
WHERE change_date <= '2019-08-16'
UNION
SELECT DISTINCT product_id, 10 AS price
FROM Products
WHERE product_id NOT IN (SELECT product_id FROM Products WHERE change_date <= '2019-08-16')


Last Person to Fit in the Bus
# There is a queue of people waiting to board a bus. However, the bus has a weight limit of 1000 kilograms, so there may be some people who cannot board.
# Write an SQL query to find the person_name of the last person that can fit on the bus without exceeding the weight limit. 
# The test cases are generated such that the first person does not exceed the weight limit.

select person_name from
(select person_name, weight, turn, sum(weight) over(order by turn) as cum_sum
from queue) x
where cum_sum <= 1000
order by turn desc limit 1;


 Count Salary Categories
# Write an SQL query to report the number of bank accounts of each salary category. The salary categories are:
# "Low Salary": All the salaries strictly less than $20000.
# "Average Salary": All the salaries in the inclusive range [$20000, $50000].
# "High Salary": All the salaries strictly greater than $50000.
# The result table must contain all three categories. If there are no accounts in a category, then report 0.
# Return the result table in any order.


SELECT 'Low Salary' AS category , COUNT(*) AS accounts_count FROM accounts WHERE income<20000
UNION
SELECT 'Average Salary' AS category , COUNT(*) AS accounts_count FROM accounts WHERE income BETWEEN 20000 and 50000
UNION
SELECT 'High Salary' AS category , COUNT(*) AS accounts_count FROM accounts WHERE income>50000 ;


Employees Whose Manager Left the Company
# Write an SQL query to report the IDs of the employees whose salary is strictly less than $30000 and whose manager left the company. 
# When a manager leaves the company, their information is deleted from the Employees table, but the reports still have their manager_id set to the manager that left.
# Return the result table ordered by employee_id.

SELECT employee_id
FROM Employees
WHERE salary < 30000
AND manager_id IS NOT NULL
AND manager_id NOT IN (SELECT employee_id FROM Employees)
ORDER BY employee_id;


Exchange Seats
# Write an SQL query to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
# Return the result table ordered by id in ascending order.

select
if(id % 2 != 0 and id = (select count(*) from Seat), id, 
if(id % 2 != 0, id + 1, id - 1)) as id, 
student from Seat order by id;


Movie Rating
# Find the name of the user who has rated the greatest number of movies. In case of a tie, return the lexicographically smaller user name.
# Find the movie name with the highest average rating in February 2020. In case of a tie, return the lexicographically smaller movie name.

(
  SELECT title as results
  FROM MovieRating
  JOIN Movies USING(movie_id)
  WHERE LEFT(created_at, 7) = '2020-02'
  GROUP BY title
  ORDER BY AVG(rating) DESC, title ASC
  LIMIT 1
  ) 
UNION (
  SELECT name as results
  FROM MovieRating
  JOIN Users USING(user_id)
  GROUP BY name
  ORDER BY COUNT(rating) DESC, name ASC  
  LIMIT 1
)
;


Restaurant Growth
# You are the restaurant owner and you want to analyze a possible expansion (there will be at least one customer every day).
# Write an SQL query to compute the moving average of how much the customer paid in a seven days window (i.e., current day + 6 days before). 
# Average_amount should be rounded to two decimal places.
# Return result table ordered by visited_on in ascending order.

with base as
(SELECT 
 visited_on,
 sum(amount) as amount
 FROM Customer
 GROUP BY 1)


SELECT c1.visited_on,
round(sum(c2.amount),2) as amount,
round(avg(c2.amount),2) as average_amount
FROM base c1 
JOIN base c2 on datediff(c1.visited_on, c2.visited_on ) between 0 and 6
GROUP BY 1
HAVING count(distinct c2.visited_on) = 7
ORDER BY 1


Friend Requests II: Who Has the Most Friends
# Write an SQL query to find the people who have the most friends and the most friends number.
# The test cases are generated so that only one person has the most friends.

with t1 as
(select requester_id as id from RequestAccepted
union all
select accepter_id as id from RequestAccepted)

select id, count(*) as num
from t1
group by id
order by num desc
limit 1


Investments in 2016
Write an SQL query to report the sum of all total investment values in 2016 tiv_2016, for all policyholders who:
have the same tiv_2015 value as one or more other policyholders, and
are not located in the same city like any other policyholder (i.e., the (lat, lon) attribute pairs must be unique).
Round tiv_2016 to two decimal places.

select round(sum(tiv_2016), 2) tiv_2016
from insurance i
where (lat, lon) not in (select lat, lon from insurance where pid<>i.pid)
    and (select count(tiv_2015) from insurance where tiv_2015=i.tiv_2015) > 1;


Department Top Three Salaries
# A company's executives are interested in seeing who earns the most money in each of the company's departments. 
# A high earner in a department is an employee who has a salary in the top three unique salaries for that department.
# Write an SQL query to find the employees who are high earners in each of the departments.
# Return the result table in any order.

SELECT Department, employee, salary FROM (
    SELECT d.name AS Department
        , e.name AS employee
        , e.salary
        , DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS drk
    FROM Employee e JOIN Department d ON e.DepartmentId= d.Id
) t WHERE t.drk <= 3


Fix Names in a Table
# Write an SQL query to fix the names so that only the first character is uppercase and the rest are lowercase.
# Return the result table ordered by user_id.


select user_id, 
concat(upper(substr(name, 1, 1)), lower(substr(name, 2, length(name)-1))) as name 
from Users order by user_id;


Patients With a Condition
# Write an SQL query to report the patient_id, patient_name and conditions of the patients who have Type I Diabetes.
# Type I Diabetes always starts with DIAB1 prefix.
# Return the result table in any order.


select * from patients where conditions like "% DIAB1%" or
conditions like "DIAB1%";

Delete Duplicate Emails
# Write an SQL query to delete all the duplicate emails, keeping only one unique email with the smallest id. 
# Note that you are supposed to write a DELETE statement and not a SELECT one.
# After running your script, the answer shown is the Person table. The driver will first compile and run your piece of code and then show the Person table. 
# The final order of the Person table does not matter.

DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id

Second Highest Salary
#Write an SQL query to report the second highest salary from the Employee table. If there is no second highest salary, the query should report null.

select max(salary) AS SecondHighestSalary from employee where salary not in (select max(salary) from employee)


Group Sold Products By The Date
# Write an SQL query to find for each date the number of different products sold and their names.
# The sold products names for each date should be sorted lexicographically.
# Return the result table ordered by sell_date.

SELECT  
	sell_date,
	(COUNT(sell_date ) ) as num_sold ,
	GROUP_CONCAT(distinct product  ORDER BY product) as products 
FROM 
	(SELECT DISTINCT sell_date,product FROM Activities) as Activities
GROUP BY sell_date;


List the Products Ordered in a Period
# Write an SQL query to get the names of products that have at least 100 units ordered in February 2020 and their amount.
# Return result table in any order.

select product_name,sum(unit) as unit
from Products a
left join Orders b on a.product_id = b.product_id
where month(order_date) = 2 and year(order_date) = '2020'
group by a.product_id
Having unit >=100


Find Users With Valid E-Mails
# Write an SQL query to find the users who have valid emails.
# A valid e-mail has a prefix name and a domain where:
# The prefix name is a string that may contain letters (upper or lower case), digits, underscore '_', period '.', and/or dash '-'. The prefix name must start with a letter.
# The domain is '@leetcode.com'.
# Return the result table in any order.

SELECT *
FROM Users
WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode\\.com'