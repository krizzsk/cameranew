package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zab extends AbstractSafeParcelable implements com.google.android.gms.common.api.g {
    public static final Parcelable.Creator<zab> CREATOR = new b();
    private final int versionCode;
    private int zasx;
    @Nullable
    private Intent zasy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zab(int i2, int i3, @Nullable Intent intent) {
        this.versionCode = i2;
        this.zasx = i3;
        this.zasy = intent;
    }

    @Override // com.google.android.gms.common.api.g
    public final Status getStatus() {
        if (this.zasx == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zasx);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 3, this.zasy, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public zab() {
        this(0, null);
    }

    private zab(int i2, @Nullable Intent intent) {
        this(2, 0, null);
    }
}
