# Introduction #

Forward port 0xffff to a log file

# Description #

By using peter-bochs instrument, if you write any value to port 0xffff, it will forward the value to a log file "os.log". You can use this feature and write kprintf, so that it will log your message.

![http://peter-bochs.googlecode.com/files/oslog.png](http://peter-bochs.googlecode.com/files/oslog.png)

# My simple kprintf #

```
int kprintf(const char* args, ...) {
	// !!!! the kmalloc is not ready here
	// backup args
	char tempArgs[1024];
	if (strlen(args) - 1 < 1024) {
		strcpy(tempArgs, args);
	} else {
		k_outStringToDisplay("print() error, args larger than 1024\n", 15);
		return;
	}
	// end backup args
	va_list ap;
	unsigned int index = 0;

	int d;
	unsigned int u;
	char c, *s;
	long ld;
	unsigned long lu;
	double lf;
	unsigned long long llu;
	long long lld;

	va_start(ap, args);

	char buffer[100];
	int numberOfSpace = 0;

	while (args[index]) {
		switch (args[index]) {
		case '%':
			if (index + 1 < strlen(args)) {
				index++;
				switch (args[index]) {
				case '-':
					if (index + 1 < strlen(args)) {
						unsigned int x;
						for (x = index + 1; x < strlen(args); x++) {
							if (!isdigit(args[x])) {
								break;
							}
						}

						char tempBuffer[100];
						if (x - index < 100) {
							strncpy(tempBuffer, args + index + 1, x - index - 1);
							tempBuffer[x - index - 1] = '\0';
						}
						numberOfSpace = convertToInt(tempBuffer) * -1;
						strcpy(args + index, args + x);
						index -= 2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					unsigned int x;
					for (x = index + 1; x < strlen(args); x++) {
						if (!isdigit(args[x])) {
							break;
						}
					}

					char tempBuffer[100];
					if (x - index < 100) {
						strncpy(tempBuffer, args + index, x - index);
						tempBuffer[x - index] = '\0';
					}
					numberOfSpace = atoi(tempBuffer);
					strcpy(args + index, args + x);
					index -= 2;
				}
					break;
				case 'u':
					u = va_arg(ap, unsigned int);
					itoa(u, buffer, 10);
					outStringToPort(DEBUG_PORT, buffer);
					numberOfSpace = 0;
					break;
				case 'd':
					d = va_arg(ap, int);
					itoa(d, buffer, 10);
					outStringToPort(DEBUG_PORT, buffer);
					numberOfSpace = 0;
					break;
				case 'x':
					d = va_arg(ap, int);
					//outStringToDisplay ("0x", 15);
					outHexToPort(DEBUG_PORT, d);
					numberOfSpace = 0;
					break;
				case 'X':
					d = va_arg(ap, int);
					//outStringToDisplay ("0x", 15);
					outHexToPort(DEBUG_PORT, d);
					numberOfSpace = 0;
					break;
				case 'l':
					if (index + 2 < strlen(args)) {
						if (args[index + 1] == 'l' && args[index + 2] == 'u') {
							llu = va_arg(ap, unsigned long long);
							outUnsignedLongLongToPort(DEBUG_PORT, llu);
							numberOfSpace = 0;
							index += 2;
							break;
						} else if (args[index + 1] == 'l' && args[index + 2]
								== 'd') {
							lld = va_arg(ap, long long);
							outUnsignedLongLongToPort(DEBUG_PORT, lld);
							numberOfSpace = 0;
							index += 2;
							break;
						}

					}
					if (index + 1 < strlen(args)) {
						if (*(args + index + 1) == 'd') {
							ld = va_arg(ap, long);
							outLongToPort(DEBUG_PORT, ld);
							numberOfSpace = 0;
							index++;
							break;
						} else if (*(args + index + 1) == 'u') {
							lu = va_arg(ap, unsigned long);
							outUnsignedLongToPort(DEBUG_PORT, lu);
							numberOfSpace = 0;
							index++;
							break;
						}
					} else {
						//printf("%%");
					}
					break;
				case 's': {
					s = va_arg(ap, char *);
					if (numberOfSpace > 0) {
						unsigned int n = numberOfSpace;
						while (numberOfSpace < strlen(s)) {
							numberOfSpace += n;
						}
						int x;
						for (x = 0; x < (int) (numberOfSpace - strlen(s)); x++) {
							outport(DEBUG_PORT, ' ');
						}
					}
					outStringToDisplay(s, 15);
					if (numberOfSpace < 0) {
						numberOfSpace = abs(numberOfSpace);
						unsigned int n = numberOfSpace;
						while (numberOfSpace < strlen(s)) {
							numberOfSpace += n;
						}
						int x;
						for (x = 0; x < (int) (numberOfSpace - strlen(s)); x++) {
							outport(DEBUG_PORT, ' ');
						}
					}
					numberOfSpace = 0;
					break;
				}
				case 'c':
					c = (char) va_arg(ap, int);
					switch (c) {
					case '\n':
						outport(DEBUG_PORT, '\n');
						break;
					case '\r':
						break;
					case '\t':
						outport(DEBUG_PORT, '\t');
						break;
					default:
						outport(DEBUG_PORT, c);
						numberOfSpace = 0;
					}
					break;
				case 'f':
					lf = va_arg(ap, double);
					//printf("%f", lf);
					break;
				default:
					outport(DEBUG_PORT, '%');
					numberOfSpace = 0;
					break;
				}
			}
			break;
		case '\n':
			outport(DEBUG_PORT, '\n');
			break;
		case '\r':
			break;
		case '\t':
			outport(DEBUG_PORT, '\t');
			break;
		default:
			outport(DEBUG_PORT, args[index]);
			//printf("%c",*(args+index));
			break;
		}
		index++;
	}

	// restore args
	strcpy(args, tempArgs);
	// end restore args
	return 0x123;
}
```

# My simple I/O routines #
```
void outport(unsigned short portNumber, unsigned char outputByte) {
	__asm__ __volatile__
	("outb  %%al,%%dx\n"::"a"(outputByte), "d"(portNumber));
}
```

<table border='0'><tr><td>
<a href='http://www.kingofcoders.com'><img src='http://www.kingofcoders.com/images/KOC_logo2.jpg' /></a>
</td>
<td>
</td>
<td>
<a href='http://www.rmit.edu.au/compsci'><img src='http://peter-bochs.googlecode.com/files/rmit.gif' /></a>
</td>
</tr>
</table>