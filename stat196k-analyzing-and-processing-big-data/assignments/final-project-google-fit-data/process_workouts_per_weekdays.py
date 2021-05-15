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

    workout_weekday_value_count = df.workoutWeekDay.value_counts()
    months = ('Monday', 'Tuesday', 'Wednesday',
              'Thursday', 'Friday', 'Saturday', 'Sunday')
    month_value = tuple(workout_weekday_value_count[i] for i in months)
    fig = px.bar(workout_weekday_value_count,
                 x=months,
                 y=month_value,
                 color=month_value,
                 text=month_value,
                 color_continuous_scale='Rainbow',
                 labels={'color': ''}
                 )
    fig.update_layout(
        title="Count of Workout in Each Week Day from 2016-02-08 to 2021-04-27",
        xaxis_title='Week Day',
        yaxis_title='Number of Workouts',
        xaxis_tickangle=-40,
        yaxis={'visible': True, 'showticklabels': True},
        font=dict(size=20)
    )
    fig.show()
    pass


if __name__ == "__main__":
    main()
    pass
