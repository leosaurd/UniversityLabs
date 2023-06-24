#include <stdio.h>
#include <stdlib.h>

int main(void){
    int reg = 0;
    double a = 0.0;
    double b = 0.0;
    double c = 0.0;
    double avg = 0.0;
    int winner = 0;
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
    printf("%d %f\n", winner, avg);
    return EXIT_SUCCESS;
}
