#include <stdio.h>
#include <stdlib.h>

#define ARRAY_SIZE 100000

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

void merge_sort(int *a, int *w, int n){
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

int main(void){
    int array[ARRAY_SIZE];
    int *workspace;
    int i;
    int count = 0;
    
    while(count < ARRAY_SIZE && 1 == scanf("%d", &array[count])){
        count++;
    }
    workspace = ((int*) malloc (count* sizeof workspace[0]));
    merge_sort(array, workspace, count);
    
    for (i = 0; i < count; i++) {
        printf("%d\n", array[i]);
    }
    return EXIT_SUCCESS;
}
