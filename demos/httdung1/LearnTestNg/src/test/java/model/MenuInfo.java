package model;

public class MenuInfo {
	public String menuName;
	public String url;
	public MenuInfo(String menuName, String url) {
		super();
		this.menuName = menuName;
		this.url = url;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		MenuInfo other = (MenuInfo) obj;
		if (menuName == null) {
			if (other.menuName != null)
				return false;
		} else if (!menuName.equalsIgnoreCase(other.menuName))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equalsIgnoreCase(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuInfo [menuName=" + menuName + ", url=" + url + "]";
	}
	
	
	
		
}
