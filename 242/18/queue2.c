#include <stdlib.h>
#include <stdio.h>
#include "queue.h"
#include "mylib.h"

typedef struct q_item *q_item;

struct q_item {
    double item;
    q_item next;
};

struct queue {
    q_item first;
    q_item last;
    int length;
};

queue queue_new(){
    queue result = emalloc(sizeof *result);
    result->length = 0;
    /*Because the first is the last on initialization*/
    result->first = result->last = NULL;
    return result;
}

void enqueue(queue q, double i){
    /*create a q_item to place into the queue*/
    q_item t = emalloc(sizeof *t);
    t->item = i;
    t->next = NULL;
    /*if its the first item, else put it into the last slot*/
    if(q->length == 0){
        q->first = t;
    } else {
        q->last->next = t;
    }
    /*change where last is pointing to */
    q->last = t;
    q->length++;
}

double dequeue(queue q){
    /*FIFO so dequeue first*/
    q_item t = q->first;
    /*placeholder for value*/
    double i;
    if(t == NULL){
        return EXIT_FAILURE;
    }
    /*record value stored*/
    i = t->item;
    /*change pointer of first*/
    q->first = q->first->next;
    q->length--;
    /*free the unlinked(dequeued) value*/
    free(t);
    return i;

}

void queue_print(queue q){
    q_item t = q->first;
    while(NULL != t){
        printf("%f\n", t->item);
        t = t->next;
    }
}

int queue_size(queue q){
    return q->length;
}

queue queue_free(queue q){
    q_item t = q->first;
    while(NULL != t){
        q->first = q->first->next;
        free(t);
        t = q->first;
    }
    free(q);
    return q;
}