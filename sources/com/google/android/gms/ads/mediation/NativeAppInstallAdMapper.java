package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public class NativeAppInstallAdMapper extends NativeAdMapper {

    /* renamed from: h  reason: collision with root package name */
    private String f3537h;

    /* renamed from: i  reason: collision with root package name */
    private List<NativeAd.Image> f3538i;

    /* renamed from: j  reason: collision with root package name */
    private String f3539j;

    /* renamed from: k  reason: collision with root package name */
    private NativeAd.Image f3540k;

    /* renamed from: l  reason: collision with root package name */
    private String f3541l;
    private double m;
    private String n;
    private String o;

    public final String getBody() {
        return this.f3539j;
    }

    public final String getCallToAction() {
        return this.f3541l;
    }

    public final String getHeadline() {
        return this.f3537h;
    }

    public final NativeAd.Image getIcon() {
        return this.f3540k;
    }

    public final List<NativeAd.Image> getImages() {
        return this.f3538i;
    }

    public final String getPrice() {
        return this.o;
    }

    public final double getStarRating() {
        return this.m;
    }

    public final String getStore() {
        return this.n;
    }

    public final void setBody(String str) {
        this.f3539j = str;
    }

    public final void setCallToAction(String str) {
        this.f3541l = str;
    }

    public final void setHeadline(String str) {
        this.f3537h = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.f3540k = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.f3538i = list;
    }

    public final void setPrice(String str) {
        this.o = str;
    }

    public final void setStarRating(double d2) {
        this.m = d2;
    }

    public final void setStore(String str) {
        this.n = str;
    }
}
