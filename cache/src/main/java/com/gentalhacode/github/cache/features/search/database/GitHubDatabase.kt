package com.gentalhacode.github.cache.features.search.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gentalhacode.github.cache.features.search.dao.RepositoryDao
import com.gentalhacode.github.cache.features.search.database.GitHubDatabase.Companion.DB_VERSION
import com.gentalhacode.github.cache.features.search.entities.CacheRepository

/**
 * .:.:.:. Created by @thgMatajs on 19/02/20 .:.:.:.
 */
@Database(
    entities = [CacheRepository::class],
    version = DB_VERSION,
    exportSchema = false
)
abstract class GitHubDatabase : RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao


    companion object {
        private var instance: GitHubDatabase? = null
        const val DB_VERSION = 1
        private const val DB_NAME = "git_hub"

        fun getDatabase(context: Context): GitHubDatabase = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { repositoryDatabase ->
                instance = repositoryDatabase
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            GitHubDatabase::class.java,
            DB_NAME)
            .build()

        fun destroyInstance() {
            instance = null
        }
    }
}