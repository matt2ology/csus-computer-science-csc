# using Plots allows use of title parameter in plot function
using Plots 
using Distributions
using StatsPlots

function main()
    OUTPUT_FOLDER_PATH = "output-plot-results-assignment/"
    mkdir("output-plot-results-assignment")

    # Cosine Distribution
    ## The cosine Distribution is a probability distribution that is both continuous—for non-negative random variables—and stable.
    # Object representing a cosine distribution
    cosine_distribution = Cosine(5)
    # Plots the probability density function (PDF) of the above cosine Distribution
    savefig(plot(cosine_distribution, lw=5 ,title="Cosine Distribution With 5 Degrees of Freedom"), 
            OUTPUT_FOLDER_PATH * "cosine-distribution-with-5-degrees-of-freedom")

    # Histograms
    ## The shape of the histogram of n IID samples from a distribution will match the PDF as n goes to infinity.
    ## This suggests a quick way to test if data came from a distribution is to look at the histogram.
    savefig(histogram(rand(cosine_distribution, 100), title="100 observations"), 
            OUTPUT_FOLDER_PATH * "histogram-of-n-iid-samples-hundred")
    savefig(histogram(rand(cosine_distribution, 10000), title="10 thousand observations"), 
            OUTPUT_FOLDER_PATH * "histogram-of-n-iid-samples-thousands")

    # Quantiles
    ## The p quantile for a distribution X is the point xq that satisfies P(X <= xq) = p
    q = range(0, 1, step=0.1)
    collect(q)
    quantile(cosine_distribution, q)

    # Simulate n data points from this RV coefficient.
    n = 100
    x_from_cosine_distribution = rand(cosine_distribution, n)

    savefig(qqplot(x_from_cosine_distribution, cosine_distribution, title="Data Appears To Match Distribution"), 
            OUTPUT_FOLDER_PATH * "data-appears-to-match-distribution")

    maximum(x_from_cosine_distribution)

    # Represents a Arcsine random variable
    arcsine_distribution15 = Arcsine(0, 15)

    savefig(qqplot(x_from_cosine_distribution, arcsine_distribution15, title="Data DOES NOT match distribution"), 
            OUTPUT_FOLDER_PATH * "data-does-not-match-distribution")
end

if abspath(PROGRAM_FILE) == @__FILE__
    main()
end