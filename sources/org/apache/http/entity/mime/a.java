package org.apache.http.entity.mime;

import us.pinguo.common.network.HttpRequest;
/* compiled from: FormBodyPart.java */
/* loaded from: classes3.dex */
public class a {
    private final String a;
    private final b b;
    private final org.apache.http.entity.mime.g.b c;

    public a(String str, org.apache.http.entity.mime.g.b bVar) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        if (bVar != null) {
            this.a = str;
            this.c = bVar;
            this.b = new b();
            b(bVar);
            c(bVar);
            d(bVar);
            return;
        }
        throw new IllegalArgumentException("Body may not be null");
    }

    public void a(String str, String str2) {
        if (str != null) {
            this.b.a(new e(str, str2));
            return;
        }
        throw new IllegalArgumentException("Field name may not be null");
    }

    protected void b(org.apache.http.entity.mime.g.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(g());
        sb.append("\"");
        if (bVar.getFilename() != null) {
            sb.append("; filename=\"");
            sb.append(bVar.getFilename());
            sb.append("\"");
        }
        a("Content-Disposition", sb.toString());
    }

    protected void c(org.apache.http.entity.mime.g.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.a());
        if (bVar.c() != null) {
            sb.append("; charset=");
            sb.append(bVar.c());
        }
        a(HttpRequest.HEADER_CONTENT_TYPE, sb.toString());
    }

    protected void d(org.apache.http.entity.mime.g.b bVar) {
        a("Content-Transfer-Encoding", bVar.b());
    }

    public org.apache.http.entity.mime.g.b e() {
        return this.c;
    }

    public b f() {
        return this.b;
    }

    public String g() {
        return this.a;
    }
}
