package us.pinguo.repository2020.database.staticsticker;

import androidx.collection.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.z0;
import us.pinguo.common.pgdownloader.download.DownloadListener;
import us.pinguo.common.pgdownloader.download.IDownloadTask;
import us.pinguo.common.pgdownloader.download.PGDownloadManger;
import us.pinguo.repository2020.api.StaticStickerFetcherKt;
import us.pinguo.util.FileUtils;
import us.pinguo.util.v;
/* compiled from: StaticStickerManager.kt */
/* loaded from: classes6.dex */
public final class StaticStickerManager {
    public static final StaticStickerManager a = new StaticStickerManager();
    private static final String b = s.q(v.e("static_sticker"), "/");
    private static final kotlinx.coroutines.sync.c c = MutexKt.b(false, 1, null);

    /* renamed from: d  reason: collision with root package name */
    private static List<ShopCategory> f11842d;

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentHashMap<String, StaticStickerCategoryTable> f11843e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, StaticStickerTable> f11844f;

    /* renamed from: g  reason: collision with root package name */
    private static List<StaticStickerCategory> f11845g;

    /* renamed from: h  reason: collision with root package name */
    private static final ConcurrentHashMap<String, StaticStickerCategory> f11846h;

    /* renamed from: i  reason: collision with root package name */
    private static final ConcurrentHashMap<String, StaticSticker> f11847i;

    /* renamed from: j  reason: collision with root package name */
    private static List<TemplateCategory> f11848j;

    /* renamed from: k  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Template> f11849k;

    /* renamed from: l  reason: collision with root package name */
    private static final LruCache<String, StaticStickerDetail> f11850l;
    private static final LruCache<String, StaticSticker> m;
    private static final CopyOnWriteArrayList<Template> n;

    /* compiled from: StaticStickerManager.kt */
    @DebugMetadata(c = "us.pinguo.repository2020.database.staticsticker.StaticStickerManager$1", f = "StaticStickerManager.kt", i = {}, l = {46, 47}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                String u = StaticStickerManager.a.u();
                this.label = 1;
                obj = FileUtils.o(u, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.j.b(obj);
                return u.a;
            } else {
                kotlin.j.b(obj);
            }
            if (!((Boolean) obj).booleanValue()) {
                String u2 = StaticStickerManager.a.u();
                this.label = 2;
                if (FileUtils.f(u2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return u.a;
        }
    }

    static {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
        f11843e = new ConcurrentHashMap<>();
        f11844f = Collections.synchronizedMap(new LinkedHashMap());
        f11846h = new ConcurrentHashMap<>();
        f11847i = new ConcurrentHashMap<>();
        f11849k = new ConcurrentHashMap<>();
        f11850l = new LruCache<>(66);
        m = new LruCache<>(Integer.MAX_VALUE);
        n = new CopyOnWriteArrayList<>();
    }

    private StaticStickerManager() {
    }

    private final void B() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$inflateRecentStickers$1(null), 3, null);
    }

    private final void D() {
        ArrayList arrayList;
        if (!n.isEmpty()) {
            return;
        }
        List<k> all = us.pinguo.repository2020.database.a.a().E().getAll();
        if (all == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (k kVar : all) {
                Template template = f11849k.get(kVar.a());
                if (template != null) {
                    arrayList2.add(template);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null) {
            return;
        }
        if (!arrayList.isEmpty()) {
            n.addAllAbsent(arrayList);
        }
        Collection<Template> values = f11849k.values();
        s.g(values, "_templateMap.values");
        for (Template template2 : values) {
            template2.isCollected().set(n.contains(template2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01dc, code lost:
        r13 = kotlin.text.StringsKt__StringsKt.p0(r21, new java.lang.String[]{","}, false, 0, 6, null);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c3 A[Catch: all -> 0x0528, TRY_LEAVE, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d7 A[Catch: all -> 0x0524, TryCatch #0 {all -> 0x0524, blocks: (B:108:0x02d1, B:110:0x02d7, B:112:0x02ee, B:141:0x03f7), top: B:208:0x02d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0311 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:13:0x0066, B:120:0x035a, B:131:0x0374, B:114:0x030b, B:116:0x0311, B:133:0x0387, B:135:0x03aa, B:143:0x03ff, B:160:0x0457, B:199:0x0513, B:163:0x0484, B:165:0x0488, B:169:0x0499, B:185:0x04cc, B:192:0x04d9, B:194:0x04f2, B:196:0x050b, B:197:0x0510, B:172:0x04a1, B:174:0x04aa, B:176:0x04b8, B:182:0x04c5, B:198:0x0511, B:146:0x0408, B:148:0x040c, B:151:0x0417, B:153:0x042a, B:155:0x042f, B:157:0x043b, B:158:0x0444, B:154:0x042d, B:159:0x0455, B:136:0x03e0, B:137:0x03e7, B:123:0x0361, B:126:0x0368), top: B:211:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0374 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:13:0x0066, B:120:0x035a, B:131:0x0374, B:114:0x030b, B:116:0x0311, B:133:0x0387, B:135:0x03aa, B:143:0x03ff, B:160:0x0457, B:199:0x0513, B:163:0x0484, B:165:0x0488, B:169:0x0499, B:185:0x04cc, B:192:0x04d9, B:194:0x04f2, B:196:0x050b, B:197:0x0510, B:172:0x04a1, B:174:0x04aa, B:176:0x04b8, B:182:0x04c5, B:198:0x0511, B:146:0x0408, B:148:0x040c, B:151:0x0417, B:153:0x042a, B:155:0x042f, B:157:0x043b, B:158:0x0444, B:154:0x042d, B:159:0x0455, B:136:0x03e0, B:137:0x03e7, B:123:0x0361, B:126:0x0368), top: B:211:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0387 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:13:0x0066, B:120:0x035a, B:131:0x0374, B:114:0x030b, B:116:0x0311, B:133:0x0387, B:135:0x03aa, B:143:0x03ff, B:160:0x0457, B:199:0x0513, B:163:0x0484, B:165:0x0488, B:169:0x0499, B:185:0x04cc, B:192:0x04d9, B:194:0x04f2, B:196:0x050b, B:197:0x0510, B:172:0x04a1, B:174:0x04aa, B:176:0x04b8, B:182:0x04c5, B:198:0x0511, B:146:0x0408, B:148:0x040c, B:151:0x0417, B:153:0x042a, B:155:0x042f, B:157:0x043b, B:158:0x0444, B:154:0x042d, B:159:0x0455, B:136:0x03e0, B:137:0x03e7, B:123:0x0361, B:126:0x0368), top: B:211:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0408 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:13:0x0066, B:120:0x035a, B:131:0x0374, B:114:0x030b, B:116:0x0311, B:133:0x0387, B:135:0x03aa, B:143:0x03ff, B:160:0x0457, B:199:0x0513, B:163:0x0484, B:165:0x0488, B:169:0x0499, B:185:0x04cc, B:192:0x04d9, B:194:0x04f2, B:196:0x050b, B:197:0x0510, B:172:0x04a1, B:174:0x04aa, B:176:0x04b8, B:182:0x04c5, B:198:0x0511, B:146:0x0408, B:148:0x040c, B:151:0x0417, B:153:0x042a, B:155:0x042f, B:157:0x043b, B:158:0x0444, B:154:0x042d, B:159:0x0455, B:136:0x03e0, B:137:0x03e7, B:123:0x0361, B:126:0x0368), top: B:211:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0484 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:13:0x0066, B:120:0x035a, B:131:0x0374, B:114:0x030b, B:116:0x0311, B:133:0x0387, B:135:0x03aa, B:143:0x03ff, B:160:0x0457, B:199:0x0513, B:163:0x0484, B:165:0x0488, B:169:0x0499, B:185:0x04cc, B:192:0x04d9, B:194:0x04f2, B:196:0x050b, B:197:0x0510, B:172:0x04a1, B:174:0x04aa, B:176:0x04b8, B:182:0x04c5, B:198:0x0511, B:146:0x0408, B:148:0x040c, B:151:0x0417, B:153:0x042a, B:155:0x042f, B:157:0x043b, B:158:0x0444, B:154:0x042d, B:159:0x0455, B:136:0x03e0, B:137:0x03e7, B:123:0x0361, B:126:0x0368), top: B:211:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04d9 A[Catch: all -> 0x007b, TryCatch #2 {all -> 0x007b, blocks: (B:13:0x0066, B:120:0x035a, B:131:0x0374, B:114:0x030b, B:116:0x0311, B:133:0x0387, B:135:0x03aa, B:143:0x03ff, B:160:0x0457, B:199:0x0513, B:163:0x0484, B:165:0x0488, B:169:0x0499, B:185:0x04cc, B:192:0x04d9, B:194:0x04f2, B:196:0x050b, B:197:0x0510, B:172:0x04a1, B:174:0x04aa, B:176:0x04b8, B:182:0x04c5, B:198:0x0511, B:146:0x0408, B:148:0x040c, B:151:0x0417, B:153:0x042a, B:155:0x042f, B:157:0x043b, B:158:0x0444, B:154:0x042d, B:159:0x0455, B:136:0x03e0, B:137:0x03e7, B:123:0x0361, B:126:0x0368), top: B:211:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf A[Catch: all -> 0x0528, TRY_LEAVE, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: all -> 0x0528, TRY_ENTER, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0149 A[Catch: all -> 0x0528, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019e A[Catch: all -> 0x0528, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x027d A[Catch: all -> 0x0528, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0292 A[Catch: all -> 0x0528, TryCatch #1 {all -> 0x0528, blocks: (B:28:0x00b5, B:30:0x00bf, B:33:0x00c6, B:35:0x00cc, B:37:0x00fd, B:53:0x013c, B:64:0x018e, B:89:0x0234, B:91:0x027d, B:92:0x0286, B:103:0x02ae, B:106:0x02c3, B:95:0x0292, B:97:0x0296, B:101:0x02a8, B:100:0x02a1, B:102:0x02ac, B:67:0x019e, B:68:0x01a2, B:70:0x01a8, B:72:0x01c4, B:75:0x01cb, B:76:0x01d3, B:85:0x01fe, B:79:0x01dc, B:82:0x01f1, B:84:0x01fa, B:86:0x022c, B:87:0x0231, B:88:0x0232, B:56:0x0149, B:58:0x014d, B:61:0x015c, B:63:0x0188, B:40:0x0114, B:43:0x011b, B:45:0x0124, B:52:0x0138, B:36:0x00e2), top: B:210:0x00b5 }] */
    /* JADX WARN: Type inference failed for: r13v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v38, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:113:0x0302 -> B:114:0x030b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x0350 -> B:120:0x035a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:138:0x03e8 -> B:139:0x03ee). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(boolean r42, kotlin.coroutines.Continuation<? super kotlin.u> r43) {
        /*
            Method dump skipped, instructions count: 1328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager.E(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Map<String, Template> A() {
        return f11849k;
    }

    public final boolean C(Template template) {
        boolean z;
        s.h(template, "template");
        StaticStickerDetail[] stickers = template.getStickers();
        if (stickers != null) {
            int length = stickers.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                StaticStickerDetail staticStickerDetail = stickers[i2];
                i2++;
                if (!f11844f.containsKey(staticStickerDetail.getSid())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public final void F(kotlin.jvm.b.l<? super Exception, u> lVar) {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$loadStickerAsync$1(lVar, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.repository2020.database.staticsticker.StaticStickerManager$needUpdate$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager$needUpdate$1 r0 = (us.pinguo.repository2020.database.staticsticker.StaticStickerManager$needUpdate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager$needUpdate$1 r0 = new us.pinguo.repository2020.database.staticsticker.StaticStickerManager$needUpdate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.j.b(r6)
            goto L4b
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.j.b(r6)
            java.lang.String r6 = r4.u()
            java.lang.String r6 = kotlin.jvm.internal.s.q(r6, r5)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = us.pinguo.util.FileUtils.o(r6, r0)
            if (r6 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r0 = 0
            if (r6 != 0) goto L59
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r5
        L59:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, us.pinguo.repository2020.database.staticsticker.StaticSticker> r6 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.f11847i
            java.lang.Object r6 = r6.get(r5)
            us.pinguo.repository2020.database.staticsticker.StaticSticker r6 = (us.pinguo.repository2020.database.staticsticker.StaticSticker) r6
            r1 = 0
            if (r6 != 0) goto L66
            r6 = r1
            goto L6a
        L66:
            java.lang.String r6 = r6.getDisplay_md5()
        L6a:
            if (r6 != 0) goto L71
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r5
        L71:
            java.util.Map<java.lang.String, us.pinguo.repository2020.database.staticsticker.StaticStickerTable> r0 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.f11844f
            java.lang.Object r0 = r0.get(r5)
            us.pinguo.repository2020.database.staticsticker.StaticStickerTable r0 = (us.pinguo.repository2020.database.staticsticker.StaticStickerTable) r0
            if (r0 != 0) goto L7d
            r0 = r1
            goto L81
        L7d:
            java.lang.String r0 = r0.getDisplay_md5()
        L81:
            if (r0 != 0) goto L97
            us.pinguo.repository2020.database.EffectDbManager r0 = us.pinguo.repository2020.database.a.a()
            us.pinguo.repository2020.database.staticsticker.g r0 = r0.D()
            us.pinguo.repository2020.database.staticsticker.StaticStickerTable r5 = r0.d(r5)
            if (r5 != 0) goto L92
            goto L98
        L92:
            java.lang.String r1 = r5.getDisplay_md5()
            goto L98
        L97:
            r1 = r0
        L98:
            boolean r5 = kotlin.jvm.internal.s.c(r1, r6)
            r5 = r5 ^ r3
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager.G(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void H() {
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$unInflateRecentStickers$1(null), 3, null);
    }

    public final void I(StaticSticker sticker) {
        s.h(sticker, "sticker");
        String sid = sticker.getSid();
        if (sid == null) {
            return;
        }
        LruCache<String, StaticSticker> lruCache = m;
        if (lruCache.get(sid) == null) {
            lruCache.put(sid, sticker);
        }
    }

    public final void h(Template template) {
        s.h(template, "template");
        String tid = template.getTid();
        if (tid != null && n.addIfAbsent(template)) {
            us.pinguo.repository2020.database.a.a().E().b(new k(tid));
        }
    }

    public final void i(String categoryId) {
        s.h(categoryId, "categoryId");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$deleteCategory$1(categoryId, null), 3, null);
    }

    public final void j(Template template) {
        s.h(template, "template");
        String tid = template.getTid();
        if (tid != null && n.remove(template)) {
            us.pinguo.repository2020.database.a.a().E().a(tid);
        }
    }

    public final void k(List<String> idList) {
        s.h(idList, "idList");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$deleteStickers$1(idList, null), 3, null);
    }

    public final void l(List<StaticSticker> stickerList, int i2, kotlin.jvm.b.l<? super Integer, u> lVar, kotlin.jvm.b.l<? super Boolean, u> lVar2) {
        s.h(stickerList, "stickerList");
        kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$downloadStickers$1(stickerList, PGDownloadManger.Companion.getInstance(), i2, lVar, lVar2, null), 3, null);
    }

    public final void m(final StaticStickerCategory stickerCategory, final p<? super String, ? super Integer, u> pVar, final p<? super String, ? super Boolean, u> pVar2) {
        String down_url;
        s.h(stickerCategory, "stickerCategory");
        final String pid = stickerCategory.getPid();
        if (pid == null || (down_url = stickerCategory.getDown_url()) == null) {
            return;
        }
        PGDownloadManger companion = PGDownloadManger.Companion.getInstance();
        IDownloadTask create = companion.create(down_url, b + pid + "_zip", false, 0);
        create.setForceReDownload(true);
        create.setListener(new DownloadListener() { // from class: us.pinguo.repository2020.database.staticsticker.StaticStickerManager$downloadWholeStickerCategory$1
            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onComplete(IDownloadTask task) {
                s.h(task, "task");
                kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new StaticStickerManager$downloadWholeStickerCategory$1$onComplete$1(task, pVar, pid, pVar2, stickerCategory, null), 3, null);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onError(IDownloadTask task, int i2) {
                s.h(task, "task");
                p<String, Integer, u> pVar3 = pVar;
                if (pVar3 != null) {
                    pVar3.invoke(pid, -1);
                }
                p<String, Boolean, u> pVar4 = pVar2;
                if (pVar4 == null) {
                    return;
                }
                pVar4.invoke(pid, Boolean.FALSE);
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onPause(IDownloadTask task) {
                s.h(task, "task");
            }

            @Override // us.pinguo.common.pgdownloader.download.DownloadListener
            public void onProgress(IDownloadTask task, int i2, int i3, int i4) {
                s.h(task, "task");
                p<String, Integer, u> pVar3 = pVar;
                if (pVar3 == null) {
                    return;
                }
                pVar3.invoke(pid, Integer.valueOf((int) ((i3 / i4) * 100.0f)));
            }
        });
        create.start();
    }

    public final void n(String pid, kotlin.jvm.b.l<? super ShopDetail, u> lVar) {
        s.h(pid, "pid");
        StaticStickerFetcherKt.a(pid, new StaticStickerManager$fetchShopDetail$1(lVar));
    }

    public final void o(boolean z, p<? super StaticStickerJson, ? super Exception, u> pVar) {
        StaticStickerFetcherKt.b(z, new StaticStickerManager$fetchStickers$1(pVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r8, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.database.staticsticker.StaticStickerDetail> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof us.pinguo.repository2020.database.staticsticker.StaticStickerManager$findStaticStickerDetail$1
            if (r0 == 0) goto L13
            r0 = r9
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager$findStaticStickerDetail$1 r0 = (us.pinguo.repository2020.database.staticsticker.StaticStickerManager$findStaticStickerDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager$findStaticStickerDetail$1 r0 = new us.pinguo.repository2020.database.staticsticker.StaticStickerManager$findStaticStickerDetail$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.j.b(r9)
            goto L8c
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.j.b(r9)
            goto L6f
        L49:
            kotlin.j.b(r9)
            androidx.collection.LruCache<java.lang.String, us.pinguo.repository2020.database.staticsticker.StaticStickerDetail> r9 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.f11850l
            java.lang.Object r9 = r9.get(r8)
            us.pinguo.repository2020.database.staticsticker.StaticStickerDetail r9 = (us.pinguo.repository2020.database.staticsticker.StaticStickerDetail) r9
            if (r9 != 0) goto Lbc
            java.lang.String r9 = r7.u()
            java.lang.String r9 = kotlin.jvm.internal.s.q(r9, r8)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = us.pinguo.util.FileUtils.o(r9, r0)
            if (r2 != r1) goto L6b
            return r1
        L6b:
            r6 = r2
            r2 = r8
            r8 = r9
            r9 = r6
        L6f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L78
            return r5
        L78:
            java.lang.String r9 = "/display.json"
            java.lang.String r8 = kotlin.jvm.internal.s.q(r8, r9)
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = us.pinguo.util.FileUtils.q(r8, r0)
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r0 = r2
        L8c:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L95
            return r5
        L95:
            java.io.InputStreamReader r9 = new java.io.InputStreamReader
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r8)
            r1.<init>(r2)
            r9.<init>(r1)
            com.google.gson.e r8 = com.pinguo.lib.GsonUtilKt.getCachedGson()
            java.lang.Class<us.pinguo.repository2020.database.staticsticker.StaticStickerDetail> r1 = us.pinguo.repository2020.database.staticsticker.StaticStickerDetail.class
            java.lang.Object r8 = r8.h(r9, r1)
            us.pinguo.repository2020.database.staticsticker.StaticStickerDetail r8 = (us.pinguo.repository2020.database.staticsticker.StaticStickerDetail) r8
            r9.close()
            if (r8 != 0) goto Lb6
            return r5
        Lb6:
            androidx.collection.LruCache<java.lang.String, us.pinguo.repository2020.database.staticsticker.StaticStickerDetail> r9 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.f11850l
            r9.put(r0, r8)
            return r8
        Lbc:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.staticsticker.StaticStickerManager.p(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<Template> q() {
        return n;
    }

    public final Map<String, StaticStickerCategoryTable> r() {
        return f11843e;
    }

    public final Map<String, StaticStickerTable> s() {
        Map<String, StaticStickerTable> _downloadedMap = f11844f;
        s.g(_downloadedMap, "_downloadedMap");
        return _downloadedMap;
    }

    public final Map<String, StaticSticker> t() {
        Map<String, StaticSticker> snapshot = m.snapshot();
        s.g(snapshot, "_recentStickers.snapshot()");
        return snapshot;
    }

    public final String u() {
        return b;
    }

    public final List<ShopCategory> v() {
        return f11842d;
    }

    public final List<StaticStickerCategory> w() {
        return f11845g;
    }

    public final Map<String, StaticStickerCategory> x() {
        return f11846h;
    }

    public final Map<String, StaticSticker> y() {
        return f11847i;
    }

    public final List<TemplateCategory> z() {
        return f11848j;
    }
}
