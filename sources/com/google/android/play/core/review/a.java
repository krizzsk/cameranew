package com.google.android.play.core.review;

import android.app.PendingIntent;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a extends ReviewInfo {
    private final PendingIntent a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PendingIntent pendingIntent) {
        Objects.requireNonNull(pendingIntent, "Null pendingIntent");
        this.a = pendingIntent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.play.core.review.ReviewInfo
    public final PendingIntent a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewInfo) {
            return this.a.equals(((ReviewInfo) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("ReviewInfo{pendingIntent=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }
}
