package com.rickdane.springmodularizedproject.common.domain.constraint;

import java.lang.annotation.Annotation;

/**
 * @author Rick Dane
 */
public interface InitializedConstraint<A extends Annotation> {
   /**
   * Take the annotations values
   *
   * @param parameters
   */
   public void initialize(A parameters);
}