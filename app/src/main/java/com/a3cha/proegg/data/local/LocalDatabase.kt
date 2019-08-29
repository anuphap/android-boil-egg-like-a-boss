package com.a3cha.proegg.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.a3cha.proegg.data.Data
import com.a3cha.proegg.data.local.model.Recipe

@Database(entities = [Recipe::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun dataDao(): RecipeDao

    companion object {

        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                LocalDatabase::class.java, "pro_egg.db"
            )
                // prepopulate the database after onCreate was called
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        ioThread {
                            getInstance(context).dataDao().insertRecipes(Data.defaultRecipes())
                        }
                    }
                })
                .build()
    }
}