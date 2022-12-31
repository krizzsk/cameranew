package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzth extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzth> CREATOR = new zztg();
    @Nullable
    public final String url;
    private final long zzbvl;
    private final String zzbvm;
    private final String zzbvn;
    private final String zzbvo;
    private final Bundle zzbvp;
    public final boolean zzbvq;
    public long zzbvr;
    public String zzbvs;
    public int zzbvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzth(@Nullable String str, long j2, String str2, String str3, String str4, Bundle bundle, boolean z, long j3, String str5, int i2) {
        this.url = str;
        this.zzbvl = j2;
        this.zzbvm = str2 == null ? "" : str2;
        this.zzbvn = str3 == null ? "" : str3;
        this.zzbvo = str4 == null ? "" : str4;
        this.zzbvp = bundle == null ? new Bundle() : bundle;
        this.zzbvq = z;
        this.zzbvr = j3;
        this.zzbvs = str5;
        this.zzbvt = i2;
    }

    @Nullable
    public static zzth zzbs(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzth zzd(Uri uri) {
        try {
            if ("gcache".equals(uri.getScheme())) {
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() != 2) {
                    int size = pathSegments.size();
                    StringBuilder sb = new StringBuilder(62);
                    sb.append("Expected 2 path parts for namespace and id, found :");
                    sb.append(size);
                    zzazk.zzex(sb.toString());
                    return null;
                }
                String str = pathSegments.get(0);
                String str2 = pathSegments.get(1);
                String host = uri.getHost();
                String queryParameter = uri.getQueryParameter("url");
                boolean equals = "1".equals(uri.getQueryParameter("read_only"));
                String queryParameter2 = uri.getQueryParameter("expiration");
                long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
                Bundle bundle = new Bundle();
                for (String str3 : uri.getQueryParameterNames()) {
                    if (str3.startsWith("tag.")) {
                        bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                    }
                }
                return new zzth(queryParameter, parseLong, host, str, str2, bundle, equals, 0L, "", 0);
            }
            return null;
        } catch (NullPointerException | NumberFormatException e2) {
            zzazk.zzd("Unable to parse Uri into cache offering.", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 2, this.url, false);
        a.q(parcel, 3, this.zzbvl);
        a.v(parcel, 4, this.zzbvm, false);
        a.v(parcel, 5, this.zzbvn, false);
        a.v(parcel, 6, this.zzbvo, false);
        a.e(parcel, 7, this.zzbvp, false);
        a.c(parcel, 8, this.zzbvq);
        a.q(parcel, 9, this.zzbvr);
        a.v(parcel, 10, this.zzbvs, false);
        a.m(parcel, 11, this.zzbvt);
        a.b(parcel, a);
    }
}
