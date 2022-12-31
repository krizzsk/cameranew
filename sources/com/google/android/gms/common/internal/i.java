package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.a;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class i {
    private final SparseIntArray a = new SparseIntArray();
    private GoogleApiAvailabilityLight b;

    public i(@NonNull GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        q.j(googleApiAvailabilityLight);
        this.b = googleApiAvailabilityLight;
    }

    public void a() {
        this.a.clear();
    }

    public int b(@NonNull Context context, @NonNull a.f fVar) {
        q.j(context);
        q.j(fVar);
        int i2 = 0;
        if (fVar.requiresGooglePlayServices()) {
            int minApkVersion = fVar.getMinApkVersion();
            int i3 = this.a.get(minApkVersion, -1);
            if (i3 != -1) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.a.size()) {
                    i2 = i3;
                    break;
                }
                int keyAt = this.a.keyAt(i4);
                if (keyAt > minApkVersion && this.a.get(keyAt) == 0) {
                    break;
                }
                i4++;
            }
            if (i2 == -1) {
                i2 = this.b.g(context, minApkVersion);
            }
            this.a.put(minApkVersion, i2);
            return i2;
        }
        return 0;
    }
}
