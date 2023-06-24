#include <stdio.h>
#include <stdlib.h>

#define ARRAY_MAX 30000

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

int binsearch(int *a, int small, int big, int val){
    int m;
    if(big >= small){
        m = small+(big-small)/2;
        
        if(a[m] == val){
            return 1;
        }
        
        if(a[m] > val){
            return binsearch(a, small, m-1, val);
        } else {
            return binsearch(a, m+1, big, val);
        }
    }
    
    return 0;
}
int main(int argc, char **argv) {
    FILE *infile;
    int my_array[ARRAY_MAX];
    int val_array[ARRAY_MAX];
    int i = 0;
    int count = 0;
    
    if(NULL == (infile = fopen(argv[1], "r"))){
        fprintf(stderr, "%s: can't find file %s\n", argv[0], argv[1]);
        return EXIT_FAILURE;
    }
    
    /*Array up to ARRAY_MAX digits read the values input.*/
    while (count < ARRAY_MAX && 1 == fscanf(infile, "%d", &my_array[count])) {
        count++;
    }
    fclose(infile);
    
    selection_sort(my_array, count);
    
    while (i < ARRAY_MAX && 1 == scanf("%d", &val_array[i])){
        if(binsearch(my_array, 0, count-1, val_array[i])){
            printf("+\n");
        } else {
            printf("-\n");
        }
        i++;
    }
    return EXIT_SUCCESS;
}
