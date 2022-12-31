package us.pinguo.edit2020.bean;

import us.pinguo.edit2020.bean.x;
import us.pinguo.repository2020.entity.OperationLabel;
import us.pinguo.repository2020.entity.StyleMakeup;
/* compiled from: StyleMakeupFunction.kt */
/* loaded from: classes4.dex */
public final class s0 implements x {
    private final StyleMakeup a;

    public s0(StyleMakeup styleMakeup) {
        kotlin.jvm.internal.s.h(styleMakeup, "styleMakeup");
        this.a = styleMakeup;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Integer vip = this.a.getVip();
        if (vip != null && vip.intValue() == 1) {
            Integer tagContent = this.a.getTagContent();
            OperationLabel operationLabel = OperationLabel.LABEL_FREE;
            int ordinal = operationLabel.ordinal();
            if (tagContent != null && tagContent.intValue() == ordinal) {
                Integer tagContent2 = this.a.getTagContent();
                int ordinal2 = operationLabel.ordinal();
                if (tagContent2 == null || tagContent2.intValue() != ordinal2) {
                    return false;
                }
                Long tagOnTime = this.a.getTagOnTime();
                long longValue = tagOnTime == null ? 0L : tagOnTime.longValue();
                Long tagOffTime = this.a.getTagOffTime();
                if (currentTimeMillis <= (tagOffTime != null ? tagOffTime.longValue() : 0L) && longValue <= currentTimeMillis) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // us.pinguo.edit2020.bean.x
    public boolean b() {
        return x.a.a(this);
    }

    @Override // us.pinguo.edit2020.bean.x
    public String c() {
        String name = this.a.getName();
        return name == null ? "" : name;
    }

    @Override // us.pinguo.edit2020.bean.x
    public int d() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // us.pinguo.edit2020.bean.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e() {
        /*
            r6 = this;
            us.pinguo.repository2020.entity.StyleMakeup r0 = r6.a
            java.lang.Integer[] r0 = r0.getEditMakeupCurrentValues()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r0 = 0
            goto L26
        Lc:
            int r3 = r0.length
            r4 = 0
        Le:
            if (r4 >= r3) goto L22
            r5 = r0[r4]
            int r5 = r5.intValue()
            if (r5 == 0) goto L1a
            r5 = 1
            goto L1b
        L1a:
            r5 = 0
        L1b:
            if (r5 == 0) goto L1f
            r0 = 1
            goto L23
        L1f:
            int r4 = r4 + 1
            goto Le
        L22:
            r0 = 0
        L23:
            if (r0 != r1) goto La
            r0 = 1
        L26:
            if (r0 != 0) goto L50
            us.pinguo.repository2020.entity.StyleMakeup r0 = r6.a
            java.lang.Integer[] r0 = r0.getEditFilterCurrentValues()
            if (r0 != 0) goto L32
        L30:
            r0 = 0
            goto L4c
        L32:
            int r3 = r0.length
            r4 = 0
        L34:
            if (r4 >= r3) goto L48
            r5 = r0[r4]
            int r5 = r5.intValue()
            if (r5 == 0) goto L40
            r5 = 1
            goto L41
        L40:
            r5 = 0
        L41:
            if (r5 == 0) goto L45
            r0 = 1
            goto L49
        L45:
            int r4 = r4 + 1
            goto L34
        L48:
            r0 = 0
        L49:
            if (r0 != r1) goto L30
            r0 = 1
        L4c:
            if (r0 == 0) goto L4f
            goto L50
        L4f:
            r1 = 0
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.edit2020.bean.s0.e():boolean");
    }

    @Override // us.pinguo.edit2020.bean.x
    public String f() {
        String pid = this.a.getPid();
        return pid == null ? "" : pid;
    }
}
