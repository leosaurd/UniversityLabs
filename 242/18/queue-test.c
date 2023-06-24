#include <stdlib.h>
#include <stdio.h>
#include "queue.h"
#include "mylib.h"

int main(void){
    queue q = queue_new();
    
    int i;
    for(i = 1; i <= 5; i++){
    enqueue(q, i);
    queue_print(q);
    printf("\n");
    }
    dequeue(q);
    queue_print(q);
    
    queue_free(q);
    return EXIT_SUCCESS;
}