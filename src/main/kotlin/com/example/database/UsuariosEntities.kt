package com.example.database

import com.example.database.DBEmpresasTable.bindTo
import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DBUsuariosTable: Table<DBUsuariosEntity>("usuarios") {
    val id_usuario = int("id_usuario").primaryKey().bindTo { it.id_usuario }
    val nome_usuario = varchar("nome_usuario").bindTo { it.nome_usuario }
    val email_usuario = varchar("email_usuario").bindTo { it.email_usuario }
    val senha_usuario = varchar("senha_usuario").bindTo { it.senha_usuario }
    val cpf_usuario = varchar("cpf_usuario").bindTo { it.cpf_usuario }
    val foto_perfil = varchar("foto_perfil").bindTo { it.foto_perfil }
    val ativo = boolean("ativo").bindTo { it.ativo }
}

interface DBUsuariosEntity: Entity<DBUsuariosEntity> {

    companion object : Entity.Factory<DBUsuariosEntity>()

    val id_usuario: Int
    val nome_usuario: String
    val email_usuario: String
    val senha_usuario: String
    val cpf_usuario: String
    val foto_perfil: String
    val ativo: Boolean
}