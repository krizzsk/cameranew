package us.pinguo.edit2020.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.f3;
import us.pinguo.foundation.video.FixedRateVideoView2;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* compiled from: ListPlayView.kt */
/* loaded from: classes4.dex */
public final class ListPlayView extends FrameLayout implements e0 {
    public Map<Integer, View> a;
    private String b;
    private FrameLayout.LayoutParams c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListPlayView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListPlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    public /* synthetic */ ListPlayView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // us.pinguo.edit2020.view.e0
    public /* bridge */ /* synthetic */ ViewGroup a() {
        f();
        return this;
    }

    @Override // us.pinguo.edit2020.view.e0
    public void b() {
        FixedRateVideoView2 b = f3.a.b();
        if (b == null) {
            return;
        }
        b.y();
        SimpleDraweeView cover = (SimpleDraweeView) d(R.id.cover);
        kotlin.jvm.internal.s.g(cover, "cover");
        cover.setVisibility(0);
        VdsAgent.onSetViewVisibility(cover, 0);
    }

    @Override // us.pinguo.edit2020.view.e0
    public void c() {
        f3 f3Var;
        View a;
        String str = this.b;
        if ((str == null || str.length() == 0) || (a = (f3Var = f3.a).a()) == null) {
            return;
        }
        ViewParent parent = a.getParent();
        if (!kotlin.jvm.internal.s.c(parent, this)) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(a);
                ((ListPlayView) parent).b();
            }
            addView(a, 1, this.c);
        }
        f3Var.f(this.b);
        FixedRateVideoView2 b = f3Var.b();
        if (b == null) {
            return;
        }
        b.setVideoPath(this.b);
        b.setLooping(true);
        b.B();
    }

    public View d(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void e(String videoUrl, String coverPath, int i2) {
        boolean p;
        kotlin.jvm.internal.s.h(videoUrl, "videoUrl");
        kotlin.jvm.internal.s.h(coverPath, "coverPath");
        this.b = videoUrl;
        p = kotlin.text.t.p(coverPath);
        if (p) {
            ((SimpleDraweeView) d(R.id.cover)).setActualImageResource(i2);
        } else if (new File(coverPath).exists()) {
            ((SimpleDraweeView) d(R.id.cover)).setImageURI(Uri.parse(kotlin.jvm.internal.s.q(InspirePublishFragment.FILE_HEADER, coverPath)), (Object) null);
        } else {
            ((SimpleDraweeView) d(R.id.cover)).setActualImageResource(i2);
        }
    }

    public ListPlayView f() {
        return this;
    }

    @Override // us.pinguo.edit2020.view.e0
    public boolean isPlaying() {
        return f3.a.d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListPlayView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.item_list_play_view, this);
        this.c = new FrameLayout.LayoutParams(-1, -1);
    }
}
