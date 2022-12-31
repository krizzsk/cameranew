package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new c();
    private final int zalk;
    private final int zanj;
    private final int zank;
    private final Uri zanm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebImage(int i2, Uri uri, int i3, int i4) {
        this.zalk = i2;
        this.zanm = uri;
        this.zanj = i3;
        this.zank = i4;
    }

    private static Uri T(JSONObject jSONObject) {
        if (jSONObject.has("url")) {
            try {
                return Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final int Q() {
        return this.zank;
    }

    public final Uri R() {
        return this.zanm;
    }

    public final int S() {
        return this.zanj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (p.a(this.zanm, webImage.zanm) && this.zanj == webImage.zanj && this.zank == webImage.zank) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.zanm, Integer.valueOf(this.zanj), Integer.valueOf(this.zank));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.zanj), Integer.valueOf(this.zank), this.zanm.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, R(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, S());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 4, Q());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public WebImage(Uri uri, int i2, int i3) throws IllegalArgumentException {
        this(1, uri, i2, i3);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(T(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }
}
