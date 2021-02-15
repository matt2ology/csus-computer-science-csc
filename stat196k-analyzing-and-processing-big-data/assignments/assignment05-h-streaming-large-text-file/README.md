# Assignment05: H-Homework Streaming Large Text File

**Due** Saturday by 11:59pm | **Points** 20 | **Submitting** a file upload | **File Types** pdf, html, and txt

Do the exercise on the bottom of [Homework Streaming Large Text File](http://webpages.csus.edu/fitzgerald/homework-streaming-large-text-file/)

- [Assignment05: H-Homework Streaming Large Text File](#assignment05-h-homework-streaming-large-text-file)
  - [Announcements](#announcements)
  - [Background](#background)
    - [Goldstein Score](#goldstein-score)
  - [Assignment](#assignment)
  - [Questions](#questions)
    - [1 - Subset](#1---subset)
      - [1.1 How many columns are there?](#11-how-many-columns-are-there)
      - [1.2 Do the data values in each column seem to match the column definitions?](#12-do-the-data-values-in-each-column-seem-to-match-the-column-definitions)
      - [1.3 What character delimits the records?](#13-what-character-delimits-the-records)
      - [1.4 What is the CAMEO event code, what event does this correspond to, and what is the Goldstein score?](#14-what-is-the-cameo-event-code-what-event-does-this-correspond-to-and-what-is-the-goldstein-score)
      - [1.5 Are the URL's to the news articles still live, and do they match the CAMEO event code?](#15-are-the-urls-to-the-news-articles-still-live-and-do-they-match-the-cameo-event-code)
      - [1.6 Does the Goldstein score appear to be doing what it was designed to do?](#16-does-the-goldstein-score-appear-to-be-doing-what-it-was-designed-to-do)
    - [2 - Histogram](#2---histogram)
      - [2.1 How long does your program take to run?](#21-how-long-does-your-program-take-to-run)
      - [2.2 Explain in detail what each command in the pipeline does and how they work together](#22-explain-in-detail-what-each-command-in-the-pipeline-does-and-how-they-work-together)
      - [2.3 Plot and interpret the histogram. You'll probably want to download the summary statistics (around 20 numbers) to your personal computer to plot the histogram. Do you notice anything strange?](#23-plot-and-interpret-the-histogram-youll-probably-want-to-download-the-summary-statistics-around-20-numbers-to-your-personal-computer-to-plot-the-histogram-do-you-notice-anything-strange)
      - [2.4 Exactly how many events (rows) are in this data?](#24-exactly-how-many-events-rows-are-in-this-data)
    - [3 - Performance](#3---performance)
      - [3.1 What are the bottlenecks?](#31-what-are-the-bottlenecks)
      - [3.2 Run and time your program on an EC2 instance with more vCPU's and a faster network and show the results of `top` once more. Is the program faster on the more expensive instance?](#32-run-and-time-your-program-on-an-ec2-instance-with-more-vcpus-and-a-faster-network-and-show-the-results-of-top-once-more-is-the-program-faster-on-the-more-expensive-instance)
      - [3.3 Are you benefitting from pipeline parallelism?](#33-are-you-benefitting-from-pipeline-parallelism)
      - [3.4 What's the bottleneck now?](#34-whats-the-bottleneck-now)
      - [3.5 Compare and comment on the financial cost of using a more expensive instance versus the t2.micro.](#35-compare-and-comment-on-the-financial-cost-of-using-a-more-expensive-instance-versus-the-t2micro)
    - [4 - Extra Credit Challenge](#4---extra-credit-challenge)
  - [Resources](#resources)

---

- Calculate summary statistics from a data stream
- Use pipelines to process a file larger than memory

## Announcements

- The question "How much longer does X take than Y" is usually most useful when answered in relative terms.
  For example, if the transfer took 1.9 seconds, and now it takes 79.2 seconds, then say that the second way is 79.2/1.9 = 42 times slower than the first.
- Check for comments / feedback on skills assignments.
- will post skills assignment solutions next week.

123 GO - what was the last kind of physical exercise you did?

## Background

The [GDELT Project](https://www.gdeltproject.org/) is the Global Database of Events, Language, and Tone.
It describes itself as:

> A Global Database of Society.
> Supported by Google Jigsaw, the GDELT Project monitors the world's broadcast, print, and web news from nearly every corner of every country in over 100 languages and identifies the people, locations, organizations, themes, sources, emotions, counts, quotes, images and events driving our global society every second of every day, creating a free open platform for computing on the entire world.

The events from 2018 are available in a single file at the S3 URI `s3://stat196k-data-examples/2018.csv.gz`.
This file is 3.8 GB, compressed.
Here are the [column definitions](https://stat196k-data-examples.s3.amazonaws.com/GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv).

### Goldstein Score

> Each CAMEO event code is assigned a numeric score from -10 to +10, capturing the theoretical potential impact that type of event will have on the stability of a country.
> This is known as the Goldstein Scale.
> This field specifies the Goldstein score for each event type.
> **NOTE:** this score is based on the type of event, not the specifics of the actual event record being recorded‚ thus two riots, one with 10 people and one with 10,000, will both receive the same Goldstein score.
> This can be aggregated to various levels of time resolution to yield an approximation of the stability of a location over time.

I believe this is the [CAMEO event code mapping](http://eventdata.parusanalytics.com/cameo.dir/CAMEO.SCALE.txt) to Goldstein scores.

## Assignment

Turn in two files:

- A PDF or HTML document containing your answers to the following questions in a neatly organized report.
- A file with extension `.sh.txt` showing all the code necessary to reproduce your work.
  The `.sh` is for shell script, and this is normally the only extension you need.
  The `.txt` allows Canvas to render it as plain text in the web browser, so I can grade it.

I suggest you use markdown through something like pandoc, Rmarkdown, or Jupyter notebooks to create your report.
The [markdown source for the assignment](https://raw.githubusercontent.com/clarkfitzg/csus_website/master/_posts/2021-02-05-homework-streaming-large-text-file.md) is on Github, so you can copy and paste from there.
MS Word and other GUI programs should work fine too.

## Questions

### 1 - Subset

**_5 pts_**

**Download a small subset of the data (100 rows is plenty) to your personal computer, and examine it using any software you like. Briefly describe this subset of the data by picking out a couple rows that look interesting to you.**

#### 1.1 How many columns are there?

Based on the [column definitions](GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv) there are 61 columns; in addition, you can run:

> $ cat -T first100Rows.csv | head -1 | grep -o "\^I" | wc -l

and see that it outputs `60`. Ignoring the last column all tableIds are followed by a delimiter separating each data type to their corresponding column/tableIds; as a result, the number of delimiters counted in any given table or csv/tsv file is **n-1** of the number of columns listed in the table.

#### 1.2 Do the data values in each column seem to match the column definitions?

Yes if you don't have the proper formatting/alignment; for, not all columns need to have a value and are left blank (tabbed over). So when read not aligned it may seem that a value is assigned to the second column, but is actually meant for the sixth column because values in columns three through five are left blank.

#### 1.3 What character delimits the records?

Escape character for tab `\t`\
**OR**

> cat -T first100Rows.csv

will output `^I` as representation of the tab delimiter. For example:

    719024869 ^I20170101 ^I201701 ^I2017 ^I2017.0027 ^IAGR ^IFARMER ^I ^I ^I ^I

#### 1.4 What is the CAMEO event code, what event does this correspond to, and what is the Goldstein score?

**The CAMEO event code** is a there level hierarchal codification that articulates the action that Actor1 performed upon Actor2 in events around the world. Form left to right, the first number (can be zero leading: 01 vs 12) sets the Superordinate (**ex. 02: APPEAL**), appended to that sets the Basic level (**ex. 025: Appeal to yield**), and depending on the situation the last number to be appended is the Subordinate level (**ex. 0251: Appeal for easing of administrative sanctions**). In use these raw CAMEO action code describes the action that Actor1 performed upon Actor2; for example, _Human Rights Watch also called on Yemen, Algeria and Malaysia to immediately lift bans on newspapers closed in recent days for printing the
caricatures_.

**The Goldstein score is** based on CAMEO event code each is assigned a numeric score from -10 to +10, where a positive number denotes that the region is doing well/contributed to good versus a negative number denotes that the region isn't doing well/is unstable, capturing the theoretical potential impact that type of event will have on the stability of a country; for example, a Goldstein score of -7.6 as a result of Armed force mobilization **VS** a Goldstein score of 7.4 as a result of Extend economic aid.

#### 1.5 Are the URL's to the news articles still live, and do they match the CAMEO event code?

Most are still live, but others like the article to [After Trump criticism China denies selling oil illicitly to North Korea](https://www.channelnewsasia.com/news/world/after-trump-criticism--china-denies-selling-oil-illicitly-to-north-korea-9819368); nevertheless, given the short descriptions of the articles they do seem to match the CAMEO event code and fits the Goldstein score as well.

#### 1.6 Does the Goldstein score appear to be doing what it was designed to do?

Yes although relatively arbitrary in what sets a type of event to be assigned a lower score than another; for example, a "Non-military destruction/injury" is given a Goldstein score of -8.7 a versus a "Non-injury destructive action" is given a Goldstein score of -8.3 are both terrible events it should be kept in mind for the general public that the "score is based on the type of event, not the specifics of the actual event
record being recorded – thus two riots, one with 10 people and one with 10,000, will both receive the same Goldstein score. This can be aggregated to various levels of time resolution to yield an approximation of the stability of a location over time"

### 2 - Histogram

**_10 pts_**

**Create a histogram of the Goldstein scores for all of 2018, using the integers as bin endpoints for the histogram.\
It's possible to do this in less than 10 minutes using a single shell pipeline on a t2 micro instance with 1 vCPU, 1 GiB memory, and 8 GiB storage.**

#### 2.1 How long does your program take to run?

#### 2.2 Explain in detail what each command in the pipeline does and how they work together

#### 2.3 Plot and interpret the histogram. You'll probably want to download the summary statistics (around 20 numbers) to your personal computer to plot the histogram. Do you notice anything strange?

#### 2.4 Exactly how many events (rows) are in this data?

### 3 - Performance

**_5 pts_**

**Print and interpret the output of `top` while your program is running.**

#### 3.1 What are the bottlenecks?

#### 3.2 Run and time your program on an EC2 instance with more vCPU's and a faster network and show the results of `top` once more. Is the program faster on the more expensive instance?

#### 3.3 Are you benefitting from pipeline parallelism?

#### 3.4 What's the bottleneck now?

#### 3.5 Compare and comment on the financial cost of using a more expensive instance versus the t2.micro.

Is it worth it?

**Remember to terminate these more expensive machines immediately after you use them!**
Otherwise, you may quickly run through your $50 credit and have to spend your own money.
[AWS Services Supported](https://s3.amazonaws.com/awseducate-starter-account-services/AWS_Educate_Starter_Accounts_and_AWS_Services.pdf) says that our Educate accounts can only use these kinds of instances: "t2.small", "t2.micro", "t2.nano", "m4.large", "c4.large", "c5.large", "m5.large", "t2.medium", "m4.xlarge", "c4.xlarge", "c5.xlarge", "t2.2xlarge", "m5.2xlarge", "t2.large", "t2.xlarge", "m5.xlarge".

### 4 - Extra Credit Challenge

**_0 pts, optional_**

Starting with the same 3.8 GB file on S3, calculate the summary statistics necessary for the histogram as fast as possible.
You can use the shell or any other programming language together with any EC2 instance available through your AWS Educate account.
Hint: look into software like [GNU parallel](https://www.gnu.org/software/parallel/) and [pigz](http://zlib.net/pigz/).
Turn in any extra code you write.
The student with the fastest program gets a minimal amount of extra credit and a maximal amount of glory.

---

## Resources

Blog post [streaming with S3](https://loige.co/aws-command-line-s3-content-from-stdin-or-to-stdout/)

- 1 Subset

  - 1.1 How many columns are there?
    - [How to count number of tabs in each line using shell script?](https://stackoverflow.com/questions/15517363/how-to-count-number-of-tabs-in-each-line-using-shell-script)
    - [How to count number of columns in CSV file using bash shell](https://linuxconfig.org/how-to-count-number-of-columns-in-csv-file-using-bash-shell)
  - 1.2 Do the data values in each column seem to match the column definitions?
  - 1.3 What character delimits the records?
  - 1.4 What is the CAMEO event code, what event does this correspond to, and what is the Goldstein score?
    - [GDELT-Data_Format_Codebook.pdf](http://data.gdeltproject.org/documentation/GDELT-Data_Format_Codebook.pdf)
    - [THE GDELT EVENT DATABASE DATA FORMAT CODEBOOK V2.0](http://data.gdeltproject.org/documentation/GDELT-Event_Codebook-V2.0.pdf)
    - [Goldstein Scale for WEIS Data](http://web.pdx.edu/~kinsella/jgscale.html)
  - 1.5 Are the URL's to the news articles still live, and do they match the CAMEO event code?
  - 1.6 Does the Goldstein score appear to be doing what it was designed to do?

- 2 Histogram

  - 2.1 How long does your program take to run?
  - 2.2 Explain in detail what each command in the pipeline does and how they work together
  - 2.3 Plot and interpret the histogram. You'll probably want to download the summary statistics (around 20 numbers) to your personal computer to plot the histogram. Do you notice anything strange?
  - 2.4 Exactly how many events (rows) are in this data?

- 3 Performance
  - 3.1 What are the bottlenecks?
  - 3.2 Run and time your program on an EC2 instance with more vCPU's and a faster network and show the results of `top` once more. Is the program faster on the more expensive instance?
  - 3.3 Are you benefitting from pipeline parallelism?
  - 3.4 What's the bottleneck now?
  - 3.5 Compare and comment on the financial cost of using a more expensive instance versus the t2.micro.
