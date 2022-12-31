package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;
import us.pinguo.common.network.HttpRequest;
/* compiled from: HttpMultipart.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static final ByteArrayBuffer f8945e;

    /* renamed from: f  reason: collision with root package name */
    private static final ByteArrayBuffer f8946f;

    /* renamed from: g  reason: collision with root package name */
    private static final ByteArrayBuffer f8947g;
    private final Charset a;
    private final String b;
    private final List<org.apache.http.entity.mime.a> c;

    /* renamed from: d  reason: collision with root package name */
    private final HttpMultipartMode f8948d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HttpMultipart.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[HttpMultipartMode.values().length];
            a = iArr;
            try {
                iArr[HttpMultipartMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Charset charset = d.a;
        f8945e = c(charset, ": ");
        f8946f = c(charset, "\r\n");
        f8947g = c(charset, "--");
    }

    public c(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        if (str == null) {
            throw new IllegalArgumentException("Multipart subtype may not be null");
        }
        if (str2 != null) {
            this.a = charset == null ? d.a : charset;
            this.b = str2;
            this.c = new ArrayList();
            this.f8948d = httpMultipartMode;
            return;
        }
        throw new IllegalArgumentException("Multipart boundary may not be null");
    }

    private void b(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) throws IOException {
        ByteArrayBuffer c = c(this.a, e());
        for (org.apache.http.entity.mime.a aVar : this.c) {
            i(f8947g, outputStream);
            i(c, outputStream);
            i(f8946f, outputStream);
            b f2 = aVar.f();
            int i2 = a.a[httpMultipartMode.ordinal()];
            if (i2 == 1) {
                Iterator<e> it = f2.iterator();
                while (it.hasNext()) {
                    j(it.next(), outputStream);
                }
            } else if (i2 == 2) {
                k(aVar.f().b("Content-Disposition"), this.a, outputStream);
                if (aVar.e().getFilename() != null) {
                    k(aVar.f().b(HttpRequest.HEADER_CONTENT_TYPE), this.a, outputStream);
                }
            }
            ByteArrayBuffer byteArrayBuffer = f8946f;
            i(byteArrayBuffer, outputStream);
            if (z) {
                aVar.e().writeTo(outputStream);
            }
            i(byteArrayBuffer, outputStream);
        }
        ByteArrayBuffer byteArrayBuffer2 = f8947g;
        i(byteArrayBuffer2, outputStream);
        i(c, outputStream);
        i(byteArrayBuffer2, outputStream);
        i(f8946f, outputStream);
    }

    private static ByteArrayBuffer c(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void g(String str, OutputStream outputStream) throws IOException {
        i(c(d.a, str), outputStream);
    }

    private static void h(String str, Charset charset, OutputStream outputStream) throws IOException {
        i(c(charset, str), outputStream);
    }

    private static void i(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void j(e eVar, OutputStream outputStream) throws IOException {
        g(eVar.b(), outputStream);
        i(f8945e, outputStream);
        g(eVar.a(), outputStream);
        i(f8946f, outputStream);
    }

    private static void k(e eVar, Charset charset, OutputStream outputStream) throws IOException {
        h(eVar.b(), charset, outputStream);
        i(f8945e, outputStream);
        h(eVar.a(), charset, outputStream);
        i(f8946f, outputStream);
    }

    public void a(org.apache.http.entity.mime.a aVar) {
        if (aVar == null) {
            return;
        }
        this.c.add(aVar);
    }

    public List<org.apache.http.entity.mime.a> d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    public long f() {
        ByteArrayOutputStream byteArrayOutputStream;
        long j2 = 0;
        for (org.apache.http.entity.mime.a aVar : this.c) {
            long contentLength = aVar.e().getContentLength();
            if (contentLength < 0) {
                return -1L;
            }
            j2 += contentLength;
        }
        try {
            b(this.f8948d, new ByteArrayOutputStream(), false);
            return j2 + byteArrayOutputStream.toByteArray().length;
        } catch (IOException unused) {
            return -1L;
        }
    }

    public void l(OutputStream outputStream) throws IOException {
        b(this.f8948d, outputStream, true);
    }
}
