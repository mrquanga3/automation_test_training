package recruitment.cmc.com.settings;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class NewsInfo {
	public String subTitle;
	public String urlBanner;
	public String subContent;
	public String detailContent;
	public String postDate;
	public String img;
	public String date;
	public String title;
	
	public NewsInfo(String subTitle, String urlBanner, String subContent, String detailContent, String postDate) {
		super();
		this.subTitle = subTitle;
		this.urlBanner = urlBanner;
		this.subContent = subContent;
		this.detailContent = detailContent;
		this.postDate = postDate;

	}
	// nttdung
	public NewsInfo(String img, String date, String description) {
		super();

		this.img = img;
		this.date = date;
		this.title = description;
	}
	public NewsInfo() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detailContent == null) ? 0 : detailContent.hashCode());
		result = prime * result + ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + ((subContent == null) ? 0 : subContent.hashCode());
		result = prime * result + ((subTitle == null) ? 0 : subTitle.hashCode());
		result = prime * result + ((urlBanner == null) ? 0 : urlBanner.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsInfo other = (NewsInfo) obj;
		if (detailContent == null) {
			if (other.detailContent != null)
				return false;
		} else if (!detailContent.equalsIgnoreCase(other.detailContent))
			return false;
		if (postDate == null) {
			if (other.postDate != null)
				return false;
		} else if (!postDate.equalsIgnoreCase(other.postDate))
			return false;
		if (subContent == null) {
			if (other.subContent != null)
				return false;
		} else if (!subContent.equalsIgnoreCase(other.subContent))
			return false;
		if (subTitle == null) {
			if (other.subTitle != null)
				return false;
		} else if (!subTitle.equalsIgnoreCase(other.subTitle))
			return false;
		if (urlBanner == null) {
			if (other.urlBanner != null)
				return false;
		} else if (!urlBanner.equalsIgnoreCase(other.urlBanner))
			return false;
		return true;
	}
	
	//nttdung
	
	public String toString1() {
		return "NewsInfo [img=" + img + ", date=" + date + ", title=" + title + "]";
	}
	
	@Override
	public String toString() {
		return "NewsInfo [subTitle=" + subTitle + ", urlBanner=" + urlBanner + ", subContent=" + subContent
				+ ", detailContent=" + detailContent + ", postDate=" + postDate + "]";
	}
	


}
