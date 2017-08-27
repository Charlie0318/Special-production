#include"Test.h"
#include<stdio.h>
#include<string.h>
#include"beecpabe.h"
#define SIZE 10
int bee_enc()
{
	if(setup("/home/wei/Desktop/cpabe_publickey","/home/wei/Desktop/cpabe_masterkey")==-1){
		printf("SETUP ERROR!\n");
		return -1;
	}
	printf("SETUP SUCCESS\n");
	return 0;
}
