import java.io.*;

class EBBill implements Serializable{
	int houseNo;
	String houseOwner;
	double startReading;
	double endReading;
	double billAmt;

	EBBill(){
		houseNo = 0;
		houseOwner = "";
		startReading=0.0;
		endReading = 0.0;
		billAmt = 0.0;
	}

	EBBill(int houseNo, String houseOwner, double startReading, double endReading, double billAmt){
		this.houseNo = houseNo;
		this.houseOwner = houseOwner;
		this.startReading = startReading;
		this.endReading = endReading;
		this.billAmt = billAmt;
	}

	public String toString(){
		return houseNo+" "+houseOwner+" "+startReading+" "+endReading+" "+billAmt;
	}
	

	void saveData()  throws Exception{
		// getting inputs
		DataInputStream din = new DataInputStream(System.in);
		System.out.print("Enter houseNo: ");
		int houseNo = din.readInt();
		System.out.print("Enter houseOwner: ");
		String houseOwner = din.readUTF();
		System.out.print("Enter startReading: ");
		double startReading = din.readDouble();
		System.out.print("Enter endReading: ");
		double endReading = din.readDouble();
		din.close();

		// saving into object and saving into file
		File f = new File("EBDetails.txt");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
		EBBill cus1 = new EBBill(houseNo,houseOwner,startReading,endReading, billAmt);
		out.writeObject(cus1);
		out.close();
	}
	
	void calculateBill(){
		double noUnits = endReading - startReading;
		if(noUnits <= 100)
			billAmt=0;
		else if((noUnits >100)&&(noUnits <= 200))
			billAmt=(noUnits-100)*0.75;
		else if((noUnits>200) && (noUnits<=300))
			billAmt=(noUnits-100)*0.75+(noUnits-200)*1.5;
		else
			billAmt=(noUnits-100)*0.75+(noUnits-200)*1.5+(noUnits-300)*3;
		
	}	
}


class EBBillDemo{
	public static void main(String args[]) throws Exception{
		EBBill array[] = new EBBill[4];
		for(int i=0; i<4; i++){
			array[i] = new EBBill();
			array[i].calculateBill();
			array[i].saveData();
		}

		File f = new File("EBDetails.txt");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		EBBill s1;
		
		for(int i=0; i<4; i++){
			s1 = (EBBill) in.readObject();
			System.out.println(s1);
		}

		in.close();
		
		
	}
}
