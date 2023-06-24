#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/*Maximum Array size.*/
#define ARRAY_MAX 30000

/*This is a function to demonstrate insertion sort.*/
void insertion_sort(int *a, int n) {
    int i;
    int key;
    int j;
    /*For each position p in array a except the first.*/
    for (i = 1; i < n; i++) {
        /*Pull out the item at p, and store it in variable key.*/
        key = a[i];
        /*For all items that are to the left of position p,
        and greater than key, move it right.*/
        for (j = i - 1; (a[j] > key && j >= 0); j--){

            a[j+1] = a[j];
        }
        /*Put key in the leftmost vacated position.*/
        a[j+1] = key;
    }
}

/*Main function provided by lab book.*/
int main(void) {
    int my_array[ARRAY_MAX];
    clock_t start, end;
    int i, count = 0;
    /*Array up to ARRAY_MAX digits read the values input.*/
    while (count < ARRAY_MAX && 1 == scanf("%d", &my_array[count])) {
        count++;
    }
    /*Timer starts here.*/
    start = clock();
    insertion_sort(my_array, count);
    /*Timer ends.*/
    end = clock();
    
    /*Print the array values after sorting.*/
    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]);
    }
    /*Print the number of values in the array, and time taken to sort.*/
    fprintf(stderr, "%d %f\n", count, (end-start)/(double)CLOCKS_PER_SEC);
    return EXIT_SUCCESS;
}
