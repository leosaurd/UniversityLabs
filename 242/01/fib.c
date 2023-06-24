#include <stdio.h>
#include <stdlib.h>
#include <math.h>

    int main(void) {
    /* variable declarations */
    int i = 1;
    int f = 0;
    int g = 1;
    int h = 0;
    /* a familiar "for loop" */
    for (i = 1; i <= 40; i++) {
        printf("%d ", g); /* sqrt defined in math.h */
        h = g;
        g += f;
        f = h;
        if(i % 5 == 0){
            printf("\n");
        }
    }
    
    return EXIT_SUCCESS; /* defined in stdlib.h */}
