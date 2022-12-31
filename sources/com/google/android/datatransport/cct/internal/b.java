package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tapjoy.TapjoyConstants;
import java.io.IOException;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: AutoBatchedLogRequestEncoder.java */
/* loaded from: classes.dex */
public final class b implements Configurator {
    public static final Configurator a = new b();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class a implements ObjectEncoder<com.google.android.datatransport.cct.internal.a> {
        static final a a = new a();
        private static final FieldDescriptor b = FieldDescriptor.of(RemoteConfigConstants.RequestFieldKey.SDK_VERSION);
        private static final FieldDescriptor c = FieldDescriptor.of(BigAlbumStore.PhotoTagColumns.MODEL);

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f3322d = FieldDescriptor.of("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f3323e = FieldDescriptor.of(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f3324f = FieldDescriptor.of("product");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f3325g = FieldDescriptor.of("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f3326h = FieldDescriptor.of("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f3327i = FieldDescriptor.of("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f3328j = FieldDescriptor.of("locale");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f3329k = FieldDescriptor.of(BigAlbumStore.PhotoAddressColumns.COUNTRY);

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f3330l = FieldDescriptor.of("mccMnc");
        private static final FieldDescriptor m = FieldDescriptor.of("applicationBuild");

        private a() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void encode(com.google.android.datatransport.cct.internal.a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, aVar.m());
            objectEncoderContext.add(c, aVar.j());
            objectEncoderContext.add(f3322d, aVar.f());
            objectEncoderContext.add(f3323e, aVar.d());
            objectEncoderContext.add(f3324f, aVar.l());
            objectEncoderContext.add(f3325g, aVar.k());
            objectEncoderContext.add(f3326h, aVar.h());
            objectEncoderContext.add(f3327i, aVar.e());
            objectEncoderContext.add(f3328j, aVar.g());
            objectEncoderContext.add(f3329k, aVar.c());
            objectEncoderContext.add(f3330l, aVar.i());
            objectEncoderContext.add(m, aVar.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: com.google.android.datatransport.cct.internal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0127b implements ObjectEncoder<j> {
        static final C0127b a = new C0127b();
        private static final FieldDescriptor b = FieldDescriptor.of("logRequest");

        private C0127b() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void encode(j jVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, jVar.c());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class c implements ObjectEncoder<ClientInfo> {
        static final c a = new c();
        private static final FieldDescriptor b = FieldDescriptor.of("clientType");
        private static final FieldDescriptor c = FieldDescriptor.of("androidClientInfo");

        private c() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, clientInfo.c());
            objectEncoderContext.add(c, clientInfo.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class d implements ObjectEncoder<k> {
        static final d a = new d();
        private static final FieldDescriptor b = FieldDescriptor.of("eventTimeMs");
        private static final FieldDescriptor c = FieldDescriptor.of("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f3331d = FieldDescriptor.of("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f3332e = FieldDescriptor.of("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f3333f = FieldDescriptor.of("sourceExtensionJsonProto3");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f3334g = FieldDescriptor.of("timezoneOffsetSeconds");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f3335h = FieldDescriptor.of("networkConnectionInfo");

        private d() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void encode(k kVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, kVar.c());
            objectEncoderContext.add(c, kVar.b());
            objectEncoderContext.add(f3331d, kVar.d());
            objectEncoderContext.add(f3332e, kVar.f());
            objectEncoderContext.add(f3333f, kVar.g());
            objectEncoderContext.add(f3334g, kVar.h());
            objectEncoderContext.add(f3335h, kVar.e());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class e implements ObjectEncoder<l> {
        static final e a = new e();
        private static final FieldDescriptor b = FieldDescriptor.of("requestTimeMs");
        private static final FieldDescriptor c = FieldDescriptor.of("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f3336d = FieldDescriptor.of("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f3337e = FieldDescriptor.of("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f3338f = FieldDescriptor.of("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f3339g = FieldDescriptor.of("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f3340h = FieldDescriptor.of("qosTier");

        private e() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void encode(l lVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, lVar.g());
            objectEncoderContext.add(c, lVar.h());
            objectEncoderContext.add(f3336d, lVar.b());
            objectEncoderContext.add(f3337e, lVar.d());
            objectEncoderContext.add(f3338f, lVar.e());
            objectEncoderContext.add(f3339g, lVar.c());
            objectEncoderContext.add(f3340h, lVar.f());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class f implements ObjectEncoder<NetworkConnectionInfo> {
        static final f a = new f();
        private static final FieldDescriptor b = FieldDescriptor.of("networkType");
        private static final FieldDescriptor c = FieldDescriptor.of("mobileSubtype");

        private f() {
        }

        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        /* renamed from: a */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(b, networkConnectionInfo.c());
            objectEncoderContext.add(c, networkConnectionInfo.b());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        C0127b c0127b = C0127b.a;
        encoderConfig.registerEncoder(j.class, c0127b);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.d.class, c0127b);
        e eVar = e.a;
        encoderConfig.registerEncoder(l.class, eVar);
        encoderConfig.registerEncoder(g.class, eVar);
        c cVar = c.a;
        encoderConfig.registerEncoder(ClientInfo.class, cVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.e.class, cVar);
        a aVar = a.a;
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.a.class, aVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.c.class, aVar);
        d dVar = d.a;
        encoderConfig.registerEncoder(k.class, dVar);
        encoderConfig.registerEncoder(com.google.android.datatransport.cct.internal.f.class, dVar);
        f fVar = f.a;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, fVar);
        encoderConfig.registerEncoder(i.class, fVar);
    }
}
