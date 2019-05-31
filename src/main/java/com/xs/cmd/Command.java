package com.xs.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Command {
	/*public static void main(String[] args){
		String commandstr = "ping www.baidu.com";
		Command.exeCmd(commandstr);
	}*/
	public static void exeCmd(String commandstr){
		BufferedReader br =null;
		
		try {
			Process p = Runtime.getRuntime().exec(commandstr);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine())!=null){
				sb.append(line+"\n");
			}
			System.out.println(sb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}

