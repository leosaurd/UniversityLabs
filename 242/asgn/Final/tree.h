#ifndef TREE_H_
#define TREE_H_

/*A type definition for the tree_node structure.*/
typedef struct tree_node *tree;

/*A type definition to enable the combined architecture of our ADT.*/
typedef enum tree_e {
    BST, RBT
} tree_t;


/* frees the memory for the node, the node's key and sets the node's pointer to
 NULL */
extern tree tree_free(tree t);

/* iterates through a tree in order, and applies function f to each node */
extern void tree_inorder(tree t, void f());

/* inserts value str into the tree b, creating a new node as necessary. returns
 b when complete */
extern tree tree_insert(tree t, char *str, tree_t type);

/* creates a new tree and sets all values to null */
extern tree tree_new();

extern void tree_output_dot(tree t, FILE *out);

/* iterates through the tree in a back-to-front order and applies function f
 to each node*/
extern void tree_preorder(tree t, void f());

/* search a tree b for key str and return 1 if found, else return 0 */
extern int tree_search(tree t, char *str);

/* prints a tree key at the currend node */
extern void tree_print_key(char *s);

/*prints the height of a tree */
extern int tree_depth(tree t);

/*sets node black */
extern void tree_root_black(tree t);

#endif
