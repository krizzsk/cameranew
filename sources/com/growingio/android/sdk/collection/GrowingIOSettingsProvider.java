package com.growingio.android.sdk.collection;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.deeplink.DeeplinkManager;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.utils.Util;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventCenterException;
/* loaded from: classes2.dex */
public class GrowingIOSettingsProvider extends ContentProvider {
    private static final String TAG = "GIO.provider";

    private static void loadClass(String str) {
        try {
            GrowingIOSettingsProvider.class.getClassLoader().loadClass(str).newInstance();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void preLoadClass() {
        new GrowingIO();
        new CoreAppState();
        try {
            EventCenter.getInstance().init(null);
        } catch (EventCenterException unused) {
        }
        try {
            Util.isInSampling("xxx", 1.0d);
            new GConfig(null);
            new GrowingIOIPC();
        } catch (Throwable unused2) {
        }
        new MessageProcessor(null, null);
        new DeviceUUIDFactory();
        new Configuration();
        new CoreInitialize();
        new DeeplinkManager();
        new SessionManager();
        loadClass("com.growingio.android.sdk.autoburry.AutoBuryAppState");
    }

    public static void preload(Context context) {
        try {
            context.getSharedPreferences(GConfig.PREF_FILE_NAME, 0);
            context.getSharedPreferences("growing_persist_data", 0);
            context.getSharedPreferences("growing_server_pref", 0);
        } catch (Throwable unused) {
        }
        new Thread() { // from class: com.growingio.android.sdk.collection.GrowingIOSettingsProvider.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                GrowingIOSettingsProvider.preLoadClass();
            }
        }.start();
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        preload(context);
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        throw new UnsupportedOperationException();
    }
}
