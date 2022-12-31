package us.pinguo.edit2020.viewmodel.module;

import android.content.Intent;
import android.graphics.PointF;
import android.util.SizeF;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.coroutines.Continuation;
import kotlin.jvm.b.q;
import kotlin.jvm.b.w;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
import kotlinx.coroutines.l;
import kotlinx.coroutines.z0;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.bean.p0;
import us.pinguo.edit2020.bean.q0;
import us.pinguo.edit2020.bean.r0;
import us.pinguo.edit2020.bean.t0;
import us.pinguo.edit2020.bean.u0;
import us.pinguo.edit2020.bean.x;
import us.pinguo.edit2020.model.EditRender;
import us.pinguo.edit2020.repository.EditRepository;
import us.pinguo.foundation.utils.n0;
import us.pinguo.repository2020.database.staticsticker.StaticSticker;
import us.pinguo.repository2020.database.staticsticker.StaticStickerCategory;
import us.pinguo.repository2020.database.staticsticker.StaticStickerDetail;
import us.pinguo.repository2020.database.staticsticker.StaticStickerManager;
import us.pinguo.repository2020.database.staticsticker.Template;
import us.pinguo.repository2020.database.staticsticker.TemplateCategory;
import us.pinguo.repository2020.entity.Material;
import us.pinguo.repository2020.entity.MaterialInstallState;
import us.pinguo.u3dengine.api.PGEditBlendMode;
import us.pinguo.u3dengine.api.StaticStickerItem;
import us.pinguo.u3dengine.edit.BasicBrushMode;
import us.pinguo.u3dengine.edit.EditModel;
import us.pinguo.u3dengine.edit.UnityEditCaller;
import us.pinguo.util.v;
/* compiled from: StaticStickerModule.kt */
/* loaded from: classes4.dex */
public final class StaticStickerModule implements LifecycleObserver {
    private final EditRender a;
    private kotlinx.coroutines.flow.c<ActivityResult> b;
    private ActivityResultLauncher<Intent> c;

    /* renamed from: d  reason: collision with root package name */
    private float f10872d;

    /* renamed from: e  reason: collision with root package name */
    private final int f10873e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10874f;

    /* renamed from: g  reason: collision with root package name */
    private final Template f10875g;

    /* renamed from: h  reason: collision with root package name */
    private StaticStickerCategory f10876h;

    /* renamed from: i  reason: collision with root package name */
    private StaticStickerCategory f10877i;

    /* renamed from: j  reason: collision with root package name */
    private TemplateCategory f10878j;

    /* renamed from: k  reason: collision with root package name */
    private TemplateCategory f10879k;

    /* renamed from: l  reason: collision with root package name */
    private Material f10880l;
    private Template m;
    private Template n;
    private int o;
    private Template p;
    private final StaticStickerManager q;
    private final HashMap<String, HashMap<String, q0>> r;
    private final HashMap<String, StaticStickerItem> s;
    private q0 t;
    private final EditRepository u;
    private final ArrayList<p0> v;
    private final ArrayList<us.pinguo.edit2020.model.f.a> w;
    private String x;

    public StaticStickerModule(EditRender editRender) {
        s.h(editRender, "editRender");
        this.a = editRender;
        this.f10872d = n0.i();
        this.f10873e = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_max_in_discrete_mode);
        this.f10874f = us.pinguo.foundation.e.b().getResources().getDimensionPixelSize(R.dimen.bold_tip_size_min_in_discrete_mode);
        Template template = new Template(Material.MATERIAL_SELECT_NONE_FLAG, Material.MATERIAL_SELECT_NONE_FLAG, v.a().getString(R.string.str_none), "ic_sticker_template_none_dark", "", 0, "", "", null, 0L, 0L);
        template.setInstallState(new ObservableField<>(MaterialInstallState.STATE_INSTALLED));
        if (template.isSelected() == null) {
            template.setSelected(new ObservableBoolean(true));
        }
        this.f10875g = template;
        this.m = template;
        this.n = template;
        this.q = StaticStickerManager.a;
        this.r = new HashMap<>();
        this.s = new HashMap<>();
        EditRepository editRepository = new EditRepository();
        this.u = editRepository;
        this.v = editRepository.c();
        this.w = editRepository.f();
        this.x = "";
    }

    public static /* synthetic */ void F0(StaticStickerModule staticStickerModule, PGEditBlendMode pGEditBlendMode, Float f2, Boolean bool, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        staticStickerModule.E0(pGEditBlendMode, f2, bool, z);
    }

    private final StaticStickerCategory M(String str) {
        boolean m;
        List<StaticStickerCategory> L = L();
        Object obj = null;
        if (L == null) {
            return null;
        }
        Iterator<T> it = L.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String[] sids = ((StaticStickerCategory) next).getSids();
            boolean z = false;
            if (sids != null) {
                m = n.m(sids, str);
                if (m) {
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
            if (z) {
                obj = next;
                break;
            }
        }
        return (StaticStickerCategory) obj;
    }

    private final void e(q0 q0Var, StaticStickerItem staticStickerItem) {
        String f2 = q0Var.f();
        String key = staticStickerItem.getKey();
        if (key == null) {
            return;
        }
        HashMap<String, q0> hashMap = this.r.get(f2);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.r.put(f2, hashMap);
        }
        hashMap.put(key, q0Var);
        this.s.put(key, staticStickerItem);
        UnityEditCaller.StaticSticker.newStaticSticker(staticStickerItem);
    }

    private final float e0(us.pinguo.facedetector.b bVar, float f2) {
        float l2 = bVar.l(74);
        float m = bVar.m(74);
        float l3 = l2 - bVar.l(77);
        float m2 = m - bVar.m(77);
        return ((float) Math.sqrt((l3 * l3) + (m2 * m2))) / f2;
    }

    private final void j0(StaticStickerDetail staticStickerDetail) {
        HashMap<String, q0> hashMap;
        String sid = staticStickerDetail.getSid();
        if (sid == null || (hashMap = this.r.get(sid)) == null) {
            return;
        }
        Iterator<Map.Entry<String, q0>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, q0> next = it.next();
            if (next.getValue().g()) {
                this.s.remove(next.getKey());
                it.remove();
                UnityEditCaller.StaticSticker.deleteStaticStickerWithKey(next.getKey());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0630  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x02e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0123 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126  */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:255:0x0621 -> B:257:0x0624). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(us.pinguo.repository2020.database.staticsticker.StaticStickerDetail r40, boolean r41, boolean r42, boolean r43, android.util.SizeF r44, android.util.SizeF r45, boolean r46, kotlin.coroutines.Continuation<? super us.pinguo.edit2020.bean.q0> r47) {
        /*
            Method dump skipped, instructions count: 1590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.m(us.pinguo.repository2020.database.staticsticker.StaticStickerDetail, boolean, boolean, boolean, android.util.SizeF, android.util.SizeF, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object n(StaticStickerModule staticStickerModule, StaticStickerDetail staticStickerDetail, boolean z, boolean z2, boolean z3, SizeF sizeF, SizeF sizeF2, boolean z4, Continuation continuation, int i2, Object obj) {
        return staticStickerModule.m(staticStickerDetail, z, z2, z3, sizeF, sizeF2, (i2 & 64) != 0 ? true : z4, continuation);
    }

    public final StaticStickerItem A() {
        return this.s.get(this.x);
    }

    public final void A0(q<? super String, ? super Boolean, ? super Boolean, u> staticStickerLayerStatus) {
        s.h(staticStickerLayerStatus, "staticStickerLayerStatus");
        this.a.j1(staticStickerLayerStatus);
    }

    public final StaticStickerCategory B() {
        return this.f10876h;
    }

    public final void B0(w<? super String, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Float, ? super Integer, ? super Integer, u> wVar) {
        this.a.S0(wVar);
    }

    public final Template C() {
        return this.n;
    }

    public final void C0(StaticSticker sticker, StaticStickerCategory category, boolean z, kotlin.jvm.b.a<u> aVar) {
        s.h(sticker, "sticker");
        s.h(category, "category");
        String sid = sticker.getSid();
        if (sid == null) {
            return;
        }
        l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new StaticStickerModule$tryApplySticker$1(this, sid, sticker, category, z, aVar, null), 3, null);
    }

    public final TemplateCategory D() {
        return this.f10878j;
    }

    public final void D0() {
        this.q.H();
    }

    public final StaticStickerCategory E() {
        return this.f10877i;
    }

    public final void E0(PGEditBlendMode pGEditBlendMode, Float f2, Boolean bool, boolean z) {
        StaticStickerItem staticStickerItem = this.s.get(this.x);
        if (staticStickerItem == null) {
            return;
        }
        if (us.pinguo.edit2020.utils.d.d(pGEditBlendMode)) {
            staticStickerItem.setBlendMode(pGEditBlendMode);
        }
        if (us.pinguo.edit2020.utils.d.d(f2)) {
            staticStickerItem.setOpacity(f2);
        }
        if (us.pinguo.edit2020.utils.d.d(bool)) {
            staticStickerItem.setNeedRecordHistory(Integer.valueOf(s.c(bool, Boolean.TRUE) ? 1 : 0));
        }
        if (z) {
            UnityEditCaller.StaticSticker.updateCurrentStaticSticker(staticStickerItem);
        }
    }

    public final Template F() {
        return this.m;
    }

    public final TemplateCategory G() {
        return this.f10879k;
    }

    public final void G0(String key, Float f2, PointF pointF, PointF pointF2) {
        s.h(key, "key");
        StaticStickerItem staticStickerItem = this.s.get(key);
        if (staticStickerItem == null) {
            return;
        }
        staticStickerItem.setRotateAngle(f2);
        staticStickerItem.setCenter(pointF);
        staticStickerItem.setSize(pointF2);
        UnityEditCaller.StaticSticker.updateCurrentStaticSticker(staticStickerItem);
    }

    public final List<StaticSticker> H() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, StaticSticker> entry : this.q.t().entrySet()) {
            linkedList.addFirst(entry.getValue());
        }
        StaticSticker staticSticker = new StaticSticker(Material.MATERIAL_DUSTBIN, Material.MATERIAL_DUSTBIN, v.a().getString(R.string.sticker_management), "ic_static_sticker_dustbin", null, null, null);
        ObservableField<MaterialInstallState> installState = staticSticker.getInstallState();
        if (installState == null) {
            staticSticker.setInstallState(new ObservableField<>(MaterialInstallState.STATE_INSTALLED));
        } else {
            installState.set(MaterialInstallState.STATE_INSTALLED);
        }
        linkedList.addFirst(staticSticker);
        return linkedList;
    }

    public final ActivityResultLauncher<Intent> I() {
        return this.c;
    }

    public final kotlinx.coroutines.flow.c<ActivityResult> J() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[LOOP:1: B:15:0x0028->B:24:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0041 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final us.pinguo.repository2020.database.staticsticker.StaticStickerCategory K(us.pinguo.repository2020.database.staticsticker.Template r12) {
        /*
            r11 = this;
            java.util.List r0 = r11.L()
            r1 = 0
            if (r0 != 0) goto L8
            goto L4e
        L8:
            java.util.Iterator r0 = r0.iterator()
        Lc:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L4c
            java.lang.Object r2 = r0.next()
            r3 = r2
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r3 = (us.pinguo.repository2020.database.staticsticker.StaticStickerCategory) r3
            r4 = 1
            r5 = 0
            if (r12 != 0) goto L1f
        L1d:
            r4 = 0
            goto L49
        L1f:
            us.pinguo.repository2020.database.staticsticker.StaticStickerDetail[] r6 = r12.getStickers()
            if (r6 != 0) goto L26
            goto L1d
        L26:
            int r7 = r6.length
            r8 = 0
        L28:
            if (r8 >= r7) goto L46
            r9 = r6[r8]
            java.lang.String[] r10 = r3.getSids()
            if (r10 != 0) goto L34
        L32:
            r9 = 0
            goto L3f
        L34:
            java.lang.String r9 = r9.getSid()
            boolean r9 = kotlin.collections.j.m(r10, r9)
            if (r9 != r4) goto L32
            r9 = 1
        L3f:
            if (r9 != 0) goto L43
            r3 = 0
            goto L47
        L43:
            int r8 = r8 + 1
            goto L28
        L46:
            r3 = 1
        L47:
            if (r3 != r4) goto L1d
        L49:
            if (r4 == 0) goto Lc
            r1 = r2
        L4c:
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r1 = (us.pinguo.repository2020.database.staticsticker.StaticStickerCategory) r1
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.K(us.pinguo.repository2020.database.staticsticker.Template):us.pinguo.repository2020.database.staticsticker.StaticStickerCategory");
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0087 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0014 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<us.pinguo.repository2020.database.staticsticker.StaticStickerCategory> L() {
        /*
            r15 = this;
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r0 = r15.q
            java.util.List r0 = r0.w()
            r1 = 0
            if (r0 != 0) goto Lb
            goto Lcf
        Lb:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L14:
            boolean r3 = r0.hasNext()
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L8b
            java.lang.Object r3 = r0.next()
            r6 = r3
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r6 = (us.pinguo.repository2020.database.staticsticker.StaticStickerCategory) r6
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.String r9 = r6.getPid()
            java.lang.String r10 = "recent"
            boolean r9 = kotlin.jvm.internal.s.c(r9, r10)
            java.lang.String[] r10 = r6.getSids()
            if (r10 != 0) goto L39
        L37:
            r10 = 0
            goto L61
        L39:
            int r11 = r10.length
            r12 = 0
        L3b:
            if (r12 >= r11) goto L5d
            r13 = r10[r12]
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r14 = us.pinguo.repository2020.database.staticsticker.StaticStickerManager.a
            java.util.Map r14 = r14.s()
            java.lang.Object r13 = r14.get(r13)
            us.pinguo.repository2020.database.staticsticker.StaticStickerTable r13 = (us.pinguo.repository2020.database.staticsticker.StaticStickerTable) r13
            if (r13 != 0) goto L4f
        L4d:
            r13 = 0
            goto L56
        L4f:
            int r13 = r13.getFromTemplate()
            if (r13 != 0) goto L4d
            r13 = 1
        L56:
            if (r13 == 0) goto L5a
            r10 = 1
            goto L5e
        L5a:
            int r12 = r12 + 1
            goto L3b
        L5d:
            r10 = 0
        L5e:
            if (r10 != r4) goto L37
            r10 = 1
        L61:
            boolean r11 = r6.isValid(r7)
            if (r11 == 0) goto L7c
            boolean r7 = r6.duringDisplayTime(r7)
            if (r7 == 0) goto L7c
            java.lang.Integer r6 = r6.is_display_new()
            if (r6 != 0) goto L74
            goto L7c
        L74:
            int r6 = r6.intValue()
            if (r6 != r4) goto L7c
            r6 = 1
            goto L7d
        L7c:
            r6 = 0
        L7d:
            if (r9 != 0) goto L85
            if (r10 != 0) goto L85
            if (r6 == 0) goto L84
            goto L85
        L84:
            r4 = 0
        L85:
            if (r4 == 0) goto L14
            r2.add(r3)
            goto L14
        L8b:
            java.util.Iterator r0 = r2.iterator()
            r3 = 0
        L90:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto Lce
            java.lang.Object r6 = r0.next()
            int r7 = r3 + 1
            if (r3 < 0) goto Lca
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r6 = (us.pinguo.repository2020.database.staticsticker.StaticStickerCategory) r6
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r8 = r15.B()
            if (r8 != 0) goto Lba
            androidx.databinding.ObservableBoolean r8 = r6.isSelected()
            if (r8 != 0) goto Lc8
            androidx.databinding.ObservableBoolean r8 = new androidx.databinding.ObservableBoolean
            if (r3 != r4) goto Lb2
            r3 = 1
            goto Lb3
        Lb2:
            r3 = 0
        Lb3:
            r8.<init>(r3)
            r6.setSelected(r8)
            goto Lc8
        Lba:
            androidx.databinding.ObservableBoolean r3 = r6.isSelected()
            if (r3 != 0) goto Lc8
            androidx.databinding.ObservableBoolean r3 = new androidx.databinding.ObservableBoolean
            r3.<init>(r5)
            r6.setSelected(r3)
        Lc8:
            r3 = r7
            goto L90
        Lca:
            kotlin.collections.s.n()
            throw r1
        Lce:
            r1 = r2
        Lcf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.L():java.util.List");
    }

    public final int N(String str) {
        List<StaticStickerCategory> L = L();
        if (L == null) {
            return -1;
        }
        int i2 = 0;
        for (StaticStickerCategory staticStickerCategory : L) {
            if (s.c(str, staticStickerCategory.getPid())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043 A[LOOP:1: B:15:0x0028->B:24:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004d A[EDGE_INSN: B:32:0x004d->B:30:0x004d ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0041 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int O(us.pinguo.repository2020.database.staticsticker.Template r12) {
        /*
            r11 = this;
            java.util.List r0 = r11.L()
            if (r0 != 0) goto L8
            r12 = -1
            goto L51
        L8:
            java.util.Iterator r1 = r0.iterator()
        Lc:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L4c
            java.lang.Object r2 = r1.next()
            r3 = r2
            us.pinguo.repository2020.database.staticsticker.StaticStickerCategory r3 = (us.pinguo.repository2020.database.staticsticker.StaticStickerCategory) r3
            r4 = 1
            r5 = 0
            if (r12 != 0) goto L1f
        L1d:
            r4 = 0
            goto L49
        L1f:
            us.pinguo.repository2020.database.staticsticker.StaticStickerDetail[] r6 = r12.getStickers()
            if (r6 != 0) goto L26
            goto L1d
        L26:
            int r7 = r6.length
            r8 = 0
        L28:
            if (r8 >= r7) goto L46
            r9 = r6[r8]
            java.lang.String[] r10 = r3.getSids()
            if (r10 != 0) goto L34
        L32:
            r9 = 0
            goto L3f
        L34:
            java.lang.String r9 = r9.getSid()
            boolean r9 = kotlin.collections.j.m(r10, r9)
            if (r9 != r4) goto L32
            r9 = 1
        L3f:
            if (r9 != 0) goto L43
            r3 = 0
            goto L47
        L43:
            int r8 = r8 + 1
            goto L28
        L46:
            r3 = 1
        L47:
            if (r3 != r4) goto L1d
        L49:
            if (r4 == 0) goto Lc
            goto L4d
        L4c:
            r2 = 0
        L4d:
            int r12 = kotlin.collections.s.F(r0, r2)
        L51:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.O(us.pinguo.repository2020.database.staticsticker.Template):int");
    }

    public final List<StaticSticker> P(StaticStickerCategory category) {
        s.h(category, "category");
        ArrayList arrayList = new ArrayList();
        String[] sids = category.getSids();
        if (sids != null) {
            for (String str : sids) {
                StaticSticker staticSticker = this.q.y().get(str);
                if (staticSticker != null) {
                    Integer vip = category.getVip();
                    staticSticker.setVip((vip != null && vip.intValue() == 2) ? staticSticker.getVip() : 0);
                    arrayList.add(staticSticker);
                }
            }
        }
        return arrayList;
    }

    public final List<StaticSticker> Q(Template template) {
        List<StaticSticker> U;
        s.h(template, "template");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        StaticStickerDetail[] stickers = template.getStickers();
        if (stickers != null) {
            for (StaticStickerDetail staticStickerDetail : stickers) {
                StaticSticker staticSticker = this.q.y().get(staticStickerDetail.getSid());
                if (staticSticker != null) {
                    ObservableField<MaterialInstallState> installState = staticSticker.getInstallState();
                    if ((installState == null ? null : installState.get()) != MaterialInstallState.STATE_INSTALLED) {
                        linkedHashSet.add(staticSticker);
                    }
                }
                StaticStickerDetail[] children = staticStickerDetail.getChildren();
                if (children != null) {
                    for (StaticStickerDetail staticStickerDetail2 : children) {
                        StaticSticker staticSticker2 = this.q.y().get(staticStickerDetail2.getSid());
                        if (staticSticker2 != null) {
                            ObservableField<MaterialInstallState> installState2 = staticSticker2.getInstallState();
                            if ((installState2 == null ? null : installState2.get()) != MaterialInstallState.STATE_INSTALLED) {
                                linkedHashSet.add(staticSticker2);
                            }
                        }
                    }
                }
            }
        }
        U = c0.U(linkedHashSet);
        return U;
    }

    public final List<TemplateCategory> R() {
        List<TemplateCategory> z = this.q.z();
        if (z == null) {
            return null;
        }
        int i2 = 0;
        for (Object obj : z) {
            int i3 = i2 + 1;
            if (i2 >= 0) {
                TemplateCategory templateCategory = (TemplateCategory) obj;
                if (templateCategory.isSelected() == null) {
                    templateCategory.setSelected(new ObservableBoolean(i2 == 1));
                }
                i2 = i3;
            } else {
                kotlin.collections.s.n();
                throw null;
            }
        }
        return z;
    }

    public final int S(String str) {
        Object obj;
        int F;
        List<TemplateCategory> R = R();
        if (R == null) {
            return -1;
        }
        Iterator<T> it = R.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (s.c(str, ((TemplateCategory) obj).getCid())) {
                break;
            }
        }
        F = c0.F(R, obj);
        return F;
    }

    public final List<Template> T(TemplateCategory category) {
        ObservableBoolean isSelected;
        s.h(category, "category");
        ArrayList arrayList = new ArrayList();
        String[] tids = category.getTids();
        if (tids != null) {
            for (String str : tids) {
                Template template = this.q.A().get(str);
                if (template != null) {
                    ObservableField<MaterialInstallState> installState = template.getInstallState();
                    if (installState != null) {
                        installState.set(b0(template) ? MaterialInstallState.STATE_INSTALLED : MaterialInstallState.STATE_UNDOWNLOAD);
                    }
                    if (!b0(template)) {
                        ObservableBoolean isSelected2 = template.isSelected();
                        if ((isSelected2 != null && isSelected2.get()) && (isSelected = template.isSelected()) != null) {
                            isSelected.set(false);
                        }
                    }
                    arrayList.add(template);
                }
            }
        }
        arrayList.add(0, this.f10875g);
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Integer U(String str, String str2) {
        List<TemplateCategory> R = R();
        TemplateCategory templateCategory = null;
        if (R != null) {
            Iterator<T> it = R.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (s.c(((TemplateCategory) next).getCid(), str)) {
                    templateCategory = next;
                    break;
                }
            }
            templateCategory = templateCategory;
        }
        int i2 = -1;
        if (templateCategory != null) {
            List<Template> T = T(templateCategory);
            int i3 = 0;
            Iterator<Template> it2 = T.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (s.c(it2.next().getTid(), str2)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            return Integer.valueOf(i2);
        }
        return -1;
    }

    public final List<x> V() {
        ArrayList arrayList = new ArrayList();
        Collection<HashMap<String, q0>> values = this.r.values();
        s.g(values, "appliedStickers.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            HashMap map = (HashMap) it.next();
            s.g(map, "map");
            if (!map.isEmpty()) {
                Collection<q0> values2 = map.values();
                s.g(values2, "map.values");
                for (q0 q0Var : values2) {
                    arrayList.add(q0Var);
                    StaticStickerCategory M = M(q0Var.f());
                    if (M != null) {
                        arrayList.add(new r0(M));
                    }
                }
            }
        }
        Template template = this.p;
        if (template != null) {
            arrayList.add(new t0(template));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008d, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a4 -> B:30:0x00a7). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object W(kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof us.pinguo.edit2020.viewmodel.module.StaticStickerModule$getUsedStickerCategoryIdsForStat$1
            if (r0 == 0) goto L13
            r0 = r10
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule$getUsedStickerCategoryIdsForStat$1 r0 = (us.pinguo.edit2020.viewmodel.module.StaticStickerModule$getUsedStickerCategoryIdsForStat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule$getUsedStickerCategoryIdsForStat$1 r0 = new us.pinguo.edit2020.viewmodel.module.StaticStickerModule$getUsedStickerCategoryIdsForStat$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$1
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.L$0
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule r5 = (us.pinguo.edit2020.viewmodel.module.StaticStickerModule) r5
            kotlin.j.b(r10)
            goto La7
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3e:
            kotlin.j.b(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, us.pinguo.edit2020.bean.q0>> r2 = r9.r
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
            r5 = r9
            r4 = r10
        L52:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto Lc4
            java.lang.Object r10 = r2.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r6 = r10.getValue()
            java.util.Map r6 = (java.util.Map) r6
            boolean r7 = r6.isEmpty()
            r8 = 0
            if (r7 == 0) goto L6c
            goto L8e
        L6c:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L74:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L8e
            java.lang.Object r7 = r6.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r7 = r7.getValue()
            us.pinguo.edit2020.bean.q0 r7 = (us.pinguo.edit2020.bean.q0) r7
            boolean r7 = r7.g()
            r7 = r7 ^ r3
            if (r7 == 0) goto L74
            r8 = 1
        L8e:
            if (r8 == 0) goto L52
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r6 = r5.q
            java.lang.Object r10 = r10.getKey()
            java.lang.String r10 = (java.lang.String) r10
            r0.L$0 = r5
            r0.L$1 = r4
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r10 = r6.p(r10, r0)
            if (r10 != r1) goto La7
            return r1
        La7:
            us.pinguo.repository2020.database.staticsticker.StaticStickerDetail r10 = (us.pinguo.repository2020.database.staticsticker.StaticStickerDetail) r10
            if (r10 != 0) goto Lac
            goto L52
        Lac:
            java.lang.String[] r10 = r10.getPids()
            if (r10 != 0) goto Lb3
            goto L52
        Lb3:
            java.lang.Object r10 = kotlin.collections.j.p(r10)
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto Lbc
            goto L52
        Lbc:
            boolean r10 = r4.add(r10)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            goto L52
        Lc4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.W(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<String> X() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, HashMap<String, q0>> entry : this.r.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<String, q0> entry2 : entry.getValue().entrySet()) {
                if (!entry2.getValue().g()) {
                    arrayList.add(key);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0039 A[EDGE_INSN: B:26:0x0039->B:20:0x0039 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String Y() {
        /*
            r7 = this;
            us.pinguo.repository2020.database.staticsticker.StaticStickerManager r0 = r7.q
            java.util.List r0 = r0.z()
            r1 = 0
            if (r0 != 0) goto La
            goto L42
        La:
            java.util.Iterator r0 = r0.iterator()
        Le:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L38
            java.lang.Object r2 = r0.next()
            r3 = r2
            us.pinguo.repository2020.database.staticsticker.TemplateCategory r3 = (us.pinguo.repository2020.database.staticsticker.TemplateCategory) r3
            java.lang.String[] r3 = r3.getTids()
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L25
        L23:
            r4 = 0
            goto L35
        L25:
            us.pinguo.repository2020.database.staticsticker.Template r6 = r7.p
            if (r6 != 0) goto L2b
            r6 = r1
            goto L2f
        L2b:
            java.lang.String r6 = r6.getTid()
        L2f:
            boolean r3 = kotlin.collections.j.m(r3, r6)
            if (r3 != r4) goto L23
        L35:
            if (r4 == 0) goto Le
            goto L39
        L38:
            r2 = r1
        L39:
            us.pinguo.repository2020.database.staticsticker.TemplateCategory r2 = (us.pinguo.repository2020.database.staticsticker.TemplateCategory) r2
            if (r2 != 0) goto L3e
            goto L42
        L3e:
            java.lang.String r1 = r2.getCid()
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.Y():java.lang.String");
    }

    public final String Z() {
        Template template = this.p;
        if (template == null) {
            return null;
        }
        return template.getTid();
    }

    public final boolean a0(StaticStickerCategory staticStickerCategory) {
        Set<String> keySet = this.q.r().keySet();
        if ((keySet instanceof Collection) && keySet.isEmpty()) {
            return false;
        }
        for (String str : keySet) {
            if (s.c(str, staticStickerCategory == null ? null : staticStickerCategory.getPid())) {
                return true;
            }
        }
        return false;
    }

    public final boolean b0(Template template) {
        s.h(template, "template");
        return this.q.C(template) || s.c(template.getTid(), Material.MATERIAL_SELECT_NONE_FLAG);
    }

    public final void c0(q0 function) {
        s.h(function, "function");
        UnityEditCaller.StaticSticker.staticStickerLayerMoveToTop(function.f() + '_' + function.h());
    }

    public final void d0(kotlin.jvm.b.l<? super Exception, u> lVar) {
        this.q.F(new StaticStickerModule$loadStickerAsync$1(lVar));
    }

    public final void f(StaticSticker sticker, StaticStickerCategory category, boolean z) {
        s.h(sticker, "sticker");
        s.h(category, "category");
        String sid = sticker.getSid();
        if (sid == null) {
            return;
        }
        q0 q0Var = this.t;
        if (q0Var == null || !s.c(q0Var.f(), sid) || q0Var.g()) {
            l.d(kotlinx.coroutines.n0.a(z0.b()), null, null, new StaticStickerModule$applySticker$2(this, sid, category, z, sticker, null), 3, null);
        } else {
            p(q0Var);
        }
    }

    public final void f0(List<String> idList) {
        s.h(idList, "idList");
        q0 q0Var = this.t;
        if (q0Var != null && idList.contains(q0Var.f())) {
            this.x = "";
            this.t = null;
            UnityEditCaller.StaticSticker.unSelectCurrentStaticSticker();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
        if ((r3.length == 0) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(us.pinguo.repository2020.database.staticsticker.Template r11, boolean r12) {
        /*
            r10 = this;
            java.lang.String r0 = "template"
            kotlin.jvm.internal.s.h(r11, r0)
            us.pinguo.repository2020.database.staticsticker.StaticStickerDetail[] r3 = r11.getStickers()
            r0 = 0
            r1 = 1
            if (r3 == 0) goto L15
            int r2 = r3.length
            if (r2 != 0) goto L12
            r2 = 1
            goto L13
        L12:
            r2 = 0
        L13:
            if (r2 == 0) goto L16
        L15:
            r0 = 1
        L16:
            if (r0 == 0) goto L19
            return
        L19:
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.z0.b()
            kotlinx.coroutines.m0 r0 = kotlinx.coroutines.n0.a(r0)
            r7 = 0
            r8 = 0
            us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applyTemplate$1 r9 = new us.pinguo.edit2020.viewmodel.module.StaticStickerModule$applyTemplate$1
            r6 = 0
            r1 = r9
            r2 = r10
            r4 = r11
            r5 = r12
            r1.<init>(r2, r3, r4, r5, r6)
            r11 = 3
            r12 = 0
            r4 = r0
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r11
            r9 = r12
            kotlinx.coroutines.j.d(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.viewmodel.module.StaticStickerModule.g(us.pinguo.repository2020.database.staticsticker.Template, boolean):void");
    }

    public final void g0(String key) {
        List o0;
        HashMap<String, q0> hashMap;
        q0 q0Var;
        s.h(key, "key");
        o0 = StringsKt__StringsKt.o0(key, new char[]{'_'}, false, 0, 6, null);
        if (o0.size() != 2 || (hashMap = this.r.get((String) o0.get(0))) == null || (q0Var = hashMap.get(key)) == null) {
            return;
        }
        this.t = q0Var;
        this.x = key;
    }

    public final void h() {
        HashMap<String, q0> hashMap;
        q0 q0Var = this.t;
        if (q0Var == null) {
            return;
        }
        this.t = null;
        String f2 = q0Var.f();
        String str = f2 + '_' + q0Var.h();
        HashMap<String, HashMap<String, q0>> hashMap2 = this.r;
        HashMap<String, q0> hashMap3 = hashMap2.get(f2);
        if (hashMap3 != null) {
            hashMap3.remove(str);
        }
        this.s.remove(str);
        UnityEditCaller.StaticSticker.deleteCurrentStaticSticker();
        Template template = this.p;
        if (template == null) {
            return;
        }
        StaticStickerDetail[] stickers = template.getStickers();
        if (stickers != null) {
            for (StaticStickerDetail staticStickerDetail : stickers) {
                String sid = staticStickerDetail.getSid();
                if (sid != null && (hashMap = hashMap2.get(sid)) != null) {
                    for (Map.Entry<String, q0> entry : hashMap.entrySet()) {
                        if (entry.getValue().g()) {
                            return;
                        }
                    }
                    continue;
                }
            }
        }
        this.p = null;
    }

    public final void h0() {
        this.t = null;
        this.x = "";
    }

    public final void i(Template template) {
        s.h(template, "template");
        this.t = null;
        this.p = null;
        StaticStickerDetail[] stickers = template.getStickers();
        if (stickers == null) {
            return;
        }
        for (StaticStickerDetail staticStickerDetail : stickers) {
            j0(staticStickerDetail);
            StaticStickerDetail[] children = staticStickerDetail.getChildren();
            if (children != null) {
                for (StaticStickerDetail staticStickerDetail2 : children) {
                    j0(staticStickerDetail2);
                }
            }
        }
    }

    public final void i0() {
        D0();
    }

    public final void j() {
        EditModel A = this.a.A();
        EditModel editModel = EditModel.StaticSticker;
        if (A != editModel) {
            this.a.o(editModel);
        }
    }

    public final void k(Template template) {
        s.h(template, "template");
        template.isCollected().set(true);
        this.q.h(template);
    }

    public final void k0(String key) {
        s.h(key, "key");
        UnityEditCaller.StaticSticker.requestStaticStickerLayerStatusWithKey(key);
    }

    public final void l(Template template) {
        s.h(template, "template");
        template.isCollected().set(false);
        this.q.j(template);
    }

    public final void l0() {
        this.t = null;
        this.x = "";
        List<StaticStickerCategory> L = L();
        List<StaticStickerCategory> L2 = L();
        if (L2 != null) {
            int i2 = 0;
            for (Object obj : L2) {
                int i3 = i2 + 1;
                if (i2 >= 0) {
                    ObservableBoolean isSelected = ((StaticStickerCategory) obj).isSelected();
                    if (isSelected != null) {
                        isSelected.set(i2 == 1);
                    }
                    i2 = i3;
                } else {
                    kotlin.collections.s.n();
                    throw null;
                }
            }
        }
        if ((L == null ? 0 : L.size()) >= 2) {
            List<StaticStickerCategory> L3 = L();
            this.f10876h = L3 == null ? null : L3.get(1);
            List<StaticStickerCategory> L4 = L();
            this.f10877i = L4 == null ? null : L4.get(1);
        }
        List<TemplateCategory> R = R();
        if (R != null) {
            int i4 = 0;
            for (Object obj2 : R) {
                int i5 = i4 + 1;
                if (i4 >= 0) {
                    TemplateCategory templateCategory = (TemplateCategory) obj2;
                    for (Template template : T(templateCategory)) {
                        ObservableBoolean isSelected2 = template.isSelected();
                        if (isSelected2 != null) {
                            isSelected2.set(false);
                        }
                    }
                    ObservableBoolean isSelected3 = templateCategory.isSelected();
                    if (isSelected3 != null) {
                        isSelected3.set(i4 == 1);
                    }
                    i4 = i5;
                } else {
                    kotlin.collections.s.n();
                    throw null;
                }
            }
        }
        if ((L != null ? L.size() : 0) >= 2) {
            this.f10878j = R == null ? null : R.get(1);
            this.f10879k = R == null ? null : R.get(1);
        }
        this.f10880l = null;
        ObservableBoolean isSelected4 = this.f10875g.isSelected();
        if (isSelected4 != null) {
            isSelected4.set(true);
        }
        Template template2 = this.f10875g;
        this.n = template2;
        this.m = template2;
    }

    public final void m0(PointF point) {
        s.h(point, "point");
        UnityEditCaller.StaticSticker.selectStaticStickerWithPoint(point.x, point.y);
    }

    public final void n0(String key) {
        s.h(key, "key");
        UnityEditCaller.StaticSticker.selectStaticStickerWithKey(key);
    }

    public final void o(q0 function) {
        s.h(function, "function");
        UnityEditCaller.StaticSticker.staticStickerLayerMoveToBottom(function.f() + '_' + function.h());
    }

    public final void o0(BasicBrushMode brushMode) {
        s.h(brushMode, "brushMode");
        UnityEditCaller.Brush.setCurrentBrushMode(brushMode);
    }

    public final void p(q0 function) {
        s.h(function, "function");
        String f2 = function.f();
        StaticStickerItem staticStickerItem = this.s.get(f2 + '_' + function.h());
        if (staticStickerItem == null) {
            return;
        }
        q0 q0Var = new q0(function.i(), function.a());
        String str = f2 + '_' + q0Var.h();
        PointF size = staticStickerItem.getSize();
        PointF pointF = size == null ? null : new PointF(size.x, size.y);
        PointF center = staticStickerItem.getCenter();
        PointF pointF2 = center != null ? new PointF(center.x, center.y) : null;
        if (pointF2 != null) {
            float f3 = pointF2.x + 0.02f;
            pointF2.x = f3;
            float f4 = pointF2.y + 0.02f;
            pointF2.y = f4;
            if (f3 > 1.0f || f4 > 1.0f) {
                pointF2.x = 0.5f;
                pointF2.y = 0.5f;
            }
        }
        StaticStickerItem staticStickerItem2 = new StaticStickerItem(staticStickerItem.getSourceTexture(), staticStickerItem.getBlendMode(), pointF, pointF2, staticStickerItem.getRotateAngle(), staticStickerItem.getEnableGestureSelect(), staticStickerItem.getNeedRecordHistory(), str, staticStickerItem.getOpacity(), staticStickerItem.getGesturePenetrate(), null);
        this.s.put(str, staticStickerItem2);
        HashMap<String, q0> hashMap = this.r.get(f2);
        if (hashMap != null) {
            hashMap.put(str, q0Var);
        }
        UnityEditCaller.StaticSticker.copyCurrentStaticSticker(staticStickerItem2);
        UnityEditCaller.StaticSticker.selectStaticStickerWithKey(str);
    }

    public final void p0(BasicBrushMode brushMode, float f2) {
        s.h(brushMode, "brushMode");
        o0(brushMode);
        UnityEditCaller.Brush.setBrushSize(brushMode, f2);
    }

    public final void q(boolean z) {
        this.a.n1(z);
    }

    public final void q0(Material material) {
        this.f10880l = material;
    }

    public final void r() {
        this.x = "";
        this.t = null;
        this.p = null;
        this.r.clear();
        this.s.clear();
    }

    public final void r0(int i2) {
        this.o = i2;
    }

    public final ArrayList<p0> s() {
        return this.v;
    }

    public final void s0(StaticStickerCategory staticStickerCategory) {
        this.f10876h = staticStickerCategory;
    }

    public final ArrayList<us.pinguo.edit2020.model.f.a> t() {
        return this.w;
    }

    public final void t0(Template template) {
        s.h(template, "<set-?>");
        this.n = template;
    }

    public final float u(int i2) {
        int i3 = this.f10873e;
        int i4 = this.f10874f;
        return (((i2 / 100.0f) * (i3 - i4)) + i4) / this.f10872d;
    }

    public final void u0(TemplateCategory templateCategory) {
        this.f10878j = templateCategory;
    }

    public final us.pinguo.repository2020.u<u0> v() {
        return this.a.L();
    }

    public final void v0(StaticStickerCategory staticStickerCategory) {
        this.f10877i = staticStickerCategory;
    }

    public final List<Template> w() {
        return this.q.q();
    }

    public final void w0(Template template) {
        s.h(template, "<set-?>");
        this.m = template;
    }

    public final Material x() {
        return this.f10880l;
    }

    public final void x0(TemplateCategory templateCategory) {
        this.f10879k = templateCategory;
    }

    public final q0 y() {
        return this.t;
    }

    public final void y0(ActivityResultLauncher<Intent> activityResultLauncher) {
        this.c = activityResultLauncher;
    }

    public final int z() {
        return this.o;
    }

    public final void z0(kotlinx.coroutines.flow.c<ActivityResult> cVar) {
        this.b = cVar;
    }
}
