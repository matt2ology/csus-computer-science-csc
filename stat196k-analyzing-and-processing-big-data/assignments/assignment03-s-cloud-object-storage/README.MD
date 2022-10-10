# S - Cloud Object Storage

**Due** Sunday by 11:59pm | **Points** 5 | **Submitting** a text entry box

Do the exercise on the bottom of [Cloud Object Storage](http://webpages.csus.edu/fitzgerald/cloud-object-storage/)

---

## Set-up

1. **Login** [AWS Educate](https://www.awseducate.com/signin/SiteLogin)
2. My Classrooms > Classroom
3. AWS Console
4. EC2 Instance
   - A
      1. Click Instance ID
      2. Can copy public IPv4 DNS
   - B
      1. Click Instance ID
      2. Click Connect
      3. Connect to instance > SSH client
      4. Naviage to step 4 on list and copy "**Connect to your instance using its Public DNS**"

5. In terminal: ssh ec2-user@hostname

---

## Resources

- [What do 'real', 'user' and 'sys' mean in the output of time(1)?](https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1/556411#556411)

- [AWS CLI Command Reference](https://docs.aws.amazon.com/cli/latest/reference/s3/ls.html)

### When gathering data use "better" standaard Deviation: Relative Standard Error (RSE): Standard error as a percentage of the mean.

- RSE is a useful statistic for analyzing the variance present in benchmarking datasets. 
- Proposal: ensure data falls within 5% RSE threshold unless there is a technically valid explanation for the variance
   - If data does not meet this RSE threshold, increase the number of test runs (in increments of 2) until it does.

Relative Standard Error (percent) : 𝑅𝑆𝐸=$\large \frac{S_M}{\overline{x}}\cdot 100$

Excel: =STDEV.S(range)/SQRT(COUNT(range))/AVERAGE(range)

---

## Exercise

Submit your answers to these questions along with bash commands and output.

1. SSH to an EC2 instance.
2. Find which files are in the bucket stat196k-data-examples.
3. How large are these files?
4. How many files are in the bucket?
5. Time how long it takes to download one of the files from S3 to your EC2 instance. What is a lower bound for the network bandwidth?
6. How long does it take to download the same file to your local machine?
7. How much faster is it to access the data in S3 from an EC2 instance versus downloading it?
