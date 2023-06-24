#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define ARRAY_SIZE 10

double mean(double s[ARRAY_SIZE], int i){
    double avg = 0.0;
    int a = 0;
    for(a = 0; a < i; a++){
        avg += s[a];
    }
    return avg/i;
}

double stand(double s[ARRAY_SIZE], int i, double avg){
    double sd = 0.0;
    int a = 0;
    for(a = 0; a < i; a++){
        sd += pow((s[a] - avg), 2);
    }
    return sqrt(sd/(i-1));
}

int main(void){
    int reg = 0;
    double a = 0;
    double b = 0;
    double c = 0;
    int i = 0;
    double j1[ARRAY_SIZE];
    double j2[ARRAY_SIZE];
    double j3[ARRAY_SIZE];
    while(4 == scanf("%d %lg %lg %lg", &reg, &a, &b, &c) && i <= ARRAY_SIZE){
        j1[i] = a;
        j2[i] = b;
        j3[i] = c;
        i++;
    }
    /*reusing a b c variables for avg */
    a = mean(j1, i);
    b = mean(j2, i);
    c = mean(j3, i);
    
    printf("\t     Average  SD\n");
    printf("JUDGE1: %8.1f %8.1f\n", a, stand(j1, i, a));
    printf("JUDGE2: %8.1f %8.1f\n", b, stand(j2, i, b));
    printf("JUDGE3: %8.1f %8.1f\n", c, stand(j3, i, c));
    
    return EXIT_SUCCESS;
    
}


