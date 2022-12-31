package us.pinguo.inspire.widget.fresco;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.facebook.drawee.backends.pipeline.e;
import com.facebook.drawee.drawable.p;
import com.facebook.imagepipeline.image.g;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import us.pinguo.foundation.utils.f0;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.MissionDetail.ChallengeDetailVideoCell;
import us.pinguo.ui.uilview.PhotoImageView;
import us.pinguo.util.q;
/* loaded from: classes9.dex */
public class WebpDraweeView extends PhotoDraweeView {
    private com.facebook.drawee.controller.c m;
    private String n;
    public ChallengeDetailVideoCell o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends d<g> {
        final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.facebook.drawee.controller.c cVar, String str) {
            super(cVar);
            this.b = str;
        }

        @Override // us.pinguo.inspire.widget.fresco.d, com.facebook.drawee.controller.c
        /* renamed from: g */
        public void d(String str, @Nullable g gVar, @Nullable Animatable animatable) {
            super.d(str, gVar, animatable);
            WebpDraweeView.this.e().v(null);
            WebpDraweeView.this.n = this.b;
        }
    }

    public WebpDraweeView(Context context) {
        super(context);
    }

    public static boolean p() {
        return q.h(Inspire.a()) && us.pinguo.util.c.f12472f;
    }

    public void q() {
        e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.C(d());
        setController(h2.L("").build());
    }

    public void r(boolean z) {
        if (d() == null || d().e() == null) {
            return;
        }
        Animatable e2 = d().e();
        if (e2.isRunning() && !z) {
            e2.stop();
        } else if (e2.isRunning() || !z) {
        } else {
            e2.start();
        }
    }

    public void setControlListener() {
    }

    public void setControllerListener(com.facebook.drawee.controller.c cVar) {
        this.m = cVar;
    }

    public void setVideoThumb(String str, int i2, int i3, int i4, int i5) {
        double d2;
        double d3;
        String addQiNiuSuffix;
        this.n = null;
        if (i3 == 0 || i5 == 0) {
            d2 = 0.0d;
            d3 = 0.0d;
        } else {
            d2 = (i2 * 1.0d) / i3;
            d3 = (i4 * 1.0d) / i5;
        }
        if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            i4 = 0;
            i5 = 0;
        } else if (d2 > d3) {
            i4 = (int) (d2 * i5);
        } else {
            i5 = (int) (i4 / d2);
        }
        if (str != null && str.startsWith("https")) {
            str = str.replaceFirst("https", "http");
        }
        if (i4 > 1 && i5 > 1 && i2 > 1 && i3 > 1) {
            addQiNiuSuffix = PhotoImageView.addQiNiuSuffix(str, i4, i5, true);
        } else {
            addQiNiuSuffix = PhotoImageView.addQiNiuSuffix(str, 0, 0, true);
        }
        e().v(null);
        e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.C(d());
        setController(h2.L(addQiNiuSuffix).build());
    }

    public void setWebp(String str) {
        setWebp(str, true);
    }

    public WebpDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setWebp(String str, boolean z) {
        if (f0.b(this.n, str) && d() != null && d().e() != null) {
            r(z);
            return;
        }
        e().v(this.f11356l);
        e().u(p.c.f2566g);
        e h2 = com.facebook.drawee.backends.pipeline.c.h();
        h2.C(d());
        e eVar = h2;
        eVar.A(new a(this.m, str));
        e eVar2 = eVar;
        eVar2.y(z);
        setController(eVar2.L(str).build());
    }

    public WebpDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
