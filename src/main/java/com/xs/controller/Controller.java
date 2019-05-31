package com.xs.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import com.mysql.fabric.Response;
import com.xs.chain.ContractUtils;
import com.xs.chain.LoadSmartContractImpl;
import com.xs.chain.MetaCoin_sol_MetaCoin;
import com.xs.chain.Register;
import com.xs.po.Account;
import com.xs.po.Item;
import com.xs.po.PageInfo;
import com.xs.po.Transaction;
import com.xs.service.impl.AccountServiceImpl;
import com.xs.service.impl.ItemServiceImpl;
import com.xs.service.impl.TransactionServiceImpl;

@RestController
public class Controller {
	
	@Resource
	private AccountServiceImpl accountServiceImpl;
	@Resource
	private ItemServiceImpl itemServiceImpl;
	@Resource
	private TransactionServiceImpl transactionServiceImpl;
	
	//登陆 session 记录登录态
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request)
	{	
		String user=request.getParameter("user");
		String pwd =request.getParameter("pwd");
		Account ac= accountServiceImpl.login(user, pwd);
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("Account", ac);
		if(ac!=null)
		{
				return "yes";
		}
		return "false";
	}

	@RequestMapping("/viewtransactionbypage.do")
	public List<Object> viewTransactionByPage(PageInfo pageInfo,HttpServletRequest request)  
	{	
			System.out.println(request.getParameter("count"));
			
			return transactionServiceImpl.getTransactionPage(pageInfo).getRows();
	}
	
	//注册新帐户
	@RequestMapping("/insert.do")
	public String register(Account ac) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException, IOException
	{	
		String filename="e:\\wallet\\"+Register.registerAccount(ac.getKeyword());
		ac.setPrivatekeyfile(filename);
		if(accountServiceImpl.insertAccount(ac)) return "yes";			
		return "false";
	}

	//查看用户拥有的音乐
	@RequestMapping("/userinfo.do")
	public List<Object> userInfo(HttpServletRequest request)  
	{	
		Account ac = (Account) request.getSession().getAttribute("Account");
		if(ac!=null)
		{
			return itemServiceImpl.getUserItems(ac.getId());
		}
		return null;
	}
	
	//查看所有音乐
	@RequestMapping("/viewallMusic.do")
	public List<Object> viewAll(HttpServletRequest request)  
	{	
			return itemServiceImpl.getAllItems();
	}
	
	//上传音乐
	@RequestMapping("/upload.do")
	public String insertMusic(@RequestParam("file") MultipartFile file,HttpServletRequest request) 
	{	
		
		if(file.isEmpty()) return "upload failed";
		String fileName = file.getOriginalFilename();
		String filePath = "e://music";
		File dest = new File(filePath+File.separator+fileName);
		
		try {
			file.transferTo(dest);
			return dest.getAbsolutePath();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Item item = new Item();
		item.setUserid(Integer.parseInt(request.getParameter("userID")));
		item.setItemname((request.getParameter("musicname")));
		item.setPrice((Integer.parseInt(request.getParameter("price"))));
		item.setPath(dest.getAbsolutePath());
		
		if(itemServiceImpl.insertItem(item))
				return "yes";			
		return "false";
	}
	
	//用户下载音乐
	@RequestMapping("/download.do")
	public String downloadMusic(HttpServletRequest request,
            HttpServletResponse response) throws UnsupportedEncodingException
	{
		File scFileDir = new File("e://music");
		String fileName=request.getParameter("filename");
		File file= new File(scFileDir, fileName);
		
		if(file.exists())
		{
			response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Access-Control-Allow-Origin", "*");
            
            byte[] buffer = new byte[1024];
            FileInputStream fis =null;
            BufferedInputStream bis =null;
            try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
	            OutputStream os = response.getOutputStream();
	            int i=bis.read(buffer);
	            while(i!=-1)
	            {
	            	os.write(buffer,0,i);
	            	i=bis.read(buffer);
	            }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            finally{
            	if(bis !=null)
            	{
            		try {
						bis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	if(fis!=null)
            	{
            		try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
            
		}
		
		return null;
	}
	@RequestMapping("/recharge.do")
	public String recharge(HttpServletRequest request)
	{
		Account ac=(Account) request.getSession().getAttribute("Account");
		if(ac!=null)
		{
			
		}
		return "false";
	}
	@RequestMapping("/getAllTransaction.do")
	public List<Object> getAllTransaction(HttpServletRequest request) throws Exception
	{	
		
		return transactionServiceImpl.getAllTransaction();
	}
	@RequestMapping("/insertAllTransaction.do")
	public boolean insertAllTransaction(Transaction tsc) throws Exception
	{	
		
		return transactionServiceImpl.insertTransaction(tsc);
	}
	
	@RequestMapping("/getbalance.do")
	public String getBalance(HttpServletRequest request) throws Exception
	{	
		Account ac= (Account) request.getSession().getAttribute("Account");
		Credentials credentials = WalletUtils.loadCredentials(ac.getKeyword(), new File(ac.getPrivatekeyfile())); 
		MetaCoin_sol_MetaCoin meta=ContractUtils.loadMetaCoin(credentials);
		return meta.balanceOf(credentials.getAddress()).send().toString();
	}
	
	@RequestMapping("/transfer.do")
	public String transfer(HttpServletRequest request) throws Exception
	{	
		Account ac= (Account) request.getSession().getAttribute("Account");
		Credentials credentials = WalletUtils.loadCredentials(ac.getKeyword(), new File(ac.getPrivatekeyfile()));
		MetaCoin_sol_MetaCoin meta=ContractUtils.loadMetaCoin(credentials);
		ac=accountServiceImpl.getAccountByID(Integer.valueOf(request.getParameter("to")));
		Credentials credentialsTo = WalletUtils.loadCredentials(ac.getKeyword(), new File(ac.getPrivatekeyfile()));
		TransactionReceipt rcp=meta.transfer(credentialsTo.getAddress(),new BigInteger(request.getParameter("itemid")) ,new BigInteger(request.getParameter("value"))).send();
		if(rcp!=null) return "yes";
		return "false";
	}
	
	
}
