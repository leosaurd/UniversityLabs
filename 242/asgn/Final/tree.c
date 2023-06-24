#include <stdio.h>
#include <stdlib.h>
#include "tree.h"
#include "mylib.h"
#include <string.h>

/**
 * A combined abstract data type of a binary search tree and red black tree.
 * 
 * Created by Oliver, Samuel & Josh.
 */

/**
 * Definition for whether the node being checked is black.
 */
#define IS_BLACK(x) ((NULL ==(x)) || (BLACK == (x)->colour))

/**
 * Definition for whether the node being checked is red.
 */
#define IS_RED(x) ((NULL != (x)) && (RED == (x)->colour))

/**
 * Type definition to determine a red black tree.
 */
typedef enum {
    RED, BLACK
} tree_colour;

/**
 * Structure of how a node in the tree is formed.
 */
struct tree_node {
        char *key;
        tree_colour colour;
        tree left;
        tree right;
        int frequency;
        tree_t tree_type;
};

/**
 * Tree function to create and initialize a node for the tree.
 * 
 * @param type is the parameter that defines if the tree created is a red black
 *        tree or a binary search tree.
 */
tree tree_new(tree_t type) {
    tree result = emalloc(sizeof *result);
    result->key = NULL;
    result->left = NULL;
    result->right = NULL;
    result->colour = RED;
    result->tree_type = type;
    result->frequency = 1;
    return result;
}

/**
 * Function that returns the depth of the tree, through recursive functions.
 * 
 * @param t is the tree that we wish to find the depth of.
 * 
 * @return returns an integer that represents the depth of the tree.
 */
int tree_depth(tree t) {
    int left_depth = 0;
    int right_depth = 0;
    if (t == NULL) {
        return -1;

    }
    left_depth = tree_depth(t->left);
    right_depth = tree_depth(t->right);
    if (left_depth > right_depth) {
        return left_depth + 1;
    } else {
        return right_depth + 1;
    }
}
/**
 * Function to determine if a value exists in the tree.
 * 
 * @param t is the tree to find the value in.
 * @param str is the word to be located.
 * 
 * @return returns 1 if the word exists, or 0 if the word does not.
 */
int tree_search(tree t, char *str) {
    if (NULL == t) {
        return 0;
    } else if (strcmp(t->key, str) == 0) {
        return 1;
    } else if (strcmp(t->key, str) > 0) {
        return tree_search(t->left, str);
    } else {
        return tree_search(t->right, str);
    }
}

/**
 * A function to print the tree in order using recursion.
 * 
 * @param t represents the tree to be printed.
 * @param f represents the function to be passed that will print the tree.
 */
void tree_inorder(tree t, void f(char *str)) {
    if (t == NULL) {
        return;
    }
    tree_inorder(t->left, f);
    f(t->key);
    if (t->tree_type == RBT) {
        if (IS_RED(t)) {
            f("red");
        } else {
            f("black");
        }
    }
    tree_inorder(t->right, f);
}

/**
 * A function to assist other functions in printing out a word.
 * This function is here to help with errors.
 * 
 * @param s represents the word to be printed.
 */
void tree_print_key(char *s) {
    printf("%s\n", s);
}

/**
 * A function to print the tree in a pre-ordered arrangement using recursion.
 * 
 * @param t represents the tree to be printed.
 * @param f represents the function to be passed in to assist in printing.
 */
void tree_preorder(tree t, void f(int freq, char *word)) {
    if (t == NULL) {
        return;
    }
    f(t->frequency, t->key);
    tree_preorder(t->left, f);
    tree_preorder(t->right, f);
}

/**
 * A tree function to free all allocated memory associated with the tree.
 * 
 * @param t represents the tree to be freed of memory allocation.
 * 
 * @return t represents the tree that is freed, and should return NULL
 *         after free is properly executed.
 */
tree tree_free(tree t) {
    if (t == NULL) {
        return t;
    }
    tree_free(t->left);
    tree_free(t->right);
    free(t->key);
    free(t);
    return t;
}

/**
 * A function to assist in fixing a red black tree through left rotation.
 * 
 * @param t represents the tree to be rotated/fixed.
 * 
 * @return t represents the fixed tree.
 */
static tree left_rotate(tree t) {
    tree temp = t;
    t = t->right;
    temp->right = t->left;
    t->left = temp;
    return t;
}

/**
 * A function to assist in fixing a red black tree through right rotation.
 * 
 * @param t represents the tree to be rotated/fixed.
 * 
 *  @return t represents the fixed tree.
 */
static tree right_rotate(tree t) {
    tree temp = t;
    t = t->left;
    temp->left = t->right;
    t->right = temp;
    return t;
}

/**
 * A function to fix the tree based upon the colors in a red black tree.
 * 
 * @param t represents the tree to be fixed.
 * 
 * @return t represents the tree that has been fixed.
 */
static tree tree_fix(tree t) {
    /* if t's left child and left-left grandchild are red: */
    if (IS_RED(t->left) && IS_RED(t->left->left)) {
        /*      if t's right child is red: */
        if (IS_RED(t->right)) {
            /*      colour b red and both children black */
            t->colour = RED;
            t->left->colour = BLACK;
            t->right->colour = BLACK;
        } else { /*    otherwise t's right child is black:
         right rotate t, colour new "t" black and new child red (t right
         child) */
            t = right_rotate(t);
            t->colour = BLACK;
            t->right->colour = RED;
        }
    } else if (IS_RED(t->left) && IS_RED(t->left->right)) {/* if t's left child
     and left-right grandchild are red: */
        /*if t's right child is red: */
        if (IS_RED(t->right)) {
            /* colour t red and both children black */
            t->colour = RED;
            t->left->colour = BLACK;
            t->right->colour = BLACK;
        } else { /* otherwise t's right child is black :
         left-rotate t's left child, then right rotate t,
         colour new root black and new child red (right) */
            t->left = left_rotate(t->left);
            t = right_rotate(t);
            t->colour = BLACK;
            t->right->colour = RED;
        }
    } else if (IS_RED(t->right) && IS_RED(t->right->left)) {/*if t's right
     child and right-left grandchild are red: */
        /* if t's left child is red: */
        if (IS_RED(t->left)) {
            /* colour t red and children black */
            t->colour = RED;
            t->left->colour = BLACK;
            t->right->colour = BLACK;
        } else { /* otherwise t's left child is black: */
            /*right rotate t's right child, left rotate t, colour new root
             black and new child red (left) */
            t->right = right_rotate(t->right);
            t = left_rotate(t);
            t->colour = BLACK;
            t->left->colour = RED;
        }
    } else if (IS_RED(t->right) && IS_RED(t->right->right)) { /*if t's right
     child and right-right grandchild are red: */
        /* if t's left child is red: */
        if (IS_RED(t->left)) {
            /* colour root red and both children black */
            t->colour = RED;
            t->left->colour = BLACK;
            t->right->colour = BLACK;
        } else { /* otherwise t's left child is black: */
            /* left rotate t, colour t black and new child (left) red */
            t = left_rotate(t);
            t->colour = BLACK;
            t->left->colour = RED;
        }
    }
    return t;
}

/**
 * A function to insert values into the tree.
 * 
 * @param t represents the tree a value is to be inserted into.
 * @param str is the word/key to be stored in the tree.
 * @param type is the value that determines if the tree created is
 *        a red black tree or binary search tree.
 *        
 * @return t is the tree that has executed the insertion successfully.
 */
tree tree_insert(tree t, char *str, tree_t type) {
    if (NULL == t) {
        t = tree_new(type);
        t->key = emalloc(strlen(str) + 1);
        strcpy(t->key, str);
    } else if (strcmp(t->key, str) == 0) {
        t->frequency++;
    } else if (strcmp(t->key, str) > 0) {
        t->left = tree_insert(t->left, str, type);
    } else {
        t->right = tree_insert(t->right, str, type);
    }
    if (type == RBT) {
        t = tree_fix(t);
    }
    return t;
}

/**
 * Traverses the tree writing a DOT description about connections, and
 * possibly colours, to the given output stream.
 *
 * @param t the tree to output a DOT description of.
 * @param out the stream to write the DOT output to.
 */
static void tree_output_dot_aux(tree t, FILE *out) {
    if (t->key != NULL) {
        fprintf(out, "\"%s\"[label=\"{<f0>%s:%d|{<f1>|<f2>}}\"color=%s];\n",
                t->key, t->key, t->frequency,
                (RBT == t->tree_type && RED == t->colour) ? "red" : "black");
    }
    if (t->left != NULL) {
        tree_output_dot_aux(t->left, out);
        fprintf(out, "\"%s\":f1 -> \"%s\":f0;\n", t->key, t->left->key);
    }
    if (t->right != NULL) {
        tree_output_dot_aux(t->right, out);
        fprintf(out, "\"%s\":f2 -> \"%s\":f0;\n", t->key, t->right->key);
    }
}

/**
 * Output a DOT description of this tree to the given output stream.
 * DOT is a plain text graph description language (see www.graphviz.org).
 * You can create a viewable graph with the command
 *
 *    dot -Tpdf < graphfile.dot > graphfile.pdf
 *
 * You can also use png, ps, jpg, svg... instead of pdf
 *
 * @param t the tree to output the DOT description of.
 * @param out the stream to write the DOT description to.
 */
void tree_output_dot(tree t, FILE *out) {
    fprintf(out, "digraph tree {\nnode [shape = Mrecord, penwidth = 2];\n");
    tree_output_dot_aux(t, out);
    fprintf(out, "}\n");
}

void tree_root_black(tree t) {
    t->colour = BLACK;
}
