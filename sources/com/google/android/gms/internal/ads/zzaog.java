package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaog extends zzanv {
    private final NativeContentAdMapper zzdoa;

    public zzaog(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdoa = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getAdvertiser() {
        return this.zzdoa.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getBody() {
        return this.zzdoa.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getCallToAction() {
        return this.zzdoa.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final Bundle getExtras() {
        return this.zzdoa.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final String getHeadline() {
        return this.zzdoa.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdoa.getImages();
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (NativeAd.Image image : images) {
                arrayList.add(new zzaed(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final boolean getOverrideClickHandling() {
        return this.zzdoa.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final boolean getOverrideImpressionRecording() {
        return this.zzdoa.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final zzzc getVideoController() {
        if (this.zzdoa.getVideoController() != null) {
            return this.zzdoa.getVideoController().zzdw();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void recordImpression() {
        this.zzdoa.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzc(b bVar, b bVar2, b bVar3) {
        this.zzdoa.trackViews((View) d.y0(bVar), (HashMap) d.y0(bVar2), (HashMap) d.y0(bVar3));
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final zzaej zzto() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final b zztp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final zzaer zztq() {
        NativeAd.Image logo = this.zzdoa.getLogo();
        if (logo != null) {
            return new zzaed(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzu(b bVar) {
        this.zzdoa.handleClick((View) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzv(b bVar) {
        this.zzdoa.trackView((View) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final b zzvg() {
        View adChoicesContent = this.zzdoa.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return d.z0(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final b zzvh() {
        View zzaet = this.zzdoa.zzaet();
        if (zzaet == null) {
            return null;
        }
        return d.z0(zzaet);
    }

    @Override // com.google.android.gms.internal.ads.zzans
    public final void zzw(b bVar) {
        this.zzdoa.untrackView((View) d.y0(bVar));
    }
}
