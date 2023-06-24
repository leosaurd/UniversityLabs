#include <stdio.h>
#include <stdlib.h>

void array_sort(int *a, int n) {
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

static void array_print(int *a, int n) {
    int i;
    
    for (i = 0; i < n; i++) {
        printf("%d\n", a[i]);
    }
}

int main(void) {
    int capacity = 2;
    int itemcount = 0;
    int item;
    int *my_array = malloc(capacity * sizeof my_array[0]);
    if (NULL == my_array) {
        fprintf(stderr, "memory allocation failed.\n");
        exit(EXIT_FAILURE);
    }
    
    while (1 == scanf("%d", &item)) {
        if (itemcount == capacity) {
            capacity += capacity;
            my_array = realloc(my_array, capacity * sizeof my_array[0]);
            if (NULL == my_array) {
                fprintf(stderr, "memory reallocation failed.\n");
                exit(EXIT_FAILURE);
            }
        }
        my_array[itemcount++] = item;
    }
    array_sort(my_array, itemcount);
    array_print(my_array, itemcount);
    free(my_array);
    
    return EXIT_SUCCESS;
    }
