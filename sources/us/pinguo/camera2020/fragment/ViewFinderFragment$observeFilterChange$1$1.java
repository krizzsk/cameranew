package us.pinguo.camera2020.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.viewmodel.CameraViewModel;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.common.filter.controller.FilterController;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.SkyParamsRecord;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1", f = "ViewFinderFragment.kt", i = {0, 1, 1, 1}, l = {1848, 1851}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "pkgId", "filterId"}, s = {"L$0", "L$0", "L$1", "L$2"})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$observeFilterChange$1$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ FilterController $controller;
    final /* synthetic */ FilterEntry $entry;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$1", f = "ViewFinderFragment.kt", i = {}, l = {1853}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ FilterController $controller;
        final /* synthetic */ String $filterId;
        final /* synthetic */ String $pkgId;
        final /* synthetic */ boolean $textureVisible;
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ViewFinderFragment.kt */
        @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$1$1", f = "ViewFinderFragment.kt", i = {}, l = {1859}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C03621 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
            final /* synthetic */ FilterController $controller;
            final /* synthetic */ String $filterId;
            final /* synthetic */ String $pkgId;
            final /* synthetic */ boolean $textureVisible;
            int label;
            final /* synthetic */ ViewFinderFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03621(FilterController filterController, boolean z, ViewFinderFragment viewFinderFragment, String str, String str2, Continuation<? super C03621> continuation) {
                super(2, continuation);
                this.$controller = filterController;
                this.$textureVisible = z;
                this.this$0 = viewFinderFragment;
                this.$filterId = str;
                this.$pkgId = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                return new C03621(this.$controller, this.$textureVisible, this.this$0, this.$filterId, this.$pkgId, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                return ((C03621) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                SkyParamsRecord skyParamsRecord;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    kotlin.j.b(obj);
                    this.$controller.n1(this.$textureVisible);
                    ViewFinderFragment viewFinderFragment = this.this$0;
                    int i3 = R.id.filterView;
                    ((FilterPanelView) viewFinderFragment._$_findCachedViewById(i3)).setDisableSeekbar(true);
                    ((FilterPanelView) this.this$0._$_findCachedViewById(i3)).P(false);
                    CameraViewModel cameraViewModel = this.this$0.f9174j;
                    if (cameraViewModel != null) {
                        skyParamsRecord = cameraViewModel.getCameraFilterModule().G().get(this.$filterId);
                        if (skyParamsRecord == null) {
                            CameraViewModel cameraViewModel2 = this.this$0.f9174j;
                            if (cameraViewModel2 == null) {
                                kotlin.jvm.internal.s.z("cameraViewModel");
                                throw null;
                            }
                            CameraFilterModule cameraFilterModule = cameraViewModel2.getCameraFilterModule();
                            String str = this.$pkgId;
                            String str2 = this.$filterId;
                            this.label = 1;
                            obj = cameraFilterModule.b0(str, str2, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        this.$controller.j1(skyParamsRecord.getTransparent(), skyParamsRecord.getMix(), skyParamsRecord.getDefaultTemperature(), skyParamsRecord.getTemperature(), skyParamsRecord.getTexture());
                        return kotlin.u.a;
                    }
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlin.j.b(obj);
                }
                skyParamsRecord = (SkyParamsRecord) obj;
                CameraViewModel cameraViewModel3 = this.this$0.f9174j;
                if (cameraViewModel3 == null) {
                    kotlin.jvm.internal.s.z("cameraViewModel");
                    throw null;
                }
                cameraViewModel3.getCameraFilterModule().G().put(this.$filterId, skyParamsRecord);
                this.$controller.j1(skyParamsRecord.getTransparent(), skyParamsRecord.getMix(), skyParamsRecord.getDefaultTemperature(), skyParamsRecord.getTemperature(), skyParamsRecord.getTexture());
                return kotlin.u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewFinderFragment viewFinderFragment, FilterController filterController, boolean z, String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = viewFinderFragment;
            this.$controller = filterController;
            this.$textureVisible = z;
            this.$filterId = str;
            this.$pkgId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$controller, this.$textureVisible, this.$filterId, this.$pkgId, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
                kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
                Lifecycle.State state = Lifecycle.State.CREATED;
                C03621 c03621 = new C03621(this.$controller, this.$textureVisible, this.this$0, this.$filterId, this.$pkgId, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, c03621, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$2", f = "ViewFinderFragment.kt", i = {}, l = {1867}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ViewFinderFragment.kt */
        @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$2$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$observeFilterChange$1$1$2$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
            int label;
            final /* synthetic */ ViewFinderFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ViewFinderFragment viewFinderFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = viewFinderFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    kotlin.j.b(obj);
                    ViewFinderFragment viewFinderFragment = this.this$0;
                    int i2 = R.id.filterView;
                    if (((FilterPanelView) viewFinderFragment._$_findCachedViewById(i2)).p()) {
                        ((FilterPanelView) this.this$0._$_findCachedViewById(i2)).setDisableSeekbar(false);
                        ((FilterPanelView) this.this$0._$_findCachedViewById(i2)).P(true);
                    }
                    return kotlin.u.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ViewFinderFragment viewFinderFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = viewFinderFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
                kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
                Lifecycle.State state = Lifecycle.State.CREATED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$observeFilterChange$1$1(ViewFinderFragment viewFinderFragment, FilterEntry filterEntry, FilterController filterController, Continuation<? super ViewFinderFragment$observeFilterChange$1$1> continuation) {
        super(2, continuation);
        this.this$0 = viewFinderFragment;
        this.$entry = filterEntry;
        this.$controller = filterController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ViewFinderFragment$observeFilterChange$1$1 viewFinderFragment$observeFilterChange$1$1 = new ViewFinderFragment$observeFilterChange$1$1(this.this$0, this.$entry, this.$controller, continuation);
        viewFinderFragment$observeFilterChange$1$1.L$0 = obj;
        return viewFinderFragment$observeFilterChange$1$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$observeFilterChange$1$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        kotlinx.coroutines.m0 m0Var;
        String itemId;
        String str;
        String str2;
        kotlinx.coroutines.m0 m0Var2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            kotlinx.coroutines.m0 m0Var3 = (kotlinx.coroutines.m0) this.L$0;
            CameraViewModel cameraViewModel = this.this$0.f9174j;
            if (cameraViewModel == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            CameraFilterModule cameraFilterModule = cameraViewModel.getCameraFilterModule();
            FilterEntry filterEntry = this.$entry;
            this.L$0 = m0Var3;
            this.label = 1;
            Object W = cameraFilterModule.W(filterEntry, this);
            if (W == coroutine_suspended) {
                return coroutine_suspended;
            }
            m0Var = m0Var3;
            obj = W;
        } else if (i2 != 1) {
            if (i2 == 2) {
                kotlin.j.b(obj);
                str = (String) this.L$2;
                str2 = (String) this.L$1;
                m0Var2 = (kotlinx.coroutines.m0) this.L$0;
                kotlinx.coroutines.l.d(m0Var2, z0.c(), null, new AnonymousClass1(this.this$0, this.$controller, ((Boolean) obj).booleanValue(), str, str2, null), 2, null);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
            m0Var = (kotlinx.coroutines.m0) this.L$0;
        }
        if (!kotlin.jvm.internal.s.c(obj, Boxing.boxBoolean(true))) {
            kotlinx.coroutines.l.d(m0Var, z0.c(), null, new AnonymousClass2(this.this$0, null), 2, null);
            return kotlin.u.a;
        }
        String pkgId = this.$entry.getPkgId();
        if (pkgId != null && (itemId = this.$entry.getItemId()) != null) {
            CameraViewModel cameraViewModel2 = this.this$0.f9174j;
            if (cameraViewModel2 == null) {
                kotlin.jvm.internal.s.z("cameraViewModel");
                throw null;
            }
            CameraFilterModule cameraFilterModule2 = cameraViewModel2.getCameraFilterModule();
            this.L$0 = m0Var;
            this.L$1 = pkgId;
            this.L$2 = itemId;
            this.label = 2;
            Object V = cameraFilterModule2.V(pkgId, itemId, this);
            if (V == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = itemId;
            str2 = pkgId;
            obj = V;
            m0Var2 = m0Var;
            kotlinx.coroutines.l.d(m0Var2, z0.c(), null, new AnonymousClass1(this.this$0, this.$controller, ((Boolean) obj).booleanValue(), str, str2, null), 2, null);
            return kotlin.u.a;
        }
        return kotlin.u.a;
    }
}
