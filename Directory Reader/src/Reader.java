/* 
*	Problem: Please write a program that can read the contents of any directory (and its subdirectories) in the
	filesystem, and display the contents sorted in order of file size to System.out. The directory to search
	should be passed as a parameter to the “main” method of the program.
	The output should show the full path of the file, the file name, and the file size.
	
	Input: directory - String, directory in which to search
	
	Output: Full file path, name, and size. 
	
*/

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Scanner;

public class Reader {
	public static void search_directory(String directory, ArrayList<File> file_list) {
		File [] files;
		
		try {
			File file_object = new File(directory);
			files = file_object.listFiles();
			
			for(File file: files) {
				
				if(file.isDirectory()) {
					search_directory(file.getPath(), file_list);
				}
				file_list.add(file);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void open__home_directory(String directory) {		
		ArrayList<File> files = new ArrayList<File>();
		search_directory(directory, files);
		
		// Sort list of files in directory by each file's size. 
		Collections.sort(files, new Comparator<File>() {

			@Override
			public int compare(File o1, File o2) {
				return (int) (o1.length() - o2.length());
			}
			
		});
		
		// Output: Print File path, name, and size in order from smallest file to largest (inclusive of directories). 
		for(File file: files) {
			System.out.println("FilePath: "+ file.getPath() + " , FileName: " + file.getName() +" , Size: " + file.length());
		}
	}

	public static void main(String[] args) {
		// Retrieves directory to search from user. Ex. input: ../Directory Reader/
		Scanner io_reader = new Scanner(System.in);
		System.out.println("Enter a file path: ");
		String input = io_reader.nextLine();
		io_reader.close();
		open__home_directory(input);

	}

}
