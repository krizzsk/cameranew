package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzasr;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class ReportingInfo {
    private final zzasm a;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class Builder {
        private final zzasr a;

        public Builder(View view) {
            zzasr zzasrVar = new zzasr();
            this.a = zzasrVar;
            zzasrVar.zzk(view);
        }

        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }

        public final Builder setAssetViews(Map<String, View> map) {
            this.a.zzh(map);
            return this;
        }
    }

    private ReportingInfo(Builder builder) {
        this.a = new zzasm(builder.a);
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.a.reportTouchEvent(motionEvent);
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.a.updateClickUrl(uri, updateClickUrlCallback);
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.a.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }
}
