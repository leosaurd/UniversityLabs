#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "flexarray.h"

void merge(int *a, int *w, int n){
    int i = 0;
    int j = n/2;
    int k = 0;
    while(i < n/2 && j < n){
        if(a[i]<a[j]){
            w[k] = a[i];
            i++;
        } else {
            w[k] = a[j];
            j++;
        }
        k++;
    }
    while(i<n/2){
        w[k] = a[i];
        k++;
        i++;
    }
    while(j<n){
        w[k] = a[j];
        k++;
        j++;
    }
}

static void merge_sort(int *a, int *w, int n){
    int i; 
    if(n<2){
        return;
    }
    merge_sort(a, w, n/2);
    merge_sort((a + (n/2)), w, (n - (n/2)));
    merge(a, w, n);
    
    for(i = 0; i < n; i++){
        a[i] = w[i];
    }
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
        /* do the old "double the capacity" trick */
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
    /* mergesort would be good */
    int *workspace = emalloc(f->itemcount * sizeof workspace[0]);
    merge_sort(f->items, workspace, f->itemcount);
    free(workspace);
}

void flexarray_free(flexarray f) {
    /* free the memory associated with the flexarray */
    free(f->items);
}


