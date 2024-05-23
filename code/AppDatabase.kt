import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        // @Volatile 애노테이션은 멀티스레드 환경에서 변수의 값이 모든 스레드에 대해 즉시 일관성 있게 보이도록 보장하는 데 사용
        @Volatile
        private var instance: AppDatabase? = null
        //DB 호출하는 함수
        fun getDatabase(context: Context): AppDatabase {
            return instance ?:
            Room.databaseBuilder(
                context,
                AppDatabase::class.java, "hyeonwoo.db"
            ).build()
                .also { instance = it }

        }
    }
}
