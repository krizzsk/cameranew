package us.pinguo.widget.discreteseekbar.internal.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
/* compiled from: TrackRectDrawable.java */
/* loaded from: classes6.dex */
public class h extends c {
    public h(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // us.pinguo.widget.discreteseekbar.internal.b.c
    public void a(Canvas canvas, Paint paint) {
        canvas.drawRect(getBounds(), paint);
    }
}
