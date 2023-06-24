#include <stdio.h>
#include <stdlib.h>

int main(void){
    int reg = 0, winner = 0;
    double a = 0.0, b = 0.0, c = 0.0, avg = 0.0;
    while (4 == scanf("%d %lg %lg %lg", &reg, &a, &b, &c)){
        if(avg < (a+b)/2 || avg < (a+c)/2 || avg < (b+c)/2){
            if(a<b && a<c){
                avg = (b+c)/2;
            } else if(b<a && b<c){
                avg = (a+c)/2;        
            } else {
                avg = (a+b)/2;
            }
            winner = reg;
        }
    }
    fprintf(stdout, "%d\n", winner);
    return EXIT_SUCCESS;
}