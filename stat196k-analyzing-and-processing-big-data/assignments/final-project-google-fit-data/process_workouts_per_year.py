import pandas as pd
import plotly.express as px
import plotly.graph_objects as go


def main():
    df = pd.read_csv(
        r'Takeout/Fit/Daily activity metrics/Daily activity metrics.csv', parse_dates=True, index_col='Date')
    df.info()
    df.drop(['Average weight (kg)', 'Max weight (kg)', 'Min weight (kg)', 'Average heart rate (bpm)',
             'Min heart rate (bpm)', 'Max heart rate (bpm)'], inplace=True, axis=1)

    df["workoutMonth"] = df.index.month_name()
    df["workoutWeekDay"] = df.index.day_name()
    df["workoutYear"] = df.index.year

    year_value = df.workoutYear.value_counts()
    fig = go.Figure(data=[go.Pie(labels=year_value.index,
                                 values=year_value.values,
                                 textinfo='label+percent',
                                 pull=[0, 0, 0, 0, 0, 0.2],
                                 title="Year's Contribution to Total Workouts from 2016-02-08 to 2021-04-27"
                                 )])
    fig.update_traces(hoverinfo='label+value',  textfont_size=32,
                      marker=dict(line=dict(color='#eff542', width=3)), showlegend=True)
    fig.update_layout(font=dict(size=32))
    fig.show()
    pass


if __name__ == "__main__":
    main()
    pass
