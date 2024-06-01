package com.example.database

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DBPostagensTable: Table<DBPostagensEntity>("postagem") {
    val id_postagem = int("id_postagem").primaryKey().bindTo { it.id_postagem }
    val titulo_postagem = varchar("titulo_postagem").bindTo { it.titulo_postagem }
    val descricao_postagem = varchar("descricao_postagem").bindTo { it.descricao_postagem }
    val tag = varchar("tag").bindTo { it.tag }
}

interface DBPostagensEntity: Entity<DBPostagensEntity> {

    companion object : Entity.Factory<DBPostagensEntity>()

    val id_postagem: Int
    val titulo_postagem: String
    val descricao_postagem: String
    val tag: String
}