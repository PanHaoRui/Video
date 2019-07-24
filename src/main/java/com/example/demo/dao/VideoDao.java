package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.VideoModel;

@Mapper
public interface VideoDao {
	List<VideoModel> getVideosByType(String maxType);
	List<VideoModel> getVideosByNumber();
	VideoModel getVideoByVideoId(int videoId);
	int insertVideo(VideoModel videoModel);
}
