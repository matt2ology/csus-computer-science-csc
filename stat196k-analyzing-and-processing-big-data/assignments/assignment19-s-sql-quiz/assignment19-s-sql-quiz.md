# Exercise19: S - SQL QUIZ

- [Exercise19: S - SQL QUIZ](#exercise19-s---sql-quiz)
  - [QUIZ QUESTIONS](#quiz-questions)
    - [**Question 1:** SQL is an acronym meaning Structured \_\_\_ Language](#question-1-sql-is-an-acronym-meaning-structured-___-language)
    - [**Question 2:** Complete the SQL query to return a table containing columns "name" and "id" from the table "students"](#question-2-complete-the-sql-query-to-return-a-table-containing-columns-name-and-id-from-the-table-students)
    - [**Question 3:** Complete the SQL query to return a table containing all rows from the table "students" where the value of the age column is greater than 25](#question-3-complete-the-sql-query-to-return-a-table-containing-all-rows-from-the-table-students-where-the-value-of-the-age-column-is-greater-than-25)
    - [**Question 4:** Complete the SQL query to order the rows of the result by the age column](#question-4-complete-the-sql-query-to-order-the-rows-of-the-result-by-the-age-column)
    - [**Question 5:** What is necessary to join two tables together?](#question-5-what-is-necessary-to-join-two-tables-together)
    - [**Question 6:** The GROUP BY clause in SQL makes sense when used together with an aggregation function, like COUNT(\*). An aggregation function takes many values and summarizes them into one](#question-6-the-group-by-clause-in-sql-makes-sense-when-used-together-with-an-aggregation-function-like-count-an-aggregation-function-takes-many-values-and-summarizes-them-into-one)
      - [Which of the following are aggregation functions?](#which-of-the-following-are-aggregation-functions)

---

## QUIZ QUESTIONS

### **Question 1:** SQL is an acronym meaning Structured \_\_\_ Language

> SQL is an acronym meaning Structured **Query** Language.

### **Question 2:** Complete the SQL query to return a table containing columns "name" and "id" from the table "students"

```SQL
SELECT [BLANK] , [BLANK] FROM [BLANK]
```

> ```SQL
> SELECT name , id FROM students
> ```

### **Question 3:** Complete the SQL query to return a table containing all rows from the table "students" where the value of the age column is greater than 25

```SQL
SELECT [BLANK] FROM [BLANK] WHERE [BLANK] < [BLANK]
```

>```SQL
> SELECT * FROM students WHERE 25 < age
>```

### **Question 4:** Complete the SQL query to order the rows of the result by the age column

```SQL
SELECT *
FROM students
```

>```SQL
> SELECT *
> FROM students
> ORDER BY age
> ```

### **Question 5:** What is necessary to join two tables together?

- both tables must have unique entires in one column

- one of the two tables must be small

- both tables must have one column that represents the same data

- both tables must have one string column

> both tables must have one column that represents the same data

### **Question 6:** The GROUP BY clause in SQL makes sense when used together with an aggregation function, like COUNT(\*). An aggregation function takes many values and summarizes them into one

#### Which of the following are aggregation functions?

- [ ] LOWER() convert characters to lowercase

- [x] MAX() maximum

- [x] SUM() sum, or total

- [ ] ABS() absolute value

- [x] MEAN() mean, or average
