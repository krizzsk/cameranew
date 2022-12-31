package us.pinguo.edit2020.controller;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import us.pinguo.edit2020.R;
import us.pinguo.foundation.video.FixedRateVideoView2;
/* compiled from: ListPlayManager.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes4.dex */
public final class f3 {
    public static final f3 a;
    private static View b;
    private static FixedRateVideoView2 c;

    static {
        f3 f3Var = new f3();
        a = f3Var;
        f3Var.c();
    }

    private f3() {
    }

    private final void c() {
        View inflate = LayoutInflater.from(us.pinguo.foundation.e.b()).inflate(R.layout.layout_player_view, (ViewGroup) null, false);
        a.g((FixedRateVideoView2) inflate.findViewById(R.id.videoPlayer3));
        b = inflate;
    }

    public final View a() {
        if (b == null) {
            c();
        }
        return b;
    }

    public final FixedRateVideoView2 b() {
        return c;
    }

    public final boolean d() {
        FixedRateVideoView2 fixedRateVideoView2 = c;
        if (fixedRateVideoView2 == null) {
            return false;
        }
        return fixedRateVideoView2.v();
    }

    public final void e() {
        FixedRateVideoView2 fixedRateVideoView2 = c;
        if (fixedRateVideoView2 != null) {
            fixedRateVideoView2.y();
        }
        c = null;
        b = null;
    }

    public final void f(String str) {
    }

    public final void g(FixedRateVideoView2 fixedRateVideoView2) {
        c = fixedRateVideoView2;
    }
}
