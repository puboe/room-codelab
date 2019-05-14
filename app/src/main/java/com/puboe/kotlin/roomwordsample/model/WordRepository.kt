package com.puboe.kotlin.roomwordsample.model

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.puboe.kotlin.roomwordsample.model.room.WordDao

class WordRepository(private val wordDao: WordDao) {

    val words: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}