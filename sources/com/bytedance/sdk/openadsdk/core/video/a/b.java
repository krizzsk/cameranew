package com.bytedance.sdk.openadsdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.IOException;
/* compiled from: SdkMediaDataSource.java */
@RequiresApi(api = 23)
/* loaded from: classes.dex */
public class b extends MediaDataSource {
    private String a;
    private String b;
    private com.bytedance.sdk.openadsdk.core.video.a.a.a c = null;

    /* renamed from: d  reason: collision with root package name */
    private long f1780d = -2147483648L;

    /* renamed from: e  reason: collision with root package name */
    private Context f1781e;

    public b(Context context, String str, String str2) {
        this.f1781e = context;
        this.a = str;
        if (TextUtils.isEmpty(str2)) {
            this.b = com.bytedance.sdk.openadsdk.h.g.b.a(str);
        } else {
            this.b = str2;
        }
    }

    private void b() {
        if (this.c == null) {
            String str = this.a;
            String str2 = this.b;
            this.c = new com.bytedance.sdk.openadsdk.core.video.a.a.b(str, str2, c.a(this.f1781e, str2));
        }
    }

    public boolean a() {
        b();
        return this.c.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        o.c("SdkMediaDataSource", "close: " + this.a);
        com.bytedance.sdk.openadsdk.core.video.a.a.a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        b();
        if (this.f1780d == -2147483648L) {
            if (this.f1781e == null || TextUtils.isEmpty(this.a)) {
                return -1L;
            }
            this.f1780d = this.c.b();
            o.c("SdkMediaDataSource", "getSize: " + this.f1780d);
        }
        return this.f1780d;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException {
        b();
        int a = this.c.a(j2, bArr, i2, i3);
        o.c("SdkMediaDataSource", "readAt: position = " + j2 + "  buffer.length =" + bArr.length + "  offset = " + i2 + " size =" + a + "  current = " + Thread.currentThread());
        return a;
    }
}
