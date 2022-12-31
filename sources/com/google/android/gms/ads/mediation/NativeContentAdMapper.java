package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public class NativeContentAdMapper extends NativeAdMapper {

    /* renamed from: h  reason: collision with root package name */
    private String f3542h;

    /* renamed from: i  reason: collision with root package name */
    private List<NativeAd.Image> f3543i;

    /* renamed from: j  reason: collision with root package name */
    private String f3544j;

    /* renamed from: k  reason: collision with root package name */
    private NativeAd.Image f3545k;

    /* renamed from: l  reason: collision with root package name */
    private String f3546l;
    private String m;

    public final String getAdvertiser() {
        return this.m;
    }

    public final String getBody() {
        return this.f3544j;
    }

    public final String getCallToAction() {
        return this.f3546l;
    }

    public final String getHeadline() {
        return this.f3542h;
    }

    public final List<NativeAd.Image> getImages() {
        return this.f3543i;
    }

    public final NativeAd.Image getLogo() {
        return this.f3545k;
    }

    public final void setAdvertiser(String str) {
        this.m = str;
    }

    public final void setBody(String str) {
        this.f3544j = str;
    }

    public final void setCallToAction(String str) {
        this.f3546l = str;
    }

    public final void setHeadline(String str) {
        this.f3542h = str;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.f3543i = list;
    }

    public final void setLogo(NativeAd.Image image) {
        this.f3545k = image;
    }
}
