# Exercise03: S - Cloud Object Storage

1. Find which files are in the bucket stat196k-data-examples
    > ssh -i key.pem ec2-user@hostname
    
    **OUTPUT**
    
        -
        2018.csv.gz
        20190203.csv
        20190204.csv
        GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv
        a.csv
        a.txt
        b.txt

2. How large are these files?

    > aws s3 ls s3://stat196k-data-examples --no-sign-request --human-readable --summarize

    **OUTPUT**

    | File Size (bytes) | Human Readable File Size | File Name                                             |
    | ----------------: | :----------------------: | :---------------------------------------------------- |
    |                 0 |         0 Bytes          | -                                                 |
    |        4150844161 |         3.9 GiB          | 2018.csv.gz                                           |
    |          41328290 |         39.4 MiB         | 20190203.csv                                          |
    |          65780184 |         62.7 MiB         | 20190204.csv                                          |
    |             27344 |         26.7 KiB         | GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv |
    |                 6 |         6 Bytes          | a.csv                                                 |
    |                 4 |         4 Bytes          | a.txt                                                 |
    |                 4 |         4 Bytes          | b.txt                                                 |

   - \- (**0 Bytes**)
   - 2018.csv.gz (**3.9 GiB**)
   - 20190203.csv (**39.4 MiB**)
   - 20190204.csv (**62.7 MiB**)
   - GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv (**26.7 KiB**)
   - a.csv (**6 Bytes**)
   - a.txt (**4 Bytes**)
   - b.txt (**4 Bytes**)

3. How many files are in the bucket?

    1. \-
    2. 2018.csv.gz
    3. 20190203.csv
    4. 20190204.csv
    5. GDELT_2.0_Events_Column_Labels_Header_Row_Sep2016.csv
    6. a.csv
    7. a.txt
    8. b.txt

    **There are seven files in the bucket.**

4. Time how long it takes to download one of the files from S3 to your EC2 instance. What is a lower bound for the network bandwidth?

    

5. How long does it take to download the same file to your local machine?


6. How much faster is it to access the data in S3 from an EC2 instance versus downloading it?
