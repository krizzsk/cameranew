package us.pinguo.edit2020.viewmodel.module;

import androidx.annotation.ColorInt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.edit2020.manager.HistoryRecord;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.foundation.statistics.h;
import us.pinguo.processor.i;
import us.pinguo.repository2020.FilterConstants;
import us.pinguo.repository2020.database.filter.FilterPackageTable;
import us.pinguo.repository2020.entity.BaseFilter;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.repository2020.entity.FilterPackage;
import us.pinguo.repository2020.manager.FilterHistoryManager;
import us.pinguo.repository2020.manager.FilterRepository;
import us.pinguo.repository2020.u;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* compiled from: EditFilterModule.kt */
/* loaded from: classes4.dex */
public final class EditFilterModule extends CameraFilterModule {
    private final EditRender m;
    private final u<FilterEntry> n;
    private FilterEntry o;
    private HashMap<String, FilterEntry> p;
    private boolean q;

    public EditFilterModule(EditRender render) {
        s.h(render, "render");
        this.m = render;
        this.n = new u<>(FilterConstants.f());
        this.p = new HashMap<>();
        this.q = true;
    }

    public static /* synthetic */ void w0(EditFilterModule editFilterModule, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = -1118482;
        }
        editFilterModule.v0(i2);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void J(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, Integer num, Float f9) {
        UnityEditCaller.SkyChange.INSTANCE.setSkyChangeParameter(f2, f3, f4, f5, f6, f7, f8, num, f9, true);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public boolean R() {
        return this.q;
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void c0() {
        FilterRepository.a.J(true);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void d(float f2) {
        UnityEditCaller.SkyChange.setSkyChangeParameter$default(UnityEditCaller.SkyChange.INSTANCE, null, null, null, Float.valueOf(f2), null, null, null, null, null, false, 1015, null);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void d0() {
        BaseFilter g2;
        Integer value = s().getValue();
        if (value == null) {
            return;
        }
        FilterEntry value2 = y().getValue();
        String itemId = value2 == null ? null : value2.getItemId();
        if (itemId == null || (g2 = FilterRepository.a.g(itemId)) == null) {
            return;
        }
        g2.setOpacityOnlyMemory(value.intValue());
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void e(int i2) {
        UnityEditCaller.SkyChange.setSkyChangeParameter$default(UnityEditCaller.SkyChange.INSTANCE, null, null, null, null, null, null, null, Integer.valueOf(i2), null, false, 895, null);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void f(float f2) {
        UnityEditCaller.SkyChange.setSkyChangeParameter$default(UnityEditCaller.SkyChange.INSTANCE, Float.valueOf(f2), null, null, null, null, null, null, null, null, false, 1022, null);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void g(float f2) {
        UnityEditCaller.SkyChange.setSkyChangeParameter$default(UnityEditCaller.SkyChange.INSTANCE, null, null, null, null, null, Float.valueOf(f2), null, null, null, false, 991, null);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void h() {
        UnityEditCaller.SkyChange.INSTANCE.cleanSkyChangeRenderAssets();
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void h0(boolean z) {
        UnityEditCaller.Filter.setIsFilterPreviewMode(z);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public void k0(String maskFilePath) {
        s.h(maskFilePath, "maskFilePath");
        UnityEditCaller.SkyChange.INSTANCE.setSkyChangeMask(maskFilePath);
    }

    public final boolean n0(EditModel model) {
        s.h(model, "model");
        return this.m.o(model);
    }

    public final void o0(boolean z) {
        this.m.n1(z);
    }

    public final HashMap<String, FilterEntry> p0() {
        return this.p;
    }

    public final EditRender q0() {
        return this.m;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @Override // us.pinguo.common.filter.CameraFilterModule
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(kotlin.coroutines.Continuation<? super java.lang.Integer> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof us.pinguo.edit2020.viewmodel.module.EditFilterModule$getCurrentFilterOpacity$1
            if (r0 == 0) goto L13
            r0 = r10
            us.pinguo.edit2020.viewmodel.module.EditFilterModule$getCurrentFilterOpacity$1 r0 = (us.pinguo.edit2020.viewmodel.module.EditFilterModule$getCurrentFilterOpacity$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.edit2020.viewmodel.module.EditFilterModule$getCurrentFilterOpacity$1 r0 = new us.pinguo.edit2020.viewmodel.module.EditFilterModule$getCurrentFilterOpacity$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r1 = r0.L$1
            us.pinguo.repository2020.entity.BaseFilter r1 = (us.pinguo.repository2020.entity.BaseFilter) r1
            java.lang.Object r0 = r0.L$0
            us.pinguo.repository2020.entity.BaseFilter r0 = (us.pinguo.repository2020.entity.BaseFilter) r0
            kotlin.j.b(r10)
            goto L99
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
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
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r10
        L58:
            us.pinguo.repository2020.manager.FilterRepository r5 = us.pinguo.repository2020.manager.FilterRepository.a
            us.pinguo.repository2020.entity.BaseFilter r6 = r5.g(r10)
            if (r6 != 0) goto L65
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r10
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
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r10
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
            r0 = r6
            r1 = r0
        L99:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r1.setOpacityOnlyMemory(r10)
            r6 = r0
            goto Lb3
        La4:
            boolean r10 = r9.T(r2, r10)
            if (r10 == 0) goto Lb0
            r10 = 100
            r6.setOpacityOnlyMemory(r10)
            goto Lb3
        Lb0:
            r6.setOpacityOnlyMemory(r4)
        Lb3:
            int r10 = r6.getOpacity()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.EditFilterModule.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void r0(boolean z) {
        this.o = z ? null : y().getValue();
    }

    public final void s0(String path) {
        s.h(path, "path");
        FilterEntry filterEntry = this.o;
        if (filterEntry != null) {
            p0().put(path, filterEntry);
        }
        this.o = null;
    }

    public final void t0(FilterEntry entry, l<? super Boolean, kotlin.u> lVar) {
        String itemId;
        FilterPackageTable packageBean;
        String packageMd5;
        s.h(entry, "entry");
        String pkgId = entry.getPkgId();
        if (pkgId == null || (itemId = entry.getItemId()) == null) {
            return;
        }
        FilterRepository filterRepository = FilterRepository.a;
        if (filterRepository.u(pkgId) == 1) {
            FilterPackage s = filterRepository.s(pkgId);
            if (s == null || (packageBean = s.getPackageBean()) == null || (packageMd5 = packageBean.getPackageMd5()) == null) {
                return;
            }
            String d2 = us.pinguo.common.filter.util.a.a.d(packageMd5);
            q0().x(false);
            q0().w(s.q(d2, itemId));
            return;
        }
        us.pinguo.processor.d k2 = k(false);
        if (k2 == null) {
            return;
        }
        h.b.A(entry.getItemId(), "preview");
        if (i.a.g(k2)) {
            if (lVar != null) {
                lVar.invoke(Boolean.TRUE);
            }
            q0().x(true);
            q0().t(k2);
            return;
        }
        q0().x(false);
        q0().v(k2);
    }

    public final void u0() {
        BaseFilter g2;
        Integer value;
        FilterEntry value2 = y().getValue();
        String itemId = value2 == null ? null : value2.getItemId();
        if (itemId == null || (g2 = FilterRepository.a.g(itemId)) == null || (value = v().getValue()) == null) {
            return;
        }
        g2.setTemplateOpacity(value.intValue());
    }

    public final void v0(@ColorInt int i2) {
        this.m.r0(i2);
    }

    public final void x0(float f2) {
        this.m.A0(f2);
    }

    @Override // us.pinguo.common.filter.CameraFilterModule
    public u<FilterEntry> y() {
        return this.n;
    }

    public final void y0(List<HistoryRecord> list) {
        Object obj;
        LinkedList linkedList = new LinkedList();
        Set<String> keySet = this.p.keySet();
        s.g(keySet, "filterRecordMap.keys");
        if (list != null) {
            for (String str : keySet) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (s.c(((HistoryRecord) obj).getPicturePath(), str)) {
                        break;
                    }
                }
                if (((HistoryRecord) obj) != null) {
                    FilterEntry filterEntry = p0().get(str);
                    s.e(filterEntry);
                    linkedList.add(filterEntry);
                }
            }
        }
        FilterHistoryManager.a.c("history_position_edit", linkedList);
        this.p.clear();
    }
}
