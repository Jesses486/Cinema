package fr.gtm.entities;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name = "films_acteur")
public class Role implements java.io.Serializable {

  private static final long serialVersionUID = 1L;

  private String role;

  public Role() {
  }

  public Role(String role) {
    this.role = role;
  }

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((role == null) ? 0 : role.hashCode());
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
	Role other = (Role) obj;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	return true;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}


  
}
