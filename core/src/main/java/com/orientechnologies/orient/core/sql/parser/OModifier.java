/* Generated By:JJTree: Do not edit this line. OModifier.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import com.orientechnologies.orient.core.command.OCommandContext;
import com.orientechnologies.orient.core.db.record.OIdentifiable;

import java.util.Map;

public class OModifier extends SimpleNode {

  boolean                    squareBrackets = false;
  OArrayRangeSelector        arrayRange;
  OOrBlock                   condition;
  OArraySingleValuesSelector arraySingleValues;
  OMethodCall                methodCall;
  OSuffixIdentifier          suffix;

  OModifier                  next;

  public OModifier(int id) {
    super(id);
  }

  public OModifier(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }

  public void toString(Map<Object, Object> params, StringBuilder builder) {

    if (squareBrackets) {
      builder.append("[");

      if (arrayRange != null) {
        arrayRange.toString(params, builder);
      } else if (condition != null) {
        condition.toString(params, builder);
      } else if (arraySingleValues != null) {
        arraySingleValues.toString(params, builder);
      }

      builder.append("]");
    } else if (methodCall != null) {
      methodCall.toString(params, builder);
    } else if (suffix != null) {
      builder.append(".");
      suffix.toString(params, builder);
    }
    if (next != null) {
      next.toString(params, builder);
    }
  }

  public Object execute(OIdentifiable iCurrentRecord, Object result, OCommandContext ctx) {
    if (methodCall != null) {
      result = methodCall.execute(result, ctx);
    } else if (suffix != null) {
      result = suffix.execute(result, ctx);
    } else if (arrayRange != null) {
      return arrayRange.execute(iCurrentRecord, result, ctx);
    } else if (condition != null) {
      throw new UnsupportedOperationException("implement OModifier!");
    } else if (arraySingleValues != null) {
      return arraySingleValues.execute(iCurrentRecord, result, ctx);
    } else {
      throw new UnsupportedOperationException("implement OModifier!");
      // TODO
    }
    if (next != null) {
      result = next.execute(iCurrentRecord, result, ctx);
    }
    return result;
  }
}
/* JavaCC - OriginalChecksum=39c21495d02f9b5007b4a2d6915496e1 (do not edit this line) */
