#include <stdlib.h>
#include <stdio.h>
#include "bst.h"
#include "mylib.h"

void print_key(char *s) {
    printf("%s\n", s);
}


int main(void) {
    bst b = bst_new();
    char word[256];
    char op;
    while (2 == scanf(" %c %255s", &op, word)) {
        if ('+' == op) {
           b = bst_insert(b, word);
        } else if ('?' == op) {
            printf("%d %s\n", bst_search(b, word), word);
        } else if( '-' == op) {
           b = bst_delete(b, word);
        } else if( '1' == op) {
           bst_inorder(b, print_key);
        } else if( '2' == op) {
           bst_preorder(b, print_key);
        }
    }
    bst_free(b);
    return EXIT_SUCCESS;
}