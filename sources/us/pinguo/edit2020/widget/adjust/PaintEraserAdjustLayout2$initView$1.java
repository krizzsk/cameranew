package us.pinguo.edit2020.widget.adjust;

import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.edit2020.R;
import us.pinguo.ui.widget.StickySeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PaintEraserAdjustLayout2.kt */
/* loaded from: classes4.dex */
public final class PaintEraserAdjustLayout2$initView$1 extends Lambda implements p<String, Integer, u> {
    final /* synthetic */ PaintEraserAdjustLayout2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaintEraserAdjustLayout2$initView$1(PaintEraserAdjustLayout2 paintEraserAdjustLayout2) {
        super(2);
        this.this$0 = paintEraserAdjustLayout2;
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ u invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return u.a;
    }

    public final void invoke(String noName_0, int i2) {
        String str;
        s.h(noName_0, "$noName_0");
        PaintEraserAdjustLayout2 paintEraserAdjustLayout2 = this.this$0;
        if (i2 == 0) {
            ((StickySeekBar) paintEraserAdjustLayout2.a(R.id.sbAdjust)).setProgress(this.this$0.i());
            str = BigAlbumStore.PhotoColumns.SIZE;
        } else {
            ((StickySeekBar) paintEraserAdjustLayout2.a(R.id.sbAdjust)).setProgress(this.this$0.f());
            str = "alpha";
        }
        paintEraserAdjustLayout2.f10956g = str;
    }
}
