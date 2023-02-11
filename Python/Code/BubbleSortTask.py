def bubble_sort(arr):
    n = len(arr)

    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]

    return arr


def main():
    arr = []
    print("Enter 10 elements:")

    for i in range(10):
        element = int(input())
        arr.append(element)

    arr = bubble_sort(arr)
    print("Sorted array is:", arr)


if __name__ == '__main__':
    main()
