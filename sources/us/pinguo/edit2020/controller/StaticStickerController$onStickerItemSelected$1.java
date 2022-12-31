package us.pinguo.edit2020.controller;

import android.graphics.drawable.Drawable;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import us.pinguo.edit2020.R;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.ui.widget.AutofitTextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StaticStickerController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$onStickerItemSelected$1", f = "StaticStickerController.kt", i = {}, l = {650}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class StaticStickerController$onStickerItemSelected$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ Material $material;
    final /* synthetic */ StaticStickerCategory $materialCategory;
    int label;
    final /* synthetic */ StaticStickerController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.StaticStickerController$onStickerItemSelected$1$1", f = "StaticStickerController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.StaticStickerController$onStickerItemSelected$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ Ref$ObjectRef<Drawable> $drawableLeft;
        int label;
        final /* synthetic */ StaticStickerController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StaticStickerController staticStickerController, Ref$ObjectRef<Drawable> ref$ObjectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = staticStickerController;
            this.$drawableLeft = ref$ObjectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$drawableLeft, continuation);
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
                ((AutofitTextView) this.this$0.f10427e.findViewById(R.id.tvSkipToStickerPackage)).setCompoundDrawables(this.$drawableLeft.element, null, null, null);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaticStickerController$onStickerItemSelected$1(Material material, StaticStickerCategory staticStickerCategory, StaticStickerController staticStickerController, Continuation<? super StaticStickerController$onStickerItemSelected$1> continuation) {
        super(2, continuation);
        this.$material = material;
        this.$materialCategory = staticStickerCategory;
        this.this$0 = staticStickerController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new StaticStickerController$onStickerItemSelected$1(this.$material, this.$materialCategory, this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((StaticStickerController$onStickerItemSelected$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb A[Catch: Exception -> 0x0011, TRY_LEAVE, TryCatch #1 {Exception -> 0x0011, blocks: (B:5:0x000c, B:12:0x001f, B:14:0x0037, B:34:0x00c7, B:36:0x00cb, B:25:0x007b, B:29:0x009f, B:28:0x009c, B:17:0x003d, B:30:0x00a3, B:33:0x00c4, B:19:0x0043, B:22:0x0072), top: B:44:0x0008, inners: #0 }] */
    /* JADX WARN: Type inference failed for: r1v19, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r6v5, types: [T, android.graphics.drawable.Drawable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1c
            if (r1 != r2) goto L14
            kotlin.j.b(r9)     // Catch: java.lang.Exception -> L11
            goto Lee
        L11:
            r9 = move-exception
            goto Ldf
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            kotlin.j.b(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Exception -> L11
            r9.<init>()     // Catch: java.lang.Exception -> L11
            us.pinguo.repository2020.entity.Material r1 = r8.$material     // Catch: java.lang.Exception -> L11
            us.pinguo.repository2020.database.staticsticker.Template r1 = (us.pinguo.repository2020.database.staticsticker.Template) r1     // Catch: java.lang.Exception -> L11
            java.lang.String r1 = r1.getTid()     // Catch: java.lang.Exception -> L11
            java.lang.String r4 = "wu"
            boolean r1 = kotlin.jvm.internal.s.c(r1, r4)     // Catch: java.lang.Exception -> L11
            r4 = 0
            r5 = 20
            if (r1 != 0) goto La3
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r1 = r8.$materialCategory     // Catch: java.lang.Exception -> L11
            if (r1 != 0) goto L3d
            r1 = r4
            goto L41
        L3d:
            java.lang.String r1 = r1.getIcon()     // Catch: java.lang.Exception -> L11
        L41:
            if (r1 == 0) goto La3
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L7a
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r6 = r8.$materialCategory     // Catch: java.lang.Exception -> L7a
            java.lang.String r6 = r6.getIcon()     // Catch: java.lang.Exception -> L7a
            kotlin.jvm.internal.s.e(r6)     // Catch: java.lang.Exception -> L7a
            r1.<init>(r6)     // Catch: java.lang.Exception -> L7a
            java.io.InputStream r1 = r1.openStream()     // Catch: java.lang.Exception -> L7a
            java.lang.String r6 = "image.png"
            android.graphics.drawable.Drawable r1 = android.graphics.drawable.Drawable.createFromStream(r1, r6)     // Catch: java.lang.Exception -> L7a
            r9.element = r1     // Catch: java.lang.Exception -> L7a
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Exception -> L7a
            int r1 = us.pinguo.common.widget.i.a.a(r1)     // Catch: java.lang.Exception -> L7a
            float r6 = (float) r1     // Catch: java.lang.Exception -> L7a
            r7 = 1067198710(0x3f9c28f6, float:1.22)
            float r6 = r6 * r7
            T r7 = r9.element     // Catch: java.lang.Exception -> L7a
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7     // Catch: java.lang.Exception -> L7a
            if (r7 != 0) goto L72
            goto Lc7
        L72:
            int r6 = kotlin.y.a.b(r6)     // Catch: java.lang.Exception -> L7a
            r7.setBounds(r3, r3, r6, r1)     // Catch: java.lang.Exception -> L7a
            goto Lc7
        L7a:
            r1 = move-exception
            us.pinguo.edit2020.controller.StaticStickerController r6 = r8.this$0     // Catch: java.lang.Exception -> L11
            android.view.ViewGroup r6 = us.pinguo.edit2020.controller.StaticStickerController.x(r6)     // Catch: java.lang.Exception -> L11
            android.content.Context r6 = r6.getContext()     // Catch: java.lang.Exception -> L11
            int r7 = us.pinguo.edit2020.R.drawable.ic_edit_skip_to_package_default     // Catch: java.lang.Exception -> L11
            android.graphics.drawable.Drawable r6 = androidx.core.content.ContextCompat.getDrawable(r6, r7)     // Catch: java.lang.Exception -> L11
            r9.element = r6     // Catch: java.lang.Exception -> L11
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Exception -> L11
            int r5 = us.pinguo.common.widget.i.a.a(r5)     // Catch: java.lang.Exception -> L11
            T r6 = r9.element     // Catch: java.lang.Exception -> L11
            android.graphics.drawable.Drawable r6 = (android.graphics.drawable.Drawable) r6     // Catch: java.lang.Exception -> L11
            if (r6 != 0) goto L9c
            goto L9f
        L9c:
            r6.setBounds(r3, r3, r5, r5)     // Catch: java.lang.Exception -> L11
        L9f:
            r1.printStackTrace()     // Catch: java.lang.Exception -> L11
            goto Lc7
        La3:
            us.pinguo.edit2020.controller.StaticStickerController r1 = r8.this$0     // Catch: java.lang.Exception -> L11
            android.view.ViewGroup r1 = us.pinguo.edit2020.controller.StaticStickerController.x(r1)     // Catch: java.lang.Exception -> L11
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Exception -> L11
            int r6 = us.pinguo.edit2020.R.drawable.ic_edit_skip_to_package_default     // Catch: java.lang.Exception -> L11
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r6)     // Catch: java.lang.Exception -> L11
            r9.element = r1     // Catch: java.lang.Exception -> L11
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Exception -> L11
            int r1 = us.pinguo.common.widget.i.a.a(r1)     // Catch: java.lang.Exception -> L11
            T r5 = r9.element     // Catch: java.lang.Exception -> L11
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5     // Catch: java.lang.Exception -> L11
            if (r5 != 0) goto Lc4
            goto Lc7
        Lc4:
            r5.setBounds(r3, r3, r1, r1)     // Catch: java.lang.Exception -> L11
        Lc7:
            T r1 = r9.element     // Catch: java.lang.Exception -> L11
            if (r1 == 0) goto Lee
            kotlinx.coroutines.g2 r1 = kotlinx.coroutines.z0.c()     // Catch: java.lang.Exception -> L11
            us.pinguo.edit2020.controller.StaticStickerController$onStickerItemSelected$1$1 r5 = new us.pinguo.edit2020.controller.StaticStickerController$onStickerItemSelected$1$1     // Catch: java.lang.Exception -> L11
            us.pinguo.edit2020.controller.StaticStickerController r6 = r8.this$0     // Catch: java.lang.Exception -> L11
            r5.<init>(r6, r9, r4)     // Catch: java.lang.Exception -> L11
            r8.label = r2     // Catch: java.lang.Exception -> L11
            java.lang.Object r9 = kotlinx.coroutines.j.g(r1, r5, r8)     // Catch: java.lang.Exception -> L11
            if (r9 != r0) goto Lee
            return r0
        Ldf:
            java.lang.String r9 = r9.getMessage()
            java.lang.String r0 = "caught exception==>"
            java.lang.String r9 = kotlin.jvm.internal.s.q(r0, r9)
            java.lang.Object[] r0 = new java.lang.Object[r3]
            us.pinguo.common.log.a.e(r9, r0)
        Lee:
            kotlin.u r9 = kotlin.u.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.controller.StaticStickerController$onStickerItemSelected$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
