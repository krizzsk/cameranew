package org.apache.http.entity.mime.g;
/* compiled from: AbstractContentBody.java */
/* loaded from: classes3.dex */
public abstract class a implements b {
    private final String a;

    public a(String str) {
        if (str != null) {
            this.a = str;
            int indexOf = str.indexOf(47);
            if (indexOf != -1) {
                str.substring(0, indexOf);
                str.substring(indexOf + 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("MIME type may not be null");
    }

    @Override // org.apache.http.entity.mime.g.c
    public String a() {
        return this.a;
    }
}
