package com.unity3d.splash.services.core.device;

import com.unity3d.splash.services.c.a.b;
import com.unity3d.splash.services.core.device.StorageManager;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.unity3d.splash.services.c.a.a {
    private String b;
    private StorageManager.StorageType c;

    public a(String str, StorageManager.StorageType storageType) {
        this.b = str;
        this.c = storageType;
    }

    public StorageManager.StorageType h() {
        return this.c;
    }

    public synchronized boolean i() {
        j();
        super.f();
        return true;
    }

    public synchronized boolean j() {
        try {
            byte[] c = b.c(new File(this.b));
            if (c == null) {
                return false;
            }
            g(new JSONObject(new String(c)));
            return true;
        } catch (Exception e2) {
            DeviceLog.g("Error creating storage JSON", e2);
            return false;
        }
    }

    public synchronized boolean k() {
        return new File(this.b).exists();
    }

    public synchronized boolean l() {
        File file = new File(this.b);
        if (d() != null) {
            return b.g(file, d().toString());
        }
        return false;
    }
}
