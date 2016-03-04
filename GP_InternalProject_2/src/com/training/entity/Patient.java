package com.training.entity;

public class Patient {

	private long patientId;
	private String patientName;
	private String patientEmail;
	private int patientAge;
	private String patientGender;

	public Patient(long patientId, String patientName, String patientEmail, int patientAge, String patientGender) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientEmail = patientEmail;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientEmail=" + patientEmail
				+ ", patientAge=" + patientAge + ", patientGender=" + patientGender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + patientAge;
		result = prime * result + ((patientEmail == null) ? 0 : patientEmail.hashCode());
		result = prime * result + ((patientGender == null) ? 0 : patientGender.hashCode());
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
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
		Patient other = (Patient) obj;
		if (patientAge != other.patientAge)
			return false;
		if (patientEmail == null) {
			if (other.patientEmail != null)
				return false;
		} else if (!patientEmail.equals(other.patientEmail))
			return false;
		if (patientGender == null) {
			if (other.patientGender != null)
				return false;
		} else if (!patientGender.equals(other.patientGender))
			return false;
		if (patientId != other.patientId)
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		return true;
	}

}
