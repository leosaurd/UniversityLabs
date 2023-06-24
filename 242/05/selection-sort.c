#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*Max array size.*/
#define STRING_LEN 80
#define ARRAY_LEN 10000

void *emalloc(size_t s){
    void *result = malloc(s);
    if(NULL == result){
        fprintf(stderr, "Memallocation failed! \n");
        exit(EXIT_FAILURE);
    }
    return result;
}

/*Function to demonstrate selection sort.*/
void selection_sort(char **a, int n) {
    int i;
    int j;
    int smallest;
    char *temp;
    /*For each position p in array a except the last.*/
    for(i = 0; i < n-1; i++){
        /*Find the smallest item from position p to n-1.*/
        smallest = i;
        for(j = i+1; j < n; j++){
            if(strcmp(a[smallest], a[j]) > 0){
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
    char word[STRING_LEN];
    char *wordlist[ARRAY_LEN];
    int i, count = 0;
    /*Array up to ARRAY_MAX digits read the values input.*/
    while (count < ARRAY_LEN && 1 == scanf("%79s", word)) {
        wordlist[count] = emalloc((strlen(word)+1) * sizeof wordlist[0][0]);
        strcpy(wordlist[count], word);
        count++;
    }
    selection_sort(wordlist, count);
    for (i = 0; i < count; i++) {
        printf("%s\n", wordlist[i]);
    }
    
    for(i = 0; i < count; i++){
        free(wordlist[i]);
    }
    return EXIT_SUCCESS;
}
