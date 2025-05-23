# Sum from one

def sum_from_one_method_one(value: int):
    for i in range(1, value):
        value += i
    return value


def sum_of_one_method_two(value: int):
    return value * (value + 1) / 2


print(f"Value: {sum_from_one_method_one(1000)}")
print(f"Value: {sum_of_one_method_two(1000)}")

number = [2, 4, 1, 6, 3, 9, 5]


def print_sorted_list(): # space complexity example
    number.sort()
    return number

print(print_sorted_list())