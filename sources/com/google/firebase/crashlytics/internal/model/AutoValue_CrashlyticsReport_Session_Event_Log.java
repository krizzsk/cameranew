package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;
/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {
    private final String content;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Log.Builder {
        private String content;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public CrashlyticsReport.Session.Event.Log build() {
            String str = "";
            if (this.content == null) {
                str = " content";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Log(this.content);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder
        public CrashlyticsReport.Session.Event.Log.Builder setContent(String str) {
            Objects.requireNonNull(str, "Null content");
            this.content = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.content.equals(((CrashlyticsReport.Session.Event.Log) obj).getContent());
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log
    @NonNull
    public String getContent() {
        return this.content;
    }

    public int hashCode() {
        return this.content.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.content + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.content = str;
    }
}
