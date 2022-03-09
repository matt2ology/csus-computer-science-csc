import math


def total_circle_area(list_of_real_numbers: list[int]) -> list[float]:
    return round(sum(list(map(lambda radius: math.pi*radius*radius, list_of_real_numbers))))
