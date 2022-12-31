package us.pinguo.advsdk.manager;
/* compiled from: PgImageLoaderManager.java */
/* loaded from: classes3.dex */
class i implements us.pinguo.advsdk.a.i {
    us.pinguo.advsdk.a.i a;

    @Override // us.pinguo.advsdk.a.i
    public void a(String str) {
        us.pinguo.advsdk.a.i iVar = this.a;
        if (iVar == null) {
            return;
        }
        iVar.a(str);
    }

    @Override // us.pinguo.advsdk.a.i
    public String b(String str) {
        us.pinguo.advsdk.a.i iVar = this.a;
        if (iVar == null) {
            return null;
        }
        return iVar.b(str);
    }

    @Override // us.pinguo.advsdk.a.i
    public void c(us.pinguo.advsdk.a.i iVar) {
        if (this.a != null) {
            return;
        }
        this.a = iVar;
    }

    @Override // us.pinguo.advsdk.a.i
    public boolean d(String str) {
        us.pinguo.advsdk.a.i iVar = this.a;
        if (iVar == null) {
            return false;
        }
        return iVar.d(str);
    }
}
