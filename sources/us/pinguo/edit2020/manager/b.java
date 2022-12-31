package us.pinguo.edit2020.manager;

import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.s;
/* compiled from: BodyShapingOperationManager.kt */
/* loaded from: classes4.dex */
public final class b {
    private final ImageView a;
    private final ImageView b;
    private final ImageView c;

    public b(ImageView undoView, ImageView redoView, ImageView diffView) {
        s.h(undoView, "undoView");
        s.h(redoView, "redoView");
        s.h(diffView, "diffView");
        this.a = undoView;
        this.b = redoView;
        this.c = diffView;
    }

    public final void a(boolean z) {
        if (z) {
            if (this.a.getVisibility() == 0) {
                return;
            }
            ImageView imageView = this.a;
            imageView.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView, 0);
            ImageView imageView2 = this.b;
            imageView2.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView2, 0);
            ImageView imageView3 = this.c;
            imageView3.setVisibility(0);
            VdsAgent.onSetViewVisibility(imageView3, 0);
            return;
        }
        if (this.a.getVisibility() == 0) {
            ImageView imageView4 = this.a;
            imageView4.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView4, 8);
            ImageView imageView5 = this.b;
            imageView5.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView5, 8);
            ImageView imageView6 = this.c;
            imageView6.setVisibility(8);
            VdsAgent.onSetViewVisibility(imageView6, 8);
        }
    }
}
