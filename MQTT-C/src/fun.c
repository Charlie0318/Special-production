#include"Test.h"
#include<stdio.h>
#include<string.h>
#include"beecpabe.h"
#define SIZE 10
int bee_enc(unsigned char* pk_path, unsigned char* pt, unsigned char* policy_str, unsigned char** ct)
{
	printf("In ENC!\n");
	if(enc(pk_path,pt,policy_str,ct)==-1){
		printf("ENC ERROR!\n");
		return -1;

	}
	printf("ENC SUCCESS\n");
	return 0;
}
