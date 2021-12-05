package edu.soft.controller;

import edu.soft.pojo.User;
import lombok.SneakyThrows;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.impl.common.IOUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
@RequestMapping(value = "user")
public class UserController {
    @RequestMapping(value = "/index")
    public String index(){
        System.out.println("-----index()-----");
        return "forward:index.jsp";
    }
    //删除操作
    @RequestMapping(value = "/delete.do")
    public String delete(){
        System.out.println("-----delete()-----");
        return "hello";
    }
    //登录
    @RequestMapping(value = "login")
    public String login(User user, HttpSession session){
        System.out.println("-----login()-----");
        int flag = 1;
        if (flag == 1) {
            session.setAttribute("user", user);
            return "welcome";
        }
        return "hello";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        System.out.println("--------logout()-----");
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println("session失效");
        String msg = "你已退出登陆";
        request.setAttribute("msg",msg);
        return "forward:/index.jsp";
    }
    @RequestMapping(value = "/hello.do")
    public String hello(){
        System.out.println("-----delete()-----");
        return "hello";
    }

    @RequestMapping(value = "upload",method = {RequestMethod.POST})

    public String upload(MultipartFile image,HttpServletRequest request) throws IOException {
        System.out.println("---------upload--------");
        //获取文件输入流对象
        InputStream is = image.getInputStream();
        //获取文件名称
        String filename = image.getOriginalFilename();
        //设置上传路径
        String realPath = request.getServletContext().getRealPath("/images");
        System.out.println("上传路径："+realPath);
        //设置上传server后的新名称tob
        OutputStream os = new FileOutputStream(new File(realPath,filename));
       int size = IOUtils.copy(is,os);
        System.out.println("上传"+""+"文件到"+realPath+"完毕,共计"+size+"字节,上传后文件名为"+"");
        //资源释放
        os.close();is.close();
        return "";
    }
    public String doFilename(String filename) {
        //获取文件后缀名
        String extension = FilenameUtils.getExtension(filename);
        String uuid = UUID.randomUUID().toString();
            return "";
    }
}
