package com.tencent.stat;
/* loaded from: classes3.dex */
public class StatGameUser implements Cloneable {
    private String a = "";
    private String b = "";
    private String c = "";

    /* renamed from: clone */
    public StatGameUser m39clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getAccount() {
        return this.b;
    }

    public String getLevel() {
        return this.c;
    }

    public String getWorldName() {
        return this.a;
    }

    public void setAccount(String str) {
        this.b = str;
    }

    public void setLevel(String str) {
        this.c = str;
    }

    public void setWorldName(String str) {
        this.a = str;
    }
}
