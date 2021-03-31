YEAR=2019

# Download all tax returns

mkdir ${YEAR}

# Didn't work without --recursive
# Takes 75 minutes
time aws s3 cp s3://irs-form-990/ ./${YEAR} --recursive --exclude "*" --include "${YEAR}*" --no-sign-request


# There are around a half million forms
ls ${YEAR} | wc
# 475575  475575 14267250

# only 16 GB, not awful
du -h ${YEAR}


# 16 GB text
# about 13 minutes to go through and remove the schema.
# Breaking my own rule by processing XML using sed! ☠️
time find ${YEAR} -type f -name "*.xml" | xargs sed -i -r -e "s/<Return .*>/<Return>/"


aws s3 rm s3://stat196k-data-examples/${YEAR}irs990.zip

# Lets zip them up and make them available, to save people having to wait 75 minutes
time zip -q -r - ${YEAR} | aws s3 cp - s3://stat196k-data-examples/${YEAR}irs990.zip



# Make sure it works for students
rm -r ${YEAR}

time aws s3 cp s3://stat196k-data-examples/${YEAR}irs990.zip ./ --no-sign-request

unzip -q ${YEAR}irs990.zip