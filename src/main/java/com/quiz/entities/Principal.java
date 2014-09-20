package com.quiz.entities;

import com.quiz.annotations.DontSerialize;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Principal extends EntityObject implements java.security.Principal, INestedObject<Principal> {
	public static final String DEFAULT_SOURCE = "internal";

	private static final long serialVersionUID = 1L;

	private String name;
	private String identifier;
	private String source = DEFAULT_SOURCE;

	private boolean deleted;

	/**
	 * @return the unique identifier that allows to reference the principal at its source
	 */
	@DontSerialize
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the unique name of the principal
	 */
	@Basic(optional = false)
	public String getName() {
		return name;
	}

	/**
	 * @param name the unique name of the principal
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the source of the principal
	 */
	@DontSerialize
	@Basic(optional = false)
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	// --------------------- Interface INestedObject ---------------------

	@Override
	@DontSerialize
	@Transient
	public Set<Principal> getChildren() {
		throw new UnsupportedOperationException();
	}

	@Override
	@DontSerialize
	@Transient
	public Principal getParent() {
		return null;
	}

	@Override
	@DontSerialize
	@Transient
	public boolean isContainer() {
		return false;
	}

	@Override
	@DontSerialize
	@Transient
	public boolean isUniqueParentAvailable() {
		return false;
	}

	@Override
	public void setChildren(Set<Principal> children) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setParent(Principal parent) {
		throw new UnsupportedOperationException();
	}

	@Transient
	public boolean isEditable() {
		return Principal.DEFAULT_SOURCE.equals(getSource());
	}
}
