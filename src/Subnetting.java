
public class Subnetting {
	
	public Subnetting(){
		
	}
	
	public int binaryToDecimal(int binaryN){
		int powerOfTwo=1, deciConvert=0, binary;
		while(binaryN>0){
			binary=binaryN%10;
			binaryN/=10;
			deciConvert+=binary*powerOfTwo;
			powerOfTwo*=2;
		}
		return deciConvert;
	}
	
	public String decimalToBinary(int decimalN){
		int b128, b64, b32, b16, b8, b4, b2, b1;
		String converted="";
				b128= decimalN/128;
			    decimalN= decimalN%128;
			    b64= decimalN/64;
			    decimalN= decimalN%64;
			    b32= decimalN/32;
			    decimalN= decimalN%32;
			    b16= decimalN/16;
			    decimalN= decimalN%16;
			    b8= decimalN/8;
			    decimalN= decimalN%8;
			    b4= decimalN/4;
			    decimalN= decimalN%4;
			    b2= decimalN/2;
			    decimalN= decimalN%2;
			    b1=decimalN;
			    
			    converted= converted+b128+""+b64+""+b32+""+b16+""+b8+""+b4+""+b2+""+b1;
			    return converted;
	}
	
	public String binaryFormWithPeriod(int n1,int n2,int n3, int n4){
			String boct1=this.decimalToBinary(n1);
			String boct2=this.decimalToBinary(n2);
			String boct3=this.decimalToBinary(n3);
			String boct4=this.decimalToBinary(n4);
			
			String boct5=boct1+"."+boct2+"."+boct3+"."+boct4;
			System.out.println(boct5);
			return boct5;
	}
	
	public String binaryFormNoPeriod(int n1,int n2,int n3, int n4){
		String boct1=this.decimalToBinary(n1);
		String boct2=this.decimalToBinary(n2);
		String boct3=this.decimalToBinary(n3);
		String boct4=this.decimalToBinary(n4);
		
		String boct5=boct1+boct2+boct3+boct4;
		System.out.println(boct5);
		return boct5;
}

	

}
