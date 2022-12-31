package us.pinguo.foundation.m;

import java.io.IOException;
import java.io.OutputStream;
/* compiled from: ProgressMultipartEntity.java */
/* loaded from: classes4.dex */
public class e extends org.apache.http.entity.mime.f {

    /* renamed from: f  reason: collision with root package name */
    private final a f11023f;

    /* compiled from: ProgressMultipartEntity.java */
    /* loaded from: classes4.dex */
    public interface a {
        void transferred(long j2, long j3);
    }

    public e(a aVar) {
        this.f11023f = aVar;
    }

    @Override // org.apache.http.entity.mime.f
    public void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(new b(outputStream, this.f11023f));
    }
}
