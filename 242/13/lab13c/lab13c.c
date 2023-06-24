#include <stdio.h>
#include <stdlib.h>

void repeats(int *arr, int n){
    int *repeats;
    int i = 0;
    repeats = malloc(n * sizeof(int));
    for(i = 0; i < n; i++) repeats[i] = 0;
    for(i = 0; i < n; i++) repeats[arr[i]]++;
    for(i = 0; i < n; i++) if(repeats[i] > 1) printf("%d occurs %d times\n", i, repeats[i]);
    free(repeats);
}

int main(void) {
int array_size = 0;
int *my_array;
int i = 0;
printf("Enter the size of the array:\n");
scanf("%d", &array_size);
my_array = malloc(array_size * sizeof my_array[0]);
if (NULL == my_array) {
fprintf(stderr, "memory allocation failed!\n");
return EXIT_FAILURE;
}
for (i = 0; i < array_size; i++) {
my_array[i] = rand() % array_size;
}
printf("What's in the array:\n");
for (i = 0; i < array_size; i++) {
printf("%d ", my_array[i]);
}
printf("\n");
repeats(my_array, array_size);
free(my_array);
return EXIT_SUCCESS;
}