package com.training.entity;

public class Doctor {

	private long doctorId;
	private String doctorName;

	public Doctor(long doctorId, String doctorName) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (doctorId ^ (doctorId >>> 32));
		result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
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
		Doctor other = (Doctor) obj;
		if (doctorId != other.doctorId)
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + "]";
	}

}
