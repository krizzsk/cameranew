package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzei {
    private static final String[] zzxx = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzxt = "googleads.g.doubleclick.net";
    private String zzxu = "/pagead/ads";
    private String zzxv = "ad.doubleclick.net";
    private String[] zzxw = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdy zzxy;

    public zzei(zzdy zzdyVar) {
        this.zzxy = zzdyVar;
    }

    private final boolean zza(Uri uri) {
        Objects.requireNonNull(uri);
        try {
            return uri.getHost().equals(this.zzxv);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final boolean zzb(Uri uri) {
        Objects.requireNonNull(uri);
        try {
            String host = uri.getHost();
            for (String str : this.zzxw) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzxx) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final zzdy zzca() {
        return this.zzxy;
    }

    public final Uri zza(Uri uri, Context context) throws zzeh {
        return zza(uri, this.zzxy.zzb(context));
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzxy.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzeh {
        try {
            return zza(uri, this.zzxy.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzeh("Provided Uri is not in a valid state");
        }
    }

    private final Uri zza(Uri uri, String str) throws zzeh {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzeh("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzeh("Query parameter already exists: ms");
            }
            if (zza) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i2 = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i2) + "dc_ms=" + str + ";" + uri2.substring(i2));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 != -1) {
                int i3 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i3) + "ms=" + str + "&" + uri3.substring(i3));
            }
            return uri.buildUpon().appendQueryParameter("ms", str).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzeh("Provided Uri is not in a valid state");
        }
    }
}
