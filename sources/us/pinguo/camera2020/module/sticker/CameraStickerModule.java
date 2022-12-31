package us.pinguo.camera2020.module.sticker;

import android.content.SharedPreferences;
import android.util.LruCache;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.model.render.UnityRender;
import us.pinguo.common.log.a;
import us.pinguo.foundation.base.e;
import us.pinguo.processor.d;
import us.pinguo.repository2020.database.sticker.Sticker;
import us.pinguo.repository2020.database.sticker.StickerCategory;
import us.pinguo.repository2020.database.sticker.StickerManager;
import us.pinguo.repository2020.database.sticker.StickerRenderData;
import us.pinguo.repository2020.database.sticker.StickerState;
import us.pinguo.repository2020.m;
import us.pinguo.repository2020.u;
import us.pinguo.util.v;
/* compiled from: CameraStickerModule.kt */
/* loaded from: classes3.dex */
public final class CameraStickerModule implements LifecycleObserver {
    private final UnityRender a;
    private final u<Sticker> b;
    private final u<String> c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, Integer> f9245d;

    /* renamed from: e  reason: collision with root package name */
    private String f9246e;

    /* renamed from: f  reason: collision with root package name */
    private final LruCache<String, d> f9247f;

    public CameraStickerModule(UnityRender unityRender) {
        s.h(unityRender, "unityRender");
        this.a = unityRender;
        this.b = new u<>();
        this.c = new u<>();
        this.f9245d = new HashMap<>();
        this.f9247f = new LruCache<>(20);
    }

    public static /* synthetic */ void L(CameraStickerModule cameraStickerModule, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        cameraStickerModule.K(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.String r14, kotlin.coroutines.Continuation<? super java.lang.String[]> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof us.pinguo.camera2020.module.sticker.CameraStickerModule$assembleUnityRenderParam$1
            if (r0 == 0) goto L13
            r0 = r15
            us.pinguo.camera2020.module.sticker.CameraStickerModule$assembleUnityRenderParam$1 r0 = (us.pinguo.camera2020.module.sticker.CameraStickerModule$assembleUnityRenderParam$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.camera2020.module.sticker.CameraStickerModule$assembleUnityRenderParam$1 r0 = new us.pinguo.camera2020.module.sticker.CameraStickerModule$assembleUnityRenderParam$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L41
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r14 = r0.L$0
            us.pinguo.repository2020.database.sticker.StickerRenderData r14 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r14
            kotlin.j.b(r15)
            goto L66
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            java.lang.Object r14 = r0.L$0
            java.lang.String r14 = (java.lang.String) r14
            kotlin.j.b(r15)
            goto L51
        L41:
            kotlin.j.b(r15)
            us.pinguo.repository2020.database.sticker.StickerManager r15 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.L$0 = r14
            r0.label = r5
            java.lang.Object r15 = r15.F(r14, r0)
            if (r15 != r1) goto L51
            return r1
        L51:
            us.pinguo.repository2020.database.sticker.StickerRenderData r15 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r15
            if (r15 != 0) goto L56
            return r3
        L56:
            us.pinguo.repository2020.database.sticker.StickerManager r2 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.L$0 = r15
            r0.label = r4
            java.lang.Object r14 = r2.I(r14, r0)
            if (r14 != r1) goto L63
            return r1
        L63:
            r12 = r15
            r15 = r14
            r14 = r12
        L66:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L6b
            return r3
        L6b:
            us.pinguo.repository2020.database.sticker.StickerUnity r0 = r14.getUnity()
            java.lang.String r0 = r0.getFolder()
            java.lang.String r15 = kotlin.jvm.internal.s.q(r15, r0)
            us.pinguo.repository2020.database.sticker.StickerUnity r14 = r14.getUnity()
            java.lang.String r6 = r14.getParams()
            char[] r7 = new char[r5]
            r14 = 44
            r0 = 0
            r7[r0] = r14
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            java.util.List r14 = kotlin.text.l.o0(r6, r7, r8, r9, r10, r11)
            java.lang.Object r1 = r14.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r14 = r14.get(r5)
            r6 = r14
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            char[] r7 = new char[r5]
            r14 = 47
            r7[r0] = r14
            java.util.List r2 = kotlin.text.l.o0(r6, r7, r8, r9, r10, r11)
            int r3 = r2.size()
            int r3 = r3 - r5
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String[] r3 = new java.lang.String[r4]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r15)
            r4.append(r14)
            r4.append(r1)
            java.lang.String r14 = r4.toString()
            r3[r0] = r14
            r3[r5] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.g(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void j(String str) {
        StickerManager.a.B(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Sticker m(String str) {
        return StickerManager.a.H(str);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        StickerManager stickerManager = StickerManager.a;
        stickerManager.g0();
        stickerManager.f0();
        a.e("ohb", "StickerModule onPause()");
        int size = stickerManager.L().size();
        if (size != e.b(v.a(), "sticker_installed")) {
            e.f(v.a(), "sticker_installed", size);
        }
    }

    public final boolean A() {
        SharedPreferences preference = us.pinguo.foundation.e.b().getSharedPreferences("sticker_preference", 0);
        boolean z = preference.getBoolean("fresh_sticker_user", true);
        if (z) {
            s.g(preference, "preference");
            SharedPreferences.Editor editor = preference.edit();
            s.g(editor, "editor");
            editor.putBoolean("fresh_sticker_user", false);
            editor.commit();
        }
        return z;
    }

    public final void B() {
        Sticker value = this.b.getValue();
        String pid = value == null ? null : value.getPid();
        if (pid == null) {
            return;
        }
        l.d(n0.a(z0.b()), null, null, new CameraStickerModule$loadStickerAdjustValue$1(pid, this, null), 3, null);
    }

    public final void C(String id, LifecycleOwner owner, Observer<Integer> observer) {
        s.h(id, "id");
        s.h(owner, "owner");
        s.h(observer, "observer");
        us.pinguo.repository2020.database.sticker.d dVar = new us.pinguo.repository2020.database.sticker.d();
        dVar.observe(owner, observer);
        StickerManager.a.b0(id, dVar);
    }

    public final void D(String id) {
        s.h(id, "id");
        StickerManager.a.a0(id);
    }

    public final v1 E() {
        String pid;
        v1 d2;
        Sticker value = this.b.getValue();
        if (value == null || (pid = value.getPid()) == null) {
            return null;
        }
        d2 = l.d(n0.a(z0.b()), null, null, new CameraStickerModule$reloadSticker$1$1(this, pid, null), 3, null);
        return d2;
    }

    public final void F(List<String> idList) {
        s.h(idList, "idList");
        StickerManager.a.c0(idList);
    }

    public final void G() {
        String r = m.a.r();
        if (r != null) {
            Sticker value = this.b.getValue();
            if (s.c(r, value == null ? null : value.getPid())) {
                return;
            }
            l.d(n0.a(z0.b()), null, null, new CameraStickerModule$restoreStickerIfAny$1(this, r, null), 3, null);
        }
    }

    public final void H(float f2) {
        this.a.h0(f2);
    }

    public final void I(float f2) {
        this.a.q0(f2);
    }

    public final void J(String id) {
        s.h(id, "id");
        l.d(n0.a(z0.b()), null, null, new CameraStickerModule$stickerClicked$1(this, id, null), 3, null);
    }

    public final void K(String id, boolean z) {
        s.h(id, "id");
        Sticker value = this.b.getValue();
        if (!s.c(id, value == null ? null : value.getPid()) || z) {
            this.f9246e = null;
            l.d(n0.a(z0.b()), null, null, new CameraStickerModule$switchSticker$1(this, id, null), 3, null);
        }
    }

    public final void M(int i2) {
        String value = this.c.getValue();
        if (value == null) {
            return;
        }
        this.f9245d.put(value, Integer.valueOf(i2));
        Sticker value2 = this.b.getValue();
        String pid = value2 == null ? null : value2.getPid();
        if (pid == null) {
            return;
        }
        SharedPreferences preference = us.pinguo.foundation.e.b().getSharedPreferences("sticker_preference", 0);
        s.g(preference, "preference");
        SharedPreferences.Editor editor = preference.edit();
        s.g(editor, "editor");
        editor.putInt(pid + '_' + value, i2);
        editor.commit();
    }

    public final void h() {
        this.f9246e = null;
    }

    public final boolean i() {
        if (this.b.getValue() == null) {
            return false;
        }
        this.b.postValue(null);
        return true;
    }

    public final void k(String id, boolean z, kotlin.jvm.b.l<? super Boolean, kotlin.u> action) {
        Object obj;
        boolean z2;
        s.h(id, "id");
        s.h(action, "action");
        StickerManager stickerManager = StickerManager.a;
        List<String> L = stickerManager.L();
        if (L.size() >= 100) {
            List<Sticker> e0 = stickerManager.e0();
            Iterator<T> it = L.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str = (String) obj;
                boolean z3 = false;
                if (!s.c(str, "5e6a360fa35dde3d3e028c2d")) {
                    if (!(e0 instanceof Collection) || !e0.isEmpty()) {
                        for (Sticker sticker : e0) {
                            if (s.c(str, sticker.getPid())) {
                                z2 = false;
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        z3 = true;
                        continue;
                    } else {
                        continue;
                    }
                }
                if (z3) {
                    break;
                }
            }
            String str2 = (String) obj;
            if (str2 != null) {
                j(str2);
            }
        }
        if (z) {
            this.f9246e = id;
        }
        StickerManager stickerManager2 = StickerManager.a;
        stickerManager2.C(id, stickerManager2.U(id), new CameraStickerModule$downloadAndInstallSticker$2(action, z, id, this));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.camera2020.module.sticker.CameraStickerModule$findBuiltinMakeupName$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.camera2020.module.sticker.CameraStickerModule$findBuiltinMakeupName$1 r0 = (us.pinguo.camera2020.module.sticker.CameraStickerModule$findBuiltinMakeupName$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.camera2020.module.sticker.CameraStickerModule$findBuiltinMakeupName$1 r0 = new us.pinguo.camera2020.module.sticker.CameraStickerModule$findBuiltinMakeupName$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            us.pinguo.repository2020.database.sticker.StickerManager r6 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.label = r3
            java.lang.Object r6 = r6.F(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            us.pinguo.repository2020.database.sticker.StickerRenderData r6 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r6
            r5 = 0
            if (r6 != 0) goto L45
            return r5
        L45:
            us.pinguo.repository2020.database.sticker.StickerBeauty r6 = r6.getBeauty()
            if (r6 != 0) goto L4d
        L4b:
            r6 = r5
            goto L58
        L4d:
            us.pinguo.repository2020.database.sticker.StickerBeautyAndroid r6 = r6.getAndroid()
            if (r6 != 0) goto L54
            goto L4b
        L54:
            java.lang.String r6 = r6.getBeautyMakeup2()
        L58:
            if (r6 != 0) goto L5b
            return r5
        L5b:
            java.lang.String r0 = "none"
            boolean r0 = kotlin.jvm.internal.s.c(r6, r0)
            if (r0 != 0) goto L64
            r5 = r6
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.l(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(java.lang.String r17, java.lang.String r18, kotlin.coroutines.Continuation<? super us.pinguo.processor.d> r19) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.n(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinMakeup$1
            if (r0 == 0) goto L13
            r0 = r7
            us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinMakeup$1 r0 = (us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinMakeup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinMakeup$1 r0 = new us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinMakeup$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            kotlin.j.b(r7)
            goto L46
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.j.b(r7)
            us.pinguo.repository2020.database.sticker.StickerManager r7 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.I(r5, r0)
            if (r7 != r1) goto L46
            return r1
        L46:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 != 0) goto L4c
            r5 = 0
            return r5
        L4c:
            java.lang.String r5 = kotlin.jvm.internal.s.q(r7, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.o(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r9, kotlin.coroutines.Continuation<? super java.lang.String> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinShape$1
            if (r0 == 0) goto L13
            r0 = r10
            us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinShape$1 r0 = (us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinShape$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinShape$1 r0 = new us.pinguo.camera2020.module.sticker.CameraStickerModule$findStickerBuiltinShape$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L49
            if (r2 == r5) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.j.b(r10)
            goto Lb2
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.j.b(r10)
            goto L8e
        L41:
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.j.b(r10)
            goto L59
        L49:
            kotlin.j.b(r10)
            us.pinguo.repository2020.database.sticker.StickerManager r10 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r10 = r10.F(r9, r0)
            if (r10 != r1) goto L59
            return r1
        L59:
            us.pinguo.repository2020.database.sticker.StickerRenderData r10 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r10
            if (r10 != 0) goto L5e
            return r6
        L5e:
            us.pinguo.repository2020.database.sticker.StickerBeauty r10 = r10.getBeauty()
            if (r10 != 0) goto L66
        L64:
            r10 = r6
            goto L71
        L66:
            us.pinguo.repository2020.database.sticker.StickerBeautyAndroid r10 = r10.getAndroid()
            if (r10 != 0) goto L6d
            goto L64
        L6d:
            java.lang.String r10 = r10.getSkinShapes()
        L71:
            if (r10 == 0) goto L7b
            boolean r2 = kotlin.text.l.p(r10)
            if (r2 == 0) goto L7a
            goto L7b
        L7a:
            r5 = 0
        L7b:
            if (r5 == 0) goto L7e
            return r6
        L7e:
            us.pinguo.repository2020.database.sticker.StickerManager r2 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r9 = r2.I(r9, r0)
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r7 = r10
            r10 = r9
            r9 = r7
        L8e:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L93
            return r6
        L93:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            r2.append(r9)
            java.lang.String r9 = "/index.json"
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r10 = us.pinguo.util.FileIOUtils.g(r9, r0)
            if (r10 != r1) goto Lb2
            return r1
        Lb2:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.p(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<Sticker> q(String categoryID) {
        Object obj;
        s.h(categoryID, "categoryID");
        if (s.c(categoryID, "recent_")) {
            return StickerManager.a.e0();
        }
        List<StickerCategory> N = StickerManager.a.N();
        if (N == null) {
            return null;
        }
        Iterator<T> it = N.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (s.c(((StickerCategory) obj).getTopic_id(), categoryID)) {
                break;
            }
        }
        StickerCategory stickerCategory = (StickerCategory) obj;
        if (stickerCategory == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(stickerCategory.getPackage_ids().length);
        for (String str : stickerCategory.getPackage_ids()) {
            Sticker m = m(str);
            if (m != null) {
                arrayList.add(m);
            }
        }
        return arrayList;
    }

    public final u<String> r() {
        return this.c;
    }

    public final Integer s(String type) {
        s.h(type, "type");
        return this.f9245d.get(type);
    }

    public final List<StickerCategory> t() {
        return StickerManager.a.N();
    }

    public final LiveData<Sticker> u() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.lang.String r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof us.pinguo.camera2020.module.sticker.CameraStickerModule$getDefaultValue$1
            if (r0 == 0) goto L13
            r0 = r8
            us.pinguo.camera2020.module.sticker.CameraStickerModule$getDefaultValue$1 r0 = (us.pinguo.camera2020.module.sticker.CameraStickerModule$getDefaultValue$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.camera2020.module.sticker.CameraStickerModule$getDefaultValue$1 r0 = new us.pinguo.camera2020.module.sticker.CameraStickerModule$getDefaultValue$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.j.b(r8)
            r4 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            goto L56
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.j.b(r8)
            r8 = 70
            if (r7 != 0) goto L47
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            return r6
        L47:
            us.pinguo.repository2020.database.sticker.StickerManager r2 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.L$0 = r6
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r7 = r2.F(r7, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            us.pinguo.repository2020.database.sticker.StickerRenderData r7 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r7
            java.lang.String r0 = "filter"
            boolean r0 = kotlin.jvm.internal.s.c(r6, r0)
            r1 = 100
            if (r0 == 0) goto L78
            r6 = 1060320051(0x3f333333, float:0.7)
            if (r7 != 0) goto L68
            goto L73
        L68:
            java.lang.Float r7 = r7.getFilterDisplayStrength()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            float r6 = r7.floatValue()
        L73:
            float r7 = (float) r1
            float r6 = r6 * r7
            int r8 = (int) r6
            goto L92
        L78:
            java.lang.String r0 = "makeup"
            boolean r6 = kotlin.jvm.internal.s.c(r6, r0)
            if (r6 == 0) goto L92
            r6 = 1061997773(0x3f4ccccd, float:0.8)
            if (r7 != 0) goto L86
            goto L73
        L86:
            java.lang.Float r7 = r7.getMakeupDisplayStrength()
            if (r7 != 0) goto L8d
            goto L73
        L8d:
            float r6 = r7.floatValue()
            goto L73
        L92:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.v(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object w(String str, Continuation<? super StickerState> continuation) {
        StickerManager.a.L();
        Sticker m = m(str);
        StickerState state = m == null ? null : m.getState();
        return state == null ? StickerState.NOT_DOWNLOADED : state;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof us.pinguo.camera2020.module.sticker.CameraStickerModule$getStickerTouchMode$1
            if (r0 == 0) goto L13
            r0 = r6
            us.pinguo.camera2020.module.sticker.CameraStickerModule$getStickerTouchMode$1 r0 = (us.pinguo.camera2020.module.sticker.CameraStickerModule$getStickerTouchMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.camera2020.module.sticker.CameraStickerModule$getStickerTouchMode$1 r0 = new us.pinguo.camera2020.module.sticker.CameraStickerModule$getStickerTouchMode$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.j.b(r6)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.j.b(r6)
            us.pinguo.repository2020.database.sticker.StickerManager r6 = us.pinguo.repository2020.database.sticker.StickerManager.a
            r0.label = r3
            java.lang.Object r6 = r6.F(r5, r0)
            if (r6 != r1) goto L3f
            return r1
        L3f:
            us.pinguo.repository2020.database.sticker.StickerRenderData r6 = (us.pinguo.repository2020.database.sticker.StickerRenderData) r6
            if (r6 != 0) goto L45
            r5 = 0
            goto L49
        L45:
            int r5 = r6.getUnityTouchMode()
        L49:
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera2020.module.sticker.CameraStickerModule.x(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int y(String id) {
        s.h(id, "id");
        StickerRenderData G = StickerManager.a.G(id);
        if (G == null) {
            return 0;
        }
        return G.getUnityTouchMode();
    }

    public final boolean z() {
        Sticker[] O = StickerManager.a.O();
        if (O == null) {
            return false;
        }
        for (Sticker sticker : O) {
            if (sticker.isFresh()) {
                return true;
            }
        }
        return false;
    }
}
