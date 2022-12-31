package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: VideoTrafficTipLayout.java */
/* loaded from: classes.dex */
public class e {
    private View a;
    private TextView b;
    private Context c;

    /* renamed from: d  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.d f1904d;

    /* renamed from: e  reason: collision with root package name */
    private b f1905e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1906f = false;

    /* renamed from: g  reason: collision with root package name */
    private n f1907g;

    /* renamed from: h  reason: collision with root package name */
    private ViewStub f1908h;

    /* renamed from: i  reason: collision with root package name */
    private View f1909i;

    /* compiled from: VideoTrafficTipLayout.java */
    /* loaded from: classes.dex */
    public enum a {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* compiled from: VideoTrafficTipLayout.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean h();

        void j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.c == null) {
            return;
        }
        d();
    }

    private void d() {
        View view = this.a;
        if (view != null) {
            view.setVisibility(8);
            VdsAgent.onSetViewVisibility(view, 8);
        }
    }

    private void b(Context context, View view) {
        ViewStub viewStub;
        if (context == null || view == null || (viewStub = this.f1908h) == null || viewStub.getParent() == null || this.a != null) {
            return;
        }
        this.f1908h.inflate();
        this.a = view.findViewById(t.e(context, "tt_video_traffic_tip_layout"));
        this.b = (TextView) view.findViewById(t.e(context, "tt_video_traffic_tip_tv"));
        view.findViewById(t.e(context, "tt_video_traffic_continue_play_btn")).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.e.1
            @Override // android.view.View.OnClickListener
            @Instrumented
            public void onClick(View view2) {
                VdsAgent.onClick(this, view2);
                e.this.c();
                if (e.this.f1904d != null) {
                    e.this.f1904d.a(a.START_VIDEO, (String) null);
                }
            }
        });
    }

    public void a(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.f1909i = view;
        this.c = o.a().getApplicationContext();
        this.f1908h = (ViewStub) LayoutInflater.from(context).inflate(t.f(context, "tt_video_traffic_tip"), (ViewGroup) view, true).findViewById(t.e(context, "tt_video_traffic_tip_layout_viewStub"));
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.d dVar, b bVar) {
        this.f1905e = bVar;
        this.f1904d = dVar;
    }

    private void b() {
        this.f1907g = null;
    }

    public boolean a(int i2, n nVar) {
        Context context = this.c;
        if (context == null || nVar == null) {
            return true;
        }
        b(context, this.f1909i);
        this.f1907g = nVar;
        if (i2 == 1 || i2 == 2) {
            return a(i2);
        }
        return true;
    }

    private boolean a(int i2) {
        b bVar;
        if (a() || this.f1906f) {
            return true;
        }
        if (this.f1904d != null && (bVar = this.f1905e) != null) {
            if (bVar.h()) {
                this.f1904d.e(null, null);
            }
            this.f1904d.a(a.PAUSE_VIDEO, (String) null);
        }
        a(this.f1907g, true);
        return false;
    }

    public void a(boolean z) {
        if (z) {
            b();
        }
        d();
    }

    public boolean a() {
        View view = this.a;
        return view != null && view.getVisibility() == 0;
    }

    private void a(n nVar, boolean z) {
        View view;
        String str;
        View view2;
        if (nVar == null || (view = this.a) == null || this.c == null || view.getVisibility() == 0) {
            return;
        }
        b bVar = this.f1905e;
        if (bVar != null) {
            bVar.j();
        }
        double ceil = Math.ceil((nVar.d() * 1.0d) / 1048576.0d);
        if (z) {
            str = String.format(t.a(this.c, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(ceil).floatValue()));
        } else {
            str = t.a(this.c, "tt_video_without_wifi_tips") + t.a(this.c, "tt_video_bytesize");
        }
        ac.a(this.a, 0);
        ac.a(this.b, str);
        if (!ac.d(this.a) || (view2 = this.a) == null) {
            return;
        }
        view2.bringToFront();
    }
}
