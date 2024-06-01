package com.example.repository

import com.example.database.DatabaseManager
import com.example.entities.Empresas
import com.example.entities.EmpresasDraft
import com.example.entities.Postagens
import com.example.entities.PostagensDraft
import org.jetbrains.exposed.sql.exists

class MySQLPostagensRepository: PostagensRepository {

    private val database = DatabaseManager()

    override fun getAllPostagens(): List<Postagens> {
        return database.getAllPostagens().map { Postagens(
            it.id_postagem,
            it.titulo_postagem,
            it.descricao_postagem,
            it.tag
        ) }
    }

    override fun addPostagens(draft: PostagensDraft): Postagens {
        return database.addPostagens(draft)
    }
}