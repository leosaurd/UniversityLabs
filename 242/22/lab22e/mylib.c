#include <assert.h>
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>

void *emalloc(size_t s){
    void *result = malloc(s);
    return result;
}
