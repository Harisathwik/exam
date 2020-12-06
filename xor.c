#include <stdio.h>
#include <string.h>

int main() {
    // Write C code here
    char* mes = "Helloworld";
    char ct[20];
    puts(mes);
    for(int i=0;i<strlen(mes);i++)
    {
       ct[i] = mes[i]^0;
    }
   for(int i=0;i<strlen(mes);i++)
   {
       printf("%c",ct[i]);
   }
    return 0;
}
