package com.google.android.gms.internal.ads;

import android.graphics.Color;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzady extends zzaei {
    private static final int zzdff;
    private static final int zzdfg;
    private static final int zzdfh;
    private static final int zzdfi;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzdfj;
    private final List<zzaed> zzdfk = new ArrayList();
    private final List<zzaer> zzdfl = new ArrayList();
    private final int zzdfm;
    private final int zzdfn;
    private final boolean zzdfo;

    static {
        int rgb = Color.rgb(12, 174, 206);
        zzdff = rgb;
        int rgb2 = Color.rgb(204, 204, 204);
        zzdfg = rgb2;
        zzdfh = rgb2;
        zzdfi = rgb;
    }

    public zzady(String str, List<zzaed> list, Integer num, Integer num2, Integer num3, int i2, int i3, boolean z) {
        this.zzdfj = str;
        if (list != null) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                zzaed zzaedVar = list.get(i4);
                this.zzdfk.add(zzaedVar);
                this.zzdfl.add(zzaedVar);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzdfh;
        this.textColor = num2 != null ? num2.intValue() : zzdfi;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzdfm = i2;
        this.zzdfn = i3;
        this.zzdfo = z;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final String getText() {
        return this.zzdfj;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final List<zzaer> zztd() {
        return this.zzdfl;
    }

    public final List<zzaed> zzte() {
        return this.zzdfk;
    }

    public final int zztf() {
        return this.zzdfm;
    }

    public final int zztg() {
        return this.zzdfn;
    }
}
