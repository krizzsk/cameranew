package com.google.android.gms.location.places.ui;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.places.internal.PlaceEntity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d {
    public static com.google.android.gms.location.places.a a(Context context, Intent intent) {
        q.k(intent, "intent must not be null");
        q.k(context, "context must not be null");
        return (com.google.android.gms.location.places.a) com.google.android.gms.common.internal.safeparcel.b.b(intent, "selected_place", PlaceEntity.CREATOR);
    }

    public static Status b(Context context, Intent intent) {
        q.k(intent, "intent must not be null");
        q.k(context, "context must not be null");
        return (Status) com.google.android.gms.common.internal.safeparcel.b.b(intent, "status", Status.CREATOR);
    }
}
