package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzaec;
import com.google.android.gms.internal.ads.zzaee;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class MediaView extends FrameLayout {
    private MediaContent a;
    private boolean b;
    private zzaec c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView.ScaleType f3559d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3560e;

    /* renamed from: f  reason: collision with root package name */
    private zzaee f3561f;

    public MediaView(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(zzaec zzaecVar) {
        this.c = zzaecVar;
        if (this.b) {
            zzaecVar.setMediaContent(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void b(zzaee zzaeeVar) {
        this.f3561f = zzaeeVar;
        if (this.f3560e) {
            zzaeeVar.setImageScaleType(this.f3559d);
        }
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.f3560e = true;
        this.f3559d = scaleType;
        zzaee zzaeeVar = this.f3561f;
        if (zzaeeVar != null) {
            zzaeeVar.setImageScaleType(scaleType);
        }
    }

    public void setMediaContent(MediaContent mediaContent) {
        this.b = true;
        this.a = mediaContent;
        zzaec zzaecVar = this.c;
        if (zzaecVar != null) {
            zzaecVar.setMediaContent(mediaContent);
        }
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
