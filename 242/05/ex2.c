#include <stdio.h>
#include <stdlib.h>

#define OCEAN_MAX 41981

struct ocean_datum {
    int x;       /* grid-reference east-west                             */
    int y;       /* grid-reference north-south                           */
    double conc; /* concentration of O_2 in mL/L found at grid-ref (x,y) */
};
    
void print_ocean_datum(struct ocean_datum *o) {
    printf("%d %d %.4f\n", o->x, o->y, o->conc);
}
    
int read_ocean_datum(struct ocean_datum *o) {
    return 3 == scanf("%d %d %lg", &o->x, &o->y, &o->conc);
}

void insertion_sort(struct ocean_datum *o, int n) {
    int i;
    struct ocean_datum key;
    int j;
    /*For each position p in array a except the first.*/
    for (i = 1; i < n; i++) {
        /*Pull out the item at p, and store it in variable key.*/
        key = o[i];
        /*For all items that are to the left of position p,
        and greater than key, move it right.*/
        for (j = i - 1; (o[j].conc > key.conc && j >= 0); j--){

            o[j+1] = o[j];
        }
        /*Put key in the leftmost vacated position.*/
        o[j+1] = key;
    }
}

    
int main(void) {
    struct ocean_datum ocean_data[OCEAN_MAX];
    int num_items;
    int i;
    num_items = 0;
    
    while (num_items < OCEAN_MAX && read_ocean_datum(&ocean_data[num_items])) {
        num_items++;
    }/* sort the data here */
    insertion_sort(ocean_data, num_items);
    /* print out the array of structs */
    for (i = 0; i < num_items; i++) {
        print_ocean_datum(&ocean_data[i]);
        }
    return EXIT_SUCCESS;
}
