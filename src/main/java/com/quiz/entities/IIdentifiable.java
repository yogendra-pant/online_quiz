package com.quiz.entities;

import java.io.Serializable;
import java.util.Date;


public interface IIdentifiable extends Serializable {
	Date getCreated();

	/**
	 * Get the entities unique id, managed by the persistence store
	 *
	 * @return The id.
	 */
	long getId();

	/**
	 * Get the entities version, managed by the persistence store
	 *
	 * @return The version.
	 */
	Long getVersion();

	void setId(long value);

	void setVersion(Long value);
}
