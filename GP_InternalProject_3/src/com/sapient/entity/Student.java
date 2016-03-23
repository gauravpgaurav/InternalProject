package com.sapient.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {

	private int studentId;
	private String studentName;
	private String department;
	private double academicMarkScore;
	private double academicEventScore;
	private double sportActivityScore;
	private double culturalActivityScore;
	private String imagePath;

	private double totalScore;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, String department, double academicMarkScore,
			double academicEventScore, double sportActivityScore, double culturalActivityScore) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.department = department;
		this.academicMarkScore = academicMarkScore;
		this.academicEventScore = academicEventScore;
		this.sportActivityScore = sportActivityScore;
		this.culturalActivityScore = culturalActivityScore;
	}

	public Student(int studentId, String studentName, String department, int academicMarkScore, int academicEventScore,
			int sportActivityScore, int culturalActivityScore, String imagePath) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.department = department;
		this.academicMarkScore = academicMarkScore;
		this.academicEventScore = academicEventScore;
		this.sportActivityScore = sportActivityScore;
		this.culturalActivityScore = culturalActivityScore;
		this.totalScore = calculateTotalScore();
		this.imagePath = imagePath;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getAcademicMarkScore() {
		return academicMarkScore;
	}

	public void setAcademicMarkScore(double academicMarkScore) {
		this.academicMarkScore = academicMarkScore;
	}

	public double getAcademicEventScore() {
		return academicEventScore;
	}

	public void setAcademicEventScore(double academicEventScore) {
		this.academicEventScore = academicEventScore;
	}

	public double getSportActivityScore() {
		return sportActivityScore;
	}

	public void setSportActivityScore(double sportActivityScore) {
		this.sportActivityScore = sportActivityScore;
	}

	public double getCulturalActivityScore() {
		return culturalActivityScore;
	}

	public void setCulturalActivityScore(double culturalActivityScore) {
		this.culturalActivityScore = culturalActivityScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public double calculateTotalScore() {

		return ((0.50 * academicMarkScore) + (0.10 * academicEventScore) + (0.20 * sportActivityScore)
				+ (0.20 * culturalActivityScore));
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", department=" + department
				+ ", academicMarkScore=" + academicMarkScore + ", academicEventScore=" + academicEventScore
				+ ", sportActivityScore=" + sportActivityScore + ", culturalActivityScore=" + culturalActivityScore
				+ ", totalScore=" + totalScore + "]";
	}

}
