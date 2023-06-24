#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "flexarray.h"


static void quicksort(int *a, int n){
    int i; 
    int j;
    int pivot;
    int temp;
    if(n<2){
        return;
    }
    pivot = a[0];
    i = -1;
    j = n;
    
    for(;;){
        do{
            i++;
        }while(a[i] < pivot);
        
        do{
            j--;
        }while(a[j] > pivot);
        
        if(i < j){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        } else {
            break;
        }
    }
    
    quicksort(a, j+1);
    quicksort((a+j+1), (n-j-1));
}

struct flexarrayrec {
    int capacity;
    int itemcount;
    int *items;
};

flexarray flexarray_new() {
    flexarray result = emalloc(sizeof *result);
    result->capacity = 2;
    result->itemcount = 0;
    result->items = emalloc(result->capacity * sizeof result->items[0]);
    return result;
}
void flexarray_append(flexarray f, int num) {
    if (f->itemcount == f->capacity) {
        /* do the old "double the capacity" trick(dont forget to increase capacity container) */
        f->capacity *= 2;
        f->items = erealloc(f->items, f->capacity * sizeof f[0]);
    }
    /* insert the item in the last free space */
    f->items[f->itemcount++] = num;
}
void flexarray_print(flexarray f) {
    /* a "for" loop to print out each cell of f->items */
    int i;
    for(i = 0; i < f->itemcount; i++){
        printf("%d\n", f->items[i]);
    }
}

void flexarray_sort(flexarray f) {
    quicksort(f->items, f->itemcount);
}

void flexarray_free(flexarray f) {
    /* free the memory associated with the flexarray */
    free(f->items);
}


