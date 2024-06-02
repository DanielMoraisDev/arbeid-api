package com.example.database

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object DBEmpresasTable: Table<DBEmpresasEntity>("empresas") {
    val id_empresa = int("id_empresa").primaryKey().bindTo { it.id_empresa }
    val nome_empresa = varchar("nome_empresa").bindTo { it.nome_empresa }
    val email_empresa = varchar("email_empresa").bindTo { it.email_empresa }
    val senha_empresa = varchar("senha_empresa").bindTo { it.senha_empresa }
    val cnpj_empresa = varchar("cnpj_empresa").bindTo { it.cnpj_empresa }
    val foto_perfil = varchar("foto_perfil").bindTo { it.foto_perfil }
    val ativo = boolean("ativo").bindTo { it.ativo }
}

interface DBEmpresasEntity: Entity<DBEmpresasEntity> {

    companion object : Entity.Factory<DBEmpresasEntity>()

    val id_empresa: Int
    val nome_empresa: String
    val email_empresa: String
    val senha_empresa: String
    val cnpj_empresa: String
    val foto_perfil: String
    val ativo: Boolean
}