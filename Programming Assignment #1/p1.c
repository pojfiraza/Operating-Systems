#include <stdio.h>

const char * dox[] = {"cd","dir","type","del","ren","copy"};
const char * unix[] = {"cd","ls","cat","rm","mv","cp"};

int main(int argc, char *argv[])
{
    for(int x = 0; x<6; x++){
        int y = strcmp(argv[1],dox[x]);
        if(y == 0){
            system(unix[x]);
            break;
        }
        else if (x == 5){
            printf("Invalid Command ");
        }
    }
    return 0;
}