package studentRecordsBackup.driver;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.util.BSTBuilder;


public class Driver {
	public static void main(String[] args){
		if(args==null || args.length==0){
			throw new IllegalArgumentException("NO input file found & No Increment Value, Two Argument Required");
		}else if(args.length<2 || args.length>2){
			throw new IllegalArgumentException("Two argument are required. <InputFile> <Increment Value>");
		}else if(args.length==2){
			String inputFile=args[0].toString();
			int incrementValue=0;

			try{
				 incrementValue=Integer.parseInt(args[1]);
			}catch(NumberFormatException e){
				System.err.println("Increment Number format is incorrect");
				e.printStackTrace();
				System.exit(1);
			}catch(Exception e){
				System.err.println("Problem in format of incrementing Value");
				e.printStackTrace();
				System.exit(1);
			}
			
			
			BST main = new BST();    //check this
			BST backup1 = new BST();
			BST backup2 = new BST();
			BSTBuilder mainBuilder = new BSTBuilder(inputFile, main, backup1, backup2);
			mainBuilder.readInsert(); // read input file and insert values into all three trees
			
			main.inorder(); // printing the tree values inorder
			backup1.inorder();
			backup2.inorder();
			
			
			main.printBSum(); // printing the tree sums
			backup1.printBSum();
			backup2.printBSum();
			
			main.updateTree(incrementValue); // increment the tree with given value
			
			main.inorder(); // printing the tree values after incrementing the inorder function
			backup1.inorder();
			backup2.inorder();
			
			main.printBSum(); // printing the tree sum after 
			backup1.printBSum();
			backup2.printBSum();
			
			
		}
	
		

	}
	
	
}
