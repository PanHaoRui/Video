package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.VideoDao;
import com.example.demo.model.UserModel;
import com.example.demo.model.VideoModel;
//返回申请页面
@Controller
public class UploadController {
	@Autowired
	VideoDao videoDao;
	
	@RequestMapping(value="apply")
	public String apply(){
		
		return "apply";
	}
	
//返回审核页面
	@RequestMapping(value="audit")
	public String audit(HttpSession session){
		UserModel userModel=(UserModel)session.getAttribute("userModel");
		System.out.println(userModel.getJurisdiction());
		if(userModel.getJurisdiction()==1){
		return "audit";}
		return "login";
	}
	
	//上传路径
	@RequestMapping("/upload")
    public String singleFileUpload(@RequestParam("video")MultipartFile video,
    		@RequestParam("image")MultipartFile image,
    		@RequestParam("title")String title,
    		@RequestParam("type")String type,
    		@RequestParam("introduction")String introduction,
    		RedirectAttributes redirectAttributes) throws IOException{
			//获取时间写在标题前防止同名覆盖问题
            Date date=new Date();
            
            // 使用 toString() 函数显示日期时间
            System.out.println(date.toString());
            //获取static资源的绝对路径
			String serverpath=ResourceUtils.getURL("classpath:static").getPath().replace("%20"," ").replace('/', '\\');
			//将视频写入本地
			Path path = Paths.get(serverpath.substring(1)+"\\video\\" +date.getTime()+video.getOriginalFilename());//
			File newVideo=new File(path.toString());
			video.transferTo(newVideo);
			//写入图片
            Path path1 = Paths.get(serverpath.substring(1)+"\\image\\movie\\"+date.getTime()+image.getOriginalFilename());//image.getOriginalFilename()
            File newImage=new File(path1.toString());
            image.transferTo(newImage);
            VideoModel videoModel=new VideoModel(title, "image/movie/"+date.getTime()+image.getOriginalFilename(), "/video/" +date.getTime()+video.getOriginalFilename(), introduction, type);
           //插入数据库数据
            System.out.println(path.toString());
            System.out.println(path1.toString());
            videoDao.insertVideo(videoModel);
        return "uploadResult";
    }	
	
	
}
