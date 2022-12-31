package com.growingio.android.sdk.base.event;

import android.app.Activity;
import android.net.Uri;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class ValidUrlEvent {
    public static final int APPLINK = 2;
    public static final int DEEPLINK = 1;
    public Activity activity;
    public Uri data;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ValidURLType {
    }

    public ValidUrlEvent(Uri uri, Activity activity, int i2) {
        this.data = uri;
        this.activity = activity;
        this.type = i2;
    }
}
