#include <stdio.h>
#include <stdlib.h>

/*Scanf needs to modify variables outside its function call, hence the need for the address. */

void max_min(int *a, int n, int *max, int*min){
    int i = 0;
    *max = a[i];
    *min = a[i];
    for(i = 1; i < n; i++){
        if(a[i]>*max){
            *max = a[i];
        } else if(a[i]<*min){
            *min = a[i];
        }
    } 
}

int main(void){
    int my_array[] = { 5, 2, 7, 3, 4 };
    int biggest, smallest;
    max_min(my_array, 5, &biggest, &smallest);
    printf("Max Value: %d\nMin Value: %d\n", biggest, smallest);
    return EXIT_SUCCESS;
}
