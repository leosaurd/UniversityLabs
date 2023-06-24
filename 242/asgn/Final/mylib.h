#ifndef MYLIB_H_
#define MYLIB_H_

/*A function to allocate memory to a structure or variable.*/
extern void *emalloc(size_t s);
/*A function to reallocate memory to an existing structure or variable.*/
extern void *erealloc(void *a, size_t s);
/*A function to get a word from an input and check for further input.*/
extern int getword(char *, int, FILE *);

#endif
