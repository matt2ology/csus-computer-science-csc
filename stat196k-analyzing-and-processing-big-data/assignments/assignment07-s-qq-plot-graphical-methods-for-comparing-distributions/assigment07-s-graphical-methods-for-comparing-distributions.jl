# using Plots allows use of title parameter in plot function
using Plots 
using Distributions
using StatsPlots

function main()
    # OUTPUT_FOLDER_PATH = "output-plot-results-assignment/"
    # mkdir("output-plot-results-assignment")
    # Levy Distribution
    ## The Levy Distribution is a probability distribution that is both continuous—for non-negative random variables—and stable.
    levyDistribution = Levy(5)
    # Plots the probability density function (PDF) of the above Levy Distribution
    savefig(plot(levyDistribution, title="Levy Distribution With 5 Degrees of Freedom"), "levy-distribution-with-5-degrees-of-freedom")

    # Histograms
    ## The shape of the histogram of n IID samples from a distribution will match the PDF as n goes to infinity.
    ## This suggests a quick way to test if data came from a distribution is to look at the histogram.
    savefig(histogram(rand(levyDistribution, 100), title="100 observations"), "histogram-of-n-iid-samples-hundred")
    savefig(histogram(rand(levyDistribution, 10000), title="10 thousand observations"), "histogram-of-n-iid-samples-thousands")

    # Quantiles
    ## The p quantile for a distribution X is the point xq that satisfies P(X <= xq) = p
    q = range(0, 1, step=0.1)

    collect(q)
    
    quantile(levyDistribution, q)

    # Simulate n data points from this RV coefficient.
    n = 100
    x_from_levyDistribution = rand(levyDistribution, n)

    savefig(qqplot(x_from_levyDistribution, levyDistribution, title="Data Appears To Match Distribution"), "data-appears-to-match-distribution")
    maximum(x_from_levyDistribution)

    # Represents a Uniform random variable
    normalDistribution15 = Normal(0, 15)

    savefig(qqplot(x_from_levyDistribution, normalDistribution15, title="Data DOES NOT match distribution"), "data-does-not-match-distribution")

end


if abspath(PROGRAM_FILE) == @__FILE__
    main()
end