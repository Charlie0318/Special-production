#include<stdio.h>
#include"Test.h"
#include<string.h>
#include<stdlib.h>

struct
{
	const char struct_id[3];
	char* pub_key;
	char* priv_key;
	char* policy;
	int security;
	int uppercase;
} opts =
{
	"NOT", NULL , NULL , NULL , 1 , 0
};

int main(void)
{
	char* Payload = "check_";
	char j[6] = "";
        char header[6] ="";
        int i = 0;
	int number;
        int count;
        int counter=1;
        int output=0;
	int length = 0;
	unsigned char buff[4]={0,0,0,0};
	unsigned char* cipher ="EMPTY";
	
	Bee_BeeOptions test = Bee_BeeOptions_initializer;
	length=fun(Payload,&test,&cipher);
	printf("%d Bytes\n",length);
	test.security=6;
/*        number = test.security;
	Bee_BeeOptions test = Bee_BeeOptions_initializer;
	fun(Payload,&test);
	test.security = 6;
        number = test.security;
        while(number != 0)
        {
                count=number%2;
                output=output+count*counter;
                counter=counter*10;
                number=number/2;
        }
        if(test.security<32)
        {
                if(test.security<16)
                {
                        if(test.security<8)
                        {
                                if(test.security<4)
                                {
                                        if(test.security<2)
                                        {
                                                strcat(header,"0");
                                        }
                                        strcat(header,"0");
                                }
                                strcat(header,"0");
                        }
                        strcat(header,"0");
                }
                strcat(header,"0");
        }
        sprintf(j,"%d",output);
        strcat(header,j);
        printf("header = %s\n",header);
*/
	//length = length; //byte->bit
	int rc_M = 0;
	rc_M=encode(buff,length);

	for(i=0;i<rc_M;i++)
	{
		printf("%d\n",buff[i]);
	}
	printf("%s\n",cipher);
	//fun(Payload,&test);
	unsigned char* totalheader=malloc(1+length+rc_M);
	totalheader[0]=(unsigned char)test.security;
	printf("$$$%d$$$\n",totalheader[0]);
	for(i=0;i<rc_M;i++)
	{
		totalheader[i+1]=buff[i];
	}
	printf("$$$%d$$$\n",totalheader[1]);
	printf("$$$%d$$$\n",totalheader[2]);
	
	memcpy(totalheader+1+rc_M,&cipher,length);
	
	printf("$$$%d$$$\n",totalheader[3]);
	printf("$$$%d$$$\n",totalheader[4]);
	
	printf("Success!\n");
	return 1;
}
