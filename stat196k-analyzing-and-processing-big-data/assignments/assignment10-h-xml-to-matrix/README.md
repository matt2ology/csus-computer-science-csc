# Assignment 10 - Homework XML To Matrix

- [Assignment 10 - Homework XML To Matrix](#assignment-10---homework-xml-to-matrix)
  - [Goals](#goals)
  - [Announcements](#announcements)
  - [Data](#data)
  - [Assignment](#assignment)
    - [Script](#script)
    - [Questions](#questions)
    - [Submission](#submission)
    - [Extra Credit](#extra-credit)

## Goals

- Apply natural language processing (NLP) techniques to convert unstructured
  text to a numeric matrix
- Extract interesting data from XML documents

## Announcements

- Excellent work coming up with questions about the IRS 990 data 👍
- The latest course EC2 image has all the software necessary to do this
  assignment

## Data

The IRS tax returns for the year 2019 are available via S3.

```bash
aws s3 cp s3://stat196k-data-examples/2019irs990.zip ./ --no-sign-request
```

This will download a 2.8 GB zip file containing around a half million IRS 990
forms for 2019. When you unzip it, the directory will be 16 GB on disk. This
means you'll need to use an EC2 instance with at least 22 GB of hard drive
available. These files are not the same as the ones [provided by AWS](https://registry.opendata.aws/irs990/); I removed the schema to make them easier to process.
For the curious, [this shell script, irs990.sh, creates the zip file](https://github.com/clarkfitzg/stat196K/blob/main/irs990.sh).

## Assignment

Use NLP to convert the text descriptions of each nonprofit into the rows of one
big document term matrix. The resulting matrix will have one row for every 990
form that has a description, and one column for every word in the lexicon. In
the next assignment we will use this matrix to cluster the nonprofits based on
their descriptions.

### Script

**Write a Julia script to process the data, including the following steps:**

1. Extract the organization name, one or more text elements that describe the
   nonprofit, and another element that can be used as a proxy for size, such as
   revenue, number of employees, etc.
2. Process the text descriptions using a similar process as [described in class](Introduction%20Natural%20Language%20Processing%20-%20Clark%20Fitzgerald.pdf).
3. Create and save the term document matrix.

\* _If you want to use another language then you may, but you're on your own for support._

### Questions

**Run your program, and report the following**

1. How many of the returns were you able to process?

2. Show and interpret one explicit example of what you extracted from one tax
   return, including the text description before and after processing.

3. What are the dimensions of your term document matrix?

4. How long did your program take to run? (Less than 30 minutes is easily
   attainable, but no problem if it takes longer, either.)

5. Which parts of the program took the longest time to run?

### Submission

Turn in a single PDF file or text document answering these questions and include
the text of your script either at the end of the document, or in the body,
Jupyter Notebook style. I only want to look at one document, which is different
than previous assignments.

For resubmissions, leave a comment in the submission comments box saying what you changed.

### Extra Credit

Worth 1 point, but so much glory.

Implement an approach to "unsplit" the concatenated words that we saw in the
description field, for example:

    THE GNU PROJECT DOES COLLABORATIVE DEVELOPMENT AND DISTRIBUTION OF ANOPERATING SYSTEM (OS)
    THAT RESPECTS USERS' FREEDOM. GNU SOFTWARE ISLICENSED FREELY SO THAT USERS CAN RUN, SHARE,
    STUDY AND MODIFY ITHOWEVER IS BEST FOR THEM. THE GNU SYSTEM IS USED MOST POPULARLY WITHTHE
    KERNEL LINUX, FORMING THE GNU/LINUX OS USED ON MILLIONS OFCOMPUTERS WORLDWIDE, INCLUDING THE
    MAJORITY OF WEB AND EMAIL SERVERS. THE FSF SUPPORTS GNU WITH RESOURCES FOR COORDINATION,
    PLANNING,SOFTWARE DEVELOPMENT INFRASTRUCTURE, WEB AND DOWNLOAD HOSTING,COPYRIGHT STEWARDSHIP,
    PROGRAMMING WORK, AND PUBLIC PROMOTION.

**This contains obvious errors:**

- `ANOPERATING` should be `AN OPERATING`
- `ISLICENSED` should be `IS LICENSED`
- `ITHOWEVER` should be `IT HOWEVER`
- `WITHTHE` should be `WITH THE`
- and so on...
