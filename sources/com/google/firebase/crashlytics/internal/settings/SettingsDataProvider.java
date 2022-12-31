package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.g;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
/* loaded from: classes2.dex */
public interface SettingsDataProvider {
    g<AppSettingsData> getAppSettings();

    Settings getSettings();
}
