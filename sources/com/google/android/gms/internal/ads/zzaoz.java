package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaoz extends zzanw {
    private final UnifiedNativeAdMapper zzdol;

    public zzaoz(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdol = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final String getAdvertiser() {
        return this.zzdol.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final String getBody() {
        return this.zzdol.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final String getCallToAction() {
        return this.zzdol.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final Bundle getExtras() {
        return this.zzdol.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final String getHeadline() {
        return this.zzdol.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdol.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzaed(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final float getMediaContentAspectRatio() {
        return this.zzdol.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final boolean getOverrideClickHandling() {
        return this.zzdol.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final boolean getOverrideImpressionRecording() {
        return this.zzdol.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final String getPrice() {
        return this.zzdol.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final double getStarRating() {
        if (this.zzdol.getStarRating() != null) {
            return this.zzdol.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final String getStore() {
        return this.zzdol.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final zzzc getVideoController() {
        if (this.zzdol.getVideoController() != null) {
            return this.zzdol.getVideoController().zzdw();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final float getVideoCurrentTime() {
        return this.zzdol.getCurrentTime();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final float getVideoDuration() {
        return this.zzdol.getDuration();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void recordImpression() {
        this.zzdol.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzc(b bVar, b bVar2, b bVar3) {
        this.zzdol.trackViews((View) d.y0(bVar), (HashMap) d.y0(bVar2), (HashMap) d.y0(bVar3));
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final zzaer zztn() {
        NativeAd.Image icon = this.zzdol.getIcon();
        if (icon != null) {
            return new zzaed(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final zzaej zzto() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final b zztp() {
        Object zzjw = this.zzdol.zzjw();
        if (zzjw == null) {
            return null;
        }
        return d.z0(zzjw);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzu(b bVar) {
        this.zzdol.handleClick((View) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final b zzvg() {
        View adChoicesContent = this.zzdol.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return d.z0(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final b zzvh() {
        View zzaet = this.zzdol.zzaet();
        if (zzaet == null) {
            return null;
        }
        return d.z0(zzaet);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzw(b bVar) {
        this.zzdol.untrackView((View) d.y0(bVar));
    }
}
