package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.o;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class FirebaseExceptionMapper implements o {
    public Exception getException(Status status) {
        if (status.R() == 8) {
            return new FirebaseException(status.W());
        }
        return new FirebaseApiNotAvailableException(status.W());
    }
}
