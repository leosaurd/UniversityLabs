#include <stdlib.h>
#include <stdio.h>
#include "queue.h"
#include "mylib.h"

#define ARRAY_MAX 5

struct queue {
    double *items;
    int head;
    int capacity;
    int num_items;
};

queue queue_new(){
    queue result = emalloc(sizeof *result);

    result->head = 0;
    result->capacity = ARRAY_MAX;
    result->num_items = 0;
    result->items = emalloc(ARRAY_MAX * sizeof (double));
    return result;
}

void enqueue(queue q, double i){
    if(q->num_items < q->capacity){
        q->items[((q->head + q->num_items) % q-> capacity)] = i;
        q->num_items++;
    }
    return;
}

double dequeue(queue q){
    double temp;
    if(q->num_items>0){
    	temp = q->items[q->head];
        q->head++;
        q->num_items--;
        return temp;
    }
    return EXIT_FAILURE;
}

void queue_print(queue q){
    int i;
    for(i = 0; i < q->num_items; i++){
        printf("%f\n", q->items[i]);
    }
}

int queue_size(queue q){
    return q->num_items;
}

queue queue_free(queue q){
    free(q->items);
    free(q);
    return q;
}