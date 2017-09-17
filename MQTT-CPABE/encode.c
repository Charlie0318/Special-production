#include<stdio.h>	

int encode(char* buf,int length)
{
	int rc = 0;
	do
	{	
                char d = length % 128;
                length /= 128;
                if(length > 0)
                {
                        d |= 0x80;
                }
                buf[rc++] = d;
	}while (length > 0);
	return rc;
}
