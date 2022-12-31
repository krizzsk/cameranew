package us.pinguo.librouter.module.camera;

import android.app.Application;
/* compiled from: ICameraModule.java */
/* loaded from: classes5.dex */
public abstract class d extends us.pinguo.librouter.c.a<c> {
    public f getPayInterface() {
        return getInterface().g();
    }

    public us.pinguo.librouter.module.inspire.b getPortalInterface() {
        return getInterface().r();
    }

    public g getVideoInterface() {
        return getInterface().p();
    }

    public void initAdvModule(Application application) {
    }
}
