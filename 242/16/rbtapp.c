#include <stdlib.h>
#include <stdio.h>
#include "rbt.h"
#include "mylib.h"

void print_key(char *s) {
    printf("%s\n", s);
}


int main(void) {
    rbt b = rbt_new();
    char word[256];
    char op;
    while (2 == scanf(" %c %255s", &op, word)) {
        if ('+' == op) {
           b = rbt_insert(b, word);
        } else if ('?' == op) {
            printf("%d %s\n", rbt_search(b, word), word);
        } else if( '-' == op) {
           b = rbt_delete(b, word);
        } else if( '1' == op) {
           rbt_inorder(b, print_key);
        } else if( '2' == op) {
           rbt_preorder(b, print_key);
        }
    }
    rbt_free(b);
    return EXIT_SUCCESS;
}