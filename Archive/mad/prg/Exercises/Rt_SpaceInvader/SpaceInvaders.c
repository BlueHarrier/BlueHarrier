#include <stdio.h>
#include <stdlib.h>

// Esta weá funciona, pero por algún motivo no lo coge Acepta el Reto

int main(){
    int cases;
    scanf("%d", &cases);
    while (cases-- > 0){
        int records;
        scanf("%d", &records);
        int doubleRecords = records * 2;
        char* output = (char*) malloc(records * 3);
        int i = 0;
        while (i < records){
            char name[] = "___";
            scanf("%s", &name);
            output[i] = name[0];
            output[i + records] = name[1];
            output[i + doubleRecords] = name[2];
            i++;
        }
        printf("%s", output);
        free(output);
    }
    return 0;
}