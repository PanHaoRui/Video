package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.VideoDao;
import com.example.demo.model.UserModel;
import com.example.demo.model.VideoModel;
import com.example.demo.service.VideoService;

@Controller
public class VideoController {

	@Autowired
	private VideoService VideoService;
	
	@Autowired
	VideoDao videoDao;

	/**
	 * 进入首页时加载推荐列表和热门视频数据
	 */
	@RequestMapping(value = "index")
	public String to_index(@RequestParam(defaultValue = "喜剧") String type, Model model,HttpServletRequest request) {
		UserModel userModel=(UserModel)request.getSession().getAttribute("userModel");
		System.out.println(userModel.toString());
		List<VideoModel> recommendVideos = VideoService.getRecommendVideos(userModel);

		model.addAttribute("recommendVideos", recommendVideos);
		// 设置热门视屏
		List<List<VideoModel>> hotVideos = VideoService.getHotVideos();
		model.addAttribute("hotVideos", hotVideos);
		return "index";
	}

	/**
	 * 进入首页时加载推荐列表和热门视频数据
	 */
	@RequestMapping(value = "play")
	public String playVideo(String videoId, Model model) { 
		// 点播次数累加
		int id;
		id=Integer.parseInt(videoId);
		VideoModel VideoModel;
		//System.out.println(videoId);
		VideoModel = videoDao.getVideoByVideoId(id);
		VideoModel.setNumber(VideoModel.getNumber() + 1);

		// 设置播放的视频
		model.addAttribute("currentPlayVideo", VideoModel);
		// 设置推荐列表加载的视频类型
		model.addAttribute("type", VideoModel.getType());
		return "forward:index";
	}
}
