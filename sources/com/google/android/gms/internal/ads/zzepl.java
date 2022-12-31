package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzepl implements zzbr, Closeable, Iterator<zzbs> {
    protected zzepn zzjbd;
    protected zzbn zzjbg;
    private static final zzbs zzjbf = new zzepo("eof ");
    private static zzept zzdc = zzept.zzn(zzepl.class);
    private zzbs zzjbh = null;
    long zzjbi = 0;
    long zzbga = 0;
    long zzasu = 0;
    private List<zzbs> zzjbj = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Iterator
    /* renamed from: zzbml */
    public final zzbs next() {
        zzbs zza;
        zzbs zzbsVar = this.zzjbh;
        if (zzbsVar != null && zzbsVar != zzjbf) {
            this.zzjbh = null;
            return zzbsVar;
        }
        zzepn zzepnVar = this.zzjbd;
        if (zzepnVar != null && this.zzjbi < this.zzasu) {
            try {
                synchronized (zzepnVar) {
                    this.zzjbd.zzfc(this.zzjbi);
                    zza = this.zzjbg.zza(this.zzjbd, this);
                    this.zzjbi = this.zzjbd.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        }
        this.zzjbh = zzjbf;
        throw new NoSuchElementException();
    }

    public void close() throws IOException {
        this.zzjbd.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbs zzbsVar = this.zzjbh;
        if (zzbsVar == zzjbf) {
            return false;
        }
        if (zzbsVar != null) {
            return true;
        }
        try {
            this.zzjbh = (zzbs) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzjbh = zzjbf;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i2 = 0; i2 < this.zzjbj.size(); i2++) {
            if (i2 > 0) {
                sb.append(";");
            }
            sb.append(this.zzjbj.get(i2).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzepn zzepnVar, long j2, zzbn zzbnVar) throws IOException {
        this.zzjbd = zzepnVar;
        long position = zzepnVar.position();
        this.zzbga = position;
        this.zzjbi = position;
        zzepnVar.zzfc(zzepnVar.position() + j2);
        this.zzasu = zzepnVar.position();
        this.zzjbg = zzbnVar;
    }

    public final List<zzbs> zzbmk() {
        if (this.zzjbd != null && this.zzjbh != zzjbf) {
            return new zzepr(this.zzjbj, this);
        }
        return this.zzjbj;
    }
}
