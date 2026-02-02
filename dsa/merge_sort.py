def merge_sort(arr, left, right):
    if left >= right:
        return

    mid = left + (right - left) // 2

    merge_sort(arr, left, mid)
    merge_sort(arr, mid + 1, right)
    merge(arr, left, mid, right)


def merge(arr, left, mid, right):
    n1 = mid - left + 1
    n2 = right - mid

    leftArray = [0] * n1
    rightArray = [0] * n2

    for i in range(n1):
        leftArray[i] = arr[left + i]

    for j in range(n2):
        rightArray[j] = arr[mid + 1 + j]

    i = j = 0
    k = left

    while i < n1 and j < n2:
        if leftArray[i] <= rightArray[j]:
            arr[k] = leftArray[i]
            i += 1
        else:
            arr[k] = rightArray[j]
            j += 1
        k += 1

    while i < n1:
        arr[k] = leftArray[i]
        i += 1
        k += 1

    while j < n2:
        arr[k] = rightArray[j]
        j += 1
        k += 1


if __name__ == '__main__':
    arr = [0, 4, 2, 3, 9, 6, 10, 85, 57, 37, 94, 102, 201, 154]
    merge_sort(arr, 0, len(arr) - 1)
    print(arr)
