#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int is_prime(int a){
    int i = 2;
    for(i = 2; i < a; i++){
        if(a%i == 0){
            return 0;
        }
    }
    return 1;
}

int main(void){
    int cand = 2;
    int num_printed = 0;
    while(num_printed < 100){
        if(is_prime(cand) == 1){
            printf("%d ", cand);
            num_printed = num_printed + 1;
        }
        cand = cand + 1;
    }
    return EXIT_SUCCESS;
}
