package com.facebook.internal.logging.monitor;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.facebook.f;
import com.facebook.internal.logging.ExternalLog;
import com.facebook.internal.x;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class MonitorLoggingStore implements com.facebook.internal.logging.c {
    private static MonitorLoggingStore a;

    private MonitorLoggingStore() {
    }

    public static synchronized MonitorLoggingStore getInstance() {
        MonitorLoggingStore monitorLoggingStore;
        synchronized (MonitorLoggingStore.class) {
            if (a == null) {
                a = new MonitorLoggingStore();
            }
            monitorLoggingStore = a;
        }
        return monitorLoggingStore;
    }

    @Override // com.facebook.internal.logging.c
    public Collection<ExternalLog> a() {
        ArrayList arrayList = new ArrayList();
        Context f2 = f.f();
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new BufferedInputStream(f2.openFileInput("facebooksdk.monitoring.persistedlogs")));
            try {
                Collection<ExternalLog> collection = (Collection) objectInputStream2.readObject();
                x.h(objectInputStream2);
                try {
                    f2.getFileStreamPath("facebooksdk.monitoring.persistedlogs").delete();
                } catch (Exception unused) {
                }
                return collection;
            } catch (Exception unused2) {
                objectInputStream = objectInputStream2;
                x.h(objectInputStream);
                try {
                    f2.getFileStreamPath("facebooksdk.monitoring.persistedlogs").delete();
                    return arrayList;
                } catch (Exception unused3) {
                    return arrayList;
                }
            } catch (Throwable th) {
                th = th;
                objectInputStream = objectInputStream2;
                x.h(objectInputStream);
                try {
                    f2.getFileStreamPath("facebooksdk.monitoring.persistedlogs").delete();
                } catch (Exception unused4) {
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
