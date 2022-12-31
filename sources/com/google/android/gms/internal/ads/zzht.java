package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.location.LocationRequestCompat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzht implements Parcelable {
    public static final Parcelable.Creator<zzht> CREATOR = new zzhs();
    public final int height;
    private final String id;
    public final int width;
    public final int zzaha;
    public final String zzahb;
    private final zzmh zzahc;
    public final String zzahd;
    public final String zzahe;
    public final int zzahf;
    public final List<byte[]> zzahg;
    public final zzjo zzahh;
    public final float zzahi;
    public final int zzahj;
    public final float zzahk;
    private final int zzahl;
    private final byte[] zzahm;
    private final zzpy zzahn;
    public final int zzaho;
    public final int zzahp;
    public final int zzahq;
    private final int zzahr;
    private final int zzahs;
    public final long zzaht;
    public final int zzahu;
    public final String zzahv;
    private final int zzahw;
    private int zzahx;

    private zzht(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, zzpy zzpyVar, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j2, List<byte[]> list, zzjo zzjoVar, zzmh zzmhVar) {
        this.id = str;
        this.zzahd = str2;
        this.zzahe = str3;
        this.zzahb = str4;
        this.zzaha = i2;
        this.zzahf = i3;
        this.width = i4;
        this.height = i5;
        this.zzahi = f2;
        this.zzahj = i6;
        this.zzahk = f3;
        this.zzahm = bArr;
        this.zzahl = i7;
        this.zzahn = zzpyVar;
        this.zzaho = i8;
        this.zzahp = i9;
        this.zzahq = i10;
        this.zzahr = i11;
        this.zzahs = i12;
        this.zzahu = i13;
        this.zzahv = str5;
        this.zzahw = i14;
        this.zzaht = j2;
        this.zzahg = list == null ? Collections.emptyList() : list;
        this.zzahh = zzjoVar;
        this.zzahc = zzmhVar;
    }

    public static zzht zza(String str, String str2, String str3, int i2, int i3, int i4, int i5, float f2, List<byte[]> list, int i6, float f3, byte[] bArr, int i7, zzpy zzpyVar, zzjo zzjoVar) {
        return new zzht(str, null, str2, null, -1, i3, i4, i5, -1.0f, i6, f3, bArr, i7, zzpyVar, -1, -1, -1, -1, -1, 0, null, -1, LocationRequestCompat.PASSIVE_INTERVAL, list, zzjoVar, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzht.class == obj.getClass()) {
            zzht zzhtVar = (zzht) obj;
            if (this.zzaha == zzhtVar.zzaha && this.zzahf == zzhtVar.zzahf && this.width == zzhtVar.width && this.height == zzhtVar.height && this.zzahi == zzhtVar.zzahi && this.zzahj == zzhtVar.zzahj && this.zzahk == zzhtVar.zzahk && this.zzahl == zzhtVar.zzahl && this.zzaho == zzhtVar.zzaho && this.zzahp == zzhtVar.zzahp && this.zzahq == zzhtVar.zzahq && this.zzahr == zzhtVar.zzahr && this.zzahs == zzhtVar.zzahs && this.zzaht == zzhtVar.zzaht && this.zzahu == zzhtVar.zzahu && zzpt.zza(this.id, zzhtVar.id) && zzpt.zza(this.zzahv, zzhtVar.zzahv) && this.zzahw == zzhtVar.zzahw && zzpt.zza(this.zzahd, zzhtVar.zzahd) && zzpt.zza(this.zzahe, zzhtVar.zzahe) && zzpt.zza(this.zzahb, zzhtVar.zzahb) && zzpt.zza(this.zzahh, zzhtVar.zzahh) && zzpt.zza(this.zzahc, zzhtVar.zzahc) && zzpt.zza(this.zzahn, zzhtVar.zzahn) && Arrays.equals(this.zzahm, zzhtVar.zzahm) && this.zzahg.size() == zzhtVar.zzahg.size()) {
                for (int i2 = 0; i2 < this.zzahg.size(); i2++) {
                    if (!Arrays.equals(this.zzahg.get(i2), zzhtVar.zzahg.get(i2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahx == 0) {
            String str = this.id;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzahd;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzahe;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzahb;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzaha) * 31) + this.width) * 31) + this.height) * 31) + this.zzaho) * 31) + this.zzahp) * 31;
            String str5 = this.zzahv;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzahw) * 31;
            zzjo zzjoVar = this.zzahh;
            int hashCode6 = (hashCode5 + (zzjoVar == null ? 0 : zzjoVar.hashCode())) * 31;
            zzmh zzmhVar = this.zzahc;
            this.zzahx = hashCode6 + (zzmhVar != null ? zzmhVar.hashCode() : 0);
        }
        return this.zzahx;
    }

    public final String toString() {
        String str = this.id;
        String str2 = this.zzahd;
        String str3 = this.zzahe;
        int i2 = this.zzaha;
        String str4 = this.zzahv;
        int i3 = this.width;
        int i4 = this.height;
        float f2 = this.zzahi;
        int i5 = this.zzaho;
        int i6 = this.zzahp;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(f2);
        sb.append("], [");
        sb.append(i5);
        sb.append(", ");
        sb.append(i6);
        sb.append("])");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.zzahd);
        parcel.writeString(this.zzahe);
        parcel.writeString(this.zzahb);
        parcel.writeInt(this.zzaha);
        parcel.writeInt(this.zzahf);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzahi);
        parcel.writeInt(this.zzahj);
        parcel.writeFloat(this.zzahk);
        parcel.writeInt(this.zzahm != null ? 1 : 0);
        byte[] bArr = this.zzahm;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzahl);
        parcel.writeParcelable(this.zzahn, i2);
        parcel.writeInt(this.zzaho);
        parcel.writeInt(this.zzahp);
        parcel.writeInt(this.zzahq);
        parcel.writeInt(this.zzahr);
        parcel.writeInt(this.zzahs);
        parcel.writeInt(this.zzahu);
        parcel.writeString(this.zzahv);
        parcel.writeInt(this.zzahw);
        parcel.writeLong(this.zzaht);
        int size = this.zzahg.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.zzahg.get(i3));
        }
        parcel.writeParcelable(this.zzahh, 0);
        parcel.writeParcelable(this.zzahc, 0);
    }

    public final zzht zzb(int i2, int i3) {
        return new zzht(this.id, this.zzahd, this.zzahe, this.zzahb, this.zzaha, this.zzahf, this.width, this.height, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahl, this.zzahn, this.zzaho, this.zzahp, this.zzahq, i2, i3, this.zzahu, this.zzahv, this.zzahw, this.zzaht, this.zzahg, this.zzahh, this.zzahc);
    }

    public final zzht zzds(long j2) {
        return new zzht(this.id, this.zzahd, this.zzahe, this.zzahb, this.zzaha, this.zzahf, this.width, this.height, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahl, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahr, this.zzahs, this.zzahu, this.zzahv, this.zzahw, j2, this.zzahg, this.zzahh, this.zzahc);
    }

    public final int zzez() {
        int i2;
        int i3 = this.width;
        if (i3 == -1 || (i2 = this.height) == -1) {
            return -1;
        }
        return i3 * i2;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzfa() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(IMediaFormat.KEY_MIME, this.zzahe);
        String str = this.zzahv;
        if (str != null) {
            mediaFormat.setString(IjkMediaMeta.IJKM_KEY_LANGUAGE, str);
        }
        zza(mediaFormat, "max-input-size", this.zzahf);
        zza(mediaFormat, "width", this.width);
        zza(mediaFormat, "height", this.height);
        float f2 = this.zzahi;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        zza(mediaFormat, "rotation-degrees", this.zzahj);
        zza(mediaFormat, "channel-count", this.zzaho);
        zza(mediaFormat, "sample-rate", this.zzahp);
        zza(mediaFormat, "encoder-delay", this.zzahr);
        zza(mediaFormat, "encoder-padding", this.zzahs);
        for (int i2 = 0; i2 < this.zzahg.size(); i2++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i2);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzahg.get(i2)));
        }
        zzpy zzpyVar = this.zzahn;
        if (zzpyVar != null) {
            zza(mediaFormat, "color-transfer", zzpyVar.zzarw);
            zza(mediaFormat, "color-standard", zzpyVar.zzarv);
            zza(mediaFormat, "color-range", zzpyVar.zzarx);
            byte[] bArr = zzpyVar.zzbkt;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzht zzv(int i2) {
        return new zzht(this.id, this.zzahd, this.zzahe, this.zzahb, this.zzaha, i2, this.width, this.height, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahl, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahr, this.zzahs, this.zzahu, this.zzahv, this.zzahw, this.zzaht, this.zzahg, this.zzahh, this.zzahc);
    }

    public static zzht zza(String str, String str2, String str3, int i2, int i3, int i4, int i5, List<byte[]> list, zzjo zzjoVar, int i6, String str4) {
        return zza(str, str2, null, -1, -1, i4, i5, -1, null, zzjoVar, 0, str4);
    }

    public static zzht zza(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, zzjo zzjoVar, int i7, String str4) {
        return new zzht(str, null, str2, null, -1, i3, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i4, i5, i6, -1, -1, i7, str4, -1, LocationRequestCompat.PASSIVE_INTERVAL, list, zzjoVar, null);
    }

    public static zzht zza(String str, String str2, String str3, int i2, int i3, String str4, zzjo zzjoVar) {
        return zza(str, str2, null, -1, i3, str4, -1, zzjoVar, LocationRequestCompat.PASSIVE_INTERVAL, Collections.emptyList());
    }

    public static zzht zza(String str, String str2, String str3, int i2, int i3, String str4, int i4, zzjo zzjoVar, long j2, List<byte[]> list) {
        return new zzht(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i3, str4, -1, j2, list, zzjoVar, null);
    }

    public static zzht zza(String str, String str2, String str3, int i2, List<byte[]> list, String str4, zzjo zzjoVar) {
        return new zzht(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, LocationRequestCompat.PASSIVE_INTERVAL, list, zzjoVar, null);
    }

    public static zzht zza(String str, String str2, long j2) {
        return new zzht(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, LocationRequestCompat.PASSIVE_INTERVAL, null, null, null);
    }

    public static zzht zza(String str, String str2, String str3, int i2, zzjo zzjoVar) {
        return new zzht(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, LocationRequestCompat.PASSIVE_INTERVAL, null, zzjoVar, null);
    }

    public final zzht zza(zzjo zzjoVar) {
        return new zzht(this.id, this.zzahd, this.zzahe, this.zzahb, this.zzaha, this.zzahf, this.width, this.height, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahl, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahr, this.zzahs, this.zzahu, this.zzahv, this.zzahw, this.zzaht, this.zzahg, zzjoVar, this.zzahc);
    }

    public final zzht zza(zzmh zzmhVar) {
        return new zzht(this.id, this.zzahd, this.zzahe, this.zzahb, this.zzaha, this.zzahf, this.width, this.height, this.zzahi, this.zzahj, this.zzahk, this.zzahm, this.zzahl, this.zzahn, this.zzaho, this.zzahp, this.zzahq, this.zzahr, this.zzahs, this.zzahu, this.zzahv, this.zzahw, this.zzaht, this.zzahg, this.zzahh, zzmhVar);
    }

    @TargetApi(16)
    private static void zza(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzht(Parcel parcel) {
        this.id = parcel.readString();
        this.zzahd = parcel.readString();
        this.zzahe = parcel.readString();
        this.zzahb = parcel.readString();
        this.zzaha = parcel.readInt();
        this.zzahf = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzahi = parcel.readFloat();
        this.zzahj = parcel.readInt();
        this.zzahk = parcel.readFloat();
        this.zzahm = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzahl = parcel.readInt();
        this.zzahn = (zzpy) parcel.readParcelable(zzpy.class.getClassLoader());
        this.zzaho = parcel.readInt();
        this.zzahp = parcel.readInt();
        this.zzahq = parcel.readInt();
        this.zzahr = parcel.readInt();
        this.zzahs = parcel.readInt();
        this.zzahu = parcel.readInt();
        this.zzahv = parcel.readString();
        this.zzahw = parcel.readInt();
        this.zzaht = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzahg = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.zzahg.add(parcel.createByteArray());
        }
        this.zzahh = (zzjo) parcel.readParcelable(zzjo.class.getClassLoader());
        this.zzahc = (zzmh) parcel.readParcelable(zzmh.class.getClassLoader());
    }
}
