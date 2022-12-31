package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzjh implements zziu {
    private final zzix zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjh(zzix zzixVar, String str, Object[] objArr) {
        char charAt;
        this.zza = zzixVar;
        this.zzb = str;
        this.zzc = objArr;
        int i2 = 1;
        try {
            charAt = str.charAt(0);
        } catch (ArrayIndexOutOfBoundsException unused) {
            char[] charArray = str.toCharArray();
            String str2 = new String(charArray);
            try {
                try {
                    charAt = str2.charAt(0);
                    str = str2;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    e = e2;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                }
            } catch (ArrayIndexOutOfBoundsException unused2) {
                char[] cArr = new char[str2.length()];
                str2.getChars(0, str2.length(), cArr, 0);
                String str3 = new String(cArr);
                try {
                    charAt = str3.charAt(0);
                    str = str3;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    e = e3;
                    str2 = str3;
                    throw new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", str2, Integer.valueOf(charArray.length)), e);
                }
            }
        }
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i3 = charAt & 8191;
        int i4 = 13;
        while (true) {
            int i5 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 < 55296) {
                this.zzd = (charAt2 << i4) | i3;
                return;
            }
            i3 |= (charAt2 & 8191) << i4;
            i4 += 13;
            i2 = i5;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final boolean zza() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final zzix zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zziu
    public final int zzc() {
        return (this.zzd & 1) == 1 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
