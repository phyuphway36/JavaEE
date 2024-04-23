package com.hostmdy.model;

public class Result {
	
	private int id;
	private String major;
	private int seatNo;
	private String name;
	private int year;
	private double grade;
	private boolean qualify;
	
	public Result() {}

	public Result(String major, int seatNo, String name, int year, double grade, boolean qualify) {
		super();
		this.major = major;
		this.seatNo = seatNo;
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.qualify = qualify;
	}

	public Result(int id, String major, int seatNo, String name, int year, double grade, boolean qualify) {
		super();
		this.id = id;
		this.major = major;
		this.seatNo = seatNo;
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.qualify = qualify;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public boolean isQualify() {
		return qualify;
	}

	public void setQualify(boolean qualify) {
		this.qualify = qualify;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", major=" + major + ", seatNo=" + seatNo + ", name=" + name + ", year=" + year
				+ ", grade=" + grade + ", qualify=" + qualify + "]";
	}
	
	

}
