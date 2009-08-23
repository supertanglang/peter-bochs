#include <stdio.h>

#define BOCHS_PATH "/root/workspace/peter-bochs/bochs -f bochsrc.bxrc"
FILE *writepipe, *readpipe, p_step;
int bochs_pid;
unsigned int bochs_offline;

unsigned int popen2( char *command, FILE **in, FILE **err ){
        int ifd[2], efd [2];

        if(in != NULL) pipe(ifd);
        if(err != NULL) pipe(efd);

        bochs_pid = fork();
        if(bochs_pid == -1) return(0);
        if(bochs_pid == 0){
                char *argv[4];
                argv[0] = "sh";
                argv[1] = "-c";
                argv[2] = command;
                argv[3] = 0;
		//printf("CHILD-%d\n", bochs_pid);
                if(in != NULL) dup2(ifd[0], stdin);
                if(err != NULL) dup2(efd[1], stderr);
		setbuf(stdout, NULL);
		//fflush(stdout);
                //freopen("/dev/null", "a", stdout);
                execv("/bin/sh", argv);
        } else {
		//printf("PARENT-%d\n", bochs_pid);
                if(err != NULL) *err = fdopen(efd[0], "r");
                if(in != NULL) *in = fdopen(ifd[1], "w");
        }
        return(1);
}

void prompt_read( ){
        char c;

        if(bochs_offline) return;

        //printf("BFE DEBUG: reading prompt... \n");

        for(c = fgetc(readpipe); c != '<' && c != EOF; c = fgetc(readpipe)){
		//printf("%c\n",c);
	}
        if(c != '<'){
		//printf("return\n");
		return;
	}
        if(fscanf(readpipe, "bochs:%u>", &p_step) != 1){
		//printf("return 2\n");
		return;
	}

        //printf("\tOK\n");
}

int main(){
	if(!popen2(BOCHS_PATH, &writepipe, &readpipe)){
                printf("BOCHS FAILED TO START");
                return 1;                 // failed to start bochs
        }
	sleep(1);
	bochs_offline=0;
        setbuf(readpipe, NULL);         // disable line buffering
        setbuf(writepipe, NULL);
	prompt_read();
	fprintf(writepipe, "s\n");
	return 0;
}
