package com.example.repository

import com.example.entities.Postagens
import com.example.entities.PostagensDraft

interface PostagensRepository {
    fun getAllPostagens(): List<Postagens>

    fun addPostagens(draft: PostagensDraft): Postagens
}