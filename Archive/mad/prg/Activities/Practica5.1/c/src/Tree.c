#include <stdio.h>

int calculateHeight(int height){
    int maxHeight = 0;
    while(height > 0){
        int nextHeight;
        scanf("%d", &nextHeight);
        int nextResult = calculateHeight(nextHeight);
        if (nextResult > maxHeight) maxHeight = nextResult;
        height--;
    }
    return maxHeight + 1;
}

int main(){
    int cases;
    scanf("%d", &cases);
    while(cases > 0){
        int startHeight;
        scanf("%d", &startHeight);
        int height = calculateHeight(startHeight);
        printf("%i\n", height);
        cases--;
    }
}