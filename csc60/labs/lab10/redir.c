#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

int main (void)
{
    int fileId;
    fileId = creat( "x.lis",0640 );
    if( fileId < 0 )  
    {  
	printf("error creating x.lis\n" ); 
	exit (EXIT_FAILURE);     
    }
    dup2( fileId, 1);      /* copy fileID to stdout */
    close( fileId );     		
    execl( "/bin/ls", "ls", 0 );
    exit (EXIT_SUCCESS);
}
