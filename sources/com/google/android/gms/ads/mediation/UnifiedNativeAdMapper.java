package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class UnifiedNativeAdMapper {
    private String a;
    private List<NativeAd.Image> b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private NativeAd.Image f3547d;

    /* renamed from: e  reason: collision with root package name */
    private String f3548e;

    /* renamed from: f  reason: collision with root package name */
    private String f3549f;

    /* renamed from: g  reason: collision with root package name */
    private Double f3550g;

    /* renamed from: h  reason: collision with root package name */
    private String f3551h;

    /* renamed from: i  reason: collision with root package name */
    private String f3552i;

    /* renamed from: j  reason: collision with root package name */
    private VideoController f3553j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3554k;

    /* renamed from: l  reason: collision with root package name */
    private View f3555l;
    private View m;
    private Object n;
    private Bundle o = new Bundle();
    private boolean p;
    private boolean q;
    private float r;

    public View getAdChoicesContent() {
        return this.f3555l;
    }

    public final String getAdvertiser() {
        return this.f3549f;
    }

    public final String getBody() {
        return this.c;
    }

    public final String getCallToAction() {
        return this.f3548e;
    }

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    public final Bundle getExtras() {
        return this.o;
    }

    public final String getHeadline() {
        return this.a;
    }

    public final NativeAd.Image getIcon() {
        return this.f3547d;
    }

    public final List<NativeAd.Image> getImages() {
        return this.b;
    }

    public float getMediaContentAspectRatio() {
        return this.r;
    }

    public final boolean getOverrideClickHandling() {
        return this.q;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.p;
    }

    public final String getPrice() {
        return this.f3552i;
    }

    public final Double getStarRating() {
        return this.f3550g;
    }

    public final String getStore() {
        return this.f3551h;
    }

    public final VideoController getVideoController() {
        return this.f3553j;
    }

    public void handleClick(View view) {
    }

    public boolean hasVideoContent() {
        return this.f3554k;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(View view) {
        this.f3555l = view;
    }

    public final void setAdvertiser(String str) {
        this.f3549f = str;
    }

    public final void setBody(String str) {
        this.c = str;
    }

    public final void setCallToAction(String str) {
        this.f3548e = str;
    }

    public final void setExtras(Bundle bundle) {
        this.o = bundle;
    }

    public void setHasVideoContent(boolean z) {
        this.f3554k = z;
    }

    public final void setHeadline(String str) {
        this.a = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.f3547d = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.b = list;
    }

    public void setMediaContentAspectRatio(float f2) {
        this.r = f2;
    }

    public void setMediaView(View view) {
        this.m = view;
    }

    public final void setOverrideClickHandling(boolean z) {
        this.q = z;
    }

    public final void setOverrideImpressionRecording(boolean z) {
        this.p = z;
    }

    public final void setPrice(String str) {
        this.f3552i = str;
    }

    public final void setStarRating(Double d2) {
        this.f3550g = d2;
    }

    public final void setStore(String str) {
        this.f3551h = str;
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public void untrackView(View view) {
    }

    public final void zza(VideoController videoController) {
        this.f3553j = videoController;
    }

    public final View zzaet() {
        return this.m;
    }

    public final Object zzjw() {
        return this.n;
    }

    public final void zzm(Object obj) {
        this.n = obj;
    }
}
