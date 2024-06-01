package com.example.database

import com.example.entities.Postagens
import com.example.entities.PostagensDraft
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.entity.firstOrNull

class DatabaseManager {
    // config
    private val hostname = "localhost"
    private val databaseName = "arbeid"
    private val username = "root"
    private val password = "Dan@2905"

    // database
    private val ktormDatabase: Database

    init {
        val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&password=$password&useSSL=false&allowPublicKeyRetrieval=true"
        ktormDatabase = Database.connect(jdbcUrl)
    }

    // Pegar todas as postagens
    fun getAllPostagens(): List<DBPostagensEntity> {
        return ktormDatabase.sequenceOf(DBPostagensTable).toList()
    }

    // Criar postagem
    fun addPostagens(draft: PostagensDraft): Postagens {
        val insertedId = ktormDatabase.insertAndGenerateKey(DBPostagensTable) {
            set(DBPostagensTable.titulo_postagem, draft.titulo_postagem)
            set(DBPostagensTable.descricao_postagem, draft.descricao_postagem)
            set(DBPostagensTable.tag, draft.tag)
        } as Int

        return Postagens(insertedId, draft.titulo_postagem, draft.descricao_postagem, draft.tag)
    }
}