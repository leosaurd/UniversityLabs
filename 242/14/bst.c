#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "mylib.h"
#include "bst.h"

struct bst_node {
 char *key;
 bst left;
 bst right;
};

bst bst_new(){
    return NULL;
}

bst bst_delete(bst b, char *str){
    int cmp = strcmp(str, b->key);
    bst temp = NULL;
    if(NULL == b || bst_search(b, str) == 0){
        return b;
    } else if(cmp < 0){
        b->left = bst_delete(b->left, str);
    } else if(cmp > 0){
        b->right = bst_delete(b->right, str);
    } else {
        if(b->left == NULL && b->right == NULL){
            free(b->key);
            free(b);
            b = NULL;
        } else if(b->left != NULL){
            free(b->key);
            temp = b->left;
            free(b);
            b = temp;
        } else if(b->right != NULL){
            free(b->key);
            temp = b->right;
            free(b);
            b = temp;
        } else {
            char *s;
            temp = b->right;
            while(temp->left != NULL){
                temp = temp->left;
            }
            s = temp->key;
            temp->key = b->key;
            b->key = s;
            b->right = bst_delete(b->right, s);
        }
    }
    return b;
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

int bst_search(bst b, char *str){
    if(NULL == b){
        return 0;
    } 
    if(strcmp(b->key, str)== 0){
        return 1;
    } else if(strcmp(b->key, str)> 0){
        return (bst_search(b->left, str));
    } else {
        return (bst_search(b->right, str));
    }
}

