package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamic.d;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaeb extends RelativeLayout {
    private static final float[] zzdfp = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable zzdfq;

    public zzaeb(Context context, zzady zzadyVar, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        q.j(zzadyVar);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzdfp, null, null));
        shapeDrawable.getPaint().setColor(zzadyVar.getBackgroundColor());
        setLayoutParams(layoutParams);
        com.google.android.gms.ads.internal.zzr.zzkt();
        setBackground(shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadyVar.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadyVar.getText());
            textView.setTextColor(zzadyVar.getTextColor());
            textView.setTextSize(zzadyVar.getTextSize());
            zzwr.zzqn();
            int zze = zzaza.zze(context, 4);
            zzwr.zzqn();
            textView.setPadding(zze, 0, zzaza.zze(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzaed> zzte = zzadyVar.zzte();
        if (zzte != null && zzte.size() > 1) {
            this.zzdfq = new AnimationDrawable();
            for (zzaed zzaedVar : zzte) {
                try {
                    this.zzdfq.addFrame((Drawable) d.y0(zzaedVar.zzti()), zzadyVar.zztf());
                } catch (Exception e2) {
                    zzazk.zzc("Error while getting drawable.", e2);
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkt();
            imageView.setBackground(this.zzdfq);
        } else if (zzte.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) d.y0(zzte.get(0).zzti()));
            } catch (Exception e3) {
                zzazk.zzc("Error while getting drawable.", e3);
            }
        }
        addView(imageView);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        AnimationDrawable animationDrawable = this.zzdfq;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        super.onAttachedToWindow();
    }
}
