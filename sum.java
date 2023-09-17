class sum{
	
	int a = 3,b = 2,c = 0;
	
	public void add(){
		c = a + b;
		System.out.println("The Sum is:" + c);
	}
	
	public static void main(String[] args){
		sum obj = new sum();
		obj.add();
	}
}