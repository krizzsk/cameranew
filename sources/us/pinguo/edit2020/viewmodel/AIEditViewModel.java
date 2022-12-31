package us.pinguo.edit2020.viewmodel;

import android.app.Application;
import android.content.Intent;
import android.media.ExifInterface;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelKt;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.File;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.controller.EditTabType;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.viewmodel.module.e;
import us.pinguo.image.saver.Saver2020;
import us.pinguo.util.j;
/* compiled from: AIEditViewModel.kt */
/* loaded from: classes4.dex */
public final class AIEditViewModel extends AndroidViewModel implements LifecycleObserver {
    private final us.pinguo.edit2020.viewmodel.module.b a;
    private boolean b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private int f10800d;

    /* renamed from: e  reason: collision with root package name */
    private List<HistoryRecord> f10801e;

    /* renamed from: f  reason: collision with root package name */
    private List<? extends x> f10802f;

    /* renamed from: g  reason: collision with root package name */
    public e f10803g;

    /* renamed from: h  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f10804h;

    /* renamed from: i  reason: collision with root package name */
    private final us.pinguo.repository2020.u<String> f10805i;

    /* renamed from: j  reason: collision with root package name */
    private final f f10806j;

    /* compiled from: AIEditViewModel.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EditTabType.values().length];
            iArr[EditTabType.AI_EDIT.ordinal()] = 1;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEditViewModel(Application application) {
        super(application);
        f a2;
        s.h(application, "application");
        System.currentTimeMillis();
        this.a = new us.pinguo.edit2020.viewmodel.module.b();
        this.c = "";
        this.f10800d = -1;
        this.f10805i = new us.pinguo.repository2020.u<>();
        a2 = h.a(LazyThreadSafetyMode.NONE, AIEditViewModel$_resultChannel$2.INSTANCE);
        this.f10806j = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.channels.e<ActivityResult> h() {
        return (kotlinx.coroutines.channels.e) this.f10806j.getValue();
    }

    public final void b(l<? super String, u> lVar) {
        HistoryRecord c = e().a().c();
        if (c == null) {
            CrashReport.postCatchedException(new IllegalArgumentException("empty record"));
            return;
        }
        String picturePath = c.getPicturePath();
        if (!new File(picturePath).exists()) {
            CrashReport.postCatchedException(new IllegalStateException(s.q("no such file:", picturePath)));
            return;
        }
        try {
            int attributeInt = new ExifInterface(picturePath).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            Saver2020.a.e(picturePath, attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : BaseBlurEffect.ROTATION_270 : 90 : BaseBlurEffect.ROTATION_180, null, null, j.d(e().a().e().get(0).getPicturePath()), false, true, new AIEditViewModel$finalSave$1(lVar));
        } catch (Exception e2) {
            e2.printStackTrace();
            CrashReport.postCatchedException(e2);
        }
    }

    public final us.pinguo.edit2020.viewmodel.module.b c() {
        return this.a;
    }

    public final void clear() {
    }

    public final String d() {
        return this.c;
    }

    public final e e() {
        e eVar = this.f10803g;
        if (eVar != null) {
            return eVar;
        }
        s.z("editHistoryModule");
        throw null;
    }

    public final kotlin.jvm.b.a<u> f() {
        return this.f10804h;
    }

    public final List<x> g() {
        return this.f10802f;
    }

    public final void i() {
        int i2;
        n(new e(this.f10801e, this.f10800d));
        List<HistoryRecord> list = this.f10801e;
        if ((list == null || list.isEmpty()) || (i2 = this.f10800d) < 0 || i2 >= list.size()) {
            return;
        }
        this.c = list.get(this.f10800d).getPicturePath();
    }

    public final boolean j() {
        return this.b;
    }

    public final void k(EditTabType tabType, kotlin.jvm.b.a<u> saveEndAction) {
        boolean z;
        s.h(tabType, "tabType");
        s.h(saveEndAction, "saveEndAction");
        if (a.a[tabType.ordinal()] == 1) {
            z = this.a.c(this.a.a());
        } else {
            z = false;
        }
        kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new AIEditViewModel$save$1(z, this, saveEndAction, null), 3, null);
    }

    public final void l(ActivityResult result) {
        s.h(result, "result");
        kotlinx.coroutines.l.d(ViewModelKt.getViewModelScope(this), null, null, new AIEditViewModel$sendActivityResult$1(this, result, null), 3, null);
    }

    public final void m(String str) {
        s.h(str, "<set-?>");
        this.c = str;
    }

    public final void n(e eVar) {
        s.h(eVar, "<set-?>");
        this.f10803g = eVar;
    }

    public final void o(boolean z) {
        this.b = z;
    }

    public final void p(ActivityResultLauncher<Intent> activityResultLauncher) {
    }

    public final void q(boolean z) {
    }

    public final void r(List<? extends x> list) {
        this.f10802f = list;
    }
}
