package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public abstract class ChunkOffsetBox extends AbstractFullBox {
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;

    static {
        ajc$preClinit();
    }

    public ChunkOffsetBox(String str) {
        super(str);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ChunkOffsetBox.java", ChunkOffsetBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.ChunkOffsetBox", "", "", "", "java.lang.String"), 18);
    }

    public abstract long[] getChunkOffsets();

    public abstract void setChunkOffsets(long[] jArr);

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return String.valueOf(getClass().getSimpleName()) + "[entryCount=" + getChunkOffsets().length + "]";
    }
}
