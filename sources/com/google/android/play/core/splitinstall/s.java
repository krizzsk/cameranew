package com.google.android.play.core.splitinstall;

import android.util.Log;
import androidx.annotation.Nullable;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
final class s {
    private final XmlPullParser a;
    private final y b = new y();

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(XmlPullParser xmlPullParser) {
        this.a = xmlPullParser;
    }

    @Nullable
    private final String b(String str) {
        for (int i2 = 0; i2 < this.a.getAttributeCount(); i2++) {
            if (this.a.getAttributeName(i2).equals(str)) {
                return this.a.getAttributeValue(i2);
            }
        }
        return null;
    }

    private final void c() throws IOException, XmlPullParserException {
        int i2 = 1;
        while (i2 != 0) {
            int next = this.a.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final z a() {
        String b;
        while (this.a.next() != 1) {
            try {
                if (this.a.getEventType() == 2) {
                    if (this.a.getName().equals("splits")) {
                        while (this.a.next() != 3) {
                            if (this.a.getEventType() == 2) {
                                if (!this.a.getName().equals("module") || (b = b("name")) == null) {
                                    c();
                                } else {
                                    while (this.a.next() != 3) {
                                        if (this.a.getEventType() == 2) {
                                            if (this.a.getName().equals(IjkMediaMeta.IJKM_KEY_LANGUAGE)) {
                                                while (this.a.next() != 3) {
                                                    if (this.a.getEventType() == 2) {
                                                        if (this.a.getName().equals("entry")) {
                                                            String b2 = b("key");
                                                            String b3 = b(TJAdUnitConstants.String.STYLE_SPLIT);
                                                            c();
                                                            if (b2 != null && b3 != null) {
                                                                this.b.b(b, b2, b3);
                                                            }
                                                        } else {
                                                            c();
                                                        }
                                                    }
                                                }
                                            } else {
                                                c();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        c();
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e2) {
                Log.e("SplitInstall", "Error while parsing splits.xml", e2);
                return null;
            }
        }
        return this.b.a();
    }
}
