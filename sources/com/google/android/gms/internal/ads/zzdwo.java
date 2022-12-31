package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
abstract class zzdwo extends zzdvq<String> {
    private int limit;
    private int offset = 0;
    private final zzdvu zzhvz;
    private final boolean zzhwa;
    final CharSequence zzhwe;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdwo(zzdwk zzdwkVar, CharSequence charSequence) {
        zzdvu zzdvuVar;
        int i2;
        zzdvuVar = zzdwkVar.zzhvz;
        this.zzhvz = zzdvuVar;
        this.zzhwa = false;
        i2 = zzdwkVar.limit;
        this.limit = i2;
        this.zzhwe = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzdvq
    protected final /* synthetic */ String zzaza() {
        int i2 = this.offset;
        while (true) {
            int i3 = this.offset;
            if (i3 != -1) {
                int zzen = zzen(i3);
                if (zzen == -1) {
                    zzen = this.zzhwe.length();
                    this.offset = -1;
                } else {
                    this.offset = zzeo(zzen);
                }
                int i4 = this.offset;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.offset = i5;
                    if (i5 > this.zzhwe.length()) {
                        this.offset = -1;
                    }
                } else {
                    while (i2 < zzen && this.zzhvz.zzc(this.zzhwe.charAt(i2))) {
                        i2++;
                    }
                    while (zzen > i2 && this.zzhvz.zzc(this.zzhwe.charAt(zzen - 1))) {
                        zzen--;
                    }
                    int i6 = this.limit;
                    if (i6 == 1) {
                        zzen = this.zzhwe.length();
                        this.offset = -1;
                        while (zzen > i2 && this.zzhvz.zzc(this.zzhwe.charAt(zzen - 1))) {
                            zzen--;
                        }
                    } else {
                        this.limit = i6 - 1;
                    }
                    return this.zzhwe.subSequence(i2, zzen).toString();
                }
            } else {
                zzazb();
                return null;
            }
        }
    }

    abstract int zzen(int i2);

    abstract int zzeo(int i2);
}
