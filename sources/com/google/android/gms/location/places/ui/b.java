package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.maps.model.LatLngBounds;
@Deprecated
/* loaded from: classes2.dex */
public class b extends d {

    /* loaded from: classes2.dex */
    public static class a extends e {
        public a() {
            super("com.google.android.gms.location.places.ui.PICK_PLACE");
            this.a.putExtra("gmscore_client_jar_version", GoogleApiAvailability.f3592f);
        }

        @Override // com.google.android.gms.location.places.ui.e
        public Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.a(activity);
        }

        public a b(LatLngBounds latLngBounds) {
            q.j(latLngBounds);
            com.google.android.gms.common.internal.safeparcel.b.d(latLngBounds, this.a, "latlng_bounds");
            return this;
        }
    }

    @Deprecated
    public static com.google.android.gms.location.places.a c(Intent intent, Context context) {
        return d.a(context, intent);
    }
}
