package us.pinguo.common.filter;

import androidx.databinding.ObservableBoolean;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.HashMap;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.s;
import us.pinguo.common.filter.util.FilterParamsHelper;
import us.pinguo.common.helper.SegmentationHelper;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.statistics.i;
import us.pinguo.processor.d;
import us.pinguo.processor.f;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
import us.pinguo.repository2020.entity.BaseFilter;
import us.pinguo.repository2020.entity.CategoryItem;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
import us.pinguo.repository2020.entity.SkyParam;
import us.pinguo.repository2020.entity.SkyParamsRecord;
import us.pinguo.repository2020.manager.FilterHistoryManager;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.repository2020.u;
import us.pinguo.u3dengine.api.UnityMethodCaller;
/* compiled from: CameraFilterModule.kt */
/* loaded from: classes4.dex */
public class CameraFilterModule {
    private ChangeStatus a;
    private final u<FilterEntry> b;
    private final u<Integer> c;

    /* renamed from: d  reason: collision with root package name */
    private final u<Integer> f9788d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, SkyParamsRecord> f9789e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9790f;

    /* renamed from: g  reason: collision with root package name */
    private final ObservableBoolean f9791g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9792h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9793i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9794j;

    /* renamed from: k  reason: collision with root package name */
    private String f9795k;

    /* renamed from: l  reason: collision with root package name */
    private final SegmentationHelper f9796l;

    /* compiled from: CameraFilterModule.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SkyParam.values().length];
            iArr[SkyParam.Opacity.ordinal()] = 1;
            iArr[SkyParam.SkyMask.ordinal()] = 2;
            iArr[SkyParam.SkyLine.ordinal()] = 3;
            iArr[SkyParam.Color.ordinal()] = 4;
            iArr[SkyParam.HightlightsShadow.ordinal()] = 5;
            iArr[SkyParam.SkyTemperature.ordinal()] = 6;
            iArr[SkyParam.SkyBrightness.ordinal()] = 7;
            iArr[SkyParam.SkyFlipMode.ordinal()] = 8;
            iArr[SkyParam.LightCurveDegree.ordinal()] = 9;
            a = iArr;
        }
    }

    public CameraFilterModule() {
        FilterRepository filterRepository = FilterRepository.a;
        filterRepository.C();
        this.a = ChangeStatus.INIT;
        this.b = filterRepository.j();
        this.c = new u<>();
        this.f9788d = new u<>(100);
        this.f9789e = new HashMap<>();
        this.f9791g = new ObservableBoolean(false);
        this.f9794j = true;
        this.f9795k = "camera_page";
        this.f9796l = new SegmentationHelper();
    }

    public static /* synthetic */ List C(CameraFilterModule cameraFilterModule, List list, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = false;
            }
            return cameraFilterModule.B(list, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFilterPackages");
    }

    private final String D(String str) {
        BaseFilter g2 = FilterRepository.a.g(str);
        if (g2 == null) {
            return null;
        }
        return g2.getPackageId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0188  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ce -> B:81:0x0184). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00d6 -> B:81:0x0184). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0114 -> B:42:0x0119). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object F(java.lang.String r21, java.lang.String r22, kotlin.coroutines.Continuation<? super java.util.Map<us.pinguo.repository2020.entity.SkyParam, java.lang.Integer>> r23) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.F(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object K(CameraFilterModule cameraFilterModule, String str, String str2, q qVar, Continuation continuation, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                qVar = null;
            }
            return cameraFilterModule.I(str, str2, qVar, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initSkyChangeParam");
    }

    public static /* synthetic */ List m(CameraFilterModule cameraFilterModule, boolean z, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                z2 = false;
            }
            return cameraFilterModule.l(z, z2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllCategories");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.ChildComponent[]> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof us.pinguo.common.filter.CameraFilterModule$getChildComponents$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.common.filter.CameraFilterModule$getChildComponents$1 r0 = (us.pinguo.common.filter.CameraFilterModule$getChildComponents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$getChildComponents$1 r0 = new us.pinguo.common.filter.CameraFilterModule$getChildComponents$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.j.b(r8)
            goto L60
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.L$0
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            goto L4d
        L3d:
            kotlin.j.b(r8)
            us.pinguo.repository2020.manager.FilterRepository r8 = us.pinguo.repository2020.manager.FilterRepository.a
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.p(r6, r0)
            if (r8 != r1) goto L4d
            return r1
        L4d:
            java.lang.String r8 = (java.lang.String) r8
            r6 = 0
            if (r8 != 0) goto L53
            return r6
        L53:
            us.pinguo.repository2020.manager.FilterRepository r2 = us.pinguo.repository2020.manager.FilterRepository.a
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r8 = r2.h(r8, r7, r0)
            if (r8 != r1) goto L60
            return r1
        L60:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.o(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object t(us.pinguo.common.filter.CameraFilterModule r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof us.pinguo.common.filter.CameraFilterModule$getCurrentFilterOpacity$1
            if (r0 == 0) goto L13
            r0 = r10
            us.pinguo.common.filter.CameraFilterModule$getCurrentFilterOpacity$1 r0 = (us.pinguo.common.filter.CameraFilterModule$getCurrentFilterOpacity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$getCurrentFilterOpacity$1 r0 = new us.pinguo.common.filter.CameraFilterModule$getCurrentFilterOpacity$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r9 = r0.L$1
            us.pinguo.repository2020.entity.BaseFilter r9 = (us.pinguo.repository2020.entity.BaseFilter) r9
            java.lang.Object r0 = r0.L$0
            us.pinguo.repository2020.entity.BaseFilter r0 = (us.pinguo.repository2020.entity.BaseFilter) r0
            kotlin.j.b(r10)
            goto L99
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            kotlin.j.b(r10)
            us.pinguo.repository2020.u r10 = r9.y()
            java.lang.Object r10 = r10.getValue()
            us.pinguo.repository2020.entity.FilterEntry r10 = (us.pinguo.repository2020.entity.FilterEntry) r10
            r2 = 0
            if (r10 != 0) goto L4b
            r10 = r2
            goto L4f
        L4b:
            java.lang.String r10 = r10.getItemId()
        L4f:
            r4 = 80
            if (r10 != 0) goto L58
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r9
        L58:
            us.pinguo.repository2020.manager.FilterRepository r5 = us.pinguo.repository2020.manager.FilterRepository.a
            us.pinguo.repository2020.entity.BaseFilter r6 = r5.g(r10)
            if (r6 != 0) goto L65
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r9
        L65:
            us.pinguo.repository2020.u r7 = r9.y()
            java.lang.Object r7 = r7.getValue()
            us.pinguo.repository2020.entity.FilterEntry r7 = (us.pinguo.repository2020.entity.FilterEntry) r7
            if (r7 != 0) goto L72
            goto L76
        L72:
            java.lang.String r2 = r7.getPkgId()
        L76:
            if (r2 != 0) goto L7d
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r9
        L7d:
            int r7 = r6.getOpacity()
            r8 = -1
            if (r7 != r8) goto Lb3
            int r5 = r5.u(r2)
            if (r5 != r3) goto La4
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r10 = r9.q(r10, r0)
            if (r10 != r1) goto L97
            return r1
        L97:
            r9 = r6
            r0 = r9
        L99:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r9.setOpacity(r10)
            r6 = r0
            goto Lb3
        La4:
            boolean r9 = r9.T(r2, r10)
            if (r9 == 0) goto Lb0
            r9 = 100
            r6.setOpacity(r9)
            goto Lb3
        Lb0:
            r6.setOpacity(r4)
        Lb3:
            int r9 = r6.getOpacity()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.t(us.pinguo.common.filter.CameraFilterModule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object w(CameraFilterModule cameraFilterModule, Continuation continuation) {
        FilterEntry value = cameraFilterModule.y().getValue();
        String itemId = value == null ? null : value.getItemId();
        if (itemId == null) {
            return Boxing.boxInt(100);
        }
        FilterRepository filterRepository = FilterRepository.a;
        BaseFilter g2 = filterRepository.g(itemId);
        if (g2 == null) {
            return Boxing.boxInt(100);
        }
        FilterEntry value2 = cameraFilterModule.y().getValue();
        String pkgId = value2 != null ? value2.getPkgId() : null;
        if (pkgId == null) {
            return Boxing.boxInt(100);
        }
        if (g2.getTemplateOpacity() == -1) {
            if (filterRepository.u(pkgId) == 1) {
                g2.setTemplateOpacity(100);
            } else {
                g2.setTemplateOpacity(100);
            }
        }
        return Boxing.boxInt(g2.getTemplateOpacity());
    }

    public final List<FilterItem> A(String str) {
        if (str == null) {
            return null;
        }
        return FilterRepository.a.w(str);
    }

    public final List<PackageItem> B(List<CategoryItem> categoryList, boolean z) {
        s.h(categoryList, "categoryList");
        return FilterRepository.a.x(categoryList, this.f9791g, R(), z);
    }

    public final boolean E() {
        return this.f9790f;
    }

    public final HashMap<String, SkyParamsRecord> G() {
        return this.f9789e;
    }

    public final void H(String str, l<? super Boolean, kotlin.u> callback) {
        s.h(callback, "callback");
        if (str == null) {
            callback.invoke(Boolean.FALSE);
        } else {
            this.f9796l.a(str, new CameraFilterModule$initSkyChange$1(this, callback));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0396 -> B:123:0x03a2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0294 -> B:54:0x02a7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(java.lang.String r31, java.lang.String r32, kotlin.jvm.b.q<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.u> r33, kotlin.coroutines.Continuation<? super kotlin.u> r34) {
        /*
            Method dump skipped, instructions count: 1090
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.I(java.lang.String, java.lang.String, kotlin.jvm.b.q, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void J(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num, Float f9) {
        UnityMethodCaller.INSTANCE.setSkyChangeParameter(f2, f3, f4, f5, f6, f7, f8, num, f9, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(us.pinguo.repository2020.entity.FilterEntry r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.common.filter.CameraFilterModule$isAdjustFilter$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.common.filter.CameraFilterModule$isAdjustFilter$1 r0 = (us.pinguo.common.filter.CameraFilterModule$isAdjustFilter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$isAdjustFilter$1 r0 = new us.pinguo.common.filter.CameraFilterModule$isAdjustFilter$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L33
            if (r2 != r5) goto L2b
            kotlin.j.b(r8)
            goto L59
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.j.b(r8)
            if (r7 != 0) goto L3a
            r8 = r3
            goto L3e
        L3a:
            java.lang.String r8 = r7.getPkgId()
        L3e:
            if (r8 != 0) goto L45
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L45:
            java.lang.String r7 = r7.getItemId()
            if (r7 != 0) goto L50
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L50:
            r0.label = r5
            java.lang.Object r8 = r6.o(r8, r7, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            us.pinguo.repository2020.entity.ChildComponent[] r8 = (us.pinguo.repository2020.entity.ChildComponent[]) r8
            if (r8 != 0) goto L5e
            goto L83
        L5e:
            int r7 = r8.length
            r0 = 0
        L60:
            if (r0 >= r7) goto L7f
            r1 = r8[r0]
            int r0 = r0 + 1
            java.lang.Integer r1 = r1.getType()
            us.pinguo.repository2020.entity.UnityFilterType r2 = us.pinguo.repository2020.entity.UnityFilterType.Adjust
            int r2 = r2.ordinal()
            if (r1 != 0) goto L73
            goto L7b
        L73:
            int r1 = r1.intValue()
            if (r1 != r2) goto L7b
            r1 = 1
            goto L7c
        L7b:
            r1 = 0
        L7c:
            if (r1 == 0) goto L60
            r4 = 1
        L7f:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.L(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final ObservableBoolean M() {
        return this.f9791g;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N(us.pinguo.repository2020.entity.FilterEntry r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.N(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(us.pinguo.repository2020.entity.FilterEntry r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.common.filter.CameraFilterModule$isEffectFilter$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.common.filter.CameraFilterModule$isEffectFilter$1 r0 = (us.pinguo.common.filter.CameraFilterModule$isEffectFilter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$isEffectFilter$1 r0 = new us.pinguo.common.filter.CameraFilterModule$isEffectFilter$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L33
            if (r2 != r5) goto L2b
            kotlin.j.b(r8)
            goto L59
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.j.b(r8)
            if (r7 != 0) goto L3a
            r8 = r3
            goto L3e
        L3a:
            java.lang.String r8 = r7.getPkgId()
        L3e:
            if (r8 != 0) goto L45
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L45:
            java.lang.String r7 = r7.getItemId()
            if (r7 != 0) goto L50
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L50:
            r0.label = r5
            java.lang.Object r8 = r6.o(r8, r7, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            us.pinguo.repository2020.entity.ChildComponent[] r8 = (us.pinguo.repository2020.entity.ChildComponent[]) r8
            if (r8 != 0) goto L5e
            goto L83
        L5e:
            int r7 = r8.length
            r0 = 0
        L60:
            if (r0 >= r7) goto L7f
            r1 = r8[r0]
            int r0 = r0 + 1
            java.lang.Integer r1 = r1.getType()
            us.pinguo.repository2020.entity.UnityFilterType r2 = us.pinguo.repository2020.entity.UnityFilterType.Effect
            int r2 = r2.ordinal()
            if (r1 != 0) goto L73
            goto L7b
        L73:
            int r1 = r1.intValue()
            if (r1 != r2) goto L7b
            r1 = 1
            goto L7c
        L7b:
            r1 = 0
        L7c:
            if (r1 == 0) goto L60
            r4 = 1
        L7f:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.O(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean P() {
        return this.f9794j;
    }

    public final boolean Q(String str) {
        if (str == null) {
            return false;
        }
        return FilterRepository.a.G(str);
    }

    public boolean R() {
        return this.f9793i;
    }

    public final boolean S(String packageId) {
        s.h(packageId, "packageId");
        return FilterRepository.a.t().contains(packageId);
    }

    public final boolean T(String packageId, String str) {
        s.h(packageId, "packageId");
        FilterRepository filterRepository = FilterRepository.a;
        if (filterRepository.u(packageId) == 1) {
            return false;
        }
        return (str != null && filterRepository.E(str)) || S(packageId) || filterRepository.F(packageId);
    }

    public final boolean U(String packageId) {
        FilterItem filterItem;
        s.h(packageId, "packageId");
        FilterRepository filterRepository = FilterRepository.a;
        List<FilterItem> w = filterRepository.w(packageId);
        boolean z = false;
        String filterId = (w == null || (filterItem = w.get(0)) == null) ? null : filterItem.getFilterId();
        if (filterId == null) {
            return false;
        }
        FilterParamsTable r = filterRepository.r(filterId);
        String onlineParam = r != null ? r.getOnlineParam() : null;
        return true ^ ((onlineParam == null || onlineParam.length() == 0) ? true : true);
    }

    public final Object V(String str, String str2, Continuation<? super Boolean> continuation) {
        return FilterRepository.a.H(str, str2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(us.pinguo.repository2020.entity.FilterEntry r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.common.filter.CameraFilterModule$isSkyChangeFilter$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.common.filter.CameraFilterModule$isSkyChangeFilter$1 r0 = (us.pinguo.common.filter.CameraFilterModule$isSkyChangeFilter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$isSkyChangeFilter$1 r0 = new us.pinguo.common.filter.CameraFilterModule$isSkyChangeFilter$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L33
            if (r2 != r5) goto L2b
            kotlin.j.b(r8)
            goto L59
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.j.b(r8)
            if (r7 != 0) goto L3a
            r8 = r3
            goto L3e
        L3a:
            java.lang.String r8 = r7.getPkgId()
        L3e:
            if (r8 != 0) goto L45
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L45:
            java.lang.String r7 = r7.getItemId()
            if (r7 != 0) goto L50
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L50:
            r0.label = r5
            java.lang.Object r8 = r6.o(r8, r7, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            us.pinguo.repository2020.entity.ChildComponent[] r8 = (us.pinguo.repository2020.entity.ChildComponent[]) r8
            if (r8 != 0) goto L5e
            goto L83
        L5e:
            int r7 = r8.length
            r0 = 0
        L60:
            if (r0 >= r7) goto L7f
            r1 = r8[r0]
            int r0 = r0 + 1
            java.lang.Integer r1 = r1.getType()
            us.pinguo.repository2020.entity.UnityFilterType r2 = us.pinguo.repository2020.entity.UnityFilterType.SkyChange
            int r2 = r2.ordinal()
            if (r1 != 0) goto L73
            goto L7b
        L73:
            int r1 = r1.intValue()
            if (r1 != r2) goto L7b
            r1 = 1
            goto L7c
        L7b:
            r1 = 0
        L7c:
            if (r1 == 0) goto L60
            r4 = 1
        L7f:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.W(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean X() {
        return this.f9792h;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(us.pinguo.repository2020.entity.FilterEntry r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof us.pinguo.common.filter.CameraFilterModule$isTemplateFilter$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.common.filter.CameraFilterModule$isTemplateFilter$1 r0 = (us.pinguo.common.filter.CameraFilterModule$isTemplateFilter$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$isTemplateFilter$1 r0 = new us.pinguo.common.filter.CameraFilterModule$isTemplateFilter$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L33
            if (r2 != r5) goto L2b
            kotlin.j.b(r8)
            goto L59
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.j.b(r8)
            if (r7 != 0) goto L3a
            r8 = r3
            goto L3e
        L3a:
            java.lang.String r8 = r7.getPkgId()
        L3e:
            if (r8 != 0) goto L45
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L45:
            java.lang.String r7 = r7.getItemId()
            if (r7 != 0) goto L50
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L50:
            r0.label = r5
            java.lang.Object r8 = r6.o(r8, r7, r0)
            if (r8 != r1) goto L59
            return r1
        L59:
            us.pinguo.repository2020.entity.ChildComponent[] r8 = (us.pinguo.repository2020.entity.ChildComponent[]) r8
            if (r8 != 0) goto L5e
            goto L83
        L5e:
            int r7 = r8.length
            r0 = 0
        L60:
            if (r0 >= r7) goto L7f
            r1 = r8[r0]
            int r0 = r0 + 1
            java.lang.Integer r1 = r1.getType()
            us.pinguo.repository2020.entity.UnityFilterType r2 = us.pinguo.repository2020.entity.UnityFilterType.Template
            int r2 = r2.ordinal()
            if (r1 != 0) goto L73
            goto L7b
        L73:
            int r1 = r1.intValue()
            if (r1 != r2) goto L7b
            r1 = 1
            goto L7c
        L7b:
            r1 = 0
        L7c:
            if (r1 == 0) goto L60
            r4 = 1
        L7f:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
        L83:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.Y(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x018b, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0191, code lost:
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0191 A[EDGE_INSN: B:102:0x0191->B:88:0x0191 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0194  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0123 -> B:54:0x0128). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Z(us.pinguo.repository2020.entity.FilterEntry r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.Z(us.pinguo.repository2020.entity.FilterEntry, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean a0(String str, String str2) {
        FilterItem z;
        if (str == null || str2 == null || (z = z(str, str2)) == null) {
            return false;
        }
        return z.isVip();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b0(java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super us.pinguo.repository2020.entity.SkyParamsRecord> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof us.pinguo.common.filter.CameraFilterModule$makeSkyFilterParamsRecord$1
            if (r0 == 0) goto L13
            r0 = r11
            us.pinguo.common.filter.CameraFilterModule$makeSkyFilterParamsRecord$1 r0 = (us.pinguo.common.filter.CameraFilterModule$makeSkyFilterParamsRecord$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.common.filter.CameraFilterModule$makeSkyFilterParamsRecord$1 r0 = new us.pinguo.common.filter.CameraFilterModule$makeSkyFilterParamsRecord$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            int r9 = r0.I$2
            int r10 = r0.I$1
            int r0 = r0.I$0
            kotlin.j.b(r11)
            goto La9
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            java.lang.Object r9 = r0.L$1
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r0.L$0
            us.pinguo.common.filter.CameraFilterModule r9 = (us.pinguo.common.filter.CameraFilterModule) r9
            kotlin.j.b(r11)
            goto L59
        L48:
            kotlin.j.b(r11)
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r8.F(r9, r10, r0)
            if (r11 != r1) goto L58
            return r1
        L58:
            r9 = r8
        L59:
            java.util.Map r11 = (java.util.Map) r11
            us.pinguo.repository2020.entity.SkyParam r2 = us.pinguo.repository2020.entity.SkyParam.Opacity
            java.lang.Object r2 = r11.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            r4 = 50
            if (r2 != 0) goto L6a
            r2 = 50
            goto L6e
        L6a:
            int r2 = r2.intValue()
        L6e:
            us.pinguo.repository2020.entity.SkyParam r5 = us.pinguo.repository2020.entity.SkyParam.Color
            java.lang.Object r5 = r11.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 != 0) goto L7b
            r5 = 50
            goto L7f
        L7b:
            int r5 = r5.intValue()
        L7f:
            us.pinguo.repository2020.entity.SkyParam r6 = us.pinguo.repository2020.entity.SkyParam.SkyTemperature
            java.lang.Object r11 = r11.get(r6)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L8c
            r11 = 50
            goto L90
        L8c:
            int r11 = r11.intValue()
        L90:
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.I$0 = r2
            r0.I$1 = r5
            r0.I$2 = r11
            r0.label = r3
            java.lang.Object r9 = r9.q(r10, r0)
            if (r9 != r1) goto La4
            return r1
        La4:
            r0 = r2
            r10 = r5
            r7 = r11
            r11 = r9
            r9 = r7
        La9:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            us.pinguo.repository2020.entity.SkyParamsRecord r1 = new us.pinguo.repository2020.entity.SkyParamsRecord
            r1.<init>(r0, r10, r9, r11)
            r1.setDefaultTransparent(r0)
            r1.setDefaultMix(r10)
            r1.setDefaultTemperature(r9)
            r1.setDefaultTexture(r11)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.b0(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void c() {
        FilterEntry value = y().getValue();
        if (value == null) {
            return;
        }
        if (s.c(value.getItemId(), Effect.EFFECT_FILTER_NONE_KEY) && s.c(value.getItemId(), Effect.EFFECT_FILTER_AUTO_KEY)) {
            return;
        }
        FilterHistoryManager.a.d("history_position_camera", value);
    }

    public void c0() {
        FilterRepository.K(FilterRepository.a, false, 1, null);
    }

    public void d(float f2) {
        UnityMethodCaller.setSkyChangeParameter$default(UnityMethodCaller.INSTANCE, null, null, null, Float.valueOf(f2), null, null, null, null, null, false, 1015, null);
    }

    public void d0() {
        BaseFilter g2;
        Integer value;
        FilterEntry value2 = y().getValue();
        String itemId = value2 == null ? null : value2.getItemId();
        if (itemId == null || (g2 = FilterRepository.a.g(itemId)) == null || (value = this.c.getValue()) == null) {
            return;
        }
        g2.setOpacity(value.intValue());
    }

    public void e(int i2) {
        UnityMethodCaller.setSkyChangeParameter$default(UnityMethodCaller.INSTANCE, null, null, null, null, null, null, null, Integer.valueOf(i2), null, false, 895, null);
    }

    public final void e0(ChangeStatus changeStatus) {
        s.h(changeStatus, "<set-?>");
        this.a = changeStatus;
    }

    public void f(float f2) {
        UnityMethodCaller.setSkyChangeParameter$default(UnityMethodCaller.INSTANCE, Float.valueOf(f2), null, null, null, null, null, null, null, null, false, 1022, null);
    }

    public final void f0(String str) {
        s.h(str, "<set-?>");
        this.f9795k = str;
    }

    public void g(float f2) {
        UnityMethodCaller.setSkyChangeParameter$default(UnityMethodCaller.INSTANCE, null, null, null, null, null, Float.valueOf(f2), null, null, null, false, 991, null);
    }

    public final void g0(boolean z) {
        this.f9794j = z;
    }

    public void h() {
        UnityMethodCaller.INSTANCE.cleanSkyChangeRenderAssets();
    }

    public void h0(boolean z) {
    }

    public final boolean i(String filterId) {
        s.h(filterId, "filterId");
        i iVar = h.b;
        iVar.N(this.f9795k, filterId, "favorite");
        if (s.c(this.f9795k, "edit_page")) {
            iVar.A(filterId, "favorite");
        }
        return FilterRepository.a.b(filterId, true);
    }

    public final void i0(boolean z) {
        this.f9790f = z;
    }

    public final void j(us.pinguo.repository2020.q listener) {
        s.h(listener, "listener");
        FilterRepository.a.c(listener);
    }

    public final void j0(boolean z) {
        this.f9792h = z;
    }

    public final d k(boolean z) {
        String itemId;
        FilterParamsTable r;
        FilterParamsHelper filterParamsHelper;
        String a2;
        String c;
        FilterEntry value = y().getValue();
        if (value == null || (itemId = value.getItemId()) == null) {
            return null;
        }
        if (s.c(itemId, Effect.EFFECT_FILTER_NONE_KEY)) {
            return FilterParamsHelper.c.a();
        }
        FilterRepository filterRepository = FilterRepository.a;
        BaseFilter g2 = filterRepository.g(itemId);
        if (g2 == null || (r = filterRepository.r(itemId)) == null || (a2 = (filterParamsHelper = new FilterParamsHelper(r, g2)).a()) == null || (c = filterParamsHelper.c(z)) == null) {
            return null;
        }
        List<f> b = filterParamsHelper.b();
        if (b == null) {
            b = kotlin.collections.u.h();
        }
        return new d(a2, c, b, false, 8, null);
    }

    public void k0(String maskFilePath) {
        s.h(maskFilePath, "maskFilePath");
        UnityMethodCaller.INSTANCE.setSkyChangeMask(maskFilePath);
    }

    public final List<CategoryItem> l(boolean z, boolean z2) {
        return FilterRepository.a.e(this.f9791g, z, z2);
    }

    public final boolean l0(String filterId) {
        s.h(filterId, "filterId");
        i iVar = h.b;
        iVar.N(this.f9795k, filterId, "favorite_undo");
        if (s.c(this.f9795k, "edit_page")) {
            iVar.A(filterId, "favorite_undo");
        }
        return FilterRepository.a.b(filterId, false);
    }

    public final void m0(List<String> packageIds) {
        s.h(packageIds, "packageIds");
        FilterRepository.a.N(packageIds);
    }

    public final ChangeStatus n() {
        return this.a;
    }

    public final List<PackageItem> p(boolean z) {
        return FilterRepository.a.i(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x013c -> B:53:0x013e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r14, kotlin.coroutines.Continuation<? super java.lang.Integer> r15) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.CameraFilterModule.q(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object r(Continuation<? super Integer> continuation) {
        return t(this, continuation);
    }

    public final u<Integer> s() {
        return this.c;
    }

    public Object u(Continuation<? super Integer> continuation) {
        return w(this, continuation);
    }

    public final u<Integer> v() {
        return this.f9788d;
    }

    public final String x() {
        return this.f9795k;
    }

    public u<FilterEntry> y() {
        return this.b;
    }

    public final FilterItem z(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return FilterRepository.a.m(str, str2);
    }
}
