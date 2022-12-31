package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.internal.x;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
/* compiled from: AppEventStore.java */
/* loaded from: classes.dex */
class d {
    private static final String a = "com.facebook.appevents.d";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AppEventStore.java */
    /* loaded from: classes.dex */
    public static class a extends ObjectInputStream {
        public a(InputStream inputStream) throws IOException {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            }
            return readClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1") ? ObjectStreamClass.lookup(AppEvent.SerializationProxyV1.class) : readClassDescriptor;
        }
    }

    d() {
    }

    public static synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, h hVar) {
        synchronized (d.class) {
            if (com.facebook.internal.instrument.e.a.c(d.class)) {
                return;
            }
            com.facebook.appevents.internal.b.b();
            PersistedEvents c = c();
            c.addEvents(accessTokenAppIdPair, hVar.d());
            d(c);
        }
    }

    public static synchronized void b(b bVar) {
        synchronized (d.class) {
            if (com.facebook.internal.instrument.e.a.c(d.class)) {
                return;
            }
            com.facebook.appevents.internal.b.b();
            PersistedEvents c = c();
            for (AccessTokenAppIdPair accessTokenAppIdPair : bVar.f()) {
                c.addEvents(accessTokenAppIdPair, bVar.c(accessTokenAppIdPair).d());
            }
            d(c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0091 A[Catch: all -> 0x0098, TRY_LEAVE, TryCatch #9 {, blocks: (B:4:0x0003, B:9:0x000c, B:12:0x0029, B:13:0x002c, B:46:0x0091, B:16:0x0037, B:25:0x004d, B:26:0x0050, B:29:0x005b, B:30:0x005f, B:32:0x0064, B:33:0x0067, B:37:0x0079, B:36:0x0072, B:39:0x007b, B:40:0x007e, B:43:0x0089), top: B:64:0x0003 }] */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized com.facebook.appevents.PersistedEvents c() {
        /*
            java.lang.Class<com.facebook.appevents.d> r0 = com.facebook.appevents.d.class
            monitor-enter(r0)
            boolean r1 = com.facebook.internal.instrument.e.a.c(r0)     // Catch: java.lang.Throwable -> L9e
            r2 = 0
            if (r1 == 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            com.facebook.appevents.internal.b.b()     // Catch: java.lang.Throwable -> L98
            android.content.Context r1 = com.facebook.f.f()     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L7a
            com.facebook.appevents.d$a r4 = new com.facebook.appevents.d$a     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L7a
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L7a
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L7a
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44 java.io.FileNotFoundException -> L7a
            java.lang.Object r3 = r4.readObject()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L63 java.io.FileNotFoundException -> L7b
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L63 java.io.FileNotFoundException -> L7b
            com.facebook.internal.x.h(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L98
            r1.delete()     // Catch: java.lang.Exception -> L36 java.lang.Throwable -> L98
            goto L8f
        L36:
            r1 = move-exception
            java.lang.String r4 = com.facebook.appevents.d.a     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> L98
            goto L8f
        L3f:
            r3 = move-exception
            goto L46
        L41:
            r3 = move-exception
            r4 = r2
            goto L64
        L44:
            r3 = move-exception
            r4 = r2
        L46:
            java.lang.String r5 = com.facebook.appevents.d.a     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r3)     // Catch: java.lang.Throwable -> L63
            com.facebook.internal.x.h(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> L98
            r1.delete()     // Catch: java.lang.Exception -> L5a java.lang.Throwable -> L98
            goto L8e
        L5a:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.d.a     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "Got unexpected exception when removing events file: "
        L5f:
            android.util.Log.w(r3, r4, r1)     // Catch: java.lang.Throwable -> L98
            goto L8e
        L63:
            r3 = move-exception
        L64:
            com.facebook.internal.x.h(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L98
            r1.delete()     // Catch: java.lang.Exception -> L71 java.lang.Throwable -> L98
            goto L79
        L71:
            r1 = move-exception
            java.lang.String r4 = com.facebook.appevents.d.a     // Catch: java.lang.Throwable -> L98
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r4, r5, r1)     // Catch: java.lang.Throwable -> L98
        L79:
            throw r3     // Catch: java.lang.Throwable -> L98
        L7a:
            r4 = r2
        L7b:
            com.facebook.internal.x.h(r4)     // Catch: java.lang.Throwable -> L98
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L98
            r1.delete()     // Catch: java.lang.Exception -> L88 java.lang.Throwable -> L98
            goto L8e
        L88:
            r1 = move-exception
            java.lang.String r3 = com.facebook.appevents.d.a     // Catch: java.lang.Throwable -> L98
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            goto L5f
        L8e:
            r3 = r2
        L8f:
            if (r3 != 0) goto L96
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch: java.lang.Throwable -> L98
            r3.<init>()     // Catch: java.lang.Throwable -> L98
        L96:
            monitor-exit(r0)
            return r3
        L98:
            r1 = move-exception
            com.facebook.internal.instrument.e.a.b(r1, r0)     // Catch: java.lang.Throwable -> L9e
            monitor-exit(r0)
            return r2
        L9e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.d.c():com.facebook.appevents.PersistedEvents");
    }

    protected static void d(PersistedEvents persistedEvents) {
        if (com.facebook.internal.instrument.e.a.c(d.class)) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            Context f2 = com.facebook.f.f();
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(f2.openFileOutput("AppEventsLogger.persistedevents", 0)));
                try {
                    objectOutputStream2.writeObject(persistedEvents);
                    x.h(objectOutputStream2);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    Log.w(a, "Got unexpected exception while persisting events: ", th);
                    try {
                        f2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                    }
                    x.h(objectOutputStream);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            com.facebook.internal.instrument.e.a.b(th3, d.class);
        }
    }
}
