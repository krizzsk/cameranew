package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzgl {
    private static final String TAG = "zzgl";
    private final String className;
    private final String zzabj;
    private final Class<?>[] zzabm;
    private final zzfc zzwc;
    private final int zzabk = 2;
    private volatile Method zzabl = null;
    private CountDownLatch zzabn = new CountDownLatch(1);

    public zzgl(zzfc zzfcVar, String str, String str2, Class<?>... clsArr) {
        this.zzwc = zzfcVar;
        this.className = str;
        this.zzabj = str2;
        this.zzabm = clsArr;
        zzfcVar.zzcg().submit(new zzgo(this));
    }

    private final String zzb(byte[] bArr, String str) throws zzej, UnsupportedEncodingException {
        return new String(this.zzwc.zzci().zza(bArr, str), "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzda() {
        try {
            Class loadClass = this.zzwc.zzch().loadClass(zzb(this.zzwc.zzcj(), this.className));
            if (loadClass == null) {
                return;
            }
            this.zzabl = loadClass.getMethod(zzb(this.zzwc.zzcj(), this.zzabj), this.zzabm);
            if (this.zzabl == null) {
            }
        } catch (zzej unused) {
        } catch (UnsupportedEncodingException unused2) {
        } catch (ClassNotFoundException unused3) {
        } catch (NoSuchMethodException unused4) {
        } catch (NullPointerException unused5) {
        } finally {
            this.zzabn.countDown();
        }
    }

    public final Method zzdb() {
        if (this.zzabl != null) {
            return this.zzabl;
        }
        try {
            if (this.zzabn.await(2L, TimeUnit.SECONDS)) {
                return this.zzabl;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
