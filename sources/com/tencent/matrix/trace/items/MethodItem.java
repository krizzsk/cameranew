package com.tencent.matrix.trace.items;
/* loaded from: classes3.dex */
public class MethodItem {
    public int count = 1;
    public int depth;
    public int durTime;
    public int methodId;

    public MethodItem(int i2, int i3, int i4) {
        this.methodId = i2;
        this.durTime = i3;
        this.depth = i4;
    }

    public void mergeMore(long j2) {
        this.count++;
        this.durTime = (int) (this.durTime + j2);
    }

    public String print() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.depth; i2++) {
            stringBuffer.append('.');
        }
        return stringBuffer.toString() + this.methodId + " " + this.count + " " + this.durTime;
    }

    public String toString() {
        return this.depth + "," + this.methodId + "," + this.count + "," + this.durTime;
    }
}
