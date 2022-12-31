package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
/* compiled from: CircleImageView.kt */
/* loaded from: classes4.dex */
public final class CircleImageView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private final Path f10639i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ CircleImageView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f10639i.reset();
        this.f10639i.addCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, Path.Direction.CCW);
        if (canvas != null) {
            canvas.clipPath(this.f10639i);
        }
        super.onDraw(canvas);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.f10639i = new Path();
    }
}
