package com.bytedance.sdk.adnet.b;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: FileRequest.java */
/* loaded from: classes.dex */
public class c extends Request<File> {
    private File c;

    /* renamed from: d  reason: collision with root package name */
    private File f1173d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f1174e;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    private m.a<File> f1175f;

    /* compiled from: FileRequest.java */
    /* loaded from: classes.dex */
    public interface a extends m.a<File> {
        void a(long j2, long j3);
    }

    public c(String str, String str2, m.a<File> aVar) {
        super(str2, aVar);
        this.f1174e = new Object();
        this.f1175f = aVar;
        this.c = new File(str);
        this.f1173d = new File(str + ".tmp");
        try {
            File file = this.c;
            if (file != null && file.getParentFile() != null && !this.c.getParentFile().exists()) {
                this.c.getParentFile().mkdirs();
            }
        } catch (Throwable unused) {
        }
        setRetryPolicy(new com.bytedance.sdk.adnet.core.e(25000, 1, 1.0f));
        setShouldCache(false);
    }

    private boolean b(HttpResponse httpResponse) {
        return TextUtils.equals(a(httpResponse, HttpRequest.HEADER_CONTENT_ENCODING), HttpRequest.ENCODING_GZIP);
    }

    private boolean c(HttpResponse httpResponse) {
        if (TextUtils.equals(a(httpResponse, "Accept-Ranges"), "bytes")) {
            return true;
        }
        String a2 = a(httpResponse, "Content-Range");
        return a2 != null && a2.startsWith("bytes");
    }

    private void h() {
        try {
            this.c.delete();
        } catch (Throwable unused) {
        }
        try {
            this.c.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<File> a(com.bytedance.sdk.adnet.core.i iVar) {
        if (!isCanceled()) {
            if (this.f1173d.canRead() && this.f1173d.length() > 0) {
                if (this.f1173d.renameTo(this.c)) {
                    return m.a((Object) null, com.bytedance.sdk.adnet.d.b.a(iVar));
                }
                h();
                return m.a(new VAdError("Can't rename the download temporary file!"));
            }
            h();
            return m.a(new VAdError("Download temporary file was invalid!"));
        }
        h();
        return m.a(new VAdError("Request was Canceled!"));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f1174e) {
            this.f1175f = null;
        }
    }

    public File f() {
        return this.c;
    }

    public File g() {
        return this.f1173d;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Map<String, String> getHeaders() throws com.bytedance.sdk.adnet.err.a {
        HashMap hashMap = new HashMap();
        hashMap.put("Range", "bytes=" + this.f1173d.length() + PGTransHeader.CONNECTOR);
        hashMap.put(HttpRequest.HEADER_ACCEPT_ENCODING, "identity");
        return hashMap;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] a(com.bytedance.sdk.adnet.core.HttpResponse r19) throws java.io.IOException, com.bytedance.sdk.adnet.err.f {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.b.c.a(com.bytedance.sdk.adnet.core.HttpResponse):byte[]");
    }

    private String a(HttpResponse httpResponse, String str) {
        if (httpResponse == null || httpResponse.getHeaders() == null || httpResponse.getHeaders().isEmpty()) {
            return null;
        }
        for (Header header : httpResponse.getHeaders()) {
            if (header != null && TextUtils.equals(header.getName(), str)) {
                return header.getValue();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<File> mVar) {
        m.a<File> aVar;
        synchronized (this.f1174e) {
            aVar = this.f1175f;
        }
        if (aVar != null) {
            aVar.a(m.a(this.c, mVar.b));
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(long j2, long j3) {
        m.a<File> aVar;
        synchronized (this.f1174e) {
            aVar = this.f1175f;
        }
        if (aVar instanceof a) {
            ((a) aVar).a(j2, j3);
        }
    }
}
