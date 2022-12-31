package com.pinguo.camera360.save.processer;

import us.pinguo.image.saver.sandbox.SandBoxConstants;
/* compiled from: PhotoProcesserUtils.java */
/* loaded from: classes3.dex */
public class e {
    public static com.pinguo.camera360.m.b a(us.pinguo.image.saver.d.a aVar) {
        com.pinguo.camera360.m.b bVar = new com.pinguo.camera360.m.b();
        if (aVar == null) {
            return bVar;
        }
        bVar.l(aVar.a());
        bVar.n(aVar.f());
        bVar.o(com.pinguo.camera360.m.d.c.a(aVar.f(), aVar.e()));
        bVar.p(aVar.c());
        bVar.w(us.pinguo.image.saver.sandbox.a.a(SandBoxConstants.SandBoxPictureType.photo_org, aVar.b()));
        bVar.y(aVar.n());
        bVar.B(aVar.m());
        bVar.x(new com.pinguo.camera360.k.a.a.a.b(aVar.r(), aVar.i()));
        bVar.r(aVar.h());
        bVar.v(aVar.l());
        bVar.D(aVar.b());
        bVar.t(aVar.j());
        bVar.u(aVar.k());
        return bVar;
    }
}
