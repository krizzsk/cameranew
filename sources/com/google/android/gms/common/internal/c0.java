package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
final class c0 implements Parcelable.Creator<BinderWrapper> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BinderWrapper[] newArray(int i2) {
        return new BinderWrapper[i2];
    }
}
