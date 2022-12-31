package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.growingio.android.sdk.utils.NetworkUtil;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNKNOWN = -1;
    private final int zza;
    private final int zzb;
    @Nullable
    private final PendingIntent zzc;
    @Nullable
    private final String zzd;
    public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionResult(int i2, int i3, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this.zza = i2;
        this.zzb = i3;
        this.zzc = pendingIntent;
        this.zzd = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static String V(int i2) {
        if (i2 != 99) {
            if (i2 != 1500) {
                switch (i2) {
                    case -1:
                        return NetworkUtil.NETWORK_UNKNOWN;
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i2) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            default:
                                StringBuilder sb = new StringBuilder(31);
                                sb.append("UNKNOWN_ERROR_CODE(");
                                sb.append(i2);
                                sb.append(")");
                                return sb.toString();
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final int Q() {
        return this.zzb;
    }

    @Nullable
    public final String R() {
        return this.zzd;
    }

    @Nullable
    public final PendingIntent S() {
        return this.zzc;
    }

    public final boolean T() {
        return (this.zzb == 0 || this.zzc == null) ? false : true;
    }

    public final boolean U() {
        return this.zzb == 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConnectionResult) {
            ConnectionResult connectionResult = (ConnectionResult) obj;
            return this.zzb == connectionResult.zzb && com.google.android.gms.common.internal.p.a(this.zzc, connectionResult.zzc) && com.google.android.gms.common.internal.p.a(this.zzd, connectionResult.zzd);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("statusCode", V(this.zzb));
        c.a("resolution", this.zzc);
        c.a("message", this.zzd);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zza);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, Q());
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, S(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public ConnectionResult(int i2) {
        this(i2, null, null);
    }

    public ConnectionResult(int i2, @Nullable PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public ConnectionResult(int i2, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i2, pendingIntent, str);
    }
}
