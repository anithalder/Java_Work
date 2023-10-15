class factorial{
	
	int n = 5,i,f = 1;
	
	public void fact(){
		for(i = 1;i <= n;i++){
			f = f * i;
		}
		System.out.println("The factorial of "+n+" is: "+f);
	}
	
	public static void main(String[] args){
		factorial f1 = new factorial();
		f1.fact();
	}
	
}