package com.petrlr14.mvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.petrlr14.mvvm.database.daos.GitHubDAO
import com.petrlr14.mvvm.database.entities.GitHubRepo

@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)
public abstract class RoomDB : RoomDatabase() {

    abstract fun repoDao():GitHubDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun getInstance(
            context: Context
        ): RoomDB {

            if (INSTANCE != null) {return INSTANCE!!}


            else{
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context, RoomDB::class.java, "Repo_Database")
                        .build()

                    return INSTANCE!!
                }

            }


        }

    }

}