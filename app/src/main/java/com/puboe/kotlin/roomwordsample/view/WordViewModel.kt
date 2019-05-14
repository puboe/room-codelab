package com.puboe.kotlin.roomwordsample.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.puboe.kotlin.roomwordsample.model.Word
import com.puboe.kotlin.roomwordsample.model.WordRepository
import com.puboe.kotlin.roomwordsample.model.room.WordRoomDatabase
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    val words: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        words = repository.words
    }

    fun insert(word: Word) =
        viewModelScope.launch {
            repository.insert(word)
        }
}