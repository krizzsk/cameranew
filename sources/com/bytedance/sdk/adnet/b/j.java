package com.bytedance.sdk.adnet.b;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import java.io.UnsupportedEncodingException;
/* compiled from: StringRequest.java */
/* loaded from: classes.dex */
public class j extends Request<String> {
    private final Object c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    private m.a<String> f1196d;

    public j(int i2, String str, @Nullable m.a<String> aVar) {
        super(i2, str, aVar);
        this.c = new Object();
        this.f1196d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public void a(m<String> mVar) {
        m.a<String> aVar;
        synchronized (this.c) {
            aVar = this.f1196d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.c) {
            this.f1196d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.adnet.core.Request
    public m<String> a(com.bytedance.sdk.adnet.core.i iVar) {
        String str;
        try {
            str = new String(iVar.b, com.bytedance.sdk.adnet.d.b.a(iVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(iVar.b);
        }
        return m.a(str, com.bytedance.sdk.adnet.d.b.a(iVar));
    }
}
