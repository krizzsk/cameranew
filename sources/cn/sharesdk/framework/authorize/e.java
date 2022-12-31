package cn.sharesdk.framework.authorize;

import android.content.Intent;
/* compiled from: SSOProcessor.java */
/* loaded from: classes.dex */
public abstract class e {
    protected d a;
    protected int b;
    protected SSOListener c;

    public e(d dVar) {
        this.a = dVar;
        this.c = dVar.a().getSSOListener();
    }

    public abstract void a();

    public void a(int i2) {
        this.b = i2;
    }

    public void a(int i2, int i3, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Intent intent) {
    }
}
