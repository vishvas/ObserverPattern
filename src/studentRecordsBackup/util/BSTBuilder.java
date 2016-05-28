package studentRecordsBackup.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.FileProcessor;
import studentRecordsBackup.bst.Node;

public class BSTBuilder {
	private FileProcessor fp=null;	
	private BST main=null,backup1=null,backup2=null;
	/**
	 * BSTBuilder constructor with inputs
	 * @param inputFile
	 * @param mainIn
	 * @param backup1In
	 * @param backup2In
	 */
	public BSTBuilder(String inputFile,BST mainIn, BST backup1In, BST backup2In) {
		this.main= mainIn;
		this.backup1=backup1In;
		this.backup2=backup2In;
		try { 								
			 fp = new FileProcessor(inputFile); 
		}catch(FileNotFoundException e){
			System.err.println("Entered File is not found");
			e.printStackTrace();
			System.exit(1);
		}catch(StreamCorruptedException e){
			System.err.println("File Stream can not be created");
			e.printStackTrace();
			System.exit(1);
		} 
		catch (Exception e) {
			System.err.println("Input file problem");
			e.printStackTrace();
			System.exit(1);
		}finally {}
	}
	/**
	 * Read input file and insert into trees
	 */
	public void readInsert(){
		String bNumber = fp.readLineFromFile();
		
		while(bNumber!=null){
			int number=0;
			try{
				number = Integer.parseInt(bNumber);
			}catch(NumberFormatException e){
				System.err.println("Input Number format is incorrect");
				e.printStackTrace();
				System.exit(1);
			}
			
			Node mainNode = new Node(number);
			Node backup1Node = new Node(number);
			Node backup2Node = new Node(number);
			
			mainNode.registerNode(backup1Node, new EvenFilterImpl());
			mainNode.registerNode(backup2Node, new OddFilterImpl());
			
			main.insert(mainNode);
			backup1.insert(backup1Node);
			backup2.insert(backup2Node);
			bNumber = fp.readLineFromFile();
		}
		
		try {
			fp.fileClose(); // file closing
		} catch (IOException e) {
			System.err.println("Unable to close file");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	
}
