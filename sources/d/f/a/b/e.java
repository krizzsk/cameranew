package d.f.a.b;

import java.util.ArrayList;
import java.util.Comparator;
/* compiled from: MemoryCacheUtils.java */
/* loaded from: classes3.dex */
public final class e {

    /* compiled from: MemoryCacheUtils.java */
    /* loaded from: classes3.dex */
    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
        }
    }

    public static Comparator<String> a() {
        return new a();
    }

    public static String b(String str, com.nostra13.universalimageloader.core.assist.c cVar) {
        return str + "_" + cVar.b() + "x" + cVar.a();
    }

    public static void c(String str, d.f.a.a.b.a aVar) {
        ArrayList<String> arrayList = new ArrayList();
        for (String str2 : aVar.a()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        for (String str3 : arrayList) {
            aVar.remove(str3);
        }
    }
}
