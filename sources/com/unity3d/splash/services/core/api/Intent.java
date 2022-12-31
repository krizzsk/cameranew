package com.unity3d.splash.services.core.api;

import android.app.Activity;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class Intent {
    private static WeakReference a;

    /* loaded from: classes3.dex */
    public enum IntentError {
        COULDNT_PARSE_EXTRAS,
        COULDNT_PARSE_CATEGORIES,
        INTENT_WAS_NULL,
        JSON_EXCEPTION,
        ACTIVITY_WAS_NULL
    }

    /* loaded from: classes3.dex */
    private static class IntentException extends Exception {
        private IntentError error;
        private Object field;

        public IntentException(IntentError intentError, Object obj) {
            this.error = intentError;
            this.field = obj;
        }

        public IntentError getError() {
            return this.error;
        }

        public Object getField() {
            return this.field;
        }
    }

    public static void a(Activity activity) {
        WeakReference weakReference = a;
        if (weakReference == null || weakReference.get() == null || activity == null || !activity.equals(a.get())) {
            return;
        }
        a = null;
    }

    public static void b(Activity activity) {
        if (activity == null) {
            a = null;
        } else {
            a = new WeakReference(activity);
        }
    }
}
