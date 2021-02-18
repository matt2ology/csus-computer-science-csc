# login to ec2 instance
ssh -i ~/.ssh/id_rsa ec2-user@ec2-100-27-27-57.compute-1.amazonaws.com
# download compressed data csv (SHOULD BE TSV) file
aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | head -n 100 > first100Rows.tsv
# print out the number of columns, but note that it will report n-1 of the actual column count
cat -T first100Rows.tsv | head -1 | grep -o "\^I" | wc -l
# generate summary statistic to download
time aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | cut -f 31 | sort -n | uniq -c > allGoldsteinScoresCounted.txt
# create sorted list of Goldstein Scores to download
time aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | cut -f 31 | sort -n > allGoldsteinScores.txt
# return to local machine
exit
# download summary statistic
scp -i ~/.ssh/id_rsa ec2-user@ec2-100-27-27-57.compute-1.amazonaws.com:~/allGoldsteinScoresCounted.txt ./
# download sorted list of Goldstein Scores
scp -i ~/.ssh/id_rsa ec2-user@ec2-100-27-27-57.compute-1.amazonaws.com:~/allGoldsteinScores.txt ./
# Do you notice anything strange?
cat allGoldsteinScoresCounted.txt | head -20 > firstTwentyGoldsteinScoresCounted.txt
# Plot and interpret the histogram
cat allGoldsteinScores.txt | python3 postProcessDataToHistogram.py

# time aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | cut -f 31 | sort -n > allGoldsteinScores.txt
# time aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | cut -f 31 | sort -n | uniq -c > allGoldsteinScoresCounted.txt
# time aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | cut -f 31 | sort -n | awk '{print int($1)}' > allIntegerGoldsteinScores.txt
# time aws s3 cp s3://stat196k-data-examples/2018.csv.gz - --no-sign-request | gunzip | cut -f 31 | sort -n | awk '{print int($1)}' | uniq -c > allIntegerGoldsteinScoresCounted.txt
