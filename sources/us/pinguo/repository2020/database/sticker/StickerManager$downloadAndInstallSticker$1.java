package us.pinguo.repository2020.database.sticker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1", f = "StickerManager.kt", i = {}, l = {783, 792}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class StickerManager$downloadAndInstallSticker$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ p<String, Boolean, u> $action;
    final /* synthetic */ boolean $isBuiltIn;
    final /* synthetic */ Sticker $sticker;
    final /* synthetic */ String $stickerId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerManager.kt */
    /* renamed from: us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends Lambda implements p<String[], Boolean, u> {
        final /* synthetic */ p<String, Boolean, u> $action;
        final /* synthetic */ Sticker $sticker;
        final /* synthetic */ String $stickerId;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StickerManager.kt */
        /* renamed from: us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C04381 extends Lambda implements r<String, String, String, Boolean, u> {
            final /* synthetic */ p<String, Boolean, u> $action;
            final /* synthetic */ StickerDetail $detail;
            final /* synthetic */ Sticker $sticker;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: StickerManager.kt */
            @DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$1$1$1", f = "StickerManager.kt", i = {}, l = {822}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: classes6.dex */
            public static final class C04391 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
                final /* synthetic */ p<String, Boolean, u> $action;
                final /* synthetic */ StickerDetail $detail;
                final /* synthetic */ String $displayDirPath;
                final /* synthetic */ String $packageDirPath;
                final /* synthetic */ String $sid;
                final /* synthetic */ Sticker $sticker;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C04391(StickerDetail stickerDetail, String str, String str2, Sticker sticker, String str3, p<? super String, ? super Boolean, u> pVar, Continuation<? super C04391> continuation) {
                    super(2, continuation);
                    this.$detail = stickerDetail;
                    this.$displayDirPath = str;
                    this.$packageDirPath = str2;
                    this.$sticker = sticker;
                    this.$sid = str3;
                    this.$action = pVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                    return new C04391(this.$detail, this.$displayDirPath, this.$packageDirPath, this.$sticker, this.$sid, this.$action, continuation);
                }

                @Override // kotlin.jvm.b.p
                public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                    return ((C04391) create(m0Var, continuation)).invokeSuspend(u.a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    HashMap hashMap;
                    CopyOnWriteArrayList copyOnWriteArrayList;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = this.label;
                    if (i2 == 0) {
                        j.b(obj);
                        StickerManager stickerManager = StickerManager.a;
                        StickerDetail stickerDetail = this.$detail;
                        String str = this.$displayDirPath;
                        String str2 = this.$packageDirPath;
                        this.label = 1;
                        obj = stickerManager.S(stickerDetail, str, str2, (r12 & 8) != 0 ? false : false, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        j.b(obj);
                    }
                    if (((Boolean) obj).booleanValue()) {
                        Sticker sticker = this.$sticker;
                        if (sticker != null) {
                            sticker.setState(StickerState.AVAILABLE);
                        }
                        copyOnWriteArrayList = StickerManager.n;
                        copyOnWriteArrayList.add(this.$sid);
                        p<String, Boolean, u> pVar = this.$action;
                        if (pVar != null) {
                            pVar.invoke(this.$sid, Boxing.boxBoolean(true));
                        }
                    } else {
                        Sticker sticker2 = this.$sticker;
                        if (sticker2 != null) {
                            sticker2.setState(StickerState.NOT_DOWNLOADED);
                        }
                        hashMap = StickerManager.r;
                        d dVar = (d) hashMap.get(this.$sid);
                        if (dVar != null) {
                            dVar.b(100);
                        }
                        p<String, Boolean, u> pVar2 = this.$action;
                        if (pVar2 != null) {
                            pVar2.invoke(this.$sid, Boxing.boxBoolean(false));
                        }
                    }
                    return u.a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C04381(p<? super String, ? super Boolean, u> pVar, StickerDetail stickerDetail, Sticker sticker) {
                super(4);
                this.$action = pVar;
                this.$detail = stickerDetail;
                this.$sticker = sticker;
            }

            @Override // kotlin.jvm.b.r
            public /* bridge */ /* synthetic */ u invoke(String str, String str2, String str3, Boolean bool) {
                invoke(str, str2, str3, bool.booleanValue());
                return u.a;
            }

            public final void invoke(String sid, String displayDirPath, String packageDirPath, boolean z) {
                HashMap hashMap;
                s.h(sid, "sid");
                s.h(displayDirPath, "displayDirPath");
                s.h(packageDirPath, "packageDirPath");
                if (z) {
                    l.d(n0.a(z0.b()), null, null, new C04391(this.$detail, displayDirPath, packageDirPath, this.$sticker, sid, this.$action, null), 3, null);
                    return;
                }
                StickerManager.a.B(sid);
                hashMap = StickerManager.r;
                d dVar = (d) hashMap.get(sid);
                if (dVar != null) {
                    dVar.b(100);
                }
                p<String, Boolean, u> pVar = this.$action;
                if (pVar == null) {
                    return;
                }
                pVar.invoke(sid, Boolean.FALSE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Sticker sticker, String str, p<? super String, ? super Boolean, u> pVar) {
            super(2);
            this.$sticker = sticker;
            this.$stickerId = str;
            this.$action = pVar;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ u invoke(String[] strArr, Boolean bool) {
            invoke(strArr, bool.booleanValue());
            return u.a;
        }

        public final void invoke(String[] idArr, boolean z) {
            HashMap hashMap;
            ConcurrentHashMap concurrentHashMap;
            HashMap hashMap2;
            s.h(idArr, "idArr");
            if (z) {
                String str = idArr[0];
                concurrentHashMap = StickerManager.m;
                StickerDetail stickerDetail = (StickerDetail) concurrentHashMap.get(str);
                if (stickerDetail != null) {
                    StickerManager.a.E(stickerDetail, new C04381(this.$action, stickerDetail, this.$sticker));
                    return;
                }
                Sticker sticker = this.$sticker;
                if (sticker != null) {
                    sticker.setState(StickerState.NOT_DOWNLOADED);
                }
                hashMap2 = StickerManager.r;
                d dVar = (d) hashMap2.get(this.$stickerId);
                if (dVar != null) {
                    dVar.b(100);
                }
                p<String, Boolean, u> pVar = this.$action;
                if (pVar == null) {
                    return;
                }
                pVar.invoke(str, Boolean.FALSE);
                return;
            }
            Sticker sticker2 = this.$sticker;
            if (sticker2 != null) {
                sticker2.setState(StickerState.NOT_DOWNLOADED);
            }
            hashMap = StickerManager.r;
            d dVar2 = (d) hashMap.get(this.$stickerId);
            if (dVar2 != null) {
                dVar2.b(100);
            }
            p<String, Boolean, u> pVar2 = this.$action;
            if (pVar2 == null) {
                return;
            }
            pVar2.invoke(idArr[0], Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerManager.kt */
    /* renamed from: us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass2 extends Lambda implements r<String, String, String, Boolean, u> {
        final /* synthetic */ p<String, Boolean, u> $action;
        final /* synthetic */ Sticker $sticker;
        final /* synthetic */ StickerDetail $stickerDetail;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StickerManager.kt */
        @DebugMetadata(c = "us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$2$1", f = "StickerManager.kt", i = {}, l = {849}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1$2$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            final /* synthetic */ p<String, Boolean, u> $action;
            final /* synthetic */ String $displayDir;
            final /* synthetic */ String $id;
            final /* synthetic */ String $packageDir;
            final /* synthetic */ Sticker $sticker;
            final /* synthetic */ StickerDetail $stickerDetail;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(StickerDetail stickerDetail, String str, String str2, Sticker sticker, String str3, p<? super String, ? super Boolean, u> pVar, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$stickerDetail = stickerDetail;
                this.$displayDir = str;
                this.$packageDir = str2;
                this.$sticker = sticker;
                this.$id = str3;
                this.$action = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$stickerDetail, this.$displayDir, this.$packageDir, this.$sticker, this.$id, this.$action, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended;
                HashMap hashMap;
                CopyOnWriteArrayList copyOnWriteArrayList;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = this.label;
                if (i2 == 0) {
                    j.b(obj);
                    StickerManager stickerManager = StickerManager.a;
                    StickerDetail stickerDetail = this.$stickerDetail;
                    String str = this.$displayDir;
                    String str2 = this.$packageDir;
                    this.label = 1;
                    obj = stickerManager.S(stickerDetail, str, str2, (r12 & 8) != 0 ? false : false, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    j.b(obj);
                }
                if (((Boolean) obj).booleanValue()) {
                    Sticker sticker = this.$sticker;
                    if (sticker != null) {
                        sticker.setState(StickerState.AVAILABLE);
                    }
                    copyOnWriteArrayList = StickerManager.n;
                    copyOnWriteArrayList.add(this.$id);
                    p<String, Boolean, u> pVar = this.$action;
                    if (pVar != null) {
                        pVar.invoke(this.$id, Boxing.boxBoolean(true));
                    }
                } else {
                    Sticker sticker2 = this.$sticker;
                    if (sticker2 != null) {
                        sticker2.setState(StickerState.NOT_DOWNLOADED);
                    }
                    hashMap = StickerManager.r;
                    d dVar = (d) hashMap.get(this.$id);
                    if (dVar != null) {
                        dVar.b(100);
                    }
                    p<String, Boolean, u> pVar2 = this.$action;
                    if (pVar2 != null) {
                        pVar2.invoke(this.$id, Boxing.boxBoolean(false));
                    }
                }
                return u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(p<? super String, ? super Boolean, u> pVar, StickerDetail stickerDetail, Sticker sticker) {
            super(4);
            this.$action = pVar;
            this.$stickerDetail = stickerDetail;
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.b.r
        public /* bridge */ /* synthetic */ u invoke(String str, String str2, String str3, Boolean bool) {
            invoke(str, str2, str3, bool.booleanValue());
            return u.a;
        }

        public final void invoke(String id, String displayDir, String packageDir, boolean z) {
            HashMap hashMap;
            s.h(id, "id");
            s.h(displayDir, "displayDir");
            s.h(packageDir, "packageDir");
            if (z) {
                l.d(n0.a(z0.b()), null, null, new AnonymousClass1(this.$stickerDetail, displayDir, packageDir, this.$sticker, id, this.$action, null), 3, null);
                return;
            }
            StickerManager.a.B(id);
            hashMap = StickerManager.r;
            d dVar = (d) hashMap.get(id);
            if (dVar != null) {
                dVar.b(100);
            }
            p<String, Boolean, u> pVar = this.$action;
            if (pVar == null) {
                return;
            }
            pVar.invoke(id, Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StickerManager$downloadAndInstallSticker$1(Sticker sticker, String str, boolean z, p<? super String, ? super Boolean, u> pVar, Continuation<? super StickerManager$downloadAndInstallSticker$1> continuation) {
        super(2, continuation);
        this.$sticker = sticker;
        this.$stickerId = str;
        this.$isBuiltIn = z;
        this.$action = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new StickerManager$downloadAndInstallSticker$1(this.$sticker, this.$stickerId, this.$isBuiltIn, this.$action, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((StickerManager$downloadAndInstallSticker$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.repository2020.database.sticker.StickerManager$downloadAndInstallSticker$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
