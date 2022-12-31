package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass().isInstance(obj)) {
            FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
            for (FastJsonResponse.Field<?, ?> field : a().values()) {
                if (f(field)) {
                    if (!fastJsonResponse.f(field) || !b(field).equals(fastJsonResponse.b(field))) {
                        return false;
                    }
                } else if (fastJsonResponse.f(field)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean g(String str) {
        return false;
    }

    public int hashCode() {
        int i2 = 0;
        for (FastJsonResponse.Field<?, ?> field : a().values()) {
            if (f(field)) {
                i2 = (i2 * 31) + b(field).hashCode();
            }
        }
        return i2;
    }
}
