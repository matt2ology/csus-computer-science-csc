# P - Final Project Ideas

**Due** Apr 29 at 11:59pm | **Points** 10 pts | **Submitting** Graded discussion

- [P - Final Project Ideas](#p---final-project-ideas)
  - [Project Guidelines](#project-guidelines)
  - [Example](#example)
  - [My Final Project Proposal](#my-final-project-proposal)
    - [Folder structure](#folder-structure)
    - [This project would use](#this-project-would-use)
    - [With the information I have the opportunity but not limited to](#with-the-information-i-have-the-opportunity-but-not-limited-to)

---

## Project Guidelines

Reply to this thread with one idea for a [final project](../final-project-google-fit-data/README.md).
You may choose to pursue a different project than you list here; the purpose is to generate ideas. State which of the following requirements this project would satisfy.

1. Cloud computing (AWS EC2)
2. Databases (AWS Athena)
3. Large datasets (say greater than 500 MB- any of the data sets we used in this class will work)
4. Complex datasets (XML, JSON)
5. Streaming computations (bash pipelines)
6. Julia programming
7. Natural language processing (NLP)
8. Dimension reduction / clustering
9. Distributional tests (chi square and QQ plots)

## Example

_The following example is a typical data science project_. You can also choose to do _something more statistical, algorithmic, or software oriented_.

How does political preference relate to COVID sentiment? Are counties that are more democratic or more republican more likely to wear a mask and receive the vaccine? Can we predict the vaccination rate in a county based on past voting information, population density, and income?

The COVID data lake in Athena contains many statistics about COVID behaviors, aggregated by county. We can find another table with the last election voting results by county, and join this with the COVID behavior to answer these questions.

## My Final Project Proposal

A final project idea I have is to download my personal [Google Fit data](https://support.google.com/fit/answer/3024190?hl=en).
With this data I can have a deeper insight into my `activities`/`workouts`, `sleep duration` and `sleep quality`.

### Folder structure

The export could contain up to 4 folders:

- **Activities:** Workouts and automatically tracked activities, like running or cycling. _(`TCX` files)_
- **Daily activity metrics:** Daily totals for each activity metric, like steps and distance. _(`CSV` files)_
- **All Data:** All my data from Google Fit, grouped by source. _(`JSON` files)_
- **All Sessions:** All the sessions recorded in Journal, including activities and sleep. _(`JSON` files)_

### This project would use

- Large datasets

  - **My Google Fit Data:** 1.63 GB (1,758,343,124 bytes)
    - _Google is creating a copy of files from Fit_\
      This process can take a long time (possibly hours or days) to complete. You'll receive an email when your export is done.

- Complex datasets

  - [`.TCX`](https://fileinfo.com/extension/tcx)
  - [`.JSON`](https://www.w3schools.com/js/js_json_intro.asp)

- Julia programming (although I might change course and go with Python)

- Dimension reduction / clustering

### With the information I have the opportunity but not limited to

- Calculate `heart rate`

  - My average heart rate in a day or a week
  - Average heart rate during a workout
  - What activity do I experience a higher average heart rate

- Track `sleep`

  - See if the is a correlation between **my** sleep and physical performance (e.g. hours of sleep per night in relation to my "performance", measured by the ratio of calories burned per time unit)

- Track my `activities`/`workouts`
  - See if I generally workout better weekdays vs weekends
