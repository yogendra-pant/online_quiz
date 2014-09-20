package com.quiz.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;


@MappedSuperclass
public abstract class Identifiable implements IIdentifiable {
	private static final long serialVersionUID = 1L;
	private long id;
	private Long version;
	private Date created;

	protected Identifiable() {
		this(0L);
	}

	protected Identifiable(long id) {
		this(id, null);
	}

	protected Identifiable(long id, Long version) {
		this(id, version, now());
	}

	private static Date now() {
		// the granularity of mysql is seconds, so we need to strip the milliseconds from the timestamp
		long now = new Date().getTime();
		return new Date(now / 1000l * 1000l);
	}

	protected Identifiable(long id, Long version, Date created) {
		this.id = id;
		this.version = version;
		this.created = created;
	}

	/**
	 * @return the date when <code>this</code> {@link EntityObject} was created
	 */
	@Override
	@Basic(optional = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created Set the entities creation date.
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * {@inheritDoc}
	 */
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	/**
	 * Set the entities unique id.
	 *
	 * @param id The id.
	 */
	public final void setId(long id) {
		this.id = id;
	}

	@Version
	@Column(nullable = false)
	public Long getVersion() {
		return version;
	}

	/**
	 * Set the entities version.
	 *
	 * @param version The version.
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return created.hashCode();
	}
}