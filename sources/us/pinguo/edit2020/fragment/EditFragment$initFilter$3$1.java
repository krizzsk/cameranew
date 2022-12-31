package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.view.FilterGestureView;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1", f = "EditFragment.kt", i = {}, l = {544, 545, 559, 567}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditFragment$initFilter$3$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ EditFilterController $controller;
    final /* synthetic */ FilterEntry $entry;
    int label;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ EditFilterController $controller;
        int label;
        final /* synthetic */ EditFragment this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EditFragment.kt */
        /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public /* synthetic */ class C03881 extends FunctionReferenceImpl implements kotlin.jvm.b.s<String, Float, Float, Float, Float, kotlin.u> {
            C03881(Object obj) {
                super(5, obj, EditFilterController.class, "onSkyPrepared", "onSkyPrepared(Ljava/lang/String;FFFF)V", 0);
            }

            @Override // kotlin.jvm.b.s
            public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, Float f3, Float f4, Float f5) {
                invoke(str, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue());
                return kotlin.u.a;
            }

            public final void invoke(String p0, float f2, float f3, float f4, float f5) {
                kotlin.jvm.internal.s.h(p0, "p0");
                ((EditFilterController) this.receiver).Z1(p0, f2, f3, f4, f5);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EditFragment.kt */
        /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1$2  reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass2 extends Lambda implements kotlin.jvm.b.s<String, Float, Float, Float, Float, kotlin.u> {
            final /* synthetic */ EditFragment this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: EditFragment.kt */
            @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1$2$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1$2$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes4.dex */
            public static final class C03891 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
                int label;
                final /* synthetic */ EditFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03891(EditFragment editFragment, Continuation<? super C03891> continuation) {
                    super(2, continuation);
                    this.this$0 = editFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                    return new C03891(this.this$0, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                    return ((C03891) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label == 0) {
                        kotlin.j.b(obj);
                        this.this$0.n1();
                        this.this$0.J2();
                        return kotlin.u.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(EditFragment editFragment) {
                super(5);
                this.this$0 = editFragment;
            }

            @Override // kotlin.jvm.b.s
            public /* bridge */ /* synthetic */ kotlin.u invoke(String str, Float f2, Float f3, Float f4, Float f5) {
                invoke(str, f2.floatValue(), f3.floatValue(), f4.floatValue(), f5.floatValue());
                return kotlin.u.a;
            }

            public final void invoke(String noName_0, float f2, float f3, float f4, float f5) {
                kotlin.jvm.internal.s.h(noName_0, "$noName_0");
                kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.c()), null, null, new C03891(this.this$0, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EditFragment editFragment, EditFilterController editFilterController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = editFragment;
            this.$controller = editFilterController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$controller, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            EditViewModel j1;
            EditViewModel j12;
            EditViewModel j13;
            EditViewModel j14;
            EditViewModel j15;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                j1 = this.this$0.j1();
                if (j1.l().J() == null) {
                    j15 = this.this$0.j1();
                    j15.l().i1(new C03881(this.$controller));
                }
                j12 = this.this$0.j1();
                if (j12.l().I() == null) {
                    j14 = this.this$0.j1();
                    j14.l().h1(new AnonymousClass2(this.this$0));
                }
                j13 = this.this$0.j1();
                us.pinguo.edit2020.bean.u0 value = j13.l().L().getValue();
                if (value == null) {
                    return null;
                }
                ((FilterGestureView) this.this$0._$_findCachedViewById(R.id.filterGestureView)).setCanvasInfo(value);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$2", f = "EditFragment.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ FilterEntry $entry;
        int label;
        final /* synthetic */ EditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EditFragment editFragment, FilterEntry filterEntry, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = editFragment;
            this.$entry = filterEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$entry, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Object M2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                EditFragment editFragment = this.this$0;
                FilterEntry entry = this.$entry;
                kotlin.jvm.internal.s.g(entry, "entry");
                this.label = 1;
                M2 = editFragment.M2(entry, this);
                if (M2 == coroutine_suspended) {
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
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$3", f = "EditFragment.kt", i = {}, l = {568}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass3 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ FilterEntry $entry;
        int label;
        final /* synthetic */ EditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(EditFragment editFragment, FilterEntry filterEntry, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = editFragment;
            this.$entry = filterEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, this.$entry, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass3) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            Object v2;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                EditFragment editFragment = this.this$0;
                FilterEntry entry = this.$entry;
                kotlin.jvm.internal.s.g(entry, "entry");
                this.label = 1;
                v2 = editFragment.v2(entry, this);
                if (v2 == coroutine_suspended) {
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
    public EditFragment$initFilter$3$1(EditFragment editFragment, FilterEntry filterEntry, EditFilterController editFilterController, Continuation<? super EditFragment$initFilter$3$1> continuation) {
        super(2, continuation);
        this.this$0 = editFragment;
        this.$entry = filterEntry;
        this.$controller = editFilterController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFragment$initFilter$3$1(this.this$0, this.$entry, this.$controller, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFragment$initFilter$3$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L2b
            if (r1 == r6) goto L27
            if (r1 == r4) goto L23
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            goto L1e
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.j.b(r8)
            goto Lba
        L23:
            kotlin.j.b(r8)
            goto L63
        L27:
            kotlin.j.b(r8)
            goto L43
        L2b:
            kotlin.j.b(r8)
            us.pinguo.edit2020.fragment.EditFragment r8 = r7.this$0
            us.pinguo.edit2020.viewmodel.EditViewModel r8 = us.pinguo.edit2020.fragment.EditFragment.r0(r8)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r8 = r8.i()
            us.pinguo.repository2020.entity.FilterEntry r1 = r7.$entry
            r7.label = r6
            java.lang.Object r8 = r8.W(r1, r7)
            if (r8 != r0) goto L43
            return r0
        L43:
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            boolean r8 = kotlin.jvm.internal.s.c(r8, r1)
            if (r8 == 0) goto L79
            kotlinx.coroutines.g2 r8 = kotlinx.coroutines.z0.c()
            us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1 r1 = new us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$1
            us.pinguo.edit2020.fragment.EditFragment r2 = r7.this$0
            us.pinguo.edit2020.controller.EditFilterController r6 = r7.$controller
            r1.<init>(r2, r6, r5)
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.j.g(r8, r1, r7)
            if (r8 != r0) goto L63
            return r0
        L63:
            kotlinx.coroutines.CoroutineDispatcher r8 = kotlinx.coroutines.z0.b()
            us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$2 r1 = new us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$2
            us.pinguo.edit2020.fragment.EditFragment r2 = r7.this$0
            us.pinguo.repository2020.entity.FilterEntry r4 = r7.$entry
            r1.<init>(r2, r4, r5)
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.j.g(r8, r1, r7)
            if (r8 != r0) goto Lba
            return r0
        L79:
            us.pinguo.edit2020.fragment.EditFragment r8 = r7.this$0
            us.pinguo.edit2020.viewmodel.EditViewModel r8 = us.pinguo.edit2020.fragment.EditFragment.r0(r8)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r8 = r8.i()
            boolean r8 = r8.X()
            if (r8 == 0) goto La4
            us.pinguo.edit2020.fragment.EditFragment r8 = r7.this$0
            us.pinguo.edit2020.viewmodel.EditViewModel r8 = us.pinguo.edit2020.fragment.EditFragment.r0(r8)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r8 = r8.i()
            r8.h()
            us.pinguo.edit2020.fragment.EditFragment r8 = r7.this$0
            us.pinguo.edit2020.viewmodel.EditViewModel r8 = us.pinguo.edit2020.fragment.EditFragment.r0(r8)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r8 = r8.i()
            r1 = 0
            r8.j0(r1)
        La4:
            kotlinx.coroutines.g2 r8 = kotlinx.coroutines.z0.c()
            us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$3 r1 = new us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1$3
            us.pinguo.edit2020.fragment.EditFragment r3 = r7.this$0
            us.pinguo.repository2020.entity.FilterEntry r4 = r7.$entry
            r1.<init>(r3, r4, r5)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.j.g(r8, r1, r7)
            if (r8 != r0) goto Lba
            return r0
        Lba:
            us.pinguo.foundation.statistics.i r8 = us.pinguo.foundation.statistics.h.b
            us.pinguo.edit2020.fragment.EditFragment r0 = r7.this$0
            us.pinguo.edit2020.viewmodel.EditViewModel r0 = us.pinguo.edit2020.fragment.EditFragment.r0(r0)
            us.pinguo.edit2020.viewmodel.module.EditFilterModule r0 = r0.i()
            java.lang.String r0 = r0.x()
            us.pinguo.repository2020.entity.FilterEntry r1 = r7.$entry
            java.lang.String r1 = r1.getItemId()
            java.lang.String r2 = "preview"
            r8.N(r0, r1, r2)
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.fragment.EditFragment$initFilter$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
