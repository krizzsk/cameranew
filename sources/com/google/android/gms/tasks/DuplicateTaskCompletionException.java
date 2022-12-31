package com.google.android.gms.tasks;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(g<?> gVar) {
        String str;
        if (!gVar.m()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception i2 = gVar.i();
        if (i2 != null) {
            str = "failure";
        } else if (gVar.n()) {
            String valueOf = String.valueOf(gVar.j());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
            sb.append("result ");
            sb.append(valueOf);
            str = sb.toString();
        } else {
            str = gVar.l() ? "cancellation" : "unknown issue";
        }
        String valueOf2 = String.valueOf(str);
        return new DuplicateTaskCompletionException(valueOf2.length() != 0 ? "Complete with: ".concat(valueOf2) : new String("Complete with: "), i2);
    }
}
