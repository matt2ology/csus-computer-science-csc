# using Plots allows use of title parameter in plot function
using Plots 
using Distributions
using StatsPlots

OUTPUT_FOLDER_PATH = "output-plot-results/"

mkdir("output-plot-results")

# Chi Squared Distribution
## The Chi squared distribution comes up as a sum of independent squared normal random variables.

# Object representing a Chi squared distribution
c5 = Chisq(5)

# Plots the probability density function (PDF) of the above Chi squared distribution
# (Takes ~10 seconds)

savefig(plot(c5, title="Chi square distribution with 5 degrees of freedom"), OUTPUT_FOLDER_PATH * "pdf-of-chi-squared-distribution")

# Histograms
## The shape of the histogram of n IID samples from a distribution will match the PDF as n goes to infinity.

## This suggests a quick way to test if data came from a distribution is to look at the histogram.

savefig(histogram(rand(c5, 100), title="100 observations"), OUTPUT_FOLDER_PATH * "histogram-of-n-iid-samples-hundred")

savefig(histogram(rand(c5, 10000), title="10 thousand observations"), OUTPUT_FOLDER_PATH * "histogram-of-n-iid-samples-thousands")

# Quantiles
## The p quantile for a distribution X is the point xq that satisfies P(X <= xq) = p

q = range(0, 1, step=0.1)

collect(q)

quantile(c5, q)

# QQ plots
## The QQ (quantile - quantile) plot is a useful visual tool to check if whether
## a particular distribution models data well. If the QQ plot follows the 
## line y = x reasonably well, then it means that the reference distribution is
## 

# Simulate n data points from this RV.
n = 100

x_from_c5 = rand(c5, n)

savefig(qqplot(x_from_c5, c5, title="Data appears to match distribution"), OUTPUT_FOLDER_PATH * "data-appears-to-match-distribution")

maximum(x_from_c5)

# Represents a Uniform random variable
U15 = Uniform(0, 15)

savefig(qqplot(x_from_c5, U15, title="Data DOES NOT match distribution"), OUTPUT_FOLDER_PATH * "data-does-not-match-distribution")
