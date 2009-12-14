int add(int x) {
	int y = 123;
	x = x * x;
	y = y * x;
	return y;
}

int main() {
	int z = 12345;
	int y = add(z);
	int abc = sub(y);
	abc = love(abc);
	return 0;
}
