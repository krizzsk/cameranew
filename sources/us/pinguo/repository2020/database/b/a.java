package us.pinguo.repository2020.database.b;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
/* compiled from: FilterHistoryDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface a {
    @Query("SELECT * FROM filter_history")
    List<c> a();

    @Insert(onConflict = 1)
    void b(c cVar);

    @Query("SELECT * FROM filter_history WHERE position=:position And filterId=:filterId")
    c c(String str, String str2);

    @Update
    void d(c cVar);
}
