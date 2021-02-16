import sys
import pandas as pd
from matplotlib import pyplot as plt

def workingSolution():
    plt.style.use('fivethirtyeight')

    data = pd.read_csv(r'data/data.csv')
    ids = data['Responder_id']
    ages = data['Age']

    bins = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

    plt.hist(ages, bins=bins, edgecolor='black', log=True)

    median_age = 29
    color = '#fc4f30'

    plt.axvline(median_age, color=color, label='Age Median', linewidth=2)

    plt.legend()

    plt.title('Ages of Respondents')
    plt.xlabel('Ages')
    plt.ylabel('Total Respondents')
    plt.savefig("data/FILENAME.PNG")
    plt.tight_layout()

    plt.show()

def main():
    # ORGANIZE DATA #
    freq = []
    score = []
    for line in sys.stdin:
        try:
            f, s = line.strip().replace(" ",  ',').split(',')
        except:
            continue
        freq.append(f)
        score.append(s)
    plt.hist(score, range=[-10,20], edgecolor='black', log=True)
    plt.title("Goldstein Scores for All of 2018")
    plt.xlabel("Goldstein Scale")
    plt.ylabel("Frequency")

    plt.xticks(rotation="horizontal")
    plt.savefig("data/FILENAME09.PNG")
    plt.tight_layout()
    plt.show()
    
    pass
    

if __name__ == "__main__":
    main()