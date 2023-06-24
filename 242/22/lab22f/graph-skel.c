#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "graph.h"
#include "mylib.h"

static int step;

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
                if(count == 0){ 
                    printf("%d", j);
                    count++;
                }
                else {
                    printf(", %d", j);
                    count++;
                }
            }
        }
        printf("\n");
    }
}

void graph_print_state(graph g) {
    int i;
    printf("vertex distance pred finish\n");
    for (i = 0; i < g->size; i++){
        printf("%5d%7d%6d%6d\n", i, g->vertices[i].distance,
               g->vertices[i].predecessor, g->vertices[i].finish);
    }
}

void visit(graph g, int v) {
    int u; 
    g->vertices[v].state = VISITED_SELF;
    step++;
    g->vertices[v].distance = step;
    for(u = 0; u < g->size; u++){
        if(g->edges[v][u] == 1 && g->vertices[u].state == UNVISITED){
            g->vertices[u].predecessor = v;
            visit(g, u);
        }
    }
    step++;
    g->vertices[v].state = VISITED_DESCENDENTS;
    g->vertices[v].finish = step;
}

void graph_dfs(graph g){
    int v = 0;
    for(v = 0; v < g->size; v++){
        g->vertices[v].state = UNVISITED;
        g->vertices[v].predecessor = -1;
    }
    step = 0;
    for(v = 0; v < g->size; v++){
        if(g->vertices[v].state == UNVISITED){
            visit(g, v);
        }
    }
}