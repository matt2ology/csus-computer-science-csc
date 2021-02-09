# Exercise03: S - Cloud Object Storage

- [Exercise03: S - Cloud Object Storage](#exercise03-s---cloud-object-storage)
  - [1. Find which files are in the bucket stat196k-data-examples](#1-find-which-files-are-in-the-bucket-stat196k-data-examples)
  - [2. How large are these files?](#2-how-large-are-these-files)
  - [3. How many files are in the bucket?](#3-how-many-files-are-in-the-bucket)
  - [4. Time how long it takes to download one of the files from S3 to your EC2 instance. What is a lower bound for the network bandwidth?](#4-time-how-long-it-takes-to-download-one-of-the-files-from-s3-to-your-ec2-instance-what-is-a-lower-bound-for-the-network-bandwidth)
    - [4.1 IN EC2 INSTANCE](#41-in-ec2-instance)
      - [4.1.1 FILE ONE: 2018.csv.gz](#411-file-one-2018csvgz)
      - [4.1.2 FILE TWO: 20190203.csv](#412-file-two-20190203csv)
  - [5. How long does it take to download the same file to your local machine?](#5-how-long-does-it-take-to-download-the-same-file-to-your-local-machine)
    - [5.1 ON LOCAL MACHINE](#51-on-local-machine)
      - [5.1.1 FILE ONE: 2018.csv.gz](#511-file-one-2018csvgz)
      - [5.1.2 FILE TWO: 20190203.csv](#512-file-two-20190203csv)
  - [6. How much faster is it to access the data in S3 from an EC2 instance versus downloading it?](#6-how-much-faster-is-it-to-access-the-data-in-s3-from-an-ec2-instance-versus-downloading-it)
    - [6.1 FILE ONE: 2018.csv.gz](#61-file-one-2018csvgz)
    - [6.2 FILE TWO: 20190203.csv](#62-file-two-20190203csv)

## 1. Find which files are in the bucket stat196k-data-examples

> ssh -i key.pem ec2-user@hostname

OUTPUT

    -
    2018.csv.gz
    20190203.csv
    20190204.csv
    GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv
    a.csv
    a.txt
    b.txt

## 2. How large are these files?

> aws s3 ls s3://stat196k-data-examples --no-sign-request --human-readable --summarize

| File Size (bytes) | Human Readable File Size | File Name                                             |
| ----------------: | :----------------------: | :---------------------------------------------------- |
|                 0 |         0 Bytes          | -                                                     |
|        4150844161 |         3.9 GiB          | 2018.csv.gz                                           |
|          41328290 |         39.4 MiB         | 20190203.csv                                          |
|          65780184 |         62.7 MiB         | 20190204.csv                                          |
|             27344 |         26.7 KiB         | GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv |
|                 6 |         6 Bytes          | a.csv                                                 |
|                 4 |         4 Bytes          | a.txt                                                 |
|                 4 |         4 Bytes          | b.txt                                                 |

OUTPUT

    \- (**0 Bytes**)
    2018.csv.gz (**3.9 GiB**)
    20190203.csv (**39.4 MiB**)
    20190204.csv (**62.7 MiB**)
    GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv (**26.7 KiB**)
    a.csv (**6 Bytes**)
    a.txt (**4 Bytes**)
    b.txt (**4 Bytes**)

## 3. How many files are in the bucket?

**There are eight files in the bucket.**

1. \-
2. 2018.csv.gz
3. 20190203.csv
4. 20190204.csv
5. GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv
6. a.csv
7. a.txt
8. b.txt

## 4. Time how long it takes to download one of the files from S3 to your EC2 instance. What is a lower bound for the network bandwidth?

### 4.1 IN EC2 INSTANCE

#### 4.1.1 FILE ONE: 2018.csv.gz

> time wget <https://stat196k-data-examples.s3.amazonaws.com/2018.csv.gz>

    --2021-02-08 06:23:10--  https://stat196k-data-examples.s3.amazonaws.com/2018.csv.gz
    Resolving stat196k-data-examples.s3.amazonaws.com (stat196k-data-examples.s3.amazonaws.com)... 52.217.32.156
    Connecting to stat196k-data-examples.s3.amazonaws.com (stat196k-data-examples.s3.amazonaws.com)|52.217.32.156|:443... connected.
    HTTP request sent, awaiting response... 200 OK
    Length: 4150844161 (3.9G) [binary/octet-stream]
    Saving to: ‘2018.csv.gz’

    100%[==========================>] 4,150,844,161 44.3MB/s   in 85s

    2021-02-08 06:24:34 (46.8 MB/s) - ‘2018.csv.gz’ saved [4150844161/4150844161]

    real    1m24.728s
    user    0m6.215s
    sys     0m12.105s

**It took 1 minute and 24.728 seconds to download one of the files (2018.csv.gz) from S3 to my EC2 instance**\

#### 4.1.2 FILE TWO: 20190203.csv

> time wget <https://stat196k-data-examples.s3.amazonaws.com/20190203.csv>

    --2021-02-08 06:41:50--  https://stat196k-data-examples.s3.amazonaws.com/20190203.csv
    Resolving stat196k-data-examples.s3.amazonaws.com (stat196k-data-examples.s3.amazonaws.com)... 52.216.85.147
    Connecting to stat196k-data-examples.s3.amazonaws.com (stat196k-data-examples.s3.amazonaws.com)|52.216.85.147|:443... connected.
    HTTP request sent, awaiting response... 200 OK
    Length: 41328290 (39M) [text/csv]
    Saving to: ‘20190203.csv’

    100%[===============================>] 41,328,290  43.1MB/s   in 0.9s

    2021-02-08 06:41:51 (43.1 MB/s) - ‘20190203.csv’ saved [41328290/41328290]

    real    0m1.047s
    user    0m0.101s
    sys     0m0.101s

> **It took 1.47 seconds to download one of the files (20190203.csv) from S3 to my EC2 instance**

## 5. How long does it take to download the same file to your local machine?

### 5.1 ON LOCAL MACHINE

#### 5.1.1 FILE ONE: 2018.csv.gz

> time scp -i ~/.ssh/id_rsa ec2-user@ec2-54-85-47-180.compute-1.amazonaws.com:~/2018.csv.gz ./

    2018.csv.gz                             100% 3959MB   8.0MB/s   08:14

    real    8m15.982s
    user    0m5.203s
    sys     0m13.578s

**It took 8 minutes and 15.982 seconds to download the same (2018.csv.gz) file to my local machine**\

#### 5.1.2 FILE TWO: 20190203.csv

> time wget <https://stat196k-data-examples.s3.amazonaws.com/20190203.csv>

    --2021-02-07 22:44:14--  https://stat196k-data-examples.s3.amazonaws.com/20190203.csv
    Resolving stat196k-data-examples.s3.amazonaws.com (stat196k-data-examples.s3.amazonaws.com)... 52.216.96.27
    Connecting to stat196k-data-examples.s3.amazonaws.com (stat196k-data-examples.s3.amazonaws.com)|52.216.96.27|:443... connected.
    HTTP request sent, awaiting response... 200 OK
    Length: 41328290 (39M) [text/csv]
    Saving to: ‘20190203.csv’

    20190203.csv       100%[==============>]  39.41M  9.76MB/s    in 4.4s

    utime(20190203.csv): Operation not permitted
    2021-02-07 22:44:19 (8.89 MB/s) - ‘20190203.csv’ saved [41328290/41328290]

    real    0m4.876s
    user    0m0.000s
    sys     0m0.250s

**It took 4.876 seconds to download the same (20190203.csv) file to my local machine.**

## 6. How much faster is it to access the data in S3 from an EC2 instance versus downloading it?

### 6.1 FILE ONE: 2018.csv.gz

    From S3 to my EC2 instance: 1 minute and 24.728 seconds (Rounded-up: 85 seconds)
    From EC2 instance to my local machine: 8 minutes and 15.982 seconds (Rounded-up: 496 seconds)

| File Name   | File Size | S3 to EC2  | EC2 to local machine | Delta ▲ (S3 to EC2/EC2 to local machine) |
| :---------- | :-------- | :--------- | :------------------- | :--------------------------------------: |
| 2018.csv.gz | 3.9 GiB   | 85 seconds | 496 seconds          |                 583.53%                  |

**Speed comparison**: For file 2018.csv.gz S3 to EC2 **IS 483.53% FASTER THAN** EC2 to local machine **[(EC2 to local machine/S3 to EC2)\*100]-100**\
**OR**\
**Time comparison**: For file 2018.csv.gz S3 to EC2 **TAKES 82.86% LESS TIME THAN** EC2 to local machine **[(S3 to EC2/EC2 to local machine)\*100]-100**\
**OR**\
**Multiplier**: For file 2018.csv.gz S3 to EC2 **IS 5.84x FASTER THAN** EC2 to local machine **[(S3 to EC2/EC2 to local machine)\*100]-100**

### 6.2 FILE TWO: 20190203.csv

    From S3 to my EC2 instance: 1.47 seconds (2 seconds) Rounded-up
    From EC2 instance to my local machine: 4.876 seconds (5 seconds) Rounded-up

| File Name    | File Size | S3 to EC2 | EC2 to local machine | Delta ▲ (S3 to EC2/EC2 to local machine) |
| :----------- | :-------- | :-------- | :------------------- | :--------------------------------------: |
| 20190203.csv | 39.4 MiB  | 2         | 5                    |                 250.00%                  |

**Speed comparison**: For file 2018.csv.gz S3 to EC2 **IS 150.00% FASTER THAN** EC2 to local machine **[(EC2 to local machine/S3 to EC2)\*100]-100**\
**OR**\
**Time comparison**: For file 2018.csv.gz S3 to EC2 **TAKES 60.00% LESS TIME THAN** EC2 to local machine **[(S3 to EC2/EC2 to local machine)\*100]-100**\
**OR**\
**Multiplier**: For file 2018.csv.gz S3 to EC2 **IS 2.5x FASTER THAN** EC2 to local machine **[(S3 to EC2/EC2 to local machine)\*100]-100**
