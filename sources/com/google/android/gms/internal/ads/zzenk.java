package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzenk extends InputStream {
    private int mark;
    private final /* synthetic */ zzeng zzitt;
    private zzenh zziud;
    private zzejy zziue;
    private int zziuf;
    private int zziug;
    private int zziuh;

    public zzenk(zzeng zzengVar) {
        this.zzitt = zzengVar;
        initialize();
    }

    private final void initialize() {
        zzenh zzenhVar = new zzenh(this.zzitt, null);
        this.zziud = zzenhVar;
        zzejy zzejyVar = (zzejy) zzenhVar.next();
        this.zziue = zzejyVar;
        this.zziuf = zzejyVar.size();
        this.zziug = 0;
        this.zziuh = 0;
    }

    private final void zzbkj() {
        if (this.zziue != null) {
            int i2 = this.zziug;
            int i3 = this.zziuf;
            if (i2 == i3) {
                this.zziuh += i3;
                this.zziug = 0;
                if (this.zziud.hasNext()) {
                    zzejy zzejyVar = (zzejy) this.zziud.next();
                    this.zziue = zzejyVar;
                    this.zziuf = zzejyVar.size();
                    return;
                }
                this.zziue = null;
                this.zziuf = 0;
            }
        }
    }

    private final int zzbkk() {
        return this.zzitt.size() - (this.zziuh + this.zziug);
    }

    private final int zzl(byte[] bArr, int i2, int i3) {
        int i4 = i3;
        while (i4 > 0) {
            zzbkj();
            if (this.zziue == null) {
                break;
            }
            int min = Math.min(this.zziuf - this.zziug, i4);
            if (bArr != null) {
                this.zziue.zza(bArr, this.zziug, i2, min);
                i2 += min;
            }
            this.zziug += min;
            i4 -= min;
        }
        return i3 - i4;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return zzbkk();
    }

    @Override // java.io.InputStream
    public final void mark(int i2) {
        this.mark = this.zziuh + this.zziug;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr);
        if (i2 >= 0 && i3 >= 0 && i3 <= bArr.length - i2) {
            int zzl = zzl(bArr, i2, i3);
            if (zzl == 0) {
                if (i3 > 0 || zzbkk() == 0) {
                    return -1;
                }
                return zzl;
            }
            return zzl;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        initialize();
        zzl(null, 0, this.mark);
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        if (j2 >= 0) {
            if (j2 > 2147483647L) {
                j2 = 2147483647L;
            }
            return zzl(null, 0, (int) j2);
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        zzbkj();
        zzejy zzejyVar = this.zziue;
        if (zzejyVar == null) {
            return -1;
        }
        int i2 = this.zziug;
        this.zziug = i2 + 1;
        return zzejyVar.zzfz(i2) & Draft_75.END_OF_FRAME;
    }
}
