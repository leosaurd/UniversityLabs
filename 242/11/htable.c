#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "htable.h"
#include "mylib.h"

static unsigned int htable_word_to_int(char *word) {
    unsigned int result = 0;
    while (*word != '\0') {
        result = (*word++ + 31 * result);
    }
    return result;
}

struct htablerec{
 int capacity;
 int num_keys;
 int *freqs;
 char **keys;
};

htable htable_new(int size){
    int i;
    htable res = emalloc(sizeof *res);
    res->capacity = size;
    res->num_keys = 0;
    res->freqs = emalloc(size * sizeof res->freqs[0]);
    res->keys = emalloc(size * sizeof res->keys[0]);
    for(i = 0; i < size; i++){
        res->freqs[i] = 0;
        res->keys[i] = NULL;
    }
    return res;
}


void htable_free(htable h){
    int i;
    for(i = 0; i < h->capacity; i++){
        if(h->keys[i] != NULL){
            free(h->keys[i]);
        }
    }

    free(h->keys);
    free(h->freqs);
    free(h);
}

int htable_insert(htable h, char *c){
    int count = 0;
    int index = htable_word_to_int(c)%h->capacity;
    do{
        if(h->keys[index] == NULL){
            h->freqs[index]++;
            h->num_keys++;
            h->keys[index] = emalloc((strlen(c)+1) * sizeof (char));
            strcpy(h->keys[index], c);
            return 1;
        } else if(strcmp(h->keys[index], c) == 0){
            h->freqs[index]++;
            return h->freqs[index];
        }
        index = index+1 % h->capacity;
        count++;
        
    }while(count != h->capacity && index <= h->capacity);
    return 0;
}

void htable_print(htable h, FILE *s){
    int i;
    for(i = 0; i < h->capacity; i++){
        if(h->keys[i] != NULL){
            fprintf(s, "%d %s\n", h->freqs[i], h->keys[i]);
        }
    }
}

int htable_search(htable h, char *c){
    int colls = 0;
    int index = htable_word_to_int(c)%h->capacity;
    while(h->keys[index] != NULL && strcmp(h->keys[index], c) != 0 && colls <= h->capacity){
        index++;
        colls++;
    }
    if(colls == h->capacity){
        return 0;
    } else {
        return h->freqs[index];
    }
}


