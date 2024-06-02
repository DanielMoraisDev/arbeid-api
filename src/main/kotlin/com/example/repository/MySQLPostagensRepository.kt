package com.example.repository

import com.example.database.DatabaseManager
import com.example.entities.Postagens
import com.example.entities.PostagensDraft

class MySQLPostagensRepository: PostagensRepository {

    private val database = DatabaseManager()

    override fun getAllPostagens(): List<Postagens> {
        return database.getAllPostagens().map { Postagens(
            it.id_postagem,
            it.titulo_postagem,
            it.descricao_postagem
        ) }
    }

    override fun addPostagens(draft: PostagensDraft): Postagens {
        return database.addPostagens(draft)
    }
}