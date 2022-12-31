package com.mob.commons.a;

import android.os.Message;
import com.mob.MobSDK;
import com.mob.tools.utils.DeviceHelper;
import java.io.File;
/* compiled from: DvcClt.java */
/* loaded from: classes2.dex */
public class k extends d {
    private boolean b = false;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5864d = false;
    private DeviceHelper a = DeviceHelper.getInstance(MobSDK.getContext());

    k() {
    }

    @Override // com.mob.commons.a.d
    protected void a(Message message) {
        int i2 = message.what;
    }

    @Override // com.mob.commons.a.d
    protected void b() {
    }

    @Override // com.mob.commons.a.d
    protected File e() {
        return com.mob.commons.d.a("comm/locks/.dic_lock");
    }

    @Override // com.mob.commons.a.d
    protected void g() {
    }
}
