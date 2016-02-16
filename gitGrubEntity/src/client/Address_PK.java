package client;

import java.io.Serializable;

public class Address_PK implements Serializable {
	private String email;
	private String addressTag;
	
	public Address_PK() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressTag == null) ? 0 : addressTag.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Address_PK other = (Address_PK) obj;
		if (addressTag == null) {
			if (other.addressTag != null)
				return false;
		} else if (!addressTag.equals(other.addressTag))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
}
