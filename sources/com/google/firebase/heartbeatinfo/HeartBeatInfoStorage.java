package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class HeartBeatInfoStorage {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd/MM/yyyy z");
    private static final String GLOBAL = "fire-global";
    private static final int HEART_BEAT_COUNT_LIMIT = 200;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static final String STORAGE_PREFERENCES_NAME = "FirebaseAppHeartBeatStorage";
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences heartBeatSharedPreferences;
    private final SharedPreferences sharedPreferences;

    private HeartBeatInfoStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        this.heartBeatSharedPreferences = context.getSharedPreferences(STORAGE_PREFERENCES_NAME, 0);
    }

    private synchronized void cleanUpStoredHeartBeats() {
        long j2 = this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.heartBeatSharedPreferences.getAll().entrySet()) {
            arrayList.add(Long.valueOf(Long.parseLong(entry.getKey())));
        }
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.heartBeatSharedPreferences.edit().remove(String.valueOf((Long) it.next())).apply();
            j2--;
            this.sharedPreferences.edit().putLong(HEART_BEAT_COUNT_TAG, j2).apply();
            if (j2 <= 100) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized HeartBeatInfoStorage getInstance(Context context) {
        HeartBeatInfoStorage heartBeatInfoStorage;
        synchronized (HeartBeatInfoStorage.class) {
            if (instance == null) {
                instance = new HeartBeatInfoStorage(context);
            }
            heartBeatInfoStorage = instance;
        }
        return heartBeatInfoStorage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSameDateUtc(long j2, long j3) {
        Date date = new Date(j2);
        Date date2 = new Date(j3);
        SimpleDateFormat simpleDateFormat = FORMATTER;
        return !simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    synchronized void clearStoredHeartBeats() {
        this.heartBeatSharedPreferences.edit().clear().apply();
        this.sharedPreferences.edit().remove(HEART_BEAT_COUNT_TAG).apply();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    int getHeartBeatCount() {
        return (int) this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long getLastGlobalHeartBeat() {
        return this.sharedPreferences.getLong(GLOBAL, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List<SdkHeartBeatResult> getStoredHeartBeats(boolean z) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.heartBeatSharedPreferences.getAll().entrySet()) {
            arrayList.add(SdkHeartBeatResult.create((String) entry.getValue(), Long.parseLong(entry.getKey())));
        }
        Collections.sort(arrayList);
        if (z) {
            clearStoredHeartBeats();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean shouldSendGlobalHeartBeat(long j2) {
        return shouldSendSdkHeartBeat(GLOBAL, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean shouldSendSdkHeartBeat(String str, long j2) {
        if (this.sharedPreferences.contains(str)) {
            if (isSameDateUtc(this.sharedPreferences.getLong(str, -1L), j2)) {
                this.sharedPreferences.edit().putLong(str, j2).apply();
                return true;
            }
            return false;
        }
        this.sharedPreferences.edit().putLong(str, j2).apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void storeHeartBeatInformation(String str, long j2) {
        long j3 = this.sharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
        this.heartBeatSharedPreferences.edit().putString(String.valueOf(j2), str).apply();
        long j4 = j3 + 1;
        this.sharedPreferences.edit().putLong(HEART_BEAT_COUNT_TAG, j4).apply();
        if (j4 > 200) {
            cleanUpStoredHeartBeats();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateGlobalHeartBeat(long j2) {
        this.sharedPreferences.edit().putLong(GLOBAL, j2).apply();
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    HeartBeatInfoStorage(SharedPreferences sharedPreferences, SharedPreferences sharedPreferences2) {
        this.sharedPreferences = sharedPreferences;
        this.heartBeatSharedPreferences = sharedPreferences2;
    }
}
