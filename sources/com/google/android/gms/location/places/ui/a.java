package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.firebase.analytics.FirebaseAnalytics;
@Deprecated
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: com.google.android.gms.location.places.ui.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0165a extends e {
        public C0165a(int i2) {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.a.putExtra("gmscore_client_jar_version", GoogleApiAvailability.f3592f);
            this.a.putExtra("mode", i2);
            this.a.putExtra(FirebaseAnalytics.Param.ORIGIN, 2);
        }

        @Override // com.google.android.gms.location.places.ui.e
        public Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.a(activity);
        }

        public C0165a b(@Nullable LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.a.putExtra("bounds", latLngBounds);
            } else {
                this.a.removeExtra("bounds");
            }
            return this;
        }

        public C0165a c(@Nullable AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.a.putExtra("filter", autocompleteFilter);
            } else {
                this.a.removeExtra("filter");
            }
            return this;
        }

        public final C0165a d(int i2) {
            this.a.putExtra(FirebaseAnalytics.Param.ORIGIN, 1);
            return this;
        }

        public final C0165a e(@Nullable String str) {
            if (str != null) {
                this.a.putExtra("initial_query", str);
            } else {
                this.a.removeExtra("initial_query");
            }
            return this;
        }
    }

    public static com.google.android.gms.location.places.a a(Context context, Intent intent) {
        return d.a(context, intent);
    }

    public static Status b(Context context, Intent intent) {
        return d.b(context, intent);
    }
}
