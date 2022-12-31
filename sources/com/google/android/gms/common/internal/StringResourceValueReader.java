package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.R;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class StringResourceValueReader {
    private final Resources a;
    private final String b;

    public StringResourceValueReader(Context context) {
        q.j(context);
        Resources resources = context.getResources();
        this.a = resources;
        this.b = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    @Nullable
    public String a(String str) {
        int identifier = this.a.getIdentifier(str, TypedValues.Custom.S_STRING, this.b);
        if (identifier == 0) {
            return null;
        }
        return this.a.getString(identifier);
    }
}
