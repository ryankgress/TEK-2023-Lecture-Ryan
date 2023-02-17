package com.tek.java.filestuffs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioExample {

	public static void main(String[] args) throws IOException {
		String[] inputFiles = {"C:\\Users\\ryank\\OneDrive - iup.edu\\Desktop\\TEK\\Development\\TEK-2023-Lecture\\ClassExamples\\src\\com\\tek\\java\\filestuffs\\file1.txt",
				"C:\\Users\\ryank\\OneDrive - iup.edu\\Desktop\\TEK\\Development\\TEK-2023-Lecture\\ClassExamples\\src\\com\\tek\\java\\filestuffs\\file2.txt"};
		
		String outputFile = "C:\\Users\\ryank\\OneDrive - iup.edu\\Desktop\\TEK\\Development\\TEK-2023-Lecture\\ClassExamples\\src\\com\\tek\\java\\filestuffs\\NioOutput.txt";
		
		FileOutputStream fos = new FileOutputStream(outputFile);
		FileChannel targetChannel = fos.getChannel();
		
		for(int i = 0; i < inputFiles.length; i++) {
			FileInputStream fis = new FileInputStream(inputFiles[i]);
			FileChannel inputChannel = fis.getChannel();
			long size = inputChannel.size();
			
			ByteBuffer buf = ByteBuffer.allocate((int)size);
			System.out.println((char)buf.get());
			
			while(inputChannel.read(buf) > 0) {
				buf.flip();
				while(buf.hasRemaining()) {
//					System.out.println((char)buf.get());
					targetChannel.write(buf);
				}
			}
		}

	}

}
