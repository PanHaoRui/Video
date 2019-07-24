package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VideoDao;
import com.example.demo.model.UserModel;
import com.example.demo.model.VideoModel;

@Service
public class VideoService {
	/**
	 * [推荐列表]获得类型相同的视频
	 */
	@Autowired
	VideoDao videoDao;
	public List<VideoModel> getRecommendVideos(UserModel userModel) {
		// 设置推荐视频

		List<VideoModel> list = new ArrayList<VideoModel>();
		int max=userModel.getComedy();
		//找出用户最喜好的电影类型，默认为戏剧
		String maxType="comedy";
		if(userModel.getAction()>max){maxType="action";max=userModel.getAction();}
		if(userModel.getCartoon()>max){maxType="cartoon";max=userModel.getCartoon();}
		if(userModel.getGunplay()>max){maxType="gunplay";max=userModel.getGunplay();}
		if(userModel.getLove()>max){maxType="love";max=userModel.getLove();}
		if(userModel.getScienceFiction()>max){maxType="scienceFiction";max=userModel.getScienceFiction();}
		if(userModel.getTerror()>max){maxType="terror";max=userModel.getTerror();}
		list=videoDao.getVideosByType(maxType);
		System.out.println(userModel.toString());

		// 控制推荐区域视频数
		// 个数不足展示，增加点击次数最多的，个数超出，删除超出部分
//		if (list.size() < 5) {
//			int index = 0;
//			for (int i = 5 - list.size(); i > 0; i--) {
//				list.add(db.get(index++));
//			}
//		} else 
			if (list.size() > 5) {
			for (int i = list.size() - 5; i > 0; i--) {
				list.remove(list.size() - 1);
			}
		}
		Collections.sort(list);
		

		return list;
	}

	/**
	 * [热门列表]获得所有视频-排序-构建成N行5列的数据结构
	 */
	public List<List<VideoModel>> getHotVideos() {
		// 获得所有视频
		List<VideoModel> data = new ArrayList<VideoModel>();
		// 排序
		data=videoDao.getVideosByNumber();
		System.out.println("调用");
		// 构建N行5列的数据结构
		List<List<VideoModel>> result = new ArrayList<List<VideoModel>>();

		// 外层循环控制行数
		for (int i = 0; i < data.size();) {
			List<VideoModel> row = new ArrayList<VideoModel>();
			// 内层循环控制列数
			for (int j = 0; j < 5; j++, i++) {
				row.add(data.get(i));
			}
			result.add(row);
		}
		return result;
	}
}
