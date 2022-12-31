package org.slf4j.helpers;
/* compiled from: FormattingTuple.java */
/* loaded from: classes3.dex */
public class a {
    private String a;
    private Throwable b;
    private Object[] c;

    public a(String str) {
        this(str, null, null);
    }

    public String a() {
        return this.a;
    }

    public Throwable b() {
        return this.b;
    }

    public a(String str, Object[] objArr, Throwable th) {
        this.a = str;
        this.b = th;
        this.c = objArr;
    }
}
