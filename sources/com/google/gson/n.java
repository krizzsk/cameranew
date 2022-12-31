package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* loaded from: classes2.dex */
public final class n extends k {
    private final Object a;

    public n(Boolean bool) {
        com.google.gson.internal.a.b(bool);
        this.a = bool;
    }

    private static boolean o(n nVar) {
        Object obj = nVar.a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    @Override // com.google.gson.k
    public int a() {
        return p() ? l().intValue() : Integer.parseInt(m());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.a == null) {
            return nVar.a == null;
        } else if (o(this) && o(nVar)) {
            return l().longValue() == nVar.l().longValue();
        } else {
            Object obj2 = this.a;
            if ((obj2 instanceof Number) && (nVar.a instanceof Number)) {
                double doubleValue = l().doubleValue();
                double doubleValue2 = nVar.l().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            }
            return obj2.equals(nVar.a);
        }
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (o(this)) {
            doubleToLongBits = l().longValue();
        } else {
            Object obj = this.a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(l().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean i() {
        if (n()) {
            return ((Boolean) this.a).booleanValue();
        }
        return Boolean.parseBoolean(m());
    }

    public double j() {
        return p() ? l().doubleValue() : Double.parseDouble(m());
    }

    public long k() {
        return p() ? l().longValue() : Long.parseLong(m());
    }

    public Number l() {
        Object obj = this.a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.a) : (Number) obj;
    }

    public String m() {
        if (p()) {
            return l().toString();
        }
        if (n()) {
            return ((Boolean) this.a).toString();
        }
        return (String) this.a;
    }

    public boolean n() {
        return this.a instanceof Boolean;
    }

    public boolean p() {
        return this.a instanceof Number;
    }

    public boolean q() {
        return this.a instanceof String;
    }

    public n(Number number) {
        com.google.gson.internal.a.b(number);
        this.a = number;
    }

    public n(String str) {
        com.google.gson.internal.a.b(str);
        this.a = str;
    }
}
