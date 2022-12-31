package us.pinguo.common.db;

import java.util.ArrayList;
import java.util.List;
/* compiled from: DbUpgradeDefinition.java */
/* loaded from: classes4.dex */
public class i {
    int a;
    int b;
    List<String> c;

    /* compiled from: DbUpgradeDefinition.java */
    /* loaded from: classes4.dex */
    public static class b {
        private int a;
        private int b;
        private List<String> c;

        public i d() {
            return new i(this);
        }

        public b e(int i2) {
            this.a = i2;
            return this;
        }

        public b f(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(str);
            }
            this.c = arrayList;
            return this;
        }

        public b g(int i2) {
            this.b = i2;
            return this;
        }
    }

    private i(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }
}
