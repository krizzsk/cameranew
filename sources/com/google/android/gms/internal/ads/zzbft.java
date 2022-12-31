package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbft {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzbft(int i2, int i3, int i4) {
        this.type = i2;
        this.widthPixels = i3;
        this.heightPixels = i4;
    }

    public static zzbft zzael() {
        return new zzbft(0, 0, 0);
    }

    public static zzbft zzaem() {
        return new zzbft(4, 0, 0);
    }

    public static zzbft zzaen() {
        return new zzbft(5, 0, 0);
    }

    public static zzbft zzb(zzvs zzvsVar) {
        if (zzvsVar.zzcig) {
            return new zzbft(3, 0, 0);
        }
        if (zzvsVar.zzcii) {
            return new zzbft(2, 0, 0);
        }
        if (zzvsVar.zzbrr) {
            return zzael();
        }
        return zzq(zzvsVar.widthPixels, zzvsVar.heightPixels);
    }

    public static zzbft zzq(int i2, int i3) {
        return new zzbft(1, i2, i3);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzaeo() {
        return this.type == 3;
    }

    public final boolean zzaep() {
        return this.type == 0;
    }

    public final boolean zzaeq() {
        return this.type == 4;
    }

    public final boolean zzaer() {
        return this.type == 5;
    }
}
