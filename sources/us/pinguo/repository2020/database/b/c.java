package us.pinguo.repository2020.database.b;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: FilterHistoryTable.kt */
@Entity(tableName = "filter_history")
/* loaded from: classes6.dex */
public final class c {
    @PrimaryKey(autoGenerate = true)
    private int a;
    @ColumnInfo
    private String b;
    @ColumnInfo
    private String c;
    @ColumnInfo

    /* renamed from: d  reason: collision with root package name */
    private String f11830d;
    @ColumnInfo

    /* renamed from: e  reason: collision with root package name */
    private int f11831e;

    public c(int i2, String filterId, String packageId, String position, int i3) {
        s.h(filterId, "filterId");
        s.h(packageId, "packageId");
        s.h(position, "position");
        this.a = i2;
        this.b = filterId;
        this.c = packageId;
        this.f11830d = position;
        this.f11831e = i3;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.f11831e;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.f11830d;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.a == cVar.a && s.c(this.b, cVar.b) && s.c(this.c, cVar.c) && s.c(this.f11830d, cVar.f11830d) && this.f11831e == cVar.f11831e;
        }
        return false;
    }

    public final void f(int i2) {
        this.f11831e = i2;
    }

    public int hashCode() {
        return (((((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.f11830d.hashCode()) * 31) + this.f11831e;
    }

    public String toString() {
        return "FilterHistoryTable(_aid=" + this.a + ", filterId=" + this.b + ", packageId=" + this.c + ", position=" + this.f11830d + ", number=" + this.f11831e + ')';
    }

    public /* synthetic */ c(int i2, String str, String str2, String str3, int i3, int i4, o oVar) {
        this((i4 & 1) != 0 ? 0 : i2, str, str2, str3, i3);
    }
}
