package com.pinguo.camera360.ui;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.util.s;
/* loaded from: classes3.dex */
public class PGOrientationEventListener extends OrientationEventListener {
    private List<us.pinguo.foundation.ui.d> a;
    private Activity b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f7001d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7002e;

    public PGOrientationEventListener(Context context) {
        super(context, 2);
        this.a = null;
        this.b = null;
        this.c = -1;
        this.f7001d = 0;
        this.f7002e = true;
        this.a = new ArrayList();
        this.b = (Activity) context;
    }

    public void a(int i2, boolean z) {
        List<us.pinguo.foundation.ui.d> list = this.a;
        if (list == null) {
            return;
        }
        for (us.pinguo.foundation.ui.d dVar : list) {
            dVar.setOrientation(i2, z);
        }
    }

    @Override // android.view.OrientationEventListener
    public void disable() {
        this.f7002e = true;
        super.disable();
    }

    @Override // android.view.OrientationEventListener
    public void enable() {
        super.enable();
        this.f7002e = false;
        a(this.f7001d, false);
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        if (i2 == -1 || this.f7002e) {
            return;
        }
        int j2 = s.j(i2, this.c);
        this.c = j2;
        int c = (j2 + s.c(this.b)) % BaseBlurEffect.ROTATION_360;
        if (this.f7001d != c) {
            this.f7001d = c;
            a(c, false);
        }
    }
}
