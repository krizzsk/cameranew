package com.facebook.appevents.ondeviceprocessing;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.l;
import com.facebook.internal.x;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteServiceParametersHelper.java */
/* loaded from: classes.dex */
public class b {
    private static final String a = RemoteServiceWrapper.class.getSimpleName();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Bundle a(RemoteServiceWrapper.EventType eventType, String str, List<AppEvent> list) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList(list);
            Bundle bundle = new Bundle();
            bundle.putString("event", eventType.toString());
            bundle.putString(TapjoyConstants.TJC_APP_ID, str);
            if (RemoteServiceWrapper.EventType.CUSTOM_APP_EVENTS == eventType) {
                JSONArray b = b(arrayList, str);
                if (b.length() == 0) {
                    return null;
                }
                bundle.putString("custom_events", b.toString());
            }
            return bundle;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    private static JSONArray b(List<AppEvent> list, String str) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            com.facebook.appevents.k.a.d(list);
            boolean c = c(str);
            for (AppEvent appEvent : list) {
                if (appEvent.isChecksumValid()) {
                    if ((!appEvent.getIsImplicit()) || (appEvent.getIsImplicit() && c)) {
                        jSONArray.put(appEvent.getJSONObject());
                    }
                } else {
                    String str2 = a;
                    x.Y(str2, "Event with invalid checksum: " + appEvent.toString());
                }
            }
            return jSONArray;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return null;
        }
    }

    private static boolean c(String str) {
        if (com.facebook.internal.instrument.e.a.c(b.class)) {
            return false;
        }
        try {
            l o = FetchedAppSettingsManager.o(str, false);
            if (o != null) {
                return o.o();
            }
            return false;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, b.class);
            return false;
        }
    }
}
