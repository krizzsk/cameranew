package com.pinguo.camera360.homepage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvConstants;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.repository2020.manager.FilterRepository;
import vStudio.Android.Camera360.R;
/* compiled from: HomePageDataProvider.kt */
/* loaded from: classes3.dex */
public final class n0 {
    private final String[] a;
    private HashMap<Integer, Integer> b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, List<AdvItem>> f6806d;

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Double.valueOf(((AdvItem) t).priority), Double.valueOf(((AdvItem) t2).priority));
            return a;
        }
    }

    public n0(String... guidArr) {
        kotlin.jvm.internal.s.h(guidArr, "guidArr");
        this.a = guidArr;
        this.b = new HashMap<>();
        this.f6806d = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(AdvItem advItem, AdvItem advItem2) {
        return advItem.priority > advItem2.priority ? 1 : 0;
    }

    private final boolean j() {
        String[] strArr;
        int o;
        if (this.a.length == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.a) {
            List<AdvItem> advList = AdvConfigManager.getInstance().getItems(str);
            if (advList != null) {
                arrayList.add(advList);
            }
            HashMap<String, List<AdvItem>> hashMap = this.f6806d;
            kotlin.jvm.internal.s.g(advList, "advList");
            hashMap.put(str, advList);
        }
        ArrayList<List<? extends AdvItem>> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((List) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        o = kotlin.collections.v.o(arrayList2, 10);
        ArrayList<Boolean> arrayList3 = new ArrayList(o);
        for (List<? extends AdvItem> list : arrayList2) {
            arrayList3.add(Boolean.valueOf(k(list)));
        }
        if (!arrayList3.isEmpty()) {
            for (Boolean bool : arrayList3) {
                if (!bool.booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean k(java.util.List<? extends us.pinguo.advconfigdata.database.AdvItem> r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L7d
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto La
            goto L7d
        La:
            java.lang.Object r1 = r7.get(r0)
            us.pinguo.advconfigdata.database.AdvItem r1 = (us.pinguo.advconfigdata.database.AdvItem) r1
            int r1 = r1.entryPos
            r2 = 1
            if (r1 != 0) goto L3b
            java.util.Iterator r7 = r7.iterator()
        L19:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L7d
            java.lang.Object r1 = r7.next()
            us.pinguo.advconfigdata.database.AdvItem r1 = (us.pinguo.advconfigdata.database.AdvItem) r1
            us.pinguo.advconfigdata.AdvConfigManager r3 = us.pinguo.advconfigdata.AdvConfigManager.getInstance()
            us.pinguo.advconfigdata.database.AdvItem r3 = r3.loadDownloadedImage(r1)
            if (r3 == 0) goto L30
            return r2
        L30:
            java.lang.String r1 = r1.advType
            java.lang.String r3 = "c360Adv"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L19
            return r2
        L3b:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r7 = r7.iterator()
        L49:
            boolean r4 = r7.hasNext()
            if (r4 == 0) goto L72
            java.lang.Object r4 = r7.next()
            us.pinguo.advconfigdata.database.AdvItem r4 = (us.pinguo.advconfigdata.database.AdvItem) r4
            int r5 = r4.entryPos
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.add(r5)
            us.pinguo.advconfigdata.AdvConfigManager r5 = us.pinguo.advconfigdata.AdvConfigManager.getInstance()
            us.pinguo.advconfigdata.database.AdvItem r5 = r5.loadDownloadedImage(r4)
            if (r5 == 0) goto L49
            int r4 = r4.entryPos
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            goto L49
        L72:
            int r7 = r1.size()
            int r1 = r3.size()
            if (r7 != r1) goto L7d
            return r2
        L7d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.n0.k(java.util.List):boolean");
    }

    public final ArrayList<AdvItem> a(String guid) {
        kotlin.jvm.internal.s.h(guid, "guid");
        boolean j2 = j();
        this.c = j2;
        if (j2) {
            ArrayList<AdvItem> arrayList = new ArrayList<>();
            List<AdvItem> list = this.f6806d.get(guid);
            if (list != null) {
                for (AdvItem advItem : list) {
                    AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(advItem);
                    if (loadDownloadedImage == null) {
                        if (kotlin.jvm.internal.s.c(AdvConstants.ADV_TYPE_PINGUO, advItem.advType)) {
                            arrayList.add(advItem);
                        }
                    } else {
                        arrayList.add(loadDownloadedImage);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    public final f0 b() {
        return new f0(Integer.valueOf((int) R.drawable.home_banner_default), FilterRepository.a.B() ? "app://camera360/cameraFilter?pkgId=5836bbbdb773028b3d368c98&filterId=596ef84dd17f2f860a157809&cameraType=3&isSticker=false&camera=1" : "app://camera360/cameraFilter?pkgId=5db94be6f34b85ce4cfe2b50&filterId=5dc0edaa9ac5306379b9bd81&cameraType=3&isSticker=false&camera=1", "", "default_advId", null, null);
    }

    public final String c(AdvItem advItem) {
        kotlin.jvm.internal.s.h(advItem, "advItem");
        switch (advItem.entryPos) {
            case 1:
                String string = us.pinguo.foundation.e.b().getString(R.string.main_menu_beauty_skinrefresh);
                kotlin.jvm.internal.s.g(string, "getAppContext().getStrin…_menu_beauty_skinrefresh)");
                return string;
            case 2:
                String string2 = us.pinguo.foundation.e.b().getString(R.string.main_menu_beauty_facialfeatures);
                kotlin.jvm.internal.s.g(string2, "getAppContext().getStrin…nu_beauty_facialfeatures)");
                return string2;
            case 3:
                String string3 = us.pinguo.foundation.e.b().getString(R.string.album);
                kotlin.jvm.internal.s.g(string3, "getAppContext().getString(R.string.album)");
                return string3;
            case 4:
                String string4 = us.pinguo.foundation.e.b().getString(R.string.vip_filter);
                kotlin.jvm.internal.s.g(string4, "getAppContext().getString(R.string.vip_filter)");
                return string4;
            case 5:
                String string5 = us.pinguo.foundation.e.b().getString(R.string.hot_challenge);
                kotlin.jvm.internal.s.g(string5, "getAppContext().getString(R.string.hot_challenge)");
                return string5;
            case 6:
                String string6 = us.pinguo.foundation.e.b().getString(R.string.beauty_lab_title);
                kotlin.jvm.internal.s.g(string6, "getAppContext().getStrin….string.beauty_lab_title)");
                return string6;
            default:
                return "";
        }
    }

    public final j0 d() {
        return new j0(Integer.valueOf((int) R.drawable.ic_user_profile), Integer.valueOf((int) R.drawable.ic_c360_logo), Integer.valueOf((int) R.drawable.ic_home_vip), new h0("0", null, null, null, null, 30, null), new h0("0", null, null, null, null, 30, null), null, null, null, 1);
    }

    public final int e(AdvItem advItem) {
        kotlin.jvm.internal.s.h(advItem, "advItem");
        switch (advItem.entryPos) {
            case 1:
                return R.drawable.home_func_skin;
            case 2:
                return R.drawable.home_func_facialfeatures;
            case 3:
                return R.drawable.home_func_album;
            case 4:
                return R.drawable.home_func_filter;
            case 5:
                return R.drawable.home_func_challenge;
            case 6:
                return R.drawable.home_func_shiyanshi;
            default:
                return 0;
        }
    }

    public final List<i0> f() {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 6) {
            int i3 = i2 + 1;
            i0 i0Var = null;
            if (i2 == 0) {
                String string = us.pinguo.foundation.e.b().getString(R.string.main_menu_beauty_skinrefresh);
                kotlin.jvm.internal.s.g(string, "getAppContext().getStrin…_menu_beauty_skinrefresh)");
                i0Var = new i0("FFFFFF", "FFFFFF", string, Integer.valueOf((int) R.drawable.home_func_skin), "", "app://camera360/edit?position=skinAdjust", 1, 4, 2, "default_advId", "defaultAdv", null, null, null, 12288, null);
            } else if (i2 == 1) {
                String string2 = us.pinguo.foundation.e.b().getString(R.string.main_menu_beauty_facialfeatures);
                kotlin.jvm.internal.s.g(string2, "getAppContext().getStrin…nu_beauty_facialfeatures)");
                i0Var = new i0("FFFFFF", "FFFFFF", string2, Integer.valueOf((int) R.drawable.home_func_facialfeatures), "", "app://camera360/edit?position=facialFeatures", 2, 4, 2, "default_advId", "defaultAdv", null, null, null, 12288, null);
            } else if (i2 == 2) {
                String string3 = us.pinguo.foundation.e.b().getString(R.string.album);
                kotlin.jvm.internal.s.g(string3, "getAppContext().getString(R.string.album)");
                i0Var = new i0("FFFFFF", "FFFFFF", string3, Integer.valueOf((int) R.drawable.home_func_album), "", "app://camera360/gallery/action", 3, 4, 2, "default_advId", "defaultAdv", null, null, null, 12288, null);
            } else if (i2 == 3) {
                String string4 = us.pinguo.foundation.e.b().getString(R.string.vip_filter);
                kotlin.jvm.internal.s.g(string4, "getAppContext().getString(R.string.vip_filter)");
                i0Var = new i0("FFFFFF", "FFFFFF", string4, Integer.valueOf((int) R.drawable.home_func_filter), "", "app://camera360/petal/openScene?sceneId=5b2b6886f54ae6fa1224d9cf", 4, 4, 2, "default_advId", "defaultAdv", null, null, null, 12288, null);
            } else if (i2 == 4) {
                String string5 = us.pinguo.foundation.e.b().getString(R.string.main_menu_beauty_makeup);
                kotlin.jvm.internal.s.g(string5, "getAppContext().getStrin….main_menu_beauty_makeup)");
                i0Var = new i0("FFFFFF", "FFFFFF", string5, Integer.valueOf((int) R.drawable.home_func_makeup), "", "app://camera360/cameraFilter?styleMakeup=default", 5, 4, 2, "default_advId", "defaultAdv", null, null, null, 12288, null);
            } else if (i2 == 5) {
                String string6 = us.pinguo.foundation.e.b().getString(R.string.beauty_lab_title);
                kotlin.jvm.internal.s.g(string6, "getAppContext().getStrin….string.beauty_lab_title)");
                i0Var = new i0("FFFFFF", "FFFFFF", string6, Integer.valueOf((int) R.drawable.home_func_shiyanshi), "", "app://camera360/beautylab", 6, 4, 2, "default_advId", "defaultAdv", null, null, null, 12288, null);
            }
            kotlin.jvm.internal.s.e(i0Var);
            arrayList.add(i0Var);
            i2 = i3;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList<AdvItem> g(String guid) {
        List<AdvItem> list;
        kotlin.jvm.internal.s.h(guid, "guid");
        boolean j2 = j();
        this.c = j2;
        if (j2 && (list = this.f6806d.get(guid)) != null) {
            ArrayList arrayList = new ArrayList();
            for (AdvItem advItem : list) {
                AdvItem loadDownloadedImage = AdvConfigManager.getInstance().loadDownloadedImage(advItem);
                if (loadDownloadedImage != null) {
                    arrayList.add(loadDownloadedImage);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : arrayList) {
                Integer valueOf = Integer.valueOf(((AdvItem) obj).entryPos);
                Object obj2 = linkedHashMap.get(valueOf);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(valueOf, obj2);
                }
                ((List) obj2).add(obj);
            }
            ArrayList<AdvItem> arrayList2 = new ArrayList<>(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((List) entry.getValue()).size() > 1) {
                    kotlin.collections.c0.R((Iterable) entry.getValue(), new a());
                }
                int i2 = 0;
                if (!this.b.containsKey(entry.getKey())) {
                    this.b.put(entry.getKey(), 0);
                }
                Integer num = this.b.get(entry.getKey());
                kotlin.jvm.internal.s.e(num);
                kotlin.jvm.internal.s.g(num, "mPositionMap[it.key]!!");
                int intValue = num.intValue();
                if (intValue <= ((List) entry.getValue()).size() - 1) {
                    i2 = intValue;
                }
                arrayList2.add(((List) entry.getValue()).get(i2));
                this.b.put(entry.getKey(), Integer.valueOf(i2 + 1));
            }
            return arrayList2;
        }
        return null;
    }

    public final AdvItem h(String guid) {
        List<AdvItem> list;
        kotlin.jvm.internal.s.h(guid, "guid");
        boolean j2 = j();
        this.c = j2;
        if (j2 && (list = this.f6806d.get(guid)) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (AdvConfigManager.getInstance().loadDownloadedImage((AdvItem) obj) != null) {
                    arrayList.add(obj);
                }
            }
            return (AdvItem) kotlin.collections.s.M(arrayList, n.a);
        }
        return null;
    }
}
