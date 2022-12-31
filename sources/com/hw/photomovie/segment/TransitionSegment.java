package com.hw.photomovie.segment;

import com.hw.photomovie.segment.e;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class TransitionSegment<PRE extends e, NEXT extends e> extends f {
    protected PRE m;
    protected NEXT n;

    /* loaded from: classes2.dex */
    private static class TransitionSegmentException extends RuntimeException {
        public TransitionSegmentException(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    class a implements e.a {
        a() {
        }

        @Override // com.hw.photomovie.segment.e.a
        public void a(boolean z) {
            TransitionSegment.this.n();
            TransitionSegment.this.n.u(null);
        }
    }

    @Override // com.hw.photomovie.segment.e
    protected boolean g() {
        return false;
    }

    @Override // com.hw.photomovie.segment.e
    public int m() {
        return 0;
    }

    @Override // com.hw.photomovie.segment.e
    public void o() {
        List e2 = this.b.e();
        int indexOf = e2.indexOf(this);
        if (indexOf > 0 && indexOf != e2.size() - 1) {
            this.m = (PRE) e2.get(indexOf - 1);
            NEXT next = (NEXT) e2.get(indexOf + 1);
            this.n = next;
            if (!(this.m instanceof TransitionSegment) && !(next instanceof TransitionSegment)) {
                next.u(new a());
                this.n.r();
                this.m.i(false);
                return;
            }
            throw new TransitionSegmentException("TransitionSegment must be in the middle of two other Segments");
        }
        throw new TransitionSegmentException("TransitionSegment must be in the middle of two other Segments");
    }

    @Override // com.hw.photomovie.segment.f, com.hw.photomovie.segment.e
    public void p() {
        super.p();
        this.m.i(true);
        this.m.s();
    }
}
