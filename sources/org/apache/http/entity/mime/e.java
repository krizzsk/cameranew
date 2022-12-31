package org.apache.http.entity.mime;
/* compiled from: MinimalField.java */
/* loaded from: classes3.dex */
public class e {
    private final String a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String toString() {
        return this.a + ": " + this.b;
    }
}
