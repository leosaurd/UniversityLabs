#include <stdio.h>
#include <stdlib.h>
#include <getopt.h>
#include <string.h>
#include <time.h>
#include "mylib.h"
#include "tree.h"

/**
 *  A program to demonstrate a combined Abstract Data Type,
 * based upon the link between a Binary Search Tree and 
 * Red Black Tree. To assist the program in prioritising options,
 * "flags" are utilized via integers.
 * 
 * Created by Oliver, Samuel & Josh.
 */

/**
 * A static function to print the variables given.
 * 
 * @param freq an integer representing the frequency provided.
 * @param word an character array representing the word provided.
 */
static void print_info(int freq, char *word) {
    printf("%-4d %s\n", freq, word);
}

/**
 *  The main function that allows a user to interact with and pass in arguments
 * to the supporting abstract data type.
 * 
 * @param argc an integer representing the location of the argument.
 * @param argv a string array representing the input of the user.
 * 
 * @return returns an EXIT_SUCCESS upon proper execution of the program.
 */
int main(int argc, char **argv) {
    int c = 0;
    int d = 0;
    int f = 0;
    int o = 0;
    int unknown_count = 0;
    char opt;
    char name[] = "tree-view.dot";
    char word[256]; /* !!check word length max */
    const char *optstring = "c:df:orh";
    double search_time = 0;
    double fill_time = 0;
    clock_t start, stop;
    tree_t r = BST;
    FILE *cfile = NULL;
    FILE *ffile = NULL;
    tree t = NULL;

    while ((opt = getopt(argc, argv, optstring)) != EOF) {
        switch (opt) {
            case 'c':
                c = 1;
                if (NULL == (cfile = fopen(optarg, "r"))) {
                    fprintf(stderr, "Can't find file %s\n", optarg);
                    return EXIT_FAILURE;
                }
                break;
            case 'd':
                d = 1;
                break;
            case 'f':
                f = 1;
                strcpy(name, optarg);
                break;
            case 'o':
                o = 1;
                break;
            case 'r':
                r = RBT;
                break;
            case 'h':
            default:
                fprintf(stdout, "Usage: ./asgn [OPTION]... <STDIN>");
                fprintf(stdout, "\n\n");
                fprintf(stdout, "Perform various operations using");
                fprintf(stdout, "a binary tree.  By default, words\n");
                fprintf(stdout, "are read from stdin ");
                fprintf(stdout, "and added to the tree, ");
                fprintf(stdout, "before being printed out\n");
                fprintf(stdout, "alongside their frequencies to stdout.");
                fprintf(stdout, "\n\n");
                fprintf(stdout, " -c FILENAME  Check spelling of words in");
                fprintf(stdout, " FILENAME using words\n\t      read from ");
                fprintf(stdout, "stdin as the dictionary.  Print timing\n");
                fprintf(stdout, "\t      info & unknown words to stderr");
                fprintf(stdout, "(ignore -d & -o)\n");
                fprintf(stdout, " -d\t      Only print the tree");
                fprintf(stdout, "depth (ignore -o)\n");
                fprintf(stdout, " -f FILENAME  Write DOT output to FILENAME");
                fprintf(stdout, "(if -o given)\n");
                fprintf(stdout, " -o\t      Output the tree in DOT form to");
                fprintf(stdout, "file 'tree-view.dot'\n");
                fprintf(stdout, " -r\t      Make the tree an RBT (the");
                fprintf(stdout, "default is a BST)\n\n");
                fprintf(stdout, " -h\t      Print this message\n");
                return EXIT_SUCCESS;
        }
    }

    start = clock();
    while (getword(word, sizeof word, stdin) != EOF) {
        t = tree_insert(t, word, r);
    }
    stop = clock();

    fill_time = (stop - start) / (double) CLOCKS_PER_SEC;
    tree_root_black(t);

    if (c == 1) {
        d = 0;
        o = 0;
        /* read from cfile */
        start = clock();
        while (getword(word, sizeof word, cfile) != EOF) {
            /* check each word is in the tree*/
            /* if in tree, do nothing, if not print to stdout */
            if (tree_search(t, word) == 0) {
                unknown_count++;
                fprintf(stdout, "%s\n", word);
            }
            stop = clock();
            search_time = (stop - start) / (double) CLOCKS_PER_SEC;
            /* when finished checking filename,
             print timing info and unkown word count to stderr*/
        }
        fprintf(stderr, "Fill time : %f\n", fill_time);
        fprintf(stderr, "Search time : %f\n", search_time);
        fprintf(stderr, "Unknown count : %d\n", unknown_count);
        fclose(cfile);
    }

    if (d == 1) {
        f = 0;
        o = 0;
        r = 0;
        printf("%d\n", tree_depth(t));
    }

    if (o == 1) {
        if (f == 0) {
            printf("Creating dot file tree-view.dot\n");
            ffile = fopen("tree-view.dot", "w");
        } else {
            printf("Creating dot file %s\n", name);
            ffile = fopen(name, "w");
        }
        tree_output_dot(t, ffile);
        fclose(ffile);

    }

    if (d == 0 && o == 0 && c == 0) {
        tree_preorder(t, print_info);
    }
    /* close the files */
    tree_free(t);

    return EXIT_SUCCESS;

}
