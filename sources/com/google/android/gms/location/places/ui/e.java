package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
/* loaded from: classes2.dex */
public class e {
    protected final Intent a;

    public e(String str) {
        Intent intent = new Intent(str);
        this.a = intent;
        intent.setPackage("com.google.android.gms");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent a(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Resources.Theme theme = activity.getTheme();
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        if (theme.resolveAttribute(16843827, typedValue, true) && !this.a.hasExtra("primary_color")) {
            this.a.putExtra("primary_color", typedValue.data);
        }
        if (theme.resolveAttribute(16843828, typedValue2, true) && !this.a.hasExtra("primary_color_dark")) {
            this.a.putExtra("primary_color_dark", typedValue2.data);
        }
        GoogleApiAvailability.getInstance().i(activity, com.google.android.gms.common.c.a);
        return this.a;
    }
}
