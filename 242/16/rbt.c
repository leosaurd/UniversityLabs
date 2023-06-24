#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "mylib.h"
#include "rbt.h"

#define IS_BLACK(x) ((NULL == (x)) || (BLACK == (x)->colour))
#define IS_RED(x) ((NULL != (x)) && (RED == (x)->colour))

struct rbt_node {
    char *key;
    rbt_colour colour;
    rbt left;
    rbt right;
};

rbt rbt_new(){
    return NULL;
}

rbt rbt_delete(rbt b, char *str){
    int cmp = strcmp(str, b->key);
    rbt temp = NULL;
    if(NULL == b || rbt_search(b, str) == 0){
        return b;
    } else if(cmp < 0){
        b->left = rbt_delete(b->left, str);
    } else if(cmp > 0){
        b->right = rbt_delete(b->right, str);
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
            b->right = rbt_delete(b->right, s);
        }
    }
    return b;
}

rbt rbt_free(rbt b){
    if(b==NULL) return b;
    rbt_free(b->right);
    rbt_free(b->left);
    free(b->key);
    free(b);
    return b;
}

static rbt right_rotate(rbt b){
    rbt temp = b;
    b = b->left;
    temp->left = b->right;
    b->right = temp;
    return b;
}

static rbt left_rotate(rbt b){
    rbt temp = b;
    b = b->right;
    temp->right = b->left;
    b->left = temp;
    return b;
}

static rbt rbt_fix(rbt b){
    if(IS_RED(b->left) && IS_RED(b->left->left)){
            if (IS_RED(b->right)){
                b->colour = RED;
                b->left->colour = BLACK;
                b->right->colour = BLACK;
            } else {
                b = right_rotate(b);
                b->colour = BLACK;
                b->right->colour = RED; 
            }
    } else if(IS_RED(b->left) && IS_RED(b->left->right)){
            if(IS_RED(b->right)){
                b->colour = RED;
                b->left->colour = BLACK;
                b->right->colour = BLACK;
            } else {
                b->left = left_rotate(b->left);
                b = right_rotate(b);
                b->colour = BLACK;
                b->right->colour = RED;
            }
    } else if(IS_RED(b->right) && IS_RED(b->right->right)){
        
            if (IS_RED(b->left)){
                b->colour = RED;
                b->left->colour = BLACK;
                b->right->colour = BLACK;
            } else {
                b = left_rotate(b);
                b->colour = BLACK;
                b->right->colour = RED; 
            }
    } else if(IS_RED(b->right) && IS_RED(b->right->left)){
            if(IS_RED(b->left)){
                b->colour = RED;
                b->left->colour = BLACK;
                b->right->colour = BLACK;
            } else {
                b->right = right_rotate(b->right);
                b = left_rotate(b);
                b->colour = BLACK;
                b->left->colour = RED;
            }
    }
    return b;
}

rbt rbt_insert(rbt b, char *str){
    if(NULL == b){
        b = emalloc(sizeof *b);
        b->colour = RED;
        b->left = NULL;
        b->right = NULL;
        b->key = emalloc(strlen(str)+1);
        strcpy(b->key, str);
    } else if(strcmp(b->key, str) > 0){
        b->left = rbt_insert(b->left, str);
    } else if(strcmp(b->key, str) < 0){
        b->right = rbt_insert(b->right, str);
    }
    b = rbt_fix(b);
    return b;
}

void rbt_preorder(rbt b, void f(char *str)){
    if(NULL==b){
        return;
    } else {
        if(IS_RED(b)){
            printf("red: \t");
        } else {
            printf("black: \t");
        }
        f(b->key);
        rbt_preorder(b->left, f);
        rbt_preorder(b->right, f);
    }
}

void rbt_inorder(rbt b, void f(char *str)){
    if(NULL==b){
        return;
    } else {
        rbt_inorder(b->left, f);
        f(b->key);
        rbt_inorder(b->right, f);
    }
}

int rbt_search(rbt b, char *str){
    if(NULL == b){
        return 0;
    } 
    if(strcmp(b->key, str)== 0){
        return 1;
    } else if(strcmp(b->key, str)> 0){
        return (rbt_search(b->left, str));
    } else {
        return (rbt_search(b->right, str));
    }
}

