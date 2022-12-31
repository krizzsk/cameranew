package us.pinguo.edit2020.viewmodel.module;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Size;
import androidx.exifinterface.media.ExifInterface;
import com.growingio.android.sdk.monitor.BuildConfig;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.pinguo.lib.GsonUtilKt;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.w;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.a0;
import us.pinguo.edit2020.bean.c0;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.repository.EditRepository;
import us.pinguo.foundation.utils.n0;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
import us.pinguo.libdeepvision.PortraitMatting;
import us.pinguo.repository2020.database.background.Background;
import us.pinguo.repository2020.database.background.BackgroundCategory;
import us.pinguo.repository2020.database.background.BackgroundDetail;
import us.pinguo.repository2020.database.background.BackgroundMaterialManager;
import us.pinguo.repository2020.database.background.CutoutFilter;
import us.pinguo.repository2020.database.background.DecorationDetail;
import us.pinguo.repository2020.database.background.DisplayRect;
import us.pinguo.repository2020.database.background.StandardFacePoints;
import us.pinguo.repository2020.utils.h;
import us.pinguo.repository2020.utils.k;
import us.pinguo.u3dengine.api.MagicBackgroundStrokeType;
import us.pinguo.u3dengine.api.MagicBgItem;
import us.pinguo.u3dengine.api.MagicBgType;
import us.pinguo.u3dengine.api.PGEditBlendMode;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.util.FileUtils;
/* compiled from: BackgroundReplacementModule.kt */
/* loaded from: classes4.dex */
public final class BackgroundReplacementModule implements us.pinguo.edit2020.utils.f {
    private final EditRender a;
    private int b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10827d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10828e;

    /* renamed from: f  reason: collision with root package name */
    private us.pinguo.edit2020.c.b f10829f;

    /* renamed from: g  reason: collision with root package name */
    private final EditRepository f10830g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<String> f10831h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, String> f10832i;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayMap<String, MagicBgItem> f10833j;

    /* renamed from: k  reason: collision with root package name */
    private e f10834k;

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<c0> f10835l;
    private final ArrayList<BackgroundCategory> m;
    private final ArrayList<us.pinguo.edit2020.bean.f> n;
    private BackgroundCategory o;
    private us.pinguo.edit2020.bean.f p;
    private String q;
    private a r;
    private boolean s;
    private Size t;
    private final kotlin.f u;
    private Size v;
    private Size w;
    private boolean x;
    private kotlin.jvm.b.a<u> y;
    private Float[] z;

    /* compiled from: BackgroundReplacementModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$1", f = "BackgroundReplacementModule.kt", i = {0, 0, 1}, l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444, BuildConfig.VERSION_CODE}, m = "invokeSuspend", n = {"context", "cacheDir", "context"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        Object L$0;
        Object L$1;
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
            File file;
            Context context;
            Context context2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                j.b(obj);
                BackgroundReplacementModule.this.L0();
                Context b = us.pinguo.foundation.e.b();
                file = new File(h.b());
                this.L$0 = b;
                this.L$1 = file;
                this.label = 1;
                Object n = FileUtils.n(file, this);
                if (n == coroutine_suspended) {
                    return coroutine_suspended;
                }
                context = b;
                obj = n;
            } else if (i2 == 1) {
                file = (File) this.L$1;
                context = (Context) this.L$0;
                j.b(obj);
            } else if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                context2 = (Context) this.L$0;
                j.b(obj);
                context = context2;
                InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(context.getAssets().open("standard_face_points.json", 3)));
                try {
                    BackgroundReplacementModule.this.z = ((StandardFacePoints) GsonUtilKt.getCachedGson().h(inputStreamReader, StandardFacePoints.class)).getPoints();
                    u uVar = u.a;
                    kotlin.io.b.a(inputStreamReader, null);
                    return uVar;
                } finally {
                }
            }
            if (((Boolean) obj).booleanValue()) {
                File[] listFiles = file.listFiles();
                this.L$0 = context;
                this.L$1 = null;
                this.label = 2;
                if (FileUtils.m(listFiles, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                context2 = context;
                context = context2;
                InputStreamReader inputStreamReader2 = new InputStreamReader(new BufferedInputStream(context.getAssets().open("standard_face_points.json", 3)));
                BackgroundReplacementModule.this.z = ((StandardFacePoints) GsonUtilKt.getCachedGson().h(inputStreamReader2, StandardFacePoints.class)).getPoints();
                u uVar2 = u.a;
                kotlin.io.b.a(inputStreamReader2, null);
                return uVar2;
            }
            file.mkdirs();
            InputStreamReader inputStreamReader22 = new InputStreamReader(new BufferedInputStream(context.getAssets().open("standard_face_points.json", 3)));
            BackgroundReplacementModule.this.z = ((StandardFacePoints) GsonUtilKt.getCachedGson().h(inputStreamReader22, StandardFacePoints.class)).getPoints();
            u uVar22 = u.a;
            kotlin.io.b.a(inputStreamReader22, null);
            return uVar22;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BackgroundReplacementModule.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private final String a;
        private final Size b;
        private final PointF c;

        /* renamed from: d  reason: collision with root package name */
        private final String f10836d;

        /* renamed from: e  reason: collision with root package name */
        private final Size f10837e;

        /* renamed from: f  reason: collision with root package name */
        private final String f10838f;

        /* renamed from: g  reason: collision with root package name */
        private final Size f10839g;

        /* renamed from: h  reason: collision with root package name */
        private us.pinguo.facedetector.c f10840h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f10841i;

        public a(String cutPath, Size cutSize, PointF cutCenter, String sourcePath, Size sourceSize, String maskPath, Size maskSize) {
            s.h(cutPath, "cutPath");
            s.h(cutSize, "cutSize");
            s.h(cutCenter, "cutCenter");
            s.h(sourcePath, "sourcePath");
            s.h(sourceSize, "sourceSize");
            s.h(maskPath, "maskPath");
            s.h(maskSize, "maskSize");
            this.a = cutPath;
            this.b = cutSize;
            this.c = cutCenter;
            this.f10836d = sourcePath;
            this.f10837e = sourceSize;
            this.f10838f = maskPath;
            this.f10839g = maskSize;
            this.f10841i = true;
            h();
        }

        public final us.pinguo.facedetector.c a() {
            return this.f10840h;
        }

        public final PointF b() {
            return this.c;
        }

        public final Size c() {
            return this.b;
        }

        public final String d() {
            return this.f10838f;
        }

        public final Size e() {
            return this.f10839g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return s.c(this.a, aVar.a) && s.c(this.b, aVar.b) && s.c(this.c, aVar.c) && s.c(this.f10836d, aVar.f10836d) && s.c(this.f10837e, aVar.f10837e) && s.c(this.f10838f, aVar.f10838f) && s.c(this.f10839g, aVar.f10839g);
            }
            return false;
        }

        public final String f() {
            return this.f10836d;
        }

        public final Size g() {
            return this.f10837e;
        }

        public final void h() {
            int c;
            if (this.f10841i) {
                us.pinguo.facedetector.c cVar = this.f10840h;
                if (new File(this.a).exists()) {
                    this.f10841i = false;
                    DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
                    c = kotlin.z.j.c(displayMetrics.widthPixels, displayMetrics.heightPixels);
                    Bitmap g2 = us.pinguo.util.e.g(this.a, c, 0, 4, null);
                    cVar = g2 == null ? null : k.r(k.a, g2, 0, 2, null);
                }
                this.f10840h = cVar;
            }
        }

        public int hashCode() {
            return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.f10836d.hashCode()) * 31) + this.f10837e.hashCode()) * 31) + this.f10838f.hashCode()) * 31) + this.f10839g.hashCode();
        }

        public String toString() {
            return "PreparedCutoutInfo(cutPath=" + this.a + ", cutSize=" + this.b + ", cutCenter=" + this.c + ", sourcePath=" + this.f10836d + ", sourceSize=" + this.f10837e + ", maskPath=" + this.f10838f + ", maskSize=" + this.f10839g + ')';
        }
    }

    public BackgroundReplacementModule(EditRender editRender) {
        kotlin.f b;
        s.h(editRender, "editRender");
        this.a = editRender;
        this.c = n0.i();
        this.f10827d = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_max_in_discrete_mode);
        this.f10828e = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_min_in_discrete_mode);
        EditRepository editRepository = new EditRepository();
        this.f10830g = editRepository;
        this.f10832i = new HashMap<>();
        this.f10833j = new ArrayMap<>();
        this.f10835l = editRepository.m();
        this.m = new ArrayList<>();
        this.n = new ArrayList<>();
        b = kotlin.h.b(BackgroundReplacementModule$originItemInfo$2.INSTANCE);
        this.u = b;
        l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new AnonymousClass1(null), 3, null);
    }

    private final float C(us.pinguo.facedetector.b bVar) {
        float l2 = bVar.l(74);
        float m = bVar.m(74);
        float l3 = l2 - bVar.l(77);
        float m2 = m - bVar.m(77);
        return (float) Math.sqrt((l3 * l3) + (m2 * m2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(String str) {
        a aVar = this.r;
        if (aVar == null) {
            return;
        }
        aVar.h();
        y(str, aVar);
    }

    private final void E(String str, BackgroundDetail backgroundDetail, a aVar) {
        if (str != null && backgroundDetail != null) {
            l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new BackgroundReplacementModule$fillOrUpdatePhotoItem$1(backgroundDetail, this, aVar, str, null), 3, null);
            return;
        }
        M0(aVar.g());
        PointF pointF = new PointF(aVar.c().getWidth() / aVar.g().getWidth(), aVar.c().getHeight() / aVar.g().getHeight());
        PointF b = aVar.b();
        Y().c(pointF, b);
        MagicBackgroundStrokeType magicBackgroundStrokeType = MagicBackgroundStrokeType.None;
        PGEditBlendMode pGEditBlendMode = PGEditBlendMode.Normal;
        RectF Z = Z();
        Pair pair = new Pair(PortalFollowFeeds.TYPE_NONE, null);
        Pair pair2 = new Pair(new Triple(aVar.f(), Integer.valueOf(aVar.g().getWidth()), Integer.valueOf(aVar.g().getHeight())), new Triple(aVar.d(), Integer.valueOf(aVar.e().getWidth()), Integer.valueOf(aVar.e().getHeight())));
        MagicBgItem magicBgItem = new MagicBgItem(null, "photoItem", pGEditBlendMode, pointF, b, null, Boolean.TRUE, null, null, null, Z, MagicBgType.Person, null, magicBackgroundStrokeType, null, null, null, null, null, pair2, pair, 0, 512929, null);
        if (!this.f10833j.containsKey("photoItem")) {
            f0(this, magicBgItem, null, null, 6, null);
        } else {
            O0(this, magicBgItem, null, null, 6, null);
        }
        u();
    }

    private final float F0(int i2) {
        Float f2;
        Float[] fArr = this.z;
        if (fArr == null || (f2 = fArr[i2 * 2]) == null) {
            return 0.0f;
        }
        return f2.floatValue();
    }

    private final float G0(int i2) {
        Float f2;
        Float[] fArr = this.z;
        if (fArr == null || (f2 = fArr[(i2 * 2) + 1]) == null) {
            return 0.0f;
        }
        return f2.floatValue();
    }

    private final List<String> K(us.pinguo.edit2020.bean.f fVar) {
        ArrayList arrayList = new ArrayList();
        if (fVar == null) {
            return arrayList;
        }
        List<DecorationDetail> F = F(fVar.f());
        if (F != null) {
            int i2 = 0;
            for (Object obj : F) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.collections.s.n();
                    throw null;
                }
                arrayList.add(((DecorationDetail) obj).getName() + '_' + i2);
                i2 = i3;
            }
        }
        ArrayList<String> arrayList2 = this.f10831h;
        if (arrayList2 != null) {
            for (String str : arrayList2) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03b5  */
    /* JADX WARN: Type inference failed for: r16v3, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List<us.pinguo.u3dengine.api.MagicBgItem> L(java.lang.String r51, us.pinguo.repository2020.database.background.BackgroundDetail r52, us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule.a r53) {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule.L(java.lang.String, us.pinguo.repository2020.database.background.BackgroundDetail, us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule$a):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(Size size) {
        Size size2 = this.w;
        if (size2 == null) {
            this.w = size;
        } else if (s.c(size2, size)) {
        } else {
            this.w = size;
            UnityEditCaller.MagicBG.updateCanvasSize(size.getWidth(), size.getHeight());
            UnityEditCaller.Common.viewPortAnimationTo(size.getWidth(), size.getHeight(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(MagicBgItem magicBgItem, BackgroundDetail backgroundDetail, Rect rect) {
        us.pinguo.edit2020.bean.f fVar = this.p;
        if (fVar != null && s.c(magicBgItem.getKey(), "photoItem") && backgroundDetail != null && rect != null) {
            String f2 = fVar.f();
            CutoutFilter filter = backgroundDetail.getCutout().getFilter();
            String fixedLut = filter == null ? null : filter.getFixedLut();
            CutoutFilter filter2 = backgroundDetail.getCutout().getFilter();
            z0(f2, fixedLut, filter2 == null ? null : filter2.getAdjustableLut(), backgroundDetail.getSupportedHue(), rect);
            A0(fVar.k() / 100.0f);
            Background h2 = fVar.h();
            boolean z = false;
            if (h2 != null && h2.getSupport_color() == 1) {
                z = true;
            }
            if (z) {
                D0(fVar.j() / 100.0f);
            }
        }
        String key = magicBgItem.getKey();
        if (key != null) {
            UnityEditCaller.MagicBG.updateItemPosition(key, magicBgItem.getSize(), magicBgItem.getCenter(), magicBgItem.getRotateAngle());
            UnityEditCaller.MagicBG.updateItemSideEffect(magicBgItem);
        }
    }

    static /* synthetic */ void O0(BackgroundReplacementModule backgroundReplacementModule, MagicBgItem magicBgItem, BackgroundDetail backgroundDetail, Rect rect, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            backgroundDetail = null;
        }
        if ((i2 & 4) != 0) {
            rect = null;
        }
        backgroundReplacementModule.N0(magicBgItem, backgroundDetail, rect);
    }

    public static /* synthetic */ void Q0(BackgroundReplacementModule backgroundReplacementModule, String str, PointF pointF, PointF pointF2, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            pointF = null;
        }
        if ((i2 & 4) != 0) {
            pointF2 = null;
        }
        if ((i2 & 8) != 0) {
            num = null;
        }
        backgroundReplacementModule.P0(str, pointF, pointF2, num);
    }

    private final Size S(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return new Size(options.outWidth, options.outHeight);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int U(int r15, float r16, float r17, float r18) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule.U(int, float, float, float):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int V(BackgroundReplacementModule backgroundReplacementModule, int i2, float f2, float f3, float f4, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = 0.2f;
        }
        if ((i3 & 4) != 0) {
            f3 = -0.16f;
        }
        if ((i3 & 8) != 0) {
            f4 = 100.0f;
        }
        return backgroundReplacementModule.U(i2, f2, f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RectF Z() {
        Context b;
        if (this.w == null) {
            return null;
        }
        Context b2 = us.pinguo.foundation.e.b();
        s.g(b2, "getAppContext()");
        int i2 = us.pinguo.util.h.i(b2);
        s.g(us.pinguo.foundation.e.b(), "getAppContext()");
        Context b3 = us.pinguo.foundation.e.b();
        s.g(b3, "getAppContext()");
        float a2 = us.pinguo.util.g.a(b3, 25.0f);
        float f2 = a2 / i2;
        float g2 = a2 / (us.pinguo.util.h.g(b) * 0.7f);
        return new RectF(f2, g2, f2, g2);
    }

    private final boolean c0(Background background, long j2) {
        if (background.isValid(j2)) {
            return (background.is_block_effect() == 1 && s.c(this.a.Q(), Boolean.FALSE)) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(MagicBgItem magicBgItem, BackgroundDetail backgroundDetail, Rect rect) {
        us.pinguo.edit2020.bean.f fVar = this.p;
        if (fVar != null && s.c(magicBgItem.getKey(), "photoItem") && backgroundDetail != null && rect != null) {
            String f2 = fVar.f();
            CutoutFilter filter = backgroundDetail.getCutout().getFilter();
            String fixedLut = filter == null ? null : filter.getFixedLut();
            CutoutFilter filter2 = backgroundDetail.getCutout().getFilter();
            z0(f2, fixedLut, filter2 == null ? null : filter2.getAdjustableLut(), backgroundDetail.getSupportedHue(), rect);
            A0(fVar.k() / 100.0f);
            Background h2 = fVar.h();
            boolean z = false;
            if (h2 != null && h2.getSupport_color() == 1) {
                z = true;
            }
            if (z) {
                D0(fVar.j() / 100.0f);
            }
        }
        ArrayMap<String, MagicBgItem> arrayMap = this.f10833j;
        String key = magicBgItem.getKey();
        if (key == null) {
            key = "";
        }
        arrayMap.put(key, magicBgItem);
        UnityEditCaller.MagicBG.newItem(magicBgItem);
    }

    static /* synthetic */ void f0(BackgroundReplacementModule backgroundReplacementModule, MagicBgItem magicBgItem, BackgroundDetail backgroundDetail, Rect rect, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            backgroundDetail = null;
        }
        if ((i2 & 4) != 0) {
            rect = null;
        }
        backgroundReplacementModule.e0(magicBgItem, backgroundDetail, rect);
    }

    private final void g0(String str, int i2, q<? super String, ? super Boolean, ? super String, u> qVar) {
        us.pinguo.edit2020.c.b bVar = this.f10829f;
        if (bVar != null) {
            bVar.a();
        }
        us.pinguo.edit2020.c.b bVar2 = new us.pinguo.edit2020.c.b(str, i2, true, this.f10832i, qVar);
        this.f10829f = bVar2;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(String str, boolean z, String str2, kotlin.jvm.b.l<? super Boolean, u> lVar, boolean z2) {
        if (z2) {
            x("photoItem");
        }
        Size S = S(str);
        Size S2 = S(str2);
        this.a.N0(new BackgroundReplacementModule$prepareAndFillOpacity$1(this, lVar, z, str, str2));
        UnityEditCaller.MagicBG.prepareMattingMaskImage(str, S.getWidth(), S.getHeight(), str2, S2.getWidth(), S2.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PointF v(Size size, Size size2, Rect rect) {
        float width = size.getWidth() / size.getHeight();
        float height = rect.height();
        return new PointF((width * height) / size2.getWidth(), height / size2.getHeight());
    }

    private final void y(String str, a aVar) {
        BackgroundDetail I = (str == null || s.c(str, "original")) ? null : I(str);
        us.pinguo.common.log.a.c("doFillBackground id=" + ((Object) str) + ", detail=" + I, new Object[0]);
        E(str, I, aVar);
        if (str == null || I == null) {
            return;
        }
        DisplayRect displayRect = I.getDisplayRect();
        Rect rect = new Rect(displayRect.getX(), displayRect.getY(), displayRect.getX() + displayRect.getW(), displayRect.getY() + displayRect.getH());
        for (MagicBgItem magicBgItem : L(str, I, aVar)) {
            e0(magicBgItem, I, rect);
        }
    }

    private final void z(List<String> list, String str, a aVar) {
        List<MagicBgItem> list2 = null;
        BackgroundDetail I = (str == null || s.c(str, "original")) ? null : I(str);
        us.pinguo.common.log.a.c("doSwitchBackground id=" + ((Object) str) + ", detail=" + I, new Object[0]);
        E(str, I, aVar);
        if (str != null && I != null) {
            list2 = L(str, I, aVar);
        }
        UnityEditCaller.MagicBG.switchItem(list, list2);
        us.pinguo.edit2020.bean.f fVar = this.p;
        if (fVar == null) {
            return;
        }
        fVar.o(true);
    }

    public final void A(us.pinguo.edit2020.bean.f func, p<? super String, ? super Integer, u> progressCallback, q<? super Boolean, ? super String, ? super Boolean, u> resultCallback) {
        s.h(func, "func");
        s.h(progressCallback, "progressCallback");
        s.h(resultCallback, "resultCallback");
        this.q = func.f();
        BackgroundMaterialManager.a.d(func.f(), progressCallback, new BackgroundReplacementModule$downloadMaterial$1(resultCallback, this));
    }

    public final void A0(float f2) {
        UnityEditCaller.MagicBG.INSTANCE.setFilterValue(f2);
    }

    public final void B(boolean z) {
        this.a.n1(z);
    }

    public final void B0(boolean z) {
        this.x = z;
    }

    public final void C0(e eVar) {
        this.f10834k = eVar;
    }

    public final void D0(float f2) {
        UnityEditCaller.MagicBG.INSTANCE.setHueValue(f2);
    }

    public final void E0(kotlin.jvm.b.a<u> aVar) {
        this.y = aVar;
    }

    public final List<DecorationDetail> F(String id) {
        s.h(id, "id");
        return BackgroundMaterialManager.a.h(id);
    }

    public final ArrayList<us.pinguo.edit2020.bean.f> G() {
        return this.n;
    }

    public final List<BackgroundCategory> H() {
        return this.m;
    }

    public final void H0(us.pinguo.edit2020.bean.f fVar, String str) {
        a aVar = this.r;
        if (aVar == null) {
            return;
        }
        aVar.h();
        z(K(fVar), str, aVar);
    }

    public final BackgroundDetail I(String id) {
        s.h(id, "id");
        return BackgroundMaterialManager.a.f(id);
    }

    public final void I0(boolean z) {
        UnityEditCaller.MagicBG.hideUnmarkedArea(z);
    }

    public final Background J(String id) {
        s.h(id, "id");
        return BackgroundMaterialManager.a.g(id);
    }

    public final void J0(boolean z) {
        if (z) {
            Size size = this.w;
            if (size == null) {
                return;
            }
            this.v = size;
            a aVar = this.r;
            Size g2 = aVar == null ? null : aVar.g();
            if (g2 == null) {
                return;
            }
            M0(g2);
            return;
        }
        Size size2 = this.v;
        if (size2 == null) {
            return;
        }
        M0(size2);
    }

    public final void K0() {
        UnityEditCaller.MagicBG.unSelectCurrentItem();
    }

    public final void L0() {
        BackgroundMaterialManager.a.e(false);
    }

    public final String[] M() {
        return new String[]{us.pinguo.foundation.e.b().getString(R.string.background_replacement)};
    }

    public final float N(int i2) {
        int i3 = this.f10827d;
        int i4 = this.f10828e;
        return (((i2 / 100.0f) * (i3 - i4)) + i4) / this.c;
    }

    public final us.pinguo.repository2020.u<u0> O() {
        return this.a.L();
    }

    public final int P(int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = i2 - 1;
        long currentTimeMillis = BackgroundMaterialManager.a.l() ? 0L : System.currentTimeMillis();
        int i4 = 0;
        int i5 = 0;
        for (Object obj : this.m) {
            int i6 = i4 + 1;
            if (i4 >= 0) {
                for (String str : ((BackgroundCategory) obj).getPids()) {
                    Background J = J(str);
                    if (J != null && c0(J, currentTimeMillis)) {
                        if (i5 == i3) {
                            return i4;
                        }
                        i5++;
                    }
                }
                i4 = i6;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        return 0;
    }

    public final void P0(String key, PointF pointF, PointF pointF2, Integer num) {
        s.h(key, "key");
        UnityEditCaller.MagicBG.updateItemPosition(key, pointF, pointF2, num);
    }

    public final BackgroundCategory Q() {
        return this.o;
    }

    public final us.pinguo.edit2020.bean.f R() {
        return this.p;
    }

    public final ArrayMap<String, MagicBgItem> T() {
        return this.f10833j;
    }

    public final ArrayList<c0> W() {
        return this.f10835l;
    }

    public final kotlin.jvm.b.a<u> X() {
        return this.y;
    }

    public final a0 Y() {
        return (a0) this.u.getValue();
    }

    @Override // us.pinguo.edit2020.utils.f
    public u0 a() {
        return this.a.L().getValue();
    }

    public final void a0(String key, PointF rectSize) {
        s.h(key, "key");
        s.h(rectSize, "rectSize");
        Q0(this, key, rectSize, null, null, 12, null);
    }

    @Override // us.pinguo.edit2020.utils.f
    public void b() {
        this.a.reportMagnifierRenderer();
    }

    public final void b0(kotlin.jvm.b.l<? super Boolean, u> callback) {
        Size size;
        us.pinguo.edit2020.manager.c a2;
        HistoryRecord c;
        s.h(callback, "callback");
        UnityEditCaller.MagicBG.init();
        e eVar = this.f10834k;
        String str = null;
        if (eVar != null && (a2 = eVar.a()) != null && (c = a2.c()) != null) {
            str = c.getPicturePath();
        }
        if (str == null) {
            this.x = false;
            callback.invoke(Boolean.FALSE);
            return;
        }
        int rotationDegrees = new ExifInterface(str).getRotationDegrees();
        int i2 = rotationDegrees % BaseBlurEffect.ROTATION_360;
        if (i2 != 90 && i2 != 270) {
            size = S(str);
        } else {
            Size S = S(str);
            size = new Size(S.getHeight(), S.getWidth());
        }
        this.t = size;
        g0(str, rotationDegrees, new BackgroundReplacementModule$initMagicBackground$1(this, callback));
    }

    public final void c() {
        UnityEditCaller.MagicBG.CurrentMagicBackgroundItemLayerMoveToCurrentItemTypeLayersTop();
    }

    public final boolean d0() {
        return this.x;
    }

    public final void j0() {
        this.a.l(new PointF(0.5f, 0.5f), 1.0f, new PointF(0.0f, 0.0f), 200);
    }

    public final void k0() {
        Size size = this.t;
        if (size == null) {
            return;
        }
        M0(size);
    }

    public final void l0() {
        PortraitMatting.b();
    }

    public final void m0() {
        UnityEditCaller.MagicBG.requestCurrentBrushMaskStatus();
    }

    public final synchronized void n0() {
        if (this.p == null) {
            return;
        }
        this.b = 0;
        this.f10831h = null;
        this.x = false;
        this.s = false;
        for (us.pinguo.edit2020.bean.f fVar : this.n) {
            fVar.o(false);
            Background h2 = fVar.h();
            if (h2 != null && h2.getSupport_color() == 1) {
                fVar.n(0);
            }
            fVar.r(50);
            fVar.q(0);
        }
        this.p = null;
        this.o = (BackgroundCategory) kotlin.collections.s.C(this.m);
        this.a.N0(null);
        this.a.s0(null);
        us.pinguo.edit2020.c.b bVar = this.f10829f;
        if (bVar != null) {
            bVar.a();
            this.f10829f = null;
        }
        p0();
        u0(null);
        this.f10833j.clear();
    }

    public final void o0() {
        UnityEditCaller.Brush.resetBrushMask();
    }

    public final void p0() {
        Iterator<c0> it = this.f10835l.iterator();
        while (it.hasNext()) {
            c0 next = it.next();
            if (s.c(next.k(), "key_rubbery") || s.c(next.k(), "key_paint")) {
                next.m(25);
                next.l(50);
            }
        }
    }

    public final void q(kotlin.jvm.b.l<? super Float, u> callback) {
        s.h(callback, "callback");
        this.a.l0(callback);
    }

    public final void q0(String resetImagePath, kotlin.jvm.b.l<? super Boolean, u> callback) {
        s.h(resetImagePath, "resetImagePath");
        s.h(callback, "callback");
        g0(resetImagePath, new ExifInterface(resetImagePath).getRotationDegrees(), new BackgroundReplacementModule$resetMattingImage$1(this, callback));
    }

    public final void r(kotlin.jvm.b.l<? super EditModel, u> prepareCallback) {
        s.h(prepareCallback, "prepareCallback");
        this.a.s0(prepareCallback);
        EditModel A = this.a.A();
        EditModel editModel = EditModel.MagicBackground;
        if (A != editModel) {
            this.a.o(editModel);
        }
    }

    public final void r0() {
        UnityEditCaller.Brush.reverseBrushMask();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(kotlin.coroutines.Continuation<? super kotlin.u> r18) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.BackgroundReplacementModule.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void s0(PointF point) {
        s.h(point, "point");
        UnityEditCaller.MagicBG.selectItem(point);
    }

    public final synchronized void t(boolean z) {
        us.pinguo.edit2020.bean.f fVar = this.p;
        if (fVar == null) {
            return;
        }
        List<DecorationDetail> F = F(fVar.f());
        if (F != null) {
            for (DecorationDetail decorationDetail : F) {
                x(decorationDetail.getName());
            }
        }
        ArrayList<String> arrayList = this.f10831h;
        if (arrayList != null) {
            for (String str : arrayList) {
                x(str);
            }
        }
        this.b = 0;
        ArrayList<String> arrayList2 = this.f10831h;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (z) {
            x("photoItem");
        }
    }

    public final void t0(String key) {
        s.h(key, "key");
        UnityEditCaller.MagicBG.selectItem(key);
    }

    public final void u() {
        UnityEditCaller.MagicBG.INSTANCE.clearFilterAndHue();
    }

    public final void u0(w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> wVar) {
        this.a.L0(wVar);
    }

    public final void v0(BasicBrushMode brushMode, Float f2, Float f3) {
        s.h(brushMode, "brushMode");
        UnityEditCaller.Brush.setCurrentBrushMode(brushMode);
        if (f2 == null || f3 == null) {
            return;
        }
        UnityEditCaller.Brush.setBrushSize(brushMode, f2.floatValue());
        UnityEditCaller.MagicBG.setBackgroundBrushIntensity(f3.floatValue());
    }

    public final void w(String key, PointF centerPosition, PointF rectSize, Integer num) {
        s.h(key, "key");
        s.h(centerPosition, "centerPosition");
        s.h(rectSize, "rectSize");
        t0(key);
        float f2 = centerPosition.x + 0.02f;
        centerPosition.x = f2;
        float f3 = centerPosition.y + 0.02f;
        centerPosition.y = f3;
        if (f2 > 1.0f || f3 > 1.0f) {
            centerPosition.x = 0.5f;
            centerPosition.y = 0.5f;
        }
        MagicBgItem magicBgItem = new MagicBgItem(null, key + '_' + this.b, null, rectSize, centerPosition, Integer.valueOf(num == null ? 0 : num.intValue()), null, null, null, null, Z(), null, null, null, null, null, null, null, null, null, null, 0, 4193221, null);
        this.b++;
        this.f10833j.put(magicBgItem.getKey(), magicBgItem);
        if (this.f10831h == null) {
            this.f10831h = new ArrayList<>();
        }
        ArrayList<String> arrayList = this.f10831h;
        s.e(arrayList);
        String key2 = magicBgItem.getKey();
        s.e(key2);
        arrayList.add(key2);
        UnityEditCaller.MagicBG.copyItem(magicBgItem);
        String key3 = magicBgItem.getKey();
        s.e(key3);
        t0(key3);
    }

    public final void w0(boolean z) {
        if (z) {
            this.s = true;
        }
        UnityEditCaller.MagicBG.setCurrentBrushEffectApplied(z);
    }

    public final void x(String key) {
        s.h(key, "key");
        this.f10833j.remove(key);
        UnityEditCaller.MagicBG.deleteItem(key);
    }

    public final void x0(BackgroundCategory backgroundCategory) {
        this.o = backgroundCategory;
    }

    public final void y0(us.pinguo.edit2020.bean.f fVar) {
        this.p = fVar;
    }

    public final void z0(String id, String str, String str2, int i2, Rect rect) {
        String str3;
        s.h(id, "id");
        s.h(rect, "rect");
        boolean z = false;
        String str4 = "";
        if (str == null || str.length() == 0) {
            str3 = "";
        } else {
            str3 = h.a() + id + '/' + ((Object) str);
        }
        if (!((str2 == null || str2.length() == 0) ? true : true)) {
            str4 = h.a() + id + '/' + ((Object) str2);
        }
        UnityEditCaller.MagicBG.INSTANCE.setEffectInfo(str3, str4, i2, rect.left, rect.top, rect.width(), rect.height());
    }
}
