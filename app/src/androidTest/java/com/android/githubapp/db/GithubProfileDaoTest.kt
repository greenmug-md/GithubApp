package com.android.githubapp.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.android.githubapp.getOrAwaitValue
import com.android.githubapp.model.GithubProfileItem
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class GithubProfileDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: GithubItemDatabase
    private lateinit var dao: GithubProfileDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            GithubItemDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.githubDao()
    }

    @Test
    fun insertGithubProfile() = runBlockingTest {
        val profileItem = GithubProfileItem("author1", "avatar", "author1","name1","url1")
        val profileItem2 = GithubProfileItem("author2", "avatar2", "author2","name2","url2")
        var list = ArrayList<GithubProfileItem>();
        list.add(profileItem)
        list.add(profileItem2)
        dao.insertProfiles(list)
        val allProfileItems = dao.getAllProfiles().getOrAwaitValue()
        assertThat(allProfileItems).contains(profileItem)
    }

    @Test
    fun deleteGithubProfile() = runBlockingTest {
        val profileItem = GithubProfileItem("author1", "avatar", "author1","name1","url1")
        var list = ArrayList<GithubProfileItem>();
        list.add(profileItem)
        dao.insertProfiles(list)
        dao.deleteProfileItems(profileItem)
        val allProfileItems = dao.getAllProfiles().getOrAwaitValue()

        assertThat(allProfileItems).doesNotContain(profileItem)
    }

    @After
    fun teardown() {
        database.close()
    }


}