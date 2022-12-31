package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public class NativeAdMapper {
    protected boolean a;
    protected boolean b;
    protected Bundle c = new Bundle();

    /* renamed from: d  reason: collision with root package name */
    protected View f3533d;

    /* renamed from: e  reason: collision with root package name */
    private View f3534e;

    /* renamed from: f  reason: collision with root package name */
    private VideoController f3535f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3536g;

    public View getAdChoicesContent() {
        return this.f3533d;
    }

    public final Bundle getExtras() {
        return this.c;
    }

    public final boolean getOverrideClickHandling() {
        return this.b;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.a;
    }

    public final VideoController getVideoController() {
        return this.f3535f;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.f3536g;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.f3533d = view;
    }

    public final void setExtras(Bundle bundle) {
        this.c = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.f3536g = z;
    }

    public void setMediaView(View view) {
        this.f3534e = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.b = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.a = z;
    }

    @Deprecated
    public void trackView(View view) {
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.f3535f = videoController;
    }

    public final View zzaet() {
        return this.f3534e;
    }
}
