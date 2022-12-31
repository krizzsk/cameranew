package org.apache.http.entity.mime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import us.pinguo.common.network.HttpRequest;
/* compiled from: MultipartEntity.java */
/* loaded from: classes3.dex */
public class f implements HttpEntity {

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f8949e = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final c a;
    private final Header b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f8950d;

    public f(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        str = str == null ? c() : str;
        this.a = new c("form-data", charset, str, httpMultipartMode == null ? HttpMultipartMode.STRICT : httpMultipartMode);
        this.b = new BasicHeader(HttpRequest.HEADER_CONTENT_TYPE, d(str, charset));
        this.f8950d = true;
    }

    public void a(String str, org.apache.http.entity.mime.g.b bVar) {
        b(new a(str, bVar));
    }

    public void b(a aVar) {
        this.a.a(aVar);
        this.f8950d = true;
    }

    protected String c() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i2 = 0; i2 < nextInt; i2++) {
            char[] cArr = f8949e;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    protected String d(String str, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str);
        if (charset != null) {
            sb.append("; charset=");
            sb.append(charset.name());
        }
        return sb.toString();
    }

    public InputStream getContent() throws IOException, UnsupportedOperationException {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        if (this.f8950d) {
            this.c = this.a.f();
            this.f8950d = false;
        }
        return this.c;
    }

    public Header getContentType() {
        return this.b;
    }

    public boolean isChunked() {
        return !isRepeatable();
    }

    public boolean isRepeatable() {
        Iterator<a> it = this.a.d().iterator();
        while (it.hasNext()) {
            if (it.next().e().getContentLength() < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isStreaming() {
        return !isRepeatable();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        this.a.l(outputStream);
    }

    public f() {
        this(HttpMultipartMode.STRICT, null, null);
    }
}
