package com.dodopipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import com.dodopipe.beans.Leavebean;
import com.dodopipe.beans.Checkbean;
import com.dodopipe.beans.Userbean;
import com.dodopipe.beans.Checkbean;
import com.dodopipe.beans.RoleRightsbean;

import com.dodopipe.dao.LeaveDao;
import com.dodopipe.dao.Idao.ILeaveDao;
import com.dodopipe.dao.CheckDao;
import com.dodopipe.dao.Idao.ICheckDao;
import com.dodopipe.dao.UserDao;
import com.dodopipe.dao.Idao.IUserDao;
import com.dodopipe.dao.RoleRightsDao;
import com.dodopipe.dao.Idao.IRoleRightsDao;

import java.util.*;
import java.io.*;
import org.json.JSONObject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

@Controller
public class DodopipeFunction{

	@RequestMapping("/top")
	public String dotop(){
		return "top";
	}
	@RequestMapping("/left")
	public String doleft(){
		return "left";
	}
	@RequestMapping("/center")
	public String docenter(){
		return "center";
	}

	/**
	 * 
	 */
	@RequestMapping("/leave")
	public String doaskForLeave(){
		return "leave";
	}
	@RequestMapping("/leave_true")
	public String sureToLeave(HttpServletRequest request,String name,String startDate,String endDate,String reason){

		ILeaveDao dao = new LeaveDao();
        Timestamp st = timestampChange(startDate);
        Timestamp en = timestampChange(endDate);

		Leavebean leave = new Leavebean(name,st,en,reason);
		if(dao.insertInfo(leave)){
			return "center";
		} else {
            request.setAttribute("leaveMessage","Leave fail");
			return "leave";
		}
	}

    public Timestamp timestampChange(String date){
        try {
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            java.util.Date start = sp.parse(date);
            Timestamp st = new Timestamp(start.getTime());
            // Timestamp en = new Timestamp(end.getTime());
        
            // Date st = new Date(start.getTime());
            return st;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value="/viewLeaveMessage")
    public String viewLeaveMessage(HttpServletRequest request,String name){
        ILeaveDao leavedao = new LeaveDao();
        List<Leavebean> leavebeans = leavedao.getAllByName(name);
        request.setAttribute("leavebeans",leavebeans);
        request.setAttribute("username",name);
        return "viewLeaveMessage";
    }

    @RequestMapping(value="/leaveManagement")
    public String leaveManagement(HttpServletRequest request,String username,String note,String startDate,String endDate,String modifymessage){
        
        Timestamp st = null;
        Timestamp end = null;

        if("" != startDate && null != startDate){
            st = timestampChange(startDate);
        }
        if("" != endDate && null != endDate){
            end = timestampChange(endDate);
        }

        Leavebean leavebean = new Leavebean(username,st,end,null,note);

        ILeaveDao leavedao = new LeaveDao();
        List leavebeans = leavedao.getInfoByBean(leavebean);
        request.setAttribute("leavebean",leavebean);
        request.setAttribute("leavebeans",leavebeans);
        request.setAttribute("modifymessage",modifymessage);
        return "leaveManagement";
    }

    @RequestMapping("/sureModify")
    public ModelAndView sureModify(int id,HttpServletRequest request){
        
        ILeaveDao leavedao = new LeaveDao();
        Leavebean leavebean = leavedao.getLeavebeanById(id);
        if (leavebean == null) {
            request.setAttribute("modifymessage","Modification fails");
            return new ModelAndView("redirect:/leaveManagement");
        }

        request.setAttribute("leavebean",leavebean);
        return new ModelAndView("modifyview");
    }

    @RequestMapping("modifyMethod")
    public ModelAndView modifyMethod(int id,String note,String remark,HttpServletRequest request){

        ILeaveDao leavedao = new LeaveDao();
        if(leavedao.updateInfo(id,note,remark)){
            request.setAttribute("modifymessage","Modification Success"); 
        } else {
            request.setAttribute("modifymessage","Did not make any changes");
        }
        return new ModelAndView("redirect:/leaveManagement");
    }

	/**
	 * 
	 */
	@RequestMapping("/checkin")
	public String doCheckin(HttpServletRequest request,String name,String falgCheck){

		Date cur_data = new Date(new java.util.Date().getTime());
        Timestamp cur_time = new Timestamp(new java.util.Date().getTime());
		Checkbean checkbean = new Checkbean();
		ICheckDao checkdao = new CheckDao();
		if("2".equals(falgCheck)){
			checkbean.setName(name);
			checkbean.setCheck_first(cur_time);
            checkbean.setCheck_second(cur_time);
			checkbean.setData(cur_data);
			checkbean.setFlag("1");
			if(checkdao.insertInfo(checkbean)){
				request.getSession().setAttribute("checkFlag","success");
			} else {
                request.getSession().setAttribute("checkFlag","failure");
            }
		} else {
			checkbean.setData(cur_data);
            checkbean.setName(name);
			checkbean.setCheck_second(cur_time);
			if(checkdao.updateInfo(checkbean)){
                request.setAttribute("checkFlag","success");
			} else {
                request.getSession().setAttribute("checkFlag","failure");
            }
			// checkbean = getCheckbeanByName(name);
		}
        // request.getSession().setAttribute("check",checkbean);

		return "recheck";
	}

    @RequestMapping(value="/viewCheckMessage")
    public String viewCheckMessage(HttpServletRequest request,String name){
    	ICheckDao checkdao = new CheckDao();
    	List<Checkbean> checkbeans = checkdao.getAllByName(name);
    	request.setAttribute("checkbeans",checkbeans);
        request.setAttribute("username",name);
    	return "viewCheckMessage";
    }

    @RequestMapping(value="/attendancemanagement")
    public String attendancemanagement(HttpServletRequest request,String username,String check_first,String check_second){
        
        Timestamp first = null;
        Timestamp second = null;

        if("" != check_first && null != check_first){
            // first = dateChange(check_first);
            first = timestampChange(check_first);
        }
        if("" != check_second && null != check_second){
            // second = dateChange(check_second);
            second = timestampChange(check_second);
        }

        Checkbean checkbean = new Checkbean();
        checkbean.setName(username);
        checkbean.setCheck_first(first);
        checkbean.setCheck_second(second);
        

        ICheckDao checkdao = new CheckDao();
        List checkbeans = checkdao.getAllByBean(checkbean);

        request.setAttribute("checkbean",checkbean);
        request.setAttribute("checkbeans",checkbeans);

        return "attendancemanagement";
    }

    /**
     * 
     */
	@RequestMapping("/index")
	public ModelAndView show_index(){
		
		return new ModelAndView("login");
	}

    @RequestMapping("/login")
    public ModelAndView login_test(HttpServletRequest request,String username,String password){
        IUserDao userdao = new UserDao();
        Userbean userbean = userdao.findByName(username);
        if(userbean != null){
            if(userbean.getPassword().equals(password)){

                Checkbean checkbean = getCheckbeanByName(username);
                List rolerightsbeans = getRoleRightsbeanByRole(userbean.getRole());

                request.getSession().setAttribute("roleRights",rolerightsbeans);               
                request.getSession().setAttribute("check",checkbean);

                request.getSession().setAttribute("user",userbean);
                return new ModelAndView("redirect:/main");
            }
        }
        request.setAttribute("loginMessage","Loginname or password error");
        return new ModelAndView("login");
    }

    @RequestMapping("/main")
    public ModelAndView toMainJsp(HttpServletRequest request){
        
        if(request.getSession().getAttribute("user") != null){
            return new ModelAndView("main");
        }
        return new ModelAndView("redirect:/index");
    }
    @RequestMapping("/safetySignOut")
    public ModelAndView safetySignOut(HttpServletRequest request){
        
        request.getSession().setAttribute("user",null);
        request.getSession().setAttribute("check",null);

        return new ModelAndView("redirect:/index");
    }

	@RequestMapping(value="/googlelogin")
	public ModelAndView googleLogin(){
		String client_ID = "762884882091.apps.googleusercontent.com";
		String redirect_uri = "http://localhost:8080/webApp/success";
		return new ModelAndView("redirect:https://accounts.google.com/o/oauth2/auth?"
			+ "redirect_uri=" + redirect_uri
			+ "&response_type=code"
			+ "&client_id=" + client_ID
			+ "&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email"
			+ "&approval_prompt=force"
			+ "&access_type=offline");
	}

	@RequestMapping(value="/success")
	public ModelAndView success(HttpServletRequest request,String code,String access_token,String beanname){

		if(access_token == null){
			String client_ID = "762884882091.apps.googleusercontent.com";
			String redirect_uri = "http://localhost:8080/webApp/success";
			String client_secret = "-PkbHqvFHUbJSfTqBQl8ukW-";
			
			Map<String,String> params = new HashMap<String, String>();
			params.put("redirect_uri",redirect_uri);
			params.put("grant_type","authorization_code");
			params.put("client_id",client_ID);
			params.put("code",code);
			params.put("client_secret",client_secret);

			access_token = sendPost("https://accounts.google.com/o/oauth2/token",params);
        }
        try{
            JSONObject access_json = new JSONObject(access_token);
            // System.out.println(access_json.get("access_token"));
            String str_access = (String)access_json.get("access_token");

            Map<String,String> token = new HashMap<String,String>();
            token.put("access_token",str_access);
            String userinfo = sendGet("https://www.googleapis.com/oauth2/v1/userinfo",token);

            JSONObject userinfo_json = new JSONObject(userinfo);

            String email = (String)userinfo_json.get("email");
            String username = email.split("@")[0];

            request.getSession().setAttribute("username",username);

            IUserDao userdao = new UserDao();
            if(userdao.findByName(username) != null){
                return new ModelAndView("afailed");
            }

            } catch(Exception e){
            e.printStackTrace();
        }

		return new ModelAndView("registration");
	}

    @RequestMapping(value="/regSuccess")
    public ModelAndView regSuccess(HttpServletRequest request,String username,String password,String role){

        Userbean user = new Userbean(username,password,role);
        IUserDao userdao = new UserDao();

        if(userdao.insertInfo(user)){

            Checkbean checkbean = getCheckbeanByName(username);
            List rolerightsbeans = getRoleRightsbeanByRole(role);

            request.getSession().setAttribute("roleRights",rolerightsbeans);    
            request.getSession().setAttribute("check",checkbean);

            request.getSession().setAttribute("user",user);
            return new ModelAndView("redirect:/main");
        }
        return new ModelAndView("afailed");
    }

    /**
     * 
     */
    public String sendGet(String url, Map<String, String> parameters) {  
        String result = "";// 返回的结果  
        BufferedReader in = null;// 读取响应输入流  
        StringBuffer sb = new StringBuffer();// 存储参数  
        String params = "";// 编码之后的参数  
        try {  
             
            for (String name : parameters.keySet()) {  
                sb.append(name)
                    .append("=")
                    .append(java.net.URLEncoder.encode(parameters.get(name),"UTF-8"))
                    .append("&");  
            }  
            String temp_params = sb.toString();  
            params = temp_params.substring(0, temp_params.length() - 1);  
            String full_url = url + "?" + params;  
            // System.out.println(full_url);  
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(full_url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 建立实际的连接  
            httpConn.connect();  
            // 响应头部获取  
            Map<String, List<String>> headers = httpConn.getHeaderFields();  
            // 遍历所有的响应头字段  
            // for (String key : headers.keySet()) {  
            //     System.out.println(key + "\t：\t" + headers.get(key));  
            // }  
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), "UTF-8"));  
            String line;  
            // 读取返回的内容  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  


	public String sendPost(String url, Map<String, String> parameters) {

        String result = "";// 返回的结果  
        BufferedReader in = null;// 读取响应输入流  
        PrintWriter out = null;  
        StringBuffer sb = new StringBuffer();// 处理请求参数  
        String params = "";// 编码之后的参数  
        try { 
            for (String name : parameters.keySet()) {
                sb.append(name)
                	.append("=")
                	.append(java.net.URLEncoder.encode(parameters.get(name),"UTF-8"))
                    .append("&");  
            }  
            String temp_params = sb.toString();  
            params = temp_params.substring(0, temp_params.length() - 1);
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            // httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 设置POST方式  
            httpConn.setDoInput(true);  
            httpConn.setDoOutput(true);  
            // 获取HttpURLConnection对象对应的输出流  
            out = new PrintWriter(httpConn.getOutputStream());  
            // 发送请求参数  
            out.write(params);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));  
            String line;  
            // 读取返回的内容  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {
            e.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }

    public Checkbean getCheckbeanByName(String username){

        ICheckDao checkdao = new CheckDao();

        return checkdao.getCheckbeanByName(username);
    }

    public List getRoleRightsbeanByRole(String role){
        
        IRoleRightsDao roleRightsdao = new RoleRightsDao();

        return roleRightsdao.getRoleRightsbeanByRole(role);
    }
}