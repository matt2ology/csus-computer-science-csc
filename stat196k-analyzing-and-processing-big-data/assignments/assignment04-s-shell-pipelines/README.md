# S - Shell Pipelines

**Due** Thursday by 11:59pm | **Points** 5 | **Submitting** a text entry box

Do the exercise on the bottom of [Shell Data Processing Pipelines](http://webpages.csus.edu/fitzgerald/shell-data-processing-pipelines/)

- Describe how a filter program processes standard input (`stdin`) into standard output (`stdout`)
- Interactively develop data processing pipelines using standard shell commands
- Create minimal working examples to check programs

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

- Software Carpentry [Pipes and Filters Lesson](https://swcarpentry.github.io/shell-novice/04-pipefilter/index.html)
- Wikipedia [Software Filters](https://en.wikipedia.org/wiki/Filter_(software))
- [Bash Redirection](https://www.gnu.org/software/bash/manual/html_node/Redirections.html)

---

## Exercise

**Submit your commands together with the output.**

1. Use `grep` to find all the rows in `presidents.csv` beginning with `D`. Hint: you shouldn’t find `R,Donald`.
2. Write a simple pipeline with `gzip` followed by `gunzip`. This is called a “round trip”, with data first being compressed, and then uncompressed. Can pipes handle binary data, in addition to text?
3. Use sed to transform `presidents.csv` into the output below. Hint: an easy way to do this is to use `sed` twice in a pipeline.
