package com.quiz.entities;

import com.quiz.entities.IIdentifiable;
import com.quiz.entities.IPersistable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.quiz.annotations.DontSerialize;
import com.quiz.entities.Identifiable;


@MappedSuperclass
public abstract class EntityObject extends Identifiable implements IPersistable {

    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean equal = false;

        if (obj instanceof EntityObject) {
            EntityObject entity = (EntityObject) obj;

            if (isPersisted() && entity.isPersisted()) {
                equal = getId() == ((IIdentifiable) obj).getId();
            } else if (!isPersisted() && !entity.isPersisted()) {
                equal = super.equals(obj);
            }
        }

        return equal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transient
    public boolean isPersisted() {
        return getVersion() != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Id: " + String.valueOf(getId()) + ", Class: " + getClass();
    }

	// --------------------- Interface IPersistable ---------------------
    @Override
    @Transient
    @DontSerialize
    public Object getIdObject() {
        return Long.valueOf(getId());
    }
}
