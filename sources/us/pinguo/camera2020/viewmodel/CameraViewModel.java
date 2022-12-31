package us.pinguo.camera2020.viewmodel;

import android.app.Application;
import android.content.Context;
import android.graphics.PointF;
import android.util.Size;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.model.Scene;
import us.pinguo.camera2020.model.render.UnityRender;
import us.pinguo.camera2020.module.AfterCaptureModule;
import us.pinguo.camera2020.module.ExclusiveEffectType;
import us.pinguo.camera2020.module.beauty.CameraBeautyModule;
import us.pinguo.camera2020.module.frame.FrameRatioModule;
import us.pinguo.camera2020.module.settings.CameraTopSettingsModule;
import us.pinguo.camera2020.module.sticker.CameraStickerModule;
import us.pinguo.cameramanger.e;
import us.pinguo.cameramanger.f;
import us.pinguo.cameramanger.g;
import us.pinguo.cameramanger.info.CameraFrame;
import us.pinguo.cameramanger.info.Flash;
import us.pinguo.cameramanger.info.LensFacing;
import us.pinguo.cameramanger.info.WhiteBalance;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.common.filter.controller.AutoFilterProducer;
import us.pinguo.facedetector.ImageMode;
import us.pinguo.foundation.statistics.h;
import us.pinguo.foundation.utils.NoProguard;
import us.pinguo.nativeinterface.UnityInterface;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.repository2020.entity.BeautyData;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterPackage;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.repository2020.u;
import us.pinguo.repository2020.utils.k;
import us.pinguo.u3dengine.api.CaptureModel;
import us.pinguo.u3dengine.api.UnityCallbackApi;
import us.pinguo.u3dengine.api.UnityFilterCallbackApi;
import us.pinguo.u3dengine.api.UnityMethodCaller;
import us.pinguo.u3dengine.api.WatermarkStyle;
/* compiled from: CameraViewModel.kt */
/* loaded from: classes3.dex */
public final class CameraViewModel extends us.pinguo.camera2020.viewmodel.a implements LifecycleObserver, NoProguard {
    public static final c Companion = new c(null);
    private static final String SP_KEY_CURRENT_SELECTED_EXCLUSIVE_TYPE = "key_current_selected_exclusive_type";
    private static final String STAT_KEY_NON_USE = "non_use";
    private final AfterCaptureModule afterCaptureModule;
    private final CameraBeautyModule cameraBeautyModule;
    private final us.pinguo.camera2020.module.settings.a cameraBottomModule;
    private final CameraFilterModule cameraFilterModule;
    private final e cameraManager;
    private final CameraStickerModule cameraStickerModule;
    private final u<Integer> cameraThemeStyle;
    private final CameraTopSettingsModule cameraTopSettingModule;
    private ExclusiveEffectType currentExclusiveType;
    private final FrameRatioModule frameRatioModule;
    private boolean gettingPictureAfterSnapshot;
    private volatile boolean gotoArgsHandled;
    private boolean isIntent;
    private u<us.pinguo.facedetector.c> recentFaceResult;
    private String shotSource;
    private final LiveData<Size> textureSize;
    private final UnityRender unityRender;
    private final us.pinguo.camera2020.module.settings.b viewFinderSettingsModule;
    private u<AutoFilterProducer.b> yuvFrame;

    /* compiled from: CameraViewModel.kt */
    /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass3 extends Lambda implements l<String, us.pinguo.processor.d> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CameraViewModel.kt */
        @DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$3$1", f = "CameraViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$3$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super v1>, Object> {
            final /* synthetic */ Ref$ObjectRef<us.pinguo.processor.d> $info;
            final /* synthetic */ String $path;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CameraViewModel this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CameraViewModel.kt */
            @DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$3$1$1", f = "CameraViewModel.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$3$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C03641 extends SuspendLambda implements p<m0, Continuation<? super kotlin.u>, Object> {
                final /* synthetic */ Ref$ObjectRef<us.pinguo.processor.d> $info;
                final /* synthetic */ String $path;
                Object L$0;
                int label;
                final /* synthetic */ CameraViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03641(CameraViewModel cameraViewModel, Ref$ObjectRef<us.pinguo.processor.d> ref$ObjectRef, String str, Continuation<? super C03641> continuation) {
                    super(2, continuation);
                    this.this$0 = cameraViewModel;
                    this.$info = ref$ObjectRef;
                    this.$path = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                    return new C03641(this.this$0, this.$info, this.$path, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(m0 m0Var, Continuation<? super kotlin.u> continuation) {
                    return ((C03641) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    Ref$ObjectRef<us.pinguo.processor.d> ref$ObjectRef;
                    Ref$ObjectRef<us.pinguo.processor.d> ref$ObjectRef2;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = this.label;
                    T t = 0;
                    if (i2 == 0) {
                        j.b(obj);
                        CameraStickerModule cameraStickerModule = this.this$0.getCameraStickerModule();
                        Sticker value = cameraStickerModule.u().getValue();
                        String pid = value == null ? null : value.getPid();
                        ref$ObjectRef = this.$info;
                        if (pid != null) {
                            String str = this.$path;
                            this.L$0 = ref$ObjectRef;
                            this.label = 1;
                            obj = cameraStickerModule.n(pid, str, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ref$ObjectRef2 = ref$ObjectRef;
                        }
                        ref$ObjectRef.element = t;
                        return kotlin.u.a;
                    } else if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                        j.b(obj);
                    }
                    ref$ObjectRef = ref$ObjectRef2;
                    t = (us.pinguo.processor.d) obj;
                    ref$ObjectRef.element = t;
                    return kotlin.u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CameraViewModel cameraViewModel, Ref$ObjectRef<us.pinguo.processor.d> ref$ObjectRef, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = cameraViewModel;
                this.$info = ref$ObjectRef;
                this.$path = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$info, this.$path, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super v1> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    j.b(obj);
                    return kotlinx.coroutines.j.d((m0) this.L$0, null, null, new C03641(this.this$0, this.$info, this.$path, null), 3, null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        public final us.pinguo.processor.d invoke(String path) {
            s.h(path, "path");
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            kotlinx.coroutines.j.f(null, new AnonymousClass1(CameraViewModel.this, ref$ObjectRef, path, null), 1, null);
            return (us.pinguo.processor.d) ref$ObjectRef.element;
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass4 extends Lambda implements l<String, Boolean> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CameraViewModel.kt */
        @DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$4$1", f = "CameraViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$4$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super v1>, Object> {
            final /* synthetic */ String $path;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ CameraViewModel this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: CameraViewModel.kt */
            @DebugMetadata(c = "us.pinguo.camera2020.viewmodel.CameraViewModel$4$1$1", f = "CameraViewModel.kt", i = {0}, l = {202}, m = "invokeSuspend", n = {"stickerModule"}, s = {"L$0"})
            /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$4$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C03651 extends SuspendLambda implements p<m0, Continuation<? super kotlin.u>, Object> {
                final /* synthetic */ String $path;
                Object L$0;
                int label;
                final /* synthetic */ CameraViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03651(CameraViewModel cameraViewModel, String str, Continuation<? super C03651> continuation) {
                    super(2, continuation);
                    this.this$0 = cameraViewModel;
                    this.$path = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                    return new C03651(this.this$0, this.$path, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(m0 m0Var, Continuation<? super kotlin.u> continuation) {
                    return ((C03651) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    CameraStickerModule cameraStickerModule;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = this.label;
                    if (i2 == 0) {
                        j.b(obj);
                        CameraStickerModule cameraStickerModule2 = this.this$0.getCameraStickerModule();
                        Sticker value = cameraStickerModule2.u().getValue();
                        String pid = value == null ? null : value.getPid();
                        if (pid == null) {
                            return kotlin.u.a;
                        }
                        String str = this.$path;
                        this.L$0 = cameraStickerModule2;
                        this.label = 1;
                        Object o = cameraStickerModule2.o(pid, str, this);
                        if (o == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        cameraStickerModule = cameraStickerModule2;
                        obj = o;
                    } else if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        cameraStickerModule = (CameraStickerModule) this.L$0;
                        j.b(obj);
                    }
                    String str2 = (String) obj;
                    Integer s = cameraStickerModule.s("makeup");
                    float intValue = (s == null ? 70 : s.intValue()) / 100.0f;
                    if (str2 == null) {
                        this.this$0.getCameraBeautyModule().q();
                    } else {
                        this.this$0.getCameraBeautyModule().k0(str2, null, Boxing.boxFloat(intValue));
                    }
                    return kotlin.u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CameraViewModel cameraViewModel, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = cameraViewModel;
                this.$path = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$path, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super v1> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    j.b(obj);
                    return kotlinx.coroutines.j.d((m0) this.L$0, null, null, new C03651(this.this$0, this.$path, null), 3, null);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        public final Boolean invoke(String path) {
            s.h(path, "path");
            kotlinx.coroutines.j.f(null, new AnonymousClass1(CameraViewModel.this, path, null), 1, null);
            return Boolean.TRUE;
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$5  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass5 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass5() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CameraViewModel.this.getCameraStickerModule().i();
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$6  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass6 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CameraViewModel.this.startRenderHD();
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* renamed from: us.pinguo.camera2020.viewmodel.CameraViewModel$7  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass7 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        AnonymousClass7() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            CameraViewModel.this.startRenderSkyChange();
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a implements f {
        a() {
        }

        @Override // us.pinguo.cameramanger.f
        public void a(byte[] bArr, int i2, int i3) {
            if (bArr == null) {
                return;
            }
            CameraViewModel cameraViewModel = CameraViewModel.this;
            if (cameraViewModel.unityRender.Z()) {
                us.pinguo.facedetector.c t = k.a.t(bArr, i2, i3, ImageMode.NV21);
                cameraViewModel.unityRender.N0(t);
                cameraViewModel.getRecentFaceResult().postValue(t);
                cameraViewModel.getYuvFrame().postValue(new AutoFilterProducer.b(bArr, i2, i3));
            }
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b implements g {
        b() {
        }

        @Override // us.pinguo.cameramanger.g
        public void a(CameraFrame frame) {
            s.h(frame, "frame");
            CameraViewModel.this.getFrameRatioModule().d().postValue(frame);
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(o oVar) {
            this();
        }
    }

    /* compiled from: CameraViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[LensFacing.values().length];
            iArr[LensFacing.BACK.ordinal()] = 1;
            iArr[LensFacing.FRONT.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[ExclusiveEffectType.values().length];
            iArr2[ExclusiveEffectType.EFFECT_STICKER.ordinal()] = 1;
            iArr2[ExclusiveEffectType.EFFECT_STYLED_MAKEUP.ordinal()] = 2;
            b = iArr2;
            int[] iArr3 = new int[CameraFrame.values().length];
            iArr3[CameraFrame.FRAME_FULL.ordinal()] = 1;
            iArr3[CameraFrame.FRAME_4_3.ordinal()] = 2;
            iArr3[CameraFrame.FRAME_16_9.ordinal()] = 3;
            iArr3[CameraFrame.FRAME_1_1.ordinal()] = 4;
            c = iArr3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraViewModel(Application app, boolean z) {
        super(app);
        s.h(app, "app");
        this.cameraThemeStyle = new u<>();
        this.recentFaceResult = new u<>();
        this.yuvFrame = new u<>();
        Context applicationContext = app.getApplicationContext();
        s.g(applicationContext, "app.applicationContext");
        UnityRender unityRender = new UnityRender(applicationContext);
        this.unityRender = unityRender;
        FrameRatioModule frameRatioModule = new FrameRatioModule();
        this.frameRatioModule = frameRatioModule;
        LensFacing lensFacing = z ? LensFacing.FRONT : LensFacing.BACK;
        CameraFrame value = frameRatioModule.d().getValue();
        value = value == null ? CameraFrame.FRAME_4_3 : value;
        s.g(value, "frameRatioModule.frameRa… ?: CameraFrame.FRAME_4_3");
        us.pinguo.cameramanger.c cVar = new us.pinguo.cameramanger.c(lensFacing, value);
        this.cameraManager = cVar;
        this.cameraStickerModule = new CameraStickerModule(unityRender);
        this.cameraFilterModule = new CameraFilterModule();
        this.cameraTopSettingModule = new CameraTopSettingsModule(cVar, unityRender);
        this.cameraBottomModule = new us.pinguo.camera2020.module.settings.a();
        this.viewFinderSettingsModule = new us.pinguo.camera2020.module.settings.b();
        AfterCaptureModule afterCaptureModule = new AfterCaptureModule(unityRender);
        this.afterCaptureModule = afterCaptureModule;
        CameraBeautyModule cameraBeautyModule = new CameraBeautyModule(unityRender);
        this.cameraBeautyModule = cameraBeautyModule;
        this.textureSize = unityRender.S();
        this.shotSource = "non_challenge";
        k kVar = k.a;
        kVar.b();
        kVar.p(cVar.l().b());
        unityRender.k0(cVar.o() == CameraFrame.FRAME_1_1);
        cVar.i(new a());
        cVar.b(new b());
        unityRender.setCameraInfo(cVar.d() == LensFacing.FRONT, cVar.l().b());
        unityRender.g0(new AnonymousClass3());
        unityRender.p0(new AnonymousClass4());
        cameraBeautyModule.r0(new AnonymousClass5());
        afterCaptureModule.p(new AnonymousClass6());
        afterCaptureModule.q(new AnonymousClass7());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void focusAndMetering$default(CameraViewModel cameraViewModel, float f2, float f3, int i2, int i3, l lVar, int i4, Object obj) {
        l<? super Boolean, kotlin.u> lVar2 = lVar;
        if ((i4 & 16) != 0) {
            lVar2 = null;
        }
        cameraViewModel.focusAndMetering(f2, f3, i2, i3, lVar2);
    }

    private final String getCameraFrameStr(CameraFrame cameraFrame) {
        int i2 = cameraFrame == null ? -1 : d.c[cameraFrame.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "full" : "1:1" : "16:9" : "4:3" : "full";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setSkyChangeRenderCompleteCallback$default(CameraViewModel cameraViewModel, kotlin.jvm.b.s sVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sVar = null;
        }
        cameraViewModel.setSkyChangeRenderCompleteCallback(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRenderHD() {
        this.unityRender.H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRenderSkyChange() {
        this.unityRender.J0();
    }

    private final void toggleCamera() {
        LensFacing lensFacing;
        int i2 = d.a[this.cameraManager.d().ordinal()];
        if (i2 == 1) {
            lensFacing = LensFacing.FRONT;
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            lensFacing = LensFacing.BACK;
        }
        us.pinguo.cameramanger.info.a q = this.cameraManager.q(lensFacing);
        this.unityRender.L0();
        e eVar = this.cameraManager;
        eVar.D(eVar.o());
        k kVar = k.a;
        kVar.p(q.b());
        this.unityRender.setCameraInfo(this.cameraManager.d() == LensFacing.FRONT, q.b());
        kVar.n();
    }

    public final void bindCamera(LifecycleOwner lifecycleOwner, int i2, int i3) {
        s.h(lifecycleOwner, "lifecycleOwner");
        this.cameraManager.w(this.unityRender);
        this.cameraManager.g(i2, i3);
        this.cameraManager.r(lifecycleOwner);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<java.lang.String> cameraAttrToSubscription() {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.viewmodel.CameraViewModel.cameraAttrToSubscription():java.util.ArrayList");
    }

    public final void cameraAttrUpToStat(String action) {
        s.h(action, "action");
        ArrayList<String> cameraAttrToSubscription = cameraAttrToSubscription();
        h.b.p(cameraAttrToSubscription.get(0), action, cameraAttrToSubscription.get(1), cameraAttrToSubscription.get(2), cameraAttrToSubscription.get(3), cameraAttrToSubscription.get(4), cameraAttrToSubscription.get(5), cameraAttrToSubscription.get(6), cameraAttrToSubscription.get(7));
    }

    public final boolean canSwitchCamera() {
        LensFacing lensFacing;
        int i2 = d.a[this.cameraManager.d().ordinal()];
        if (i2 == 1) {
            lensFacing = LensFacing.FRONT;
        } else if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        } else {
            lensFacing = LensFacing.BACK;
        }
        this.cameraManager.q(lensFacing);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x019a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void captureUpToStatistics() {
        /*
            Method dump skipped, instructions count: 894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.viewmodel.CameraViewModel.captureUpToStatistics():void");
    }

    public final void changeFrame(CameraFrame frameRatio) {
        s.h(frameRatio, "frameRatio");
        if (this.cameraManager.o() != frameRatio) {
            this.unityRender.L0();
            this.cameraManager.j(frameRatio);
            this.unityRender.k0(frameRatio == CameraFrame.FRAME_1_1);
        }
    }

    public final void clearFocusAndMetering() {
        this.cameraManager.A();
        this.cameraManager.s();
    }

    public final void doUnityFilterRender(FilterEntry filterEntry) {
        FilterPackageTable packageBean;
        String packageMd5;
        s.h(filterEntry, "filterEntry");
        FilterPackage s = FilterRepository.a.s(filterEntry.getPkgId());
        if (s == null || (packageBean = s.getPackageBean()) == null || (packageMd5 = packageBean.getPackageMd5()) == null) {
            return;
        }
        kotlinx.coroutines.j.d(n0.a(z0.b()), null, null, new CameraViewModel$doUnityFilterRender$1$1(this, filterEntry, s.q(us.pinguo.common.filter.util.a.a.d(packageMd5), filterEntry.getItemId()), null), 3, null);
    }

    public final void doUnityNoneFilterRender() {
        this.unityRender.J();
    }

    public final boolean enableTorch(boolean z) {
        return this.cameraManager.f(z);
    }

    public final void focusAndMetering(float f2, float f3, int i2, int i3, l<? super Boolean, kotlin.u> lVar) {
        us.pinguo.common.log.a.c("focusArea: x=" + f2 + ", y=" + f3 + ", width=" + i2 + ", height=" + i3, new Object[0]);
        float f4 = (float) (i2 / 2);
        float f5 = (f2 - f4) / f4;
        float f6 = (float) (i3 / 2);
        float f7 = (f3 - f6) / f6;
        e.b.a(this.cameraManager, new PointF(f5, f7), 0.0f, 0, 6, null);
        e.b.b(this.cameraManager, new PointF(f5, f7), 0.0f, 0, 6, null);
    }

    public final AfterCaptureModule getAfterCaptureModule() {
        return this.afterCaptureModule;
    }

    public final CameraBeautyModule getCameraBeautyModule() {
        return this.cameraBeautyModule;
    }

    public final us.pinguo.camera2020.module.settings.a getCameraBottomModule() {
        return this.cameraBottomModule;
    }

    public final CameraFilterModule getCameraFilterModule() {
        return this.cameraFilterModule;
    }

    public final CameraStickerModule getCameraStickerModule() {
        return this.cameraStickerModule;
    }

    public final u<Integer> getCameraThemeStyle() {
        return this.cameraThemeStyle;
    }

    public final CameraTopSettingsModule getCameraTopSettingModule() {
        return this.cameraTopSettingModule;
    }

    public final ExclusiveEffectType getCurrentExclusiveType() {
        if (this.currentExclusiveType == null) {
            String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, SP_KEY_CURRENT_SELECTED_EXCLUSIVE_TYPE, "EFFECT_FILTER", null, 4, null);
            if (j2 == null) {
                j2 = "EFFECT_FILTER";
            }
            this.currentExclusiveType = ExclusiveEffectType.valueOf(j2);
        }
        return this.currentExclusiveType;
    }

    public final Flash getFlash() {
        return this.cameraManager.e();
    }

    public final FrameRatioModule getFrameRatioModule() {
        return this.frameRatioModule;
    }

    public final boolean getGettingPictureAfterSnapshot() {
        return this.gettingPictureAfterSnapshot;
    }

    public final boolean getGotoArgsHandled() {
        return this.gotoArgsHandled;
    }

    public final u<us.pinguo.facedetector.c> getRecentFaceResult() {
        return this.recentFaceResult;
    }

    public final String getShotSource() {
        return this.shotSource;
    }

    public final List<WhiteBalance> getSupportedWhiteBalance() {
        return this.cameraManager.B();
    }

    public final LiveData<us.pinguo.cameramanger.info.b> getTargetCameraResolutionInfo(LensFacing facing) {
        s.h(facing, "facing");
        return this.cameraManager.q(facing).c();
    }

    public final LiveData<Size> getTextureSize() {
        return this.textureSize;
    }

    public final UnityCallbackApi getUnityCallback() {
        return this.unityRender.T();
    }

    public final UnityFilterCallbackApi getUnityFilterCallback() {
        return this.unityRender.T();
    }

    public final UnityInterface.c getUnityGLRender() {
        return this.unityRender.T();
    }

    public final us.pinguo.camera2020.module.settings.b getViewFinderSettingsModule() {
        return this.viewFinderSettingsModule;
    }

    public final u<AutoFilterProducer.b> getYuvFrame() {
        return this.yuvFrame;
    }

    public final boolean hasCamera(LensFacing lensFacing) {
        s.h(lensFacing, "lensFacing");
        return this.cameraManager.n(lensFacing);
    }

    public final void initRender() {
        this.unityRender.W();
    }

    public final boolean isExposureSupport() {
        return this.cameraManager.v();
    }

    public final boolean isFocusOrMeteringSupport() {
        boolean m = this.cameraManager.m();
        boolean c2 = this.cameraManager.c();
        us.pinguo.common.log.a.c("isFocusAreaSupport:" + m + ", isMeteringAreaSupport" + c2, new Object[0]);
        return m || c2;
    }

    public final boolean isIntent() {
        return this.isIntent;
    }

    public final boolean isTorchOn() {
        return this.cameraManager.y();
    }

    public final boolean isZoomSupport() {
        return this.cameraManager.u();
    }

    public final void recordUpToStatistics() {
        captureUpToStatistics();
        us.pinguo.foundation.statistics.a.u().D(String.valueOf(this.cameraTopSettingModule.m().getValue()));
    }

    public final void reportModifiedCameraBeautyKeys() {
        for (BeautyData beautyData : this.cameraBeautyModule.I()) {
            h.b.w0(beautyData.getBeautyKey(), "shot");
        }
    }

    public final void resolutionStat() {
        us.pinguo.cameramanger.info.b value;
        EnumMap<CameraFrame, Size> b2;
        Size size;
        CameraFrame value2 = this.frameRatioModule.d().getValue();
        String cameraFrameStr = getCameraFrameStr(value2);
        LensFacing d2 = this.cameraManager.d();
        String str = d2 == LensFacing.FRONT ? "front_cam" : "rear_cam";
        if (!this.cameraManager.n(d2) || (value = getTargetCameraResolutionInfo(d2).getValue()) == null || (b2 = value.b()) == null || (size = b2.get(this.frameRatioModule.d().getValue())) == null) {
            return;
        }
        if (CameraFrame.FRAME_1_1 == value2) {
            int min = Math.min(size.getWidth(), size.getHeight());
            h.b.O(cameraFrameStr, str, String.valueOf(min * min));
            return;
        }
        h.b.O(cameraFrameStr, str, String.valueOf(size.getWidth() * size.getHeight()));
    }

    public final void restoreCameraPreview() {
        this.unityRender.F0();
        if (this.cameraStickerModule.u().getValue() != null) {
            this.cameraStickerModule.E();
            return;
        }
        FilterEntry value = this.cameraFilterModule.y().getValue();
        if (value == null) {
            UnityMethodCaller.setFilterInfo$default(UnityMethodCaller.FilterType.Local, null, 2, null);
        } else {
            kotlinx.coroutines.j.d(n0.a(z0.b()), null, null, new CameraViewModel$restoreCameraPreview$1(value, this, null), 3, null);
        }
    }

    public final void resume() {
        int i2;
        this.unityRender.a0();
        Integer value = this.viewFinderSettingsModule.b().getValue();
        if (value != null && value.intValue() == 2) {
            i2 = 90;
        } else {
            i2 = (value != null && value.intValue() == 3) ? 75 : 98;
        }
        this.unityRender.j0(i2);
        us.pinguo.common.log.a.c(s.q("resumeEngineMode, setImageSaveQuality:", Integer.valueOf(i2)), new Object[0]);
    }

    public final void setCaptureInfo(us.pinguo.processor.d makeInfo) {
        s.h(makeInfo, "makeInfo");
        this.unityRender.d0(makeInfo);
    }

    public final void setContrastValue(float f2) {
        us.pinguo.common.log.a.c(s.q("setContrastValue:", Float.valueOf(f2)), new Object[0]);
        this.unityRender.f0(f2);
    }

    public final void setCurrentExclusiveType(ExclusiveEffectType exclusiveEffectType) {
        if (exclusiveEffectType != null) {
            us.pinguo.common.log.a.e(s.q("CameraViewModel:currentExclusiveType:", exclusiveEffectType), new Object[0]);
            this.currentExclusiveType = exclusiveEffectType;
            us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, SP_KEY_CURRENT_SELECTED_EXCLUSIVE_TYPE, exclusiveEffectType.name(), null, 4, null);
        }
    }

    public final void setExposureCompensation(float f2) {
        this.cameraManager.k(f2);
    }

    public final void setFilterOpacity(float f2) {
        us.pinguo.common.log.a.c(s.q("setFilterOpacity:", Float.valueOf(f2)), new Object[0]);
        this.unityRender.h0(f2);
    }

    public final void setFilterOpacityNextFrame(float f2) {
        us.pinguo.common.log.a.c(s.q("setFilterOpacityNextFrame:", Float.valueOf(f2)), new Object[0]);
        this.unityRender.i0(f2);
    }

    public final void setGettingPictureAfterSnapshot(boolean z) {
        this.gettingPictureAfterSnapshot = z;
    }

    public final void setGotoArgsHandled(boolean z) {
        this.gotoArgsHandled = z;
    }

    public final void setIntent(boolean z) {
        this.isIntent = z;
    }

    public final void setIsFrontMirror(boolean z) {
        this.unityRender.l0(!z);
    }

    public final void setIsShowBeautyCompare(boolean z) {
        this.unityRender.m0(z);
    }

    public final void setMakeInfo(us.pinguo.processor.d makeInfo) {
        s.h(makeInfo, "makeInfo");
        this.unityRender.o0(makeInfo);
    }

    public final void setOnCaptureImageRenderEndCallback(l<? super CaptureModel, kotlin.u> callback) {
        s.h(callback, "callback");
        this.unityRender.b0(callback);
    }

    public final void setOnCaptureImageSavedCallback(q<? super String, ? super Integer, ? super Scene, kotlin.u> callback) {
        s.h(callback, "callback");
        this.unityRender.c0(callback);
    }

    public final void setOnCaptureRenderEndCallback(l<? super Scene, kotlin.u> callback) {
        s.h(callback, "callback");
        this.unityRender.e0(callback);
    }

    public final void setOnFirstRenderStart(kotlin.jvm.b.a<kotlin.u> callback) {
        s.h(callback, "callback");
        this.unityRender.r0(callback);
    }

    public final void setOrientation(int i2) {
        k.a.p(us.pinguo.camera2020.utils.a.a.a(this.cameraManager.d() == LensFacing.FRONT, this.cameraManager.l().b(), i2));
        this.unityRender.s0(i2);
    }

    public final void setPreviewAction(q<? super Boolean, ? super Boolean, ? super String, kotlin.u> qVar) {
        this.unityRender.t0(qVar);
    }

    public final void setRecentFaceResult(u<us.pinguo.facedetector.c> uVar) {
        s.h(uVar, "<set-?>");
        this.recentFaceResult = uVar;
    }

    public final void setSaturationValue(float f2) {
        us.pinguo.common.log.a.c(s.q("setSaturationValue:", Float.valueOf(f2)), new Object[0]);
        this.unityRender.u0(f2);
    }

    public final void setShotSource(String str) {
        s.h(str, "<set-?>");
        this.shotSource = str;
    }

    public final void setShutterSoundEnable(boolean z) {
        this.cameraManager.p(z);
    }

    public final void setSkyChangeRenderCompleteCallback(kotlin.jvm.b.s<? super String, ? super Float, ? super Float, ? super Float, ? super Float, kotlin.u> sVar) {
        this.unityRender.v0(sVar);
    }

    public final void setUnityFilterRender(boolean z) {
        this.unityRender.w0(z);
    }

    public final void setUnityVolumeEnable(boolean z) {
        this.unityRender.y0(z);
    }

    public final void setWatermarkStyle(WatermarkStyle style) {
        s.h(style, "style");
        this.unityRender.C0(style);
    }

    public final void setWhiteBalance(WhiteBalance whiteBalance) {
        s.h(whiteBalance, "whiteBalance");
        this.cameraManager.x(whiteBalance);
    }

    public final void setYuvFrame(u<AutoFilterProducer.b> uVar) {
        s.h(uVar, "<set-?>");
        this.yuvFrame = uVar;
    }

    public final void setZoom(float f2) {
        this.cameraManager.C(f2);
    }

    public final void startCameraRender() {
        this.unityRender.F0();
    }

    public final void startRecord(int i2) {
        this.unityRender.K0(i2);
    }

    public final void stopRecord() {
        this.unityRender.M0();
    }

    public final void switchCamera(boolean z) {
        if ((this.cameraManager.d() == LensFacing.FRONT) != z) {
            toggleCamera();
        }
    }

    public final void takePicture(int i2) {
        kotlinx.coroutines.j.d(n0.a(z0.b()), null, null, new CameraViewModel$takePicture$1(this, i2, null), 3, null);
    }
}
