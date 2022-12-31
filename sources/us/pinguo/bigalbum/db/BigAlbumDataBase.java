package us.pinguo.bigalbum.db;

import android.content.Context;
import us.pinguo.common.db.b;
/* loaded from: classes3.dex */
public class BigAlbumDataBase extends b {
    public final String dbPath;

    public BigAlbumDataBase(String str) {
        super(str, BigAlbumStore.BIG_ALBUM_DB);
        this.dbPath = str + BigAlbumStore.BIG_ALBUM_DB_NAME;
    }

    public BigAlbumDataBase(Context context) {
        super(context, BigAlbumStore.BIG_ALBUM_DB);
        this.dbPath = context.getDatabasePath(BigAlbumStore.BIG_ALBUM_DB_NAME).getAbsolutePath();
    }
}
