# Assignment21 - Homework COVID Database

**Due** May 6 at 11:59pm | **Points** 20 pts | **Submitting** a file upload | **File Types** PDF

- [Assignment21 - Homework COVID Database](#assignment21---homework-covid-database)
  - [Understanding The Data (4 points)](#understanding-the-data-4-points)
    - [Understanding The Data Question #1](#understanding-the-data-question-1)
    - [Understanding The Data Question #2](#understanding-the-data-question-2)
  - [Counting (8 points)](#counting-8-points)
    - [Counting Queston #1](#counting-queston-1)
    - [Counting Queston #2](#counting-queston-2)
    - [Counting Queston #3](#counting-queston-3)
  - [Open Ended Questions (8 points)](#open-ended-questions-8-points)
    - [Open Ended Question #1](#open-ended-question-1)
    - [Open Ended Question #2](#open-ended-question-2)

---

## Database Crawler Setup

Following steps used in lecture Apr 28,2021

1. Go to [AWS Glue](https://console.aws.amazon.com/glue/home?region=us-east-1#catalog:tab=crawlers)
2. Click `Add crawler`
3. **Specify crawler source type**
   1. Using `Crawler name`: homework-covid-database
   2. **No changes** to `Tags, description, security configuration, and classifiers (optional)`
4. Click `Next`
5. **Specify crawler source type**
   1. **Crawler source type**: `Data stores`
   2. **Repeat crawls of S3 data stores**: `Crawl all folders` _Crawl all folders again with every subsequent crawl._
6. Click `Next`
7. **Add a data store**
   1. **Choose a data store**: `S3`
   2. **Connection**: Not needed (leave blank)
   3. **Crawl data in**: `Specified path`
   4. **Include path** `s3://stat196k-data-examples/covid_db/`
8. Click `Next`
9. **Add another data store**: `No` (for now... later to load our own table and bring it into our own database/collection of tables)
10. **Choose an IAM role**
    1. Select: `Create an IAM role`
    2. **IAM role**: `AWSGlueServiceRole-`covid-database
11. Click `Next`
12. **Create a schedule for this crawler**
    1. **Frequency**: `Run on demand`
13. Click `Next`
14. **Configure the crawler's output**
    1. Click `Add database`
    2. **Database name**: homework-covid-database (same name as crawler)
    3. **Prefix added to tables (optional)**: Leave blank
    4. **Description and location (optional)**: Leave blank
    5. **Resource link name**: Leave blank/unchanged
    6. **Shared database suggestions**: Leave blank/unchanged
    7. **Shared database**: Leave blank/unchanged
    8. **Shared database owner account ID**: Leave blank/unchanged
15. Click `Create`
16. **Grouping behavior for S3 data (optional)**: Leave blank
17. **Configuration options (optional)**: Leave unchanged
18. Click `Next`
19. **Review all steps**

    1. **Crawler info**
       1. **Name** homework-covid-database
       2. **Tags**: -
    2. **Data stores**
       1. **Data store**: S3
       2. **Include pat**: h s3://stat196k-data-examples/covid_db/
       3. **Connection**: -
       4. **Exclude patterns**: -
    3. **IAM role**
       1. **IAM role**: arn:aws:iam::503811637238:role/service-role/AWSGlueServiceRole-covid-database
    4. **Schedule**
       1. **Schedule**: Run on demand
    5. **Output**
       1. **Database**: homework-covid-database
       2. **Prefix added to tables (optional)**: -
       3. **Create a single schema for each S3 path**: false
       4. **Configuration options**
          1. **Schema updates in the data store**: Update the table definition in the data catalog.
          2. **Object deletion in the data store**: Mark the table as deprecated in the data catalog.

20. Click `Finish`\
    ![What it looks like when you've set up properly](readme-images/aws_glue_crawlers.png)
21. Click `homework-covid-database`
22. Click `Run crawler` (Will take a moment)
    1. When completed in `Tables added` you should see 3 added\
       ![Three tables added](readme-images/aws_glue_three_tables_added.png)
23. From `Data catalog` > `Databases` > `Tables` (located on the left-hand-side)\
    ![`Data catalog` > `Databases` > `Tables`](readme-images/data_cataloge_databases_tables.png)

24. You should see three tables
    1. county
    2. covid
    3. states
       ![Three tables](readme-images/three_tables_shown.png)

## Understanding The Data (4 points)

### Understanding The Data Question #1

Pick one of the [limitations described in the data documentation](https://cmu-delphi.github.io/delphi-epidata/api/covidcast-signals/fb-survey.html#limitations)
and elaborate on it. What does it mean?

- `Non-response bias`: The survey is voluntary, and people who accept the
  invitation when it is presented to them on Facebook may be different from
  those who do not. The [survey weights provided by Facebook](https://cmu-delphi.github.io/delphi-epidata/api/covidcast-signals/fb-survey.html#survey-weighting)
  attempt to model the probability of response for each user and hence adjust
  for this, but it is difficult to tell if these weights account for all
  possible non-response bias.

> This term is to articulate if you don't respond or partake in the survay you will be assumed to be a member of the majority; for example, if you are a Black woman living in a place that is majority White and you don't respond to the survay you are invited to Facebook would use a process called "[imputation](https://g.co/kgs/EnjxXZ)." Facebook would then say "hey, this person might be a White male."

### Understanding The Data Question #2

Find a row in the `covid` table that contains SE (standard error) for one signal.
Use this to construct and interpret a "quick and dirty" 95% confidence interval for that particular signal in that row.

> [PlaceHolder]

## Counting (8 points)

_Include your answers and show SQL queries for the questions below._

### Counting Queston #1

How many observations are there for each signal in the county level `covid` rows?\
County level rows means that `geo_type = 'county'`.\
Show the top 5 `signals` with the most counts.

> ```sql
>
> ```

### Counting Queston #2

How many county level rows does the `covid` table have for each state?\
Show the top 5 states with the most counts, including the name of the state.\
How many observations does California have?

> ```sql
>
> ```

### Counting Queston #3

The original data source claims to have around 20 million Facebook survey responses.\
Does it appear that there are around 20 million survey responses present in the `covid` table?

> ```sql
>
> ```

## Open Ended Questions (8 points)

_Include the SQL and at least 1 plot in your answers to the following questions.
It's sufficient to include a plot for either the first or second question._

### Open Ended Question #1

Pick one of the signals from Delphi's [Facebook survey](https://cmu-delphi.github.io/delphi-epidata/api/covidcast-signals/fb-survey.html) that you find personally interesting.\
Explain what the signal means, and use this signal to pose and answer a question using the `covid` table.

> ```sql
>
> ```

### Open Ended Question #2

Load an external table into your database and use it to ask and answer a new question by joining it with the existing tables.

```text
For example, we could look at the relationship between political backgrounds and COVID attitudes by finding a table with votes for each party by state or county for the 2020 presidential election.
```

> ```sql
>
> ```
