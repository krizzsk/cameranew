package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.p;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class b {
    public final Uri a;

    public b(Uri uri) {
        this.a = uri;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            if (this == obj) {
                return true;
            }
            return p.a(((b) obj).a, this.a);
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.a);
    }
}
