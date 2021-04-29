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

## Understanding The Data (4 points)

### Understanding The Data Question #1

Pick one of the [limitations described in the data documentation](https://cmu-delphi.github.io/delphi-epidata/api/covidcast-signals/fb-survey.html#limitations) and elaborate on it. What does it mean?

> [PlaceHolder]

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
