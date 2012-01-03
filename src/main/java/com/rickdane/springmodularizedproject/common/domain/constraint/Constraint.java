package com.rickdane.springmodularizedproject.common.domain.constraint;

/**
 * @author Rick Dane
 */
public interface Constraint {
   /**
   * does the object/element pass the constraints
   */
   public boolean isValid(Object value);
}
