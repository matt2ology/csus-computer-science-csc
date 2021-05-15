import pandas as pd


def main():
    df = pd.read_csv(
        r'Takeout/Fit/Daily activity metrics/Daily activity metrics.csv', parse_dates=True, index_col='Date')
    df.info()
    df.drop(['Average weight (kg)', 'Max weight (kg)', 'Min weight (kg)', 'Average heart rate (bpm)',
             'Min heart rate (bpm)', 'Max heart rate (bpm)'], inplace=True, axis=1)

    df["workoutMonth"] = df.index.month_name()
    df["workoutWeekDay"] = df.index.day_name()
    df["workoutYear"] = df.index.year

    pass


if __name__ == "__main__":
    main()
    pass
