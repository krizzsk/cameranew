package com.bytedance.sdk.adnet.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;
import java.io.UnsupportedEncodingException;
/* compiled from: JsonRequest.java */
/* loaded from: classes.dex */
public abstract class g<T> extends Request<T> {
    private static final String c = String.format("application/json; charset=%s", "utf-8");

    /* renamed from: d  reason: collision with root package name */
    private final Object f1193d;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    private m.a<T> f1194e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f1195f;

    public g(int i2, String str, @Nullable String str2, @Nullable m.a<T> aVar) {
        super(i2, str, aVar);
        this.f1193d = new Object();
        this.f1194e = aVar;
        this.f1195f = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public abstract m<T> a(com.bytedance.sdk.adnet.core.i iVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<T> mVar) {
        m.a<T> aVar;
        synchronized (this.f1193d) {
            aVar = this.f1194e;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f1193d) {
            this.f1194e = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public byte[] getBody() {
        try {
            String str = this.f1195f;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            o.d("Unsupported Encoding while trying to get the bytes of %s using %s", this.f1195f, "utf-8");
            return null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public String getBodyContentType() {
        return c;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }
}
