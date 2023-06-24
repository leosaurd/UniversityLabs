#include <stdio.h>
#include <stdlib.h>
#include <time.h>
/*Max array size.*/
#define ARRAY_MAX 30000

/*Function to demonstrate selection sort.*/
void selection_sort(int *a, int n) {
    int i;
    int j;
    int smallest;
    int temp;
    /*For each position p in array a except the last.*/
    for(i = 0; i < n-1; i++){
        /*Find the smallest item from position p to n-1.*/
        smallest = i;
        for(j = i+1; j < n; j++){
            if(a[smallest] > a[j]){
                smallest = j;
            }
        }
    /*Swap the item found with whatever is at position p.*/
    temp = a[smallest];
    a[smallest] = a[i];
    a[i] = temp;
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
    selection_sort(my_array, count);
    /*Timer ends here.*/
    end = clock();
    for (i = 0; i < count; i++) {
        printf("%d\n", my_array[i]);
    }
    fprintf(stderr, "%d %f\n", count, (end-start)/(double)CLOCKS_PER_SEC);
    return EXIT_SUCCESS;
}
