#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <ctype.h>
#include "mylib.h"
#include <string.h>
/**
 * A function to allocate memory to a variable/structure.
 * 
 * @param s is the size of the allocated memory, and type(Char, Integer, etc).
 * 
 * @return result is the structure being allocated memory.
 **/
extern void *emalloc(size_t s) {
    void *result = malloc(s);
    if (result == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit (EXIT_FAILURE);
    }
    return result;
}

/**
 * A function to reallocate memory to a variable/structure.
 * 
 * @param a the structure to be allocated memory.
 * @param s the reallocated size of the memory.
 * 
 * @return result is the structure being reallocated memory.
 */
extern void *erealloc(void *a, size_t s) {
    void *result = realloc(a, s);
    if (result == NULL) {
        fprintf(stderr, "Memory reallocation failed\n");
        exit (EXIT_FAILURE);
    }
    return result;
}
/**
 * A function to get a word from an input through the use of
 * alphanumerical values.
 * 
 * @param s is the word to be read.
 * @param limit is the size of the word.
 * @param stream is the location where the word is read from.
 * 
 * @return is the alphanumeric representation of the word.
 */
int getword(char *s, int limit, FILE *stream) {
    int c;
    char *w = s;
    assert(limit > 0 && s != NULL && stream != NULL);
    /* skip to the start of the word */
    while (!isalnum(c = getc(stream)) && EOF != c)
        ;
    if (EOF == c) {
        return EOF;
    } else if (--limit > 0) { /* reduce limit by 1 to allow for the \0 */
        *w++ = tolower(c);
    }
    while (--limit > 0) {
        if (isalnum(c = getc(stream))) {
            *w++ = tolower(c);
        } else if ('\'' == c) {
            limit++;
        } else {
            break;
        }
    }
    *w = '\0';
    return w - s;
}
