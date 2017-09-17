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
int bee_dec(unsigned char* pk_path, unsigned char* sk_path, unsigned char* ct, unsigned char** pt)
{
	printf("In fun bee_dec ct = %u\n",ct);
	printf("In fun bee_dec pt = %u\n",pt);	
	printf("In DEC!\n");
		
	if(dec(pk_path,sk_path,ct,pt)==-1){
		printf("DEC FAIL\n");
		return -1;
	}
	printf("DEC SUCCESS\n");
	printf("In fun bee_dec pt = %u\n",pt);	
	return 0;
}
