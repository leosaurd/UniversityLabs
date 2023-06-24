#include <stdio.h>
#include <stdlib.h>
#include "flexarray.h"

void *emalloc(size_t s){
    void *result = malloc(s);
    if(NULL == result && s != 0){
        fprintf(stderr, "Memory allocation failed!\n");
        exit(EXIT_FAILURE);
    }
    return result;
}

void *erealloc(void *p, size_t s){
    void *result = realloc(p, s);
    if(NULL == result && s != 0){
        fprintf(stderr, "Memory allocation failed!\n");
    }
    return result;
}

void print_arr(int *a, int n){
    int i = 0;
    for(i = 0; i < n; i++){
        fprintf(stderr, "%d\n", a[i]);
    }
}

static void selection_sort(int *a, int n) {
    int i;
    int j;
    int smallest;
    int temp;
    for(i = 0; i < n-1; i++){
        if(i == n/2){
            print_arr(a, n);
        }
        smallest = i;
        for(j = i+1; j < n; j++){
            if(a[smallest] > a[j]){
                smallest = j;
            }
        }
        temp = a[smallest];
        a[smallest] = a[i];
        a[i] = temp;
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
    if (f->itemcount >= f->capacity) {
        f->capacity += f->capacity;
        f->items = erealloc(f->items, f->capacity * sizeof f[0]);
    }
    f->items[f->itemcount++] = num;
}
void flexarray_print(flexarray f) {
    int i;
    for(i = 0; i < f->itemcount; i++){
        fprintf(stdout, "%d\n", f->items[i]);
    }
}

void flexarray_sort(flexarray f) {
    selection_sort(f->items, f->itemcount);
}

void flexarray_free(flexarray f) {
    free(f->items);
    free(f);
}


