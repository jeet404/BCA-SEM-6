def binary_search(arr, x):
    low = 0
    high = len(arr) - 1
    mid = 0

    while low <= high:

        mid = (high + low) // 2

        if arr[mid] == x:
            return True
        elif arr[mid] < x:
            low = mid + 1
        else:
            high = mid - 1

    return False


def main():
    arr = [1, 8, 3, 5, 4, 6, 7, 2]
    arr.sort()
    x = int(input("Enter the number you want to search: "))

    result = binary_search(arr, x)

    if result is True:
        print(arr)
        print("\nElement is present in the list")
    else:
        raise Exception("Element is not present in the list")


if __name__ == '__main__':
    main()
