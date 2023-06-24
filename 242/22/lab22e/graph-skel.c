#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "graph.h"
#include "mylib.h"
#include "queue.h"

typedef enum state {
    UNVISITED, VISITED_SELF, VISITED_DESCENDENTS
} state_t;

struct vertexrec {
    int predecessor;
    int distance;
    state_t state;
    int finish;
};

struct graphrec {
    int **edges;
    int size;
    vertex *vertices;
};


graph graph_new(int num_vertices) {
    int i;
    int j;
    graph g = emalloc(sizeof (*g));
    g->size = num_vertices;
    g->vertices = emalloc(g->size * sizeof g->vertices[0]);
    g->edges = emalloc(g->size * sizeof g->edges[0]);
    for(i = 0; i < num_vertices; i++){
        g->edges[i] = emalloc(g->size * sizeof g->edges[0][0]);
        for(j=0; j < num_vertices; j++){
            g->edges[i][j] = 0;
        }
    }
    return g;
}
graph graph_free(graph g) {
    int i; 
    for(i = 0; i < g->size; i++){
        free(g->edges[i]);
    }
    free(g->edges);
    free(g->vertices);
    free(g);
    return g;
}
void graph_add_2edges(graph g, int u, int v) {
    g->edges[u][v] = 1;
    g->edges[v][u] = 1;
}
void graph_add_edge(graph g, int u, int v) {
    g->edges[u][v] = 1;
}
void graph_print_list(graph g) {
    int i = 0;
    int j = 0;
    int count;
    printf("adjacency list:\n");
    for(i = 0; i < g->size; i++){
        printf("%d | ", i);
        count = 0;
        for (j = 0; j < g->size; j++){
            if(g->edges[i][j] == 1){
                count == 0 ? printf("%d", j) : printf(", %d",j);
                count++;
                
            }
        }
        printf("\n");
    }
}

void graph_print_state(graph g) {
    int i;
    printf("vertex distance pred\n");
    for (i = 0; i < g->size; i++){
        printf("%5d%7d%6d\n", i, g->vertices[i].distance,
               g->vertices[i].predecessor);
    }
}

/* either */
void graph_bfs(graph g, int source) {
 queue q = queue_new(g->size);
    int i = -1;
    state_t unv = UNVISITED;
    state_t vis = VISITED_SELF;
    state_t vid = VISITED_DESCENDENTS;
    
    int u = -1;
   
    for(i = 0; i < g->size; i++) {
        g->vertices[i].state = unv;
        g->vertices[i].distance = -1;
        g->vertices[i].predecessor = -1;
    }

   g->vertices[source].state = vis;
   g->vertices[source].distance = 0;
   
   enqueue(q, source);

   while(queue_size(q) > 0) {
        u = dequeue(q);
        
        for(i = 0; i < g->size; i++) {
            if(g->edges[u][i] == 1 && g->vertices[i].state == unv) {
               g->vertices[i].state = vis;
               g->vertices[i].distance = 1 + g->vertices[u].distance;
               g->vertices[i].predecessor = u;
               enqueue(q, i);
            }
        }
        g->vertices[u].state = vid;
   }

   graph_print_state(g);
   q = queue_free(q);
}
