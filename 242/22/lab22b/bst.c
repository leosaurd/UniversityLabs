#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "mylib.h"
#include "bst.h"

struct bstnode { /* should live in bst.c */
char *key;
bst left;
bst right;
};

bst bst_new(){
    return NULL;
}

int bst_search(bst b, char *key){
    if(b==NULL){
       return 0;
    }
    if(strcmp(b->key, key) == 0){
        return 1;
    } else if(strcmp(b->key, key) > 0){
       return(bst_search(b->left, key));
    } else {
       return(bst_search(b->right, key));
    }
}

bst bst_free(bst b){
    if(b==NULL) return b;
    bst_free(b->right);
    bst_free(b->left);
    free(b->key);
    free(b);
    return b;
}

bst bst_insert(bst b, char *str){
    if(NULL == b){
        b = emalloc(sizeof *b);
        b->left = NULL;
        b->right = NULL;
        b->key = emalloc(strlen(str)+1);
        strcpy(b->key, str);
    } else if(strcmp(b->key, str) > 0){
        b->left = bst_insert(b->left, str);
    } else if(strcmp(b->key, str) < 0){
        b->right = bst_insert(b->right, str);
    }
    return b;
}

void bst_preorder(bst b, void f(char *str)){
    if(NULL==b){
        return;
    } else {
        f(b->key);
        bst_preorder(b->left, f);
        bst_preorder(b->right, f);
    }
}

void bst_inorder(bst b, void f(char *str)){
    if(NULL==b){
        return;
    } else {
        bst_inorder(b->left, f);
        f(b->key);
        bst_inorder(b->right, f);
    }
}