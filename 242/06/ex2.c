#include <stdio.h>
#include <stdlib.h>

int factorial(int num) {
    if(num==0){
        return 1;
    } else {
        return num*factorial(num-1);
    }
}/*it blows out at 17, where it starts to overflow.*/

int main() {
    int num;
    while (1 == scanf("%d", &num)) {
        printf("%d\n", factorial(num));
    }
    return EXIT_SUCCESS;
}
