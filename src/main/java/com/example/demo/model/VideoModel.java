package com.example.demo.model;

//继承Comparable接口实现类的排序
public class VideoModel implements Comparable<VideoModel> {
	/**
	 * 重写集合的排序功能，实现根据热门度排序
	 */

	public int compareTo(VideoModel video) {
		if (this.getNumber() > video.getNumber()) {
			return -1;
		} else if (this.getNumber() < video.getNumber()) {
			return 1;
		}
		return 0;
	}
	private int videoId;
	// 视频标题（唯一）
	private String title;
	// 图片路径
	private String imageUrl;
	// 视频路劲
	private String videoUrl;
	// 视频简介
	private String introduction;
	// 视频类型
	private String type;
	// 点播次数
	private Long number;
	private int state;

	// 在创建视频对象时需要提供全部参数的构造方法
	public VideoModel(Integer videoId,int state,String title, String imageUrl, String videoUrl, String introduction, String type, Long number) {
		this.videoId=videoId;
		this.title = title;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
		this.introduction = introduction;
		this.type = type;
		this.number = number;
		this.state=state;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public VideoModel(String title, String imageUrl, String videoUrl, String introduction, String type) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
		this.introduction = introduction;
		this.type = type;
	}
	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public VideoModel(String title) {
		this.title = title;
	}

	public VideoModel() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "VideoModel [videoId=" + videoId + ", title=" + title + ", imageUrl=" + imageUrl + ", videoUrl="
				+ videoUrl + ", introduction=" + introduction + ", type=" + type + ", number=" + number + "]";
	}

}
