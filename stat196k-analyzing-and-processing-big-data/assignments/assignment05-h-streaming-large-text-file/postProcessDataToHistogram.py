import sys  # read standard input from pipe
import os  # create folder
from matplotlib import pyplot as plt


def create_results_folder():
    if not os.path.exists('results'):
        os.makedirs('results')
    pass


def generate_histogram_from_sorted_streamed_goldstein_scores():
    goldsteinScores = []
    for line in sys.stdin:
        try:
            s = line.strip()
        except:
            continue
        goldsteinScores.append(s)
    plt.hist(goldsteinScores, bins=43,
             histtype='bar', log=True, color='#e6b711', edgecolor='black')
    plt.tight_layout(pad=2)
    plt.xticks(rotation="vertical")
    plt.title("Goldstein Scores for All of 2018")
    plt.xlabel("Goldstein Scale")
    plt.ylabel("Frequency")
    plt.savefig("results/2018-goldsteinScoreHistogram.PNG")
    plt.tight_layout()
    plt.show()
    pass


def main():
    create_results_folder()
    generate_histogram_from_sorted_streamed_goldstein_scores()
    pass


if __name__ == "__main__":
    main()
