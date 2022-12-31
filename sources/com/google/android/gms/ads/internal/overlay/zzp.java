package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwr;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzp extends FrameLayout implements View.OnClickListener {
    private final ImageButton a;
    private final zzz b;

    public zzp(Context context, zzs zzsVar, @Nullable zzz zzzVar) {
        super(context);
        this.b = zzzVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.a = imageButton;
        imageButton.setImageResource(17301527);
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzwr.zzqn();
        int zze = zzaza.zze(context, zzsVar.paddingLeft);
        zzwr.zzqn();
        int zze2 = zzaza.zze(context, 0);
        zzwr.zzqn();
        int zze3 = zzaza.zze(context, zzsVar.paddingRight);
        zzwr.zzqn();
        imageButton.setPadding(zze, zze2, zze3, zzaza.zze(context, zzsVar.paddingBottom));
        imageButton.setContentDescription("Interstitial close button");
        zzwr.zzqn();
        int zze4 = zzaza.zze(context, zzsVar.size + zzsVar.paddingLeft + zzsVar.paddingRight);
        zzwr.zzqn();
        addView(imageButton, new FrameLayout.LayoutParams(zze4, zzaza.zze(context, zzsVar.size + zzsVar.paddingBottom), 17));
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        VdsAgent.onClick(this, view);
        zzz zzzVar = this.b;
        if (zzzVar != null) {
            zzzVar.zzvv();
        }
    }

    public final void zzam(boolean z) {
        if (z) {
            this.a.setVisibility(8);
        } else {
            this.a.setVisibility(0);
        }
    }
}
