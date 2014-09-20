package com.quiz.entities;

import java.util.Set;


public interface INestedObject<T extends INestedObject<T>> extends IIdentifiable {
	/**
	 * @return the parent object of <code>this</code> object. might be <code>null</code>
	 * @actionscript.property type=mx.collections.ArrayCollection
	 */
	Set<T> getChildren();

	/**
	 * @return the parent objects, might be <code>null</code> if it is the root
	 */
	T getParent();

	boolean isContainer();

	/**
	 * @return <code>true</code> if objects of that type have a unique parent. This is usually
	 *         <code>true</code>, if there exists an 1:n relationship and you can build a tree
	 */
	boolean isUniqueParentAvailable();

	void setChildren(Set<T> children);

	void setParent(T parent);
}
