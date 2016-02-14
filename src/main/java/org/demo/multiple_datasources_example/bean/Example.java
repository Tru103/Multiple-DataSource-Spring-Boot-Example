package org.demo.multiple_datasources_example.bean;

public class Example {
	
	private int id;
	private String string;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public Example(int id, String string) {
		super();
		this.id = id;
		this.string = string;
	}
	public Example() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Example [id=" + id + ", " + (string != null ? "string=" + string : "") + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
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
		Example other = (Example) obj;
		if (id != other.id)
			return false;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}
	
	

}
