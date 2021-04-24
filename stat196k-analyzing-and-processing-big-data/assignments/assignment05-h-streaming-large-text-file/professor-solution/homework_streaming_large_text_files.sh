# homework_streaming_large_text_file
# http://webpages.csus.edu/fitzgerald/homework-streaming-large-text-file/ (Links to an external site.)

S3FILE="s3://stat196k-data-examples/2018.csv.gz"
COL31FILE="s3://stat196k-data-examples/2018_col31.csv.gz"
GOLDSTEIN=31

# It might be fun to make the histogram right on the shell.

time aws s3 cp ${S3FILE} - |
    gunzip |
    #head |
    cut --fields=${GOLDSTEIN} |
    sed -r "s/\.[0-9]+//" |
    sort --numeric-sort |
    uniq -c > hist_bin_counts.txt