package com.orientechnologies.orient.core.sql.executor;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OElement;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.record.impl.OBlob;

import java.util.Optional;
import java.util.Set;

/**
 * Created by luigidellaquila on 21/07/16.
 */
public interface OResult {
  <T> T getProperty(String name);

  Set<String> getPropertyNames();

  boolean isElement();

  Optional<OElement> getElement();

  OElement toElement();

  default boolean isVertex() {
    return getElement().map(x -> x.isVertex()).orElse(false);
  }

  default Optional<OVertex> getVertex() {
    return getElement().filter(x -> x instanceof OVertex).map(OVertex.class::cast);
  }

  default boolean isEdge() {
    return getElement().map(x -> x.isEdge()).orElse(false);
  }

  default Optional<OEdge> getEdge() {
    return getElement().filter(x -> x instanceof OEdge).map(OEdge.class::cast);
  }

  default boolean isBlob() {
    return getElement().map(x -> x instanceof OBlob).orElse(false);
  }

  default Optional<OBlob> getBlob() {
    return getElement().filter(x -> x instanceof OBlob).map(OBlob.class::cast);
  }

}