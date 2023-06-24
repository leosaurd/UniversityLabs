#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "htable.h"
#include "mylib.h"
struct htablerec {
        int capacity;
        int num_keys;
        char **keys;
};
static unsigned int htable_word_to_int(char *word) {
    unsigned int result = 0;
    while (*word != '\0') {
        result = (*word++ + 31 * result);
    }
    return result;
}
static unsigned int htable_hash(htable h, unsigned int i_key) {
    return i_key % h->capacity;
}
htable htable_new(int capacity) {
    htable result = emalloc(sizeof *result);
    result->capacity = capacity;
    result->num_keys = 0;
    result->keys = emalloc(capacity * sizeof result->keys[0]);
    for(capacity = 0; capacity < result->capacity; capacity++){
        result->keys[capacity] = NULL;
    }
    return result;
}
void htable_free(htable h) {
    int i;
    for(i = 0; i < h->capacity; i++){
        if(h->keys[i] != NULL){
            free(h->keys[i]);
        }
    }
    free(h->keys);
    free(h);
}
int htable_insert(htable h, char *key) {
    int index = htable_word_to_int(key);
    int hash = htable_hash(h, index);
    int i = hash;
    do{
        if(h->keys[hash] == NULL){
            h->num_keys++;
            h->keys[hash] = emalloc((strlen(key)+1) * sizeof (char));
            strcpy(h->keys[hash], key);
            return 1;
        } else if (strcmp(h->keys[hash], key) == 0){
            return 0;
        }
        hash = (hash+1) % h->capacity;
    }while(hash!=i);
    return 0;
}
void htable_print(htable h, FILE *stream) {
    int i;
    for (i = 0; i < h->capacity; i++) {
        fprintf(stream, "%2d %s\n", i, h->keys[i] == NULL ? "" : h->keys[i]);
    }
}
